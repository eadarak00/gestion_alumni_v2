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
public class LangueParlees extends EntiteDeBase {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;
    
    @Enumerated(EnumType.STRING)
    private Langues langue; // FRANCAIS, ANGLAIS, ESPAGNOL, etc.
    
    @Enumerated(EnumType.STRING)
    private NiveauLangue niveau; // DEBUTANT, INTERMEDIAIRE, AVANCE, COURANT, NATIF
}