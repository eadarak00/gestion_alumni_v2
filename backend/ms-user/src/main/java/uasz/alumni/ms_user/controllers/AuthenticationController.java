package uasz.alumni.ms_user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.dtos.EtudiantRequestDTO;
import uasz.alumni.ms_user.dtos.EtudiantResponseDTO;
import uasz.alumni.ms_user.services.EtudiantService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthenticationController {

    private final EtudiantService etudiantService;
    // private final AlumniService alumniService;


    @PostMapping("/inscription-etudiant")
    public ResponseEntity<EtudiantResponseDTO> inscrireEtudiant(
            @Valid @RequestBody EtudiantRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(etudiantService.inscrireEtudiant(dto));
    }

    // @PostMapping("/inscription-alumni")
    // public ResponseEntity<AlumniResponseDTO> inscrireEtudiant(
    //         @Valid @RequestBody AlumniRequestDTO dto) {
    //     return ResponseEntity
    //             .status(HttpStatus.CREATED)
    //             .body(alumniService.inscrireAlumni(dto));
    // }
    


}