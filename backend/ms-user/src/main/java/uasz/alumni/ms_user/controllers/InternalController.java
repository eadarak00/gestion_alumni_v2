package uasz.alumni.ms_user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.services.UtilisateurService;
import uasz.alumni.spi.model.UtilisateurResponseDTO;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
public class InternalController {

    private final UtilisateurService utilisateurService;

    @GetMapping("/users/{id}")
    public UtilisateurResponseDTO getUtilisateur(@PathVariable Long id) {
        return utilisateurService.getUtilisateurDto(id);
    }
}
