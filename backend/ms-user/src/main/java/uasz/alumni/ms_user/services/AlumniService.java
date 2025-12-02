package uasz.alumni.ms_user.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.common.exceptions.ResourceAlreadyExistsException;
import uasz.alumni.ms_user.common.exceptions.ResourceNotFoundException;
import uasz.alumni.ms_user.dtos.AlumniRequestDTO;
import uasz.alumni.ms_user.dtos.AlumniResponseDTO;
import uasz.alumni.ms_user.entities.Alumni;
import uasz.alumni.ms_user.entities.Role;
import uasz.alumni.ms_user.mappers.AlumniMapper;
import uasz.alumni.ms_user.repositories.AlumniRepository;
import uasz.alumni.ms_user.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AlumniService {

    private final AlumniRepository alumniRepository;
    private final RoleRepository roleRepository;
    private final AlumniMapper alumniMapper;
    private final PasswordEncoder passwordEncoder;
    private final CodeValidationService codeValidationService;

    /**
     * Inscription d'un alumni
     *
     * @param dto DTO d'inscription
     * @return DTO de réponse
     */
    public AlumniResponseDTO inscrireAlumni(@NonNull AlumniRequestDTO dto) {

        // Vérification d'unicité
        checkEmailUnique(dto.email());
        checkUsernameUnique(dto.username());

        // Récupération du rôle ALUMNI
        Role roleAlumni = roleRepository.findByLibelle("ALUMNI")
                .orElseThrow(() -> new ResourceNotFoundException("Le rôle ALUMNI n'existe pas"));

        // Création et préparation de l'entité
        Alumni alumni = alumniMapper.toEntity(dto);
        alumni.setRole(roleAlumni);
        alumni.setActif(false); // par défaut à l'inscription
        alumni.setMotDePasse(passwordEncoder.encode(alumni.getMotDePasse()));

        // Sauvegarde et envoi du code de validation
        Alumni saved = alumniRepository.save(alumni);
        codeValidationService.creerEtEnvoyerCode(saved.getEmail());

        // Conversion en DTO immuable record
        return alumniMapper.toResponse(saved);
    }

    // --- Méthodes privées pour clean code ---

    private void checkEmailUnique(String email) {
        if (alumniRepository.existsByEmail(email)) {
            throw new ResourceAlreadyExistsException("Email déjà utilisé");
        }
    }

    private void checkUsernameUnique(String username) {
        if (username != null && alumniRepository.existsByUsername(username)) {
            throw new ResourceAlreadyExistsException("Username déjà utilisé");
        }
    }
}
