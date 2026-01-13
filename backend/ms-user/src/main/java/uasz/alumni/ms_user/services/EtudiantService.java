package uasz.alumni.ms_user.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_user.common.exceptions.ResourceAlreadyExistsException;
import uasz.alumni.ms_user.common.exceptions.ResourceNotFoundException;
import uasz.alumni.spi.model.EtudiantRequestDTO;
import uasz.alumni.spi.model.EtudiantResponseDTO;
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
    private final PasswordEncoder passwordEncoder;
    private final CodeValidationService codeValidationService;

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
        codeValidationService.creerEtEnvoyerCode(saved.getEmail());

        log.info("Nouvel étudiant inscrit : {} ({})", saved.getNom(), saved.getEmail());

        // Retour DTO record
        return etudiantMapper.toResponse(saved);
    }

    // --------------------- Méthodes privées ---------------------

    private void checkUnicite(EtudiantRequestDTO dto) {
        if (etudiantRepository.findByEmail(dto.getEmail()).isPresent())
            throw new ResourceAlreadyExistsException("Email déjà utilisé");

        if (dto.getUsername() != null && etudiantRepository.findByUsername(dto.getUsername()).isPresent())
            throw new ResourceAlreadyExistsException("Username déjà utilisé");

        if (etudiantRepository.findByNumeroCarteEtudiant(dto.getNumeroCarteEtudiant()).isPresent())
            throw new ResourceAlreadyExistsException("Numéro de carte déjà utilisé");
    }

    private Etudiant prepareEtudiant(EtudiantRequestDTO dto, Role roleEtudiant) {
        Etudiant etudiant = etudiantMapper.toEntity(dto);

        etudiant.setRole(roleEtudiant);

        // Encodage du mot de passe
        etudiant.setMotDePasse(passwordEncoder.encode(etudiant.getMotDePasse()));

        return etudiant;
    }

    public EtudiantResponseDTO getEtudiantConnecte() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String email = authentication.getName();

    Etudiant etu = etudiantRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("Étudiant connecté introuvable"));
    
    return etudiantMapper.toResponse(etu);
}

}
