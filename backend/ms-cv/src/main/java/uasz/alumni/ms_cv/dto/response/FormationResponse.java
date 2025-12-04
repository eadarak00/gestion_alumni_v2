package uasz.alumni.ms_cv.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormationResponse {
    
    private Integer id;
    private Integer cvId;
    private String diplome;
    private String etablissement;
    private String localisation;
    private String dateDebut;
    private String dateFin;
    private Boolean enCours;
    private String description;
    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;
}