package uasz.alumni.ms_cv.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_cv.model.CategorieCompetence;
import uasz.alumni.ms_cv.model.NiveauCompetence;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetenceRequest {
    
    @NotNull(message = "L'ID du CV est obligatoire")
    private Integer cvId;
    
    @NotBlank(message = "Le nom de la compétence est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String nom;
    
    @NotNull(message = "Le niveau de compétence est obligatoire")
    private NiveauCompetence niveau; // DEBUTANT, INTERMEDIAIRE, AVANCE, EXPERT
    
    private CategorieCompetence categorie; // TECHNIQUE, LINGUISTIQUE, SOFT_SKILLS, AUTRE
}