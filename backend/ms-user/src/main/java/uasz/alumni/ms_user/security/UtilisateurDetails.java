package uasz.alumni.ms_user.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uasz.alumni.ms_user.entities.Utilisateur;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

/**
 * Classe UserDetails pour Spring Security.
 * Elle encapsule un utilisateur et expose les informations nécessaires pour
 * l'authentification et l'autorisation.
 */
@Getter
public class UtilisateurDetails implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * L'utilisateur encapsulé.
     * Marqué transient pour éviter les problèmes de sérialisation avec Hibernate.
     */
    private final transient Utilisateur utilisateur;

    public UtilisateurDetails(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Retourne les rôles sous forme de GrantedAuthority.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().getLibelle()));
    }

    @Override
    public String getPassword() {
        return utilisateur.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return utilisateur.getEmail(); // On utilise l'email comme identifiant unique
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Peut être étendu pour gérer l'expiration des comptes
    }

    @Override
    public boolean isAccountNonLocked() {
        return !utilisateur.isDeleted(); // Lock si supprimé
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Peut être étendu pour gérer l'expiration des credentials
    }

    @Override
    public boolean isEnabled() {
        return utilisateur.isActif() && !utilisateur.isDeleted(); // Actif seulement si validé et non supprimé
    }

    /**
     * Retourne l'id de l'utilisateur pour un usage interne (optionnel).
     */
    public Long getId() {
        return utilisateur.getId();
    }
}
