package uasz.alumni.ms_user.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.dtos.UtilisateurResponseDTO;
import uasz.alumni.ms_user.services.UtilisateurService;

@RestController
@RequestMapping("/api/v1/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    /**
     * Récupérer tous les utilisateurs (y compris supprimés)
     */
    @GetMapping
    public ResponseEntity<List<UtilisateurResponseDTO>> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    /**
     * Récupérer uniquement les utilisateurs non supprimés (actifs)
     */
    @GetMapping("/non-supprimes")
    public ResponseEntity<List<UtilisateurResponseDTO>> getUtilisateursNonSupprimes() {
        return ResponseEntity.ok(utilisateurService.getUtilisateursNonSupprimes());
    }

    /**
     * Récupérer un utilisateur par email (DTO)
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UtilisateurResponseDTO> getUtilisateurByEmail(@PathVariable String email) {
        UtilisateurResponseDTO dto = utilisateurService.getUtilisateurDtoByEmail(email);
        return ResponseEntity.ok(dto);
    }

    /**
     * Vérifier si un email existe
     */
    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Boolean> emailExists(@PathVariable String email) {
        return ResponseEntity.ok(utilisateurService.emailExists(email));
    }

    /**
     * Vérifier si un username existe
     */
    @GetMapping("/exists/username/{username}")
    public ResponseEntity<Boolean> usernameExists(@PathVariable String username) {
        return ResponseEntity.ok(utilisateurService.usernameExists(username));
    }

}
