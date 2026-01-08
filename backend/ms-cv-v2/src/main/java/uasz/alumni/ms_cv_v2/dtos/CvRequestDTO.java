package uasz.alumni.ms_cv_v2.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CvRequestDTO {

    @NotNull
    private Long templateId;

    private String titreProfil;
    private String telephone;
    private String email;
    private String adresse;
    private String resumeProfil;

    private List<FormationDTO> formations;
    private List<ExperienceDTO> experiences;
    private List<CompetenceDTO> competences;
    private List<LangueDTO> langues;
    private List<InteretDTO> interets;
}
