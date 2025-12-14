package uasz.alumni.ms_user.controllers;

import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateursApi {

    private final UtilisateurService utilisateurService;

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
    public ResponseEntity<AlumniResponseDTO> completerProfilAlumni(Long id, @Valid AlumniProfilRequestDTO dto) {
        return ResponseEntity.ok(utilisateurService.completerProfilAlumni(id, dto));
    }

    @Override
    public ResponseEntity<EtudiantResponseDTO> completerProfilEtudiant(Long id,
            @Valid EtudiantProfilRequestDTO dto) {

        return ResponseEntity.ok(utilisateurService.completerProfilEtudiant(id, dto));

    }
}
