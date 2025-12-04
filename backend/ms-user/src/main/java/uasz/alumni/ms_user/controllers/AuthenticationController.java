package uasz.alumni.ms_user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.services.AlumniService;
import uasz.alumni.ms_user.services.AuthService;
import uasz.alumni.ms_user.services.EtudiantService;
import uasz.alumni.spi.api.AuthApi;
import uasz.alumni.spi.model.AlumniRequestDTO;
import uasz.alumni.spi.model.AlumniResponseDTO;
import uasz.alumni.spi.model.EtudiantRequestDTO;
import uasz.alumni.spi.model.EtudiantResponseDTO;
import uasz.alumni.spi.model.LoginRequest;
import uasz.alumni.spi.model.RefreshRequest;
import uasz.alumni.spi.model.TokenResponse;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController implements AuthApi {

    private final EtudiantService etudiantService;
    private final AlumniService alumniService;
    private final AuthService authService;

    @Override
    public ResponseEntity<EtudiantResponseDTO> inscrireEtudiant(EtudiantRequestDTO etudiantRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(etudiantService.inscrireEtudiant(etudiantRequestDTO));
    }

    @Override
    public ResponseEntity<AlumniResponseDTO> inscrireAlumni(AlumniRequestDTO alumniRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alumniService.inscrireAlumni(alumniRequestDTO));
    }

    @Override
    public ResponseEntity<TokenResponse> login(LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @Override
    public ResponseEntity<TokenResponse> refresh(RefreshRequest refreshRequest) {
        return ResponseEntity.ok(authService.refresh(refreshRequest));
    }

    @Override
    public ResponseEntity<Void> logout(RefreshRequest refreshRequest) {
        authService.logout(refreshRequest.getRefreshToken());
        return ResponseEntity.noContent().build();
    }
}