package uasz.alumni.ms_user.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.services.UtilisateurService;
import uasz.alumni.spi.api.UtilisateursApi;
import uasz.alumni.spi.model.UtilisateurResponseDTO;

@RestController
@RequestMapping("/api/v1/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateursApi {

    private final UtilisateurService utilisateurService;

    @Override
    public ResponseEntity<Boolean> emailExists(@Email String email) {
        return ResponseEntity.ok(utilisateurService.emailExists(email));
    }

    @Override
    public ResponseEntity<List<UtilisateurResponseDTO>> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    @Override
    public ResponseEntity<UtilisateurResponseDTO> getUtilisateurByEmail(@Email String email) {
        return ResponseEntity.ok(utilisateurService.getUtilisateurDtoByEmail(email));
    }

    @Override
    public ResponseEntity<List<UtilisateurResponseDTO>> getUtilisateursNonSupprimes() {
        return ResponseEntity.ok(utilisateurService.getUtilisateursNonSupprimes());
    }

    @Override
    public ResponseEntity<Boolean> usernameExists(String username) {
        return ResponseEntity.ok(utilisateurService.usernameExists(username));
    }
}
