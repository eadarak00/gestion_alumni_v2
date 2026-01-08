package uasz.alumni.ms_user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.services.AuthService;
import uasz.alumni.spi.api.AuthApi;
import uasz.alumni.spi.model.LoginRequest;
import uasz.alumni.spi.model.RefreshRequest;
import uasz.alumni.spi.model.TokenResponse;
import uasz.alumni.spi.model.UtilisateurRequestDTO;
import uasz.alumni.spi.model.UtilisateurResponseDTO;

@RestController
@RequestMapping("/api-users/v1")
@RequiredArgsConstructor
public class AuthenticationController implements AuthApi {

    private final AuthService authService;

    @Override
    public ResponseEntity<UtilisateurResponseDTO> inscrire(@Valid UtilisateurRequestDTO dto) {
        return ResponseEntity.ok(authService.inscrire(dto));
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