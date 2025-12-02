package uasz.alumni.ms_user.services;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_user.common.exceptions.ResourceAlreadyExistsException;
import uasz.alumni.ms_user.common.exceptions.ResourceNotFoundException;
import uasz.alumni.ms_user.dtos.EtudiantRequestDTO;
import uasz.alumni.ms_user.dtos.EtudiantResponseDTO;
import uasz.alumni.ms_user.entities.Etudiant;
import uasz.alumni.ms_user.entities.Role;
import uasz.alumni.ms_user.mappers.EtudiantMapper;
import uasz.alumni.ms_user.repositories.EtudiantRepository;
import uasz.alumni.ms_user.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final RoleRepository roleRepository;
    private final EtudiantMapper etudiantMapper;
    // private final PasswordEncoder passwordEncoder;
    // private final codeValidationService codeValidationService;

    public EtudiantResponseDTO inscrireEtudiant(EtudiantRequestDTO dto) {

        // Vérifications d'unicité
        checkUnicite(dto);

        // Récupération du rôle ETUDIANT
        Role roleEtudiant = roleRepository.findByLibelle("ETUDIANT")
                .orElseThrow(() -> new ResourceNotFoundException("Le rôle ETUDIANT n'existe pas"));

        // Création et préparation de l'entité
        Etudiant etudiant = prepareEtudiant(dto, roleEtudiant);

        // Sauvegarde
        Etudiant saved = etudiantRepository.save(etudiant);

        // Envoi code validation
        // codeValidationService.creerEtEnvoyerCode(saved.getEmail());

        log.info("Nouvel étudiant inscrit : {} ({})", saved.getNom(), saved.getEmail());

        // Retour DTO record
        return etudiantMapper.toResponse(saved);
    }

    // --------------------- Méthodes privées ---------------------

    private void checkUnicite(EtudiantRequestDTO dto) {
        if (etudiantRepository.findByEmail(dto.email()).isPresent())
            throw new ResourceAlreadyExistsException("Email déjà utilisé");

        if (dto.username() != null && etudiantRepository.findByUsername(dto.username()).isPresent())
            throw new ResourceAlreadyExistsException("Username déjà utilisé");

        if (etudiantRepository.findByNumeroCarteEtudiant(dto.numeroCarteEtudiant()).isPresent())
            throw new ResourceAlreadyExistsException("Numéro de carte déjà utilisé");
    }

    private Etudiant prepareEtudiant(EtudiantRequestDTO dto, Role roleEtudiant) {
        Etudiant etudiant = etudiantMapper.toEntity(dto);

        // Username généré si absent
        // if (etudiant.getUsername() == null || etudiant.getUsername().isBlank()) {
        //     etudiant.setUsername(generateUsername(dto));
        // }

        etudiant.setRole(roleEtudiant);

        // Encodage du mot de passe
        // etudiant.setMotDePasse(passwordEncoder.encode(etudiant.getMotDePasse()));

        return etudiant;
    }

    // private String generateUsername(EtudiantRequestDTO dto) {
    //     String base = dto.nom().toLowerCase() + "." + dto.prenom().toLowerCase();
    //     String username = base;
    //     int counter = 1;
    //     while (etudiantRepository.findByUsername(username).isPresent()) {
    //         username = base + counter++;
    //     }
    //     return username;
    // }
}
