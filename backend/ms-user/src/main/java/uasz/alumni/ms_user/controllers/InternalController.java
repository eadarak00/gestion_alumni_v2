package uasz.alumni.ms_user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.services.EtudiantService;
import uasz.alumni.spi.model.EtudiantResponseDTO;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
public class InternalController {

    private final EtudiantService etudiantService;

    @GetMapping("/etudiants/etudiant-connecte")
    public EtudiantResponseDTO getEtudiantConnecte() {
        return etudiantService.getEtudiantConnecte();
    }
}
