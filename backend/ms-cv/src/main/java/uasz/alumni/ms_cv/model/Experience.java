package uasz.alumni.ms_cv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Experience extends EntiteDeBase {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;
    
    private String poste;
    private String entreprise;
    private String localisation;
    private String dateDebut;
    private String dateFin;
    private Boolean enCours;
    
    @Column(length = 2000)
    private String description;
}