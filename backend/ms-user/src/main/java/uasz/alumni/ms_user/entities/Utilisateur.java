package uasz.alumni.ms_user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uasz.alumni.ms_user.common.entities.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "type_utilisateur",
        discriminatorType = DiscriminatorType.STRING,
        length = 50
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"motDePasse", "role"})
public class Utilisateur extends BaseEntity {

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    @Email(message = "Email invalide")
    private String email;

    @Column(nullable = false)
    private String motDePasse; // à hasher côté service

    @Pattern(
        regexp = "^(\\+221|00221)?7[015678]\\d{7}$",
        message = "Numéro de téléphone invalide (format Sénégal)"
    )
    private String telephone;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private boolean actif = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    /**
     * Normalisation automatique des champs avant l'insertion
     */
    @PrePersist
    @Override
    protected void onCreate() {
        super.onCreate();
        normalize();
    }

    /**
     * Normalisation automatique des champs avant update
     */
    @PreUpdate
    @Override
    protected void onUpdate() {
        super.onUpdate();
        normalize();
    }

    /**
     * Normalisation centralisée
     */
    private void normalize() {
        if (email != null) email = email.trim().toLowerCase();
        if (username != null) username = username.trim().toLowerCase();
        if (telephone != null) telephone = telephone.trim();
    }
}
