package uasz.alumni.ms_user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.services.UtilisateurService;
import uasz.alumni.spi.api.UtilisateursApi;
import uasz.alumni.spi.model.GetAllUtilisateursFiltered200Response;
import uasz.alumni.spi.model.UtilisateurResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    // Recuper l'utilisateur par l'ID
    // @GetMapping("/{id}")
    // public ResponseEntity<UtilisateurResponseDTO> getUtilisateurById(Integer id) {
    //     Integer idInt = id;
    //     Long idLong = idInt.longValue();
    //     System.out.println("\n\n" + id + "\n");
    //     System.out.println("\n\n" + idInt + "\n");
    //     System.out.println("\n\n" + idLong + "\n");

    //     return ResponseEntity.ok(utilisateurService.getUtilisateurDtoById(idLong));
    // }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurResponseDTO> getUtilisateurById(@PathVariable Integer id) {
        System.out.println("\n\n ID : " + id + "\n");
        Long idLong = id.longValue();
        return ResponseEntity.ok(utilisateurService.getUtilisateurDtoById(idLong));
    }

}
