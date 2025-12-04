package uasz.alumni.ms_user.services;

import lombok.RequiredArgsConstructor;
import uasz.alumni.spi.model.LoginRequest;
import uasz.alumni.spi.model.RefreshRequest;
import uasz.alumni.spi.model.TokenResponse;
import uasz.alumni.ms_user.entities.RefreshToken;
import uasz.alumni.ms_user.entities.Utilisateur;
import uasz.alumni.ms_user.repositories.RefreshTokenRepository;
import uasz.alumni.ms_user.repositories.UtilisateurRepository;
import uasz.alumni.ms_user.security.JwtService;
import uasz.alumni.ms_user.security.TokenHashUtil;
import uasz.alumni.ms_user.security.UtilisateurDetails;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Value("${jwt.refresh-exp-days:30}")
    private long refreshExpDays;

    @Value("${jwt.access-exp-seconds:900}")
    private long accessExpSeconds;

    /** LOGIN */
    public TokenResponse login(LoginRequest req) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getMotDePasse()));

        UtilisateurDetails user = (UtilisateurDetails) auth.getPrincipal();
        Utilisateur u = utilisateurRepository
                .findByEmailAndDeletedFalse(user.getUsername())
                .orElseThrow();

        String accessToken = jwtService.generateAccessToken(user);

        String refreshToken = UUID.randomUUID().toString();
        String hash = TokenHashUtil.sha256(refreshToken);

        // Réinitialisation des anciens tokens
        refreshTokenRepository.deleteByUtilisateur(u);

        RefreshToken rt = RefreshToken.builder()
                .tokenHash(hash)
                .utilisateur(u)
                .expiryDate(Instant.now().plus(refreshExpDays, ChronoUnit.DAYS))
                .revoked(false)
                .build();

        refreshTokenRepository.save(rt);

        TokenResponse response = new TokenResponse();
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        response.setTokenType("Bearer");
        response.setExpiresInSeconds(accessExpSeconds);
        return response;
    }

    /** REFRESH TOKEN */
    public TokenResponse refresh(RefreshRequest refreshReq) {

        String hash = TokenHashUtil.sha256(refreshReq.getRefreshToken());

        RefreshToken stored = refreshTokenRepository.findByTokenHash(hash)
                .orElseThrow(() -> new IllegalArgumentException("Refresh token invalide"));

        if (stored.isRevoked() || stored.getExpiryDate().isBefore(Instant.now())) {
            refreshTokenRepository.delete(stored);
            throw new IllegalArgumentException("Refresh token expiré");
        }

        Utilisateur utilisateur = stored.getUtilisateur();
        UtilisateurDetails userDetails = new UtilisateurDetails(utilisateur);

        // rotation
        stored.setRevoked(true);
        refreshTokenRepository.save(stored);

        String newRefresh = UUID.randomUUID().toString();
        String newHash = TokenHashUtil.sha256(newRefresh);

        RefreshToken newStored = RefreshToken.builder()
                .tokenHash(newHash)
                .utilisateur(utilisateur)
                .expiryDate(Instant.now().plus(refreshExpDays, ChronoUnit.DAYS))
                .revoked(false)
                .build();
        refreshTokenRepository.save(newStored);

        String newAccess = jwtService.generateAccessToken(userDetails);

        TokenResponse response = new TokenResponse();
        response.setAccessToken(newAccess);
        response.setRefreshToken(newRefresh);
        response.setTokenType("Bearer");
        response.setExpiresInSeconds(accessExpSeconds);
        return response;
    }

    /** LOGOUT */
    public void logout(String refreshToken) {
        String hash = TokenHashUtil.sha256(refreshToken);
        refreshTokenRepository.findByTokenHash(hash)
                .ifPresent(rt -> {
                    rt.setRevoked(true);
                    refreshTokenRepository.save(rt);
                });
    }
}
