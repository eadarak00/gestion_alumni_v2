package uasz.alumni.ms_cv.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.spi.model.CategorieCompetence;
import uasz.alumni.spi.model.NiveauCompetence;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetenceResponse {
    
    private Integer id;
    private Integer cvId;
    private String nom;
    private NiveauCompetence niveau;
    private CategorieCompetence categorie;
    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;
}