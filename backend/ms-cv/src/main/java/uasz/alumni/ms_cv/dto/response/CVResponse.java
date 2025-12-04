package uasz.alumni.ms_cv.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_cv.model.TypeTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CVResponse {
    
    private Integer id;
    private String titre;
    private String resume;
    private String photo;
    private String linkedin;
    private String github;
    private String portfolio;
    private String telephone;
    private String email;
    private String adresse;
    private Integer utilisateurId;
    private TypeTemplate template;
    
    // Collections des sections
    private List<ExperienceResponse> experiences;
    private List<FormationResponse> formations;
    private List<CompetenceResponse> competences;
    private List<LangueParleesResponse> languesParlees;
    private List<CertificationResponse> certifications;
    
    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;
}