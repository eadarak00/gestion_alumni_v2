package uasz.alumni.ms_cv.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class EntiteDeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;
    private String creePar;
    private String modifiePar;

    @PrePersist
    protected void lorsDeCreation() {
        dateCreation = LocalDateTime.now();
        dateDerniereModification = LocalDateTime.now();
    }

    @PreUpdate
    protected void lorsDeModification() {
        dateDerniereModification = LocalDateTime.now();
    }
}
