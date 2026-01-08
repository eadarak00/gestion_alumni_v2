// package uasz.alumni.ms_cv.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.NoArgsConstructor;
// import lombok.experimental.SuperBuilder;

// @EqualsAndHashCode(callSuper = true)
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @SuperBuilder
// @Entity
// public class Formation extends EntiteDeBase {

//     private Integer cvId;

//     private String diplome;

//     private String etablissement;

//     private String localisation;

//     private String dateDebut;

//     private String dateFin;

//     private Boolean enCours;

//     @Column(length = 2000)
//     private String description;
// }


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
public class Formation extends EntiteDeBase {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;
    
    private String diplome;
    private String etablissement;
    private String localisation;
    private String dateDebut;
    private String dateFin;
    private Boolean enCours;
    
    @Column(length = 2000)
    private String description;
}