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
public class Competence extends EntiteDeBase {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;
    
    private String nom;
    
    @Enumerated(EnumType.STRING)
    private NiveauCompetence niveau; // DEBUTANT, INTERMEDIAIRE, AVANCE, EXPERT
    
    @Enumerated(EnumType.STRING)
    private CategorieCompetence categorie; // TECHNIQUE, LINGUISTIQUE, SOFT_SKILLS
}