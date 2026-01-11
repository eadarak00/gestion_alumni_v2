package uasz.alumni.ms_cv_v2.mappers;


import java.util.List;

import uasz.alumni.ms_cv_v2.dtos.CompetenceResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.CvRequestDTO;
import uasz.alumni.ms_cv_v2.dtos.CvResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.ExperienceResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.FormationResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.InteretResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.LangueResponseDTO;
import uasz.alumni.ms_cv_v2.entities.Competence;
import uasz.alumni.ms_cv_v2.entities.Cv;
import uasz.alumni.ms_cv_v2.entities.Experience;
import uasz.alumni.ms_cv_v2.entities.Formation;
import uasz.alumni.ms_cv_v2.entities.Interet;
import uasz.alumni.ms_cv_v2.entities.Langue;
import uasz.alumni.ms_cv_v2.entities.Template;

public class CvMapper {

    /* ================= REQUEST -> ENTITY ================= */

    public static Cv toEntity(CvRequestDTO dto, Template template, Long userId) {

        Cv cv = Cv.builder()
                .userId(userId)
                .template(template)
                .titreProfil(dto.getTitreProfil())
                .telephone(dto.getTelephone())
                .email(dto.getEmail())
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

    public static CvResponseDTO toResponse(Cv cv) {

        return CvResponseDTO.builder()
                .id(cv.getId())
                .userId(cv.getUserId())
                .templateId(cv.getTemplate().getId())
                .templateNom(cv.getTemplate().getNom())
                .titreProfil(cv.getTitreProfil())
                .telephone(cv.getTelephone())
                .email(cv.getEmail())
                .adresse(cv.getAdresse())
                .resumeProfil(cv.getResumeProfil())
                .createdAt(cv.getCreatedAt())
                .updatedAt(cv.getUpdatedAt())
                .formations(mapFormations(cv.getFormations()))
                .experiences(mapExperiences(cv.getExperiences()))
                .competences(mapCompetences(cv.getCompetences()))
                .langues(mapLangues(cv.getLangues()))
                .interets(mapInterets(cv.getInterets()))
                .build();
    }

    private static List<FormationResponseDTO> mapFormations(List<Formation> list) {
        if (list == null) return List.of();
        return list.stream().map(f ->
                FormationResponseDTO.builder()
                        .diplome(f.getDiplome())
                        .etablissement(f.getEtablissement())
                        .ville(f.getVille())
                        .anneeDebut(f.getAnneeDebut())
                        .anneeFin(f.getAnneeFin())
                        .build()
        ).toList();
    }

    private static List<ExperienceResponseDTO> mapExperiences(List<Experience> list) {
        if (list == null) return List.of();
        return list.stream().map(e ->
                ExperienceResponseDTO.builder()
                        .poste(e.getPoste())
                        .entreprise(e.getEntreprise())
                        .ville(e.getVille())
                        .dateDebut(e.getDateDebut())
                        .dateFin(e.getDateFin())
                        .description(e.getDescription())
                        .build()
        ).toList();
    }

    private static List<CompetenceResponseDTO> mapCompetences(List<Competence> list) {
        if (list == null) return List.of();
        return list.stream().map(c ->
                CompetenceResponseDTO.builder()
                        .nom(c.getNom())
                        .niveau(c.getNiveau())
                        .build()
        ).toList();
    }

    private static List<LangueResponseDTO> mapLangues(List<Langue> list) {
        if (list == null) return List.of();
        return list.stream().map(l ->
                LangueResponseDTO.builder()
                        .nom(l.getNom())
                        .niveau(l.getNiveau())
                        .build()
        ).toList();
    }

    private static List<InteretResponseDTO> mapInterets(List<Interet> list) {
        if (list == null) return List.of();
        return list.stream().map(i ->
                InteretResponseDTO.builder()
                        .libelle(i.getLibelle())
                        .build()
        ).toList();
    }
}
