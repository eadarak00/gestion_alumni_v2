package uasz.alumni.ms_user.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uasz.alumni.ms_user.common.entities.BaseEntity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;


@Entity
@Table(name = "code_validations", indexes = {
        @Index(name = "idx_code", columnList = "code"),
        @Index(name = "idx_utilisateur_id", columnList = "utilisateur_id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeValidation extends BaseEntity {

    /**
     * Code à 6 chiffres généré pour une validation
     */
    @Column(length = 6, nullable = false)
    private String code;

    /**
     * Utilisateur associé au code
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    /**
     * Date d'expiration du code
     */
    @Column(nullable = false)
    private Instant dateExpiration;

    /**
     * Date de création du code
     */
    @Column(nullable = false, updatable = false)
    private Instant dateCreation;

    /**
     * Indique si le code a déjà été utilisé
     */
    @Column(nullable = false)
    private boolean utilise;

    @PrePersist
    protected void initializeTimestamps() {
        if (dateCreation == null) {
            dateCreation = Instant.now();
        }
        utilise = false;
    }

    /**
     * Vérifie si le code est expiré.
     */
    public boolean isExpired() {
        return Instant.now().isAfter(dateExpiration);
    }

    /**
     * Un code est utilisable s'il n'est pas expiré et pas déjà utilisé.
     */
    public boolean isUsable() {
        return !utilise && !isExpired();
    }
}