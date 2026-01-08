package uasz.alumni.ms_cv_v2.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CvResponseDTO {

    private Long id;

    private Long templateId;
    private String templateNom;

    private String titreProfil;
    private String telephone;
    private String email;
    private String adresse;
    private String resumeProfil;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<FormationResponseDTO> formations;
    private List<ExperienceResponseDTO> experiences;
    private List<CompetenceResponseDTO> competences;
    private List<LangueResponseDTO> langues;
    private List<InteretResponseDTO> interets;
}
