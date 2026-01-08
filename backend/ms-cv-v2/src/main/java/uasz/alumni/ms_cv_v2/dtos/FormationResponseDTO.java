package uasz.alumni.ms_cv_v2.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FormationResponseDTO {
    private String diplome;
    private String etablissement;
    private String ville;
    private String anneeDebut;
    private String anneeFin;
}
