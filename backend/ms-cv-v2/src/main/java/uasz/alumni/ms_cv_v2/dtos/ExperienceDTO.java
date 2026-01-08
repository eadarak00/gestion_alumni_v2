package uasz.alumni.ms_cv_v2.dtos;


import lombok.Data;

@Data
public class ExperienceDTO {
    private String poste;
    private String entreprise;
    private String ville;
    private String dateDebut;
    private String dateFin;
    private String description;
}
