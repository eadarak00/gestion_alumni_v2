package uasz.alumni.ms_cv_v2.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExperienceResponseDTO {
    private String poste;
    private String entreprise;
    private String ville;
    private String dateDebut;
    private String dateFin;
    private String description;
}
