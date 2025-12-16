package uasz.alumni.ms_cv.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_cv.model.TypeTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CVCompletResponse {
    
    // Informations du CV
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
    
    // Toutes les sections
    @Builder.Default
    private List<ExperienceResponse> experiences = new ArrayList<>();
    
    @Builder.Default
    private List<FormationResponse> formations = new ArrayList<>();
    
    @Builder.Default
    private List<CompetenceResponse> competences = new ArrayList<>();
    
    @Builder.Default
    private List<LangueParleesResponse> languesParlees = new ArrayList<>();
    
    @Builder.Default
    private List<CertificationResponse> certifications = new ArrayList<>();
    
    // Métadonnées
    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;
}