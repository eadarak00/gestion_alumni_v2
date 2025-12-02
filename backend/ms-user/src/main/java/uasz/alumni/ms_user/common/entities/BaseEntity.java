package uasz.alumni.ms_user.common.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted = false;

    private LocalDateTime deletedAt;

    /**
     * Callback avant insertion
     */
    @PrePersist
    protected void onCreate() {
        // PROPRE : on laisse Hibernate gérer createdAt avec @CreationTimestamp
        if (deleted == null) {
            deleted = false;
        }
    }

    /**
     * Callback avant mise à jour
     */
    @PreUpdate
    protected void onUpdate() {
        // updatedAt est géré automatiquement par @UpdateTimestamp, pas besoin de set()

        // Ajout date lors d'une suppression logique
        if (Boolean.TRUE.equals(deleted) && deletedAt == null) {
            deletedAt = LocalDateTime.now();
        }

        // Nettoyage date lors d'une restauration
        if (Boolean.FALSE.equals(deleted) && deletedAt != null) {
            deletedAt = null;
        }
    }

    /**
     * Suppression logique
     */
    public void softDelete() {
        this.deleted = true;
        this.deletedAt = LocalDateTime.now();
    }

    /**
     * Restauration d'une entité soft-deleted
     */
    public void restore() {
        this.deleted = false;
        this.deletedAt = null;
    }

    /**
     * Vérifie si l'entité est supprimée logiquement
     */
    public boolean isDeleted() {
        return Boolean.TRUE.equals(this.deleted);
    }
}
