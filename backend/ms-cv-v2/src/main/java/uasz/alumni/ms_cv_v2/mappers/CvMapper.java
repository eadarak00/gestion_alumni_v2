package uasz.alumni.ms_cv_v2.mappers;


import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import uasz.alumni.ms_cv_v2.entities.Competence;
import uasz.alumni.ms_cv_v2.entities.Cv;
import uasz.alumni.ms_cv_v2.entities.Experience;
import uasz.alumni.ms_cv_v2.entities.Formation;
import uasz.alumni.ms_cv_v2.entities.Interet;
import uasz.alumni.ms_cv_v2.entities.Langue;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.spi.model.CompetenceResponseDTO;
import uasz.alumni.spi.model.CvRequestDTO;
import uasz.alumni.spi.model.CvResponseDTO;
import uasz.alumni.spi.model.ExperienceResponseDTO;
import uasz.alumni.spi.model.FormationResponseDTO;
import uasz.alumni.spi.model.InteretResponseDTO;
import uasz.alumni.spi.model.LangueResponseDTO;


public class CvMapper {

    /* ================= REQUEST -> ENTITY ================= */

    public static Cv toEntity(CvRequestDTO dto, Template template, Long userId) {

        Cv cv = Cv.builder()
                .userId(userId)
                .template(template)
                .titreProfil(dto.getTitreProfil())
                .telephone(dto.getTelephone())
                .email(dto.getEmail())
                .prenom(dto.getPrenom())
                .nom(dto.getNom())
                .adresse(dto.getAdresse())
                .resumeProfil(dto.getResumeProfil())
                .build();

        if (dto.getFormations() != null) {
            cv.setFormations(dto.getFormations().stream()
                    .map(f -> Formation.builder()
                            .diplome(f.getDiplome())
                            .etablissement(f.getEtablissement())
                            .ville(f.getVille())
                            .anneeDebut(f.getAnneeDebut())
                            .anneeFin(f.getAnneeFin())
                            .cv(cv)
                            .build())
                    .toList());
        }

        if (dto.getExperiences() != null) {
            cv.setExperiences(dto.getExperiences().stream()
                    .map(e -> Experience.builder()
                            .poste(e.getPoste())
                            .entreprise(e.getEntreprise())
                            .ville(e.getVille())
                            .dateDebut(e.getDateDebut())
                            .dateFin(e.getDateFin())
                            .description(e.getDescription())
                            .cv(cv)
                            .build())
                    .toList());
        }

        if (dto.getCompetences() != null) {
            cv.setCompetences(dto.getCompetences().stream()
                    .map(c -> Competence.builder()
                            .nom(c.getNom())
                            .niveau(c.getNiveau())
                            .cv(cv)
                            .build())
                    .toList());
        }

        if (dto.getLangues() != null) {
            cv.setLangues(dto.getLangues().stream()
                    .map(l -> Langue.builder()
                            .nom(l.getNom())
                            .niveau(l.getNiveau())
                            .cv(cv)
                            .build())
                    .toList());
        }

        if (dto.getInterets() != null) {
            cv.setInterets(dto.getInterets().stream()
                    .map(i -> Interet.builder()
                            .libelle(i.getLibelle())
                            .cv(cv)
                            .build())
                    .toList());
        }

        return cv;
    }

    /* ================= ENTITY -> RESPONSE ================= */

//     public static CvResponseDTO toResponse(Cv cv) {

//         return CvResponseDTO.builder()
//                 .id(cv.getId())
//                 .userId(cv.getUserId())
//                 .templateId(cv.getTemplate().getId())
//                 .templateNom(cv.getTemplate().getNom())
//                 .titreProfil(cv.getTitreProfil())
//                 .telephone(cv.getTelephone())
//                 .email(cv.getEmail())
//                 .prenom(cv.getPrenom())
//                 .nom(cv.getNom())
//                 .adresse(cv.getAdresse())
//                 .resumeProfil(cv.getResumeProfil())
//                 .createdAt(cv.getCreatedAt())
//                 .updatedAt(cv.getUpdatedAt())
//                 .formations(mapFormations(cv.getFormations()))
//                 .experiences(mapExperiences(cv.getExperiences()))
//                 .competences(mapCompetences(cv.getCompetences()))
//                 .langues(mapLangues(cv.getLangues()))
//                 .interets(mapInterets(cv.getInterets()))
//                 .build();
//     }

//     private static List<FormationResponseDTO> mapFormations(List<Formation> list) {
//         if (list == null) return List.of();
//         return list.stream().map(f ->
//                 FormationResponseDTO.builder()
//                         .diplome(f.getDiplome())
//                         .etablissement(f.getEtablissement())
//                         .ville(f.getVille())
//                         .anneeDebut(f.getAnneeDebut())
//                         .anneeFin(f.getAnneeFin())
//                         .build()
//         ).toList();
//     }

//     private static List<ExperienceResponseDTO> mapExperiences(List<Experience> list) {
//         if (list == null) return List.of();
//         return list.stream().map(e ->
//                 ExperienceResponseDTO.builder()
//                         .poste(e.getPoste())
//                         .entreprise(e.getEntreprise())
//                         .ville(e.getVille())
//                         .dateDebut(e.getDateDebut())
//                         .dateFin(e.getDateFin())
//                         .description(e.getDescription())
//                         .build()
//         ).toList();
//     }

//     private static List<CompetenceResponseDTO> mapCompetences(List<Competence> list) {
//         if (list == null) return List.of();
//         return list.stream().map(c ->
//                 CompetenceResponseDTO.builder()
//                         .nom(c.getNom())
//                         .niveau(c.getNiveau())
//                         .build()
//         ).toList();
//     }

//     private static List<LangueResponseDTO> mapLangues(List<Langue> list) {
//         if (list == null) return List.of();
//         return list.stream().map(l ->
//                 LangueResponseDTO.builder()
//                         .nom(l.getNom())
//                         .niveau(l.getNiveau())
//                         .build()
//         ).toList();
//     }

//     private static List<InteretResponseDTO> mapInterets(List<Interet> list) {
//         if (list == null) return List.of();
//         return list.stream().map(i ->
//                 InteretResponseDTO.builder()
//                         .libelle(i.getLibelle())
//                         .build()
//         ).toList();
//     }

    public static CvResponseDTO toResponse(Cv cv) {
    CvResponseDTO response = new CvResponseDTO();
    
    response.setId(cv.getId());
    response.setUserId(cv.getUserId());
    response.setTemplateId(cv.getTemplate().getId());
    response.setTemplateNom(cv.getTemplate().getNom());
    response.setTitreProfil(cv.getTitreProfil());
    response.setTelephone(cv.getTelephone());
    response.setEmail(cv.getEmail());
    response.setPrenom(cv.getPrenom());
    response.setNom(cv.getNom());
    response.setAdresse(cv.getAdresse());
    response.setResumeProfil(cv.getResumeProfil());
    response.setCreatedAt(cv.getCreatedAt().atOffset(ZoneOffset.UTC));
    response.setUpdatedAt(cv.getUpdatedAt().atOffset(ZoneOffset.UTC));
    response.setFormations(mapFormations(cv.getFormations()));
    response.setExperiences(mapExperiences(cv.getExperiences()));
    response.setCompetences(mapCompetences(cv.getCompetences()));
    response.setLangues(mapLangues(cv.getLangues()));
    response.setInterets(mapInterets(cv.getInterets()));
    
    return response;
}

private static List<FormationResponseDTO> mapFormations(List<Formation> list) {
    if (list == null) return List.of();
    
    List<FormationResponseDTO> result = new ArrayList<>();
    for (Formation f : list) {
        FormationResponseDTO dto = new FormationResponseDTO();
        dto.setDiplome(f.getDiplome());
        dto.setEtablissement(f.getEtablissement());
        dto.setVille(f.getVille());
        dto.setAnneeDebut(f.getAnneeDebut());
        dto.setAnneeFin(f.getAnneeFin());
        result.add(dto);
    }
    return result;
}

private static List<ExperienceResponseDTO> mapExperiences(List<Experience> list) {
    if (list == null) return List.of();
    
    List<ExperienceResponseDTO> result = new ArrayList<>();
    for (Experience e : list) {
        ExperienceResponseDTO dto = new ExperienceResponseDTO();
        dto.setPoste(e.getPoste());
        dto.setEntreprise(e.getEntreprise());
        dto.setVille(e.getVille());
        dto.setDateDebut(e.getDateDebut());
        dto.setDateFin(e.getDateFin());
        dto.setDescription(e.getDescription());
        result.add(dto);
    }
    return result;
}

private static List<CompetenceResponseDTO> mapCompetences(List<Competence> list) {
    if (list == null) return List.of();
    
    List<CompetenceResponseDTO> result = new ArrayList<>();
    for (Competence c : list) {
        CompetenceResponseDTO dto = new CompetenceResponseDTO();
        dto.setNom(c.getNom());
        dto.setNiveau(c.getNiveau());
        result.add(dto);
    }
    return result;
}

private static List<LangueResponseDTO> mapLangues(List<Langue> list) {
    if (list == null) return List.of();
    
    List<LangueResponseDTO> result = new ArrayList<>();
    for (Langue l : list) {
        LangueResponseDTO dto = new LangueResponseDTO();
        dto.setNom(l.getNom());
        dto.setNiveau(l.getNiveau());
        result.add(dto);
    }
    return result;
}

private static List<InteretResponseDTO> mapInterets(List<Interet> list) {
    if (list == null) return List.of();
    
    List<InteretResponseDTO> result = new ArrayList<>();
    for (Interet i : list) {
        InteretResponseDTO dto = new InteretResponseDTO();
        dto.setLibelle(i.getLibelle());
        result.add(dto);
    }
    return result;
}
}
