package uasz.alumni.ms_user.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.entities.Utilisateur;
import uasz.alumni.ms_user.repositories.UtilisateurRepository;

@Component
@RequiredArgsConstructor
public class SecurityServiceUtils {
    private final UtilisateurRepository utilisateurRepository;

    public String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("Aucun utilisateur authentifié");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        }

        if (principal instanceof String username) {
            return username;
        }

        throw new IllegalStateException("Principal non supporté");
    }


    public Long getAuthenticatedUserId() {
        String username = this.getAuthenticatedUsername();

        return utilisateurRepository.findByUsername(username)
                .map(Utilisateur::getId)
                .orElseThrow(() -> new IllegalStateException("Utilisateur introuvable"));
    }
}
