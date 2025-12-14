package uasz.alumni.ms_user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.services.UtilisateurService;
import uasz.alumni.spi.api.UtilisateursApi;
import uasz.alumni.spi.model.AlumniProfilRequestDTO;
import uasz.alumni.spi.model.AlumniResponseDTO;
import uasz.alumni.spi.model.EtudiantProfilRequestDTO;
import uasz.alumni.spi.model.EtudiantResponseDTO;
import uasz.alumni.spi.model.GetAllUtilisateursFiltered200Response;
import uasz.alumni.spi.model.UtilisateurResponseDTO;

import uasz.alumni.ms_user.common.utils.SecurityServiceUtils;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateursApi {

    private final UtilisateurService utilisateurService;
    private final SecurityServiceUtils securityServiceUtils;

    @Override
    public ResponseEntity<GetAllUtilisateursFiltered200Response> getAllUtilisateursFiltered(
            Boolean actif,
            Boolean deleted,
            Integer page,
            Integer size,
            String sort) {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateursFiltered(actif, deleted, page, size, sort));
    }

    @Override
    public ResponseEntity<Boolean> emailExists(@Email String email) {
        return ResponseEntity.ok(utilisateurService.emailExists(email));
    }

    @Override
    public ResponseEntity<UtilisateurResponseDTO> getUtilisateurByEmail(@Email String email) {
        return ResponseEntity.ok(utilisateurService.getUtilisateurDtoByEmail(email));
    }

    @Override
    public ResponseEntity<Boolean> usernameExists(String username) {
        return ResponseEntity.ok(utilisateurService.usernameExists(username));
    }

    @Override
    @PreAuthorize("hasRole('ALUMNI')")
    public ResponseEntity<AlumniResponseDTO> completerProfilAlumni(
            @Valid AlumniProfilRequestDTO dto) {
        Long userId = securityServiceUtils.getAuthenticatedUserId();
        AlumniResponseDTO response = utilisateurService.completerProfilAlumni(userId, dto);
        return ResponseEntity.ok(response);
    }

    @Override
    @PreAuthorize("hasRole('ETUDIANT')")
    public ResponseEntity<EtudiantResponseDTO> completerProfilEtudiant(
            @Valid EtudiantProfilRequestDTO dto) {
        Long userId = securityServiceUtils.getAuthenticatedUserId();
        EtudiantResponseDTO response = utilisateurService.completerProfilEtudiant(userId, dto);
        return ResponseEntity.ok(response);
    }

}
