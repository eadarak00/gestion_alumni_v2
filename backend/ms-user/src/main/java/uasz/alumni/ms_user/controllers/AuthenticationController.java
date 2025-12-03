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
import uasz.alumni.ms_user.dtos.AlumniRequestDTO;
import uasz.alumni.ms_user.dtos.AlumniResponseDTO;
import uasz.alumni.ms_user.dtos.EtudiantRequestDTO;
import uasz.alumni.ms_user.dtos.EtudiantResponseDTO;
import uasz.alumni.ms_user.dtos.LoginRequest;
import uasz.alumni.ms_user.dtos.RefreshRequest;
import uasz.alumni.ms_user.dtos.TokenResponse;
import uasz.alumni.ms_user.services.AlumniService;
import uasz.alumni.ms_user.services.AuthService;
import uasz.alumni.ms_user.services.EtudiantService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthenticationController {

    private final EtudiantService etudiantService;
    private final AlumniService alumniService;
    private final AuthService authService;


    @PostMapping("/inscription-etudiant")
    public ResponseEntity<EtudiantResponseDTO> inscrireEtudiant(
            @Valid @RequestBody EtudiantRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(etudiantService.inscrireEtudiant(dto));
    }

    @PostMapping("/inscription-alumni")
    public ResponseEntity<AlumniResponseDTO> inscrireEtudiant(
            @Valid @RequestBody AlumniRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alumniService.inscrireAlumni(dto));
    }

     @PostMapping("/connecter")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest req) {
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@Valid @RequestBody RefreshRequest req) {
        return ResponseEntity.ok(authService.refresh(req));
    }

    @PostMapping("/deconnecter")
    public ResponseEntity<Void> logout(@Valid @RequestBody RefreshRequest req) {
        authService.logout(req.refreshToken());
        return ResponseEntity.noContent().build();
    }
    


}