package uasz.alumni.ms_user.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.common.exceptions.ResourceNotFoundException;
import uasz.alumni.ms_user.entities.Alumni;
import uasz.alumni.ms_user.entities.Etudiant;
import uasz.alumni.ms_user.entities.Utilisateur;
import uasz.alumni.ms_user.mappers.UtilisateurMapper;
import uasz.alumni.ms_user.repositories.UtilisateurRepository;
import uasz.alumni.spi.model.AlumniProfilRequestDTO;
import uasz.alumni.spi.model.AlumniResponseDTO;
import uasz.alumni.spi.model.EtudiantProfilRequestDTO;
import uasz.alumni.spi.model.EtudiantResponseDTO;
import uasz.alumni.spi.model.GetAllUtilisateursFiltered200Response;
import uasz.alumni.spi.model.UtilisateurResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    /**
     * Liste paginée et filtrée des utilisateurs
     */
    @Transactional(readOnly = true)
    public GetAllUtilisateursFiltered200Response getAllUtilisateursFiltered(
            Boolean actif,
            Boolean deleted,
            Integer page,
            Integer size,
            String sort) {

        // Valeurs par défaut
        int pageNumber = (page != null && page >= 0) ? page : 0;
        int pageSize = (size != null && size > 0) ? size : 10;

        // Créer le Pageable avec tri si fourni
        org.springframework.data.domain.Pageable pageable;
        if (sort != null && !sort.isBlank()) {
            String[] sortParams = sort.split(",");
            String field = sortParams[0];
            org.springframework.data.domain.Sort.Direction direction = sortParams.length > 1
                    && "desc".equalsIgnoreCase(sortParams[1])
                            ? org.springframework.data.domain.Sort.Direction.DESC
                            : org.springframework.data.domain.Sort.Direction.ASC;
            pageable = org.springframework.data.domain.PageRequest.of(pageNumber, pageSize,
                    org.springframework.data.domain.Sort.by(direction, field));
        } else {
            pageable = org.springframework.data.domain.PageRequest.of(pageNumber, pageSize);
        }

        // Récupérer les utilisateurs selon les filtres
        org.springframework.data.domain.Page<Utilisateur> utilisateursPage;

        if (actif != null && deleted != null) {
            utilisateursPage = utilisateurRepository.findByActifAndDeleted(actif, deleted, pageable);
        } else if (actif != null) {
            utilisateursPage = utilisateurRepository.findByActif(actif, pageable);
        } else if (deleted != null) {
            if (deleted) {
                utilisateursPage = utilisateurRepository.findByDeletedTrue(pageable);
            } else {
                utilisateursPage = utilisateurRepository.findByDeletedFalse(pageable);
            }
        } else {
            utilisateursPage = utilisateurRepository.findAll(pageable);
        }

        // Mapper vers DTO
        List<UtilisateurResponseDTO> content = utilisateursPage.getContent()
                .stream()
                .map(utilisateurMapper::toDto)
                .toList();

        // Créer la réponse paginée
        GetAllUtilisateursFiltered200Response response = new GetAllUtilisateursFiltered200Response();
        response.setContent(content);
        response.setTotalElements((int) utilisateursPage.getTotalElements());
        response.setTotalPages(utilisateursPage.getTotalPages());
        response.setSize(utilisateursPage.getSize());
        response.setNumber(utilisateursPage.getNumber());

        return response;
    }

    /**
     * Récupérer un utilisateur par e-mail (non supprimé par défaut)
     */
    @Transactional(readOnly = true)
    public UtilisateurResponseDTO getUtilisateurDtoByEmail(@NonNull String email) {
        Utilisateur utilisateur = this.getUtilisateurEntityByEmail(email);
        return utilisateurMapper.toDto(utilisateur);
    }

    /**
     * Récupération d’un utilisateur (entité) par email — uniquement actif/non
     * supprimé
     */
    @Transactional(readOnly = true)
    public Utilisateur getUtilisateurEntityByEmail(@NonNull String email) {
        return utilisateurRepository.findByEmailAndDeletedFalse(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Utilisateur non trouvé ou supprimé avec l'email : " + email));
    }

    /**
     * Vérifier l’existence d’un email
     */
    @Transactional(readOnly = true)
    public boolean emailExists(@NonNull String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    /**
     * Vérifier l’existence d’un username
     */
    @Transactional(readOnly = true)
    public boolean usernameExists(@NonNull String username) {
        return utilisateurRepository.existsByUsername(username);
    }

    @Transactional
    public EtudiantResponseDTO completerProfilEtudiant(Long id, EtudiantProfilRequestDTO dto) {
        Utilisateur user = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable"));

        if (!user.getRole().equals("ETUDIANT")) {
            throw new IllegalArgumentException("Cet utilisateur n'est pas un étudiant.");
        }

        Etudiant etudiant = new Etudiant();
        etudiant.setId(user.getId());
        etudiant.setNom(user.getNom());
        etudiant.setPrenom(user.getPrenom());
        etudiant.setEmail(user.getEmail());
        etudiant.setUsername(user.getUsername());
        etudiant.setTelephone(user.getTelephone());
        etudiant.setRole(user.getRole());

        etudiant.setNumeroCarteEtudiant(dto.getNumeroEtudiant());
        etudiant.setFiliere(dto.getFiliere());
        etudiant.setNiveau(dto.getNiveau());

        Etudiant savedEtudiant = utilisateurRepository.save(etudiant);
        return utilisateurMapper.toEtudiantDto(savedEtudiant);
    }

    @Transactional
    public AlumniResponseDTO completerProfilAlumni(Long id, AlumniProfilRequestDTO dto) {
        // Récupérer l'utilisateur générique
        Utilisateur user = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable"));

        // Vérifier le rôle
        if (!"ALUMNI".equals(user.getRole())) {
            throw new IllegalArgumentException("Cet utilisateur n'est pas un alumni.");
        }

        // Créer une instance Alumni et copier les champs communs
        Alumni alumni = new Alumni();
        alumni.setId(user.getId()); // garder le même ID
        alumni.setNom(user.getNom());
        alumni.setPrenom(user.getPrenom());
        alumni.setEmail(user.getEmail());
        alumni.setUsername(user.getUsername());
        alumni.setTelephone(user.getTelephone());
        alumni.setRole(user.getRole());
        alumni.setActif(user.isActif());

        // Compléter les informations spécifiques
        alumni.setProfession(dto.getProfession());
        alumni.setEntreprise(dto.getEntreprise());

        // Sauvegarder la nouvelle instance Alumni
        Alumni savedAlumni = utilisateurRepository.save(alumni);

        return utilisateurMapper.toAlumniDto(savedAlumni);
    }

}
