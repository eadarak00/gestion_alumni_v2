package uasz.alumni.ms_cv_v2.dtos;

import lombok.Data;

@Data
public class FormationDTO {
    private String diplome;
    private String etablissement;
    private String ville;
    private String anneeDebut;
    private String anneeFin;
}
