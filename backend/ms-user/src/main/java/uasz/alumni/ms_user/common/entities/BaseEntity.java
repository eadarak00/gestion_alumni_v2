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
    private boolean deleted;

    private LocalDateTime deletedAt;

    /**
     * Callback avant insertion
     */
    @PrePersist
    protected void onCreate() {
        // Rien à faire ici : createdAt est géré automatiquement
        this.deleted = false;
    }

    /**
     * Callback avant mise à jour
     */
    @PreUpdate
    protected void onUpdate() {
        // updatedAt est géré automatiquement

        // Ajout de la date si suppression logique
        if (deleted && deletedAt == null) {
            deletedAt = LocalDateTime.now();
        }

        // Nettoyage si restauré
        if (!deleted && deletedAt != null) {
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
     * Restauration
     */
    public void restore() {
        this.deleted = false;
        this.deletedAt = null;
    }

}
