package uasz.alumni.ms_cv_v2.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_cv_v2.dtos.CvRequestDTO;
import uasz.alumni.ms_cv_v2.dtos.CvResponseDTO;
import uasz.alumni.ms_cv_v2.entities.Competence;
import uasz.alumni.ms_cv_v2.entities.Cv;
import uasz.alumni.ms_cv_v2.entities.Experience;
import uasz.alumni.ms_cv_v2.entities.Formation;
import uasz.alumni.ms_cv_v2.entities.Interet;
import uasz.alumni.ms_cv_v2.entities.Langue;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.mappers.CvMapper;
import uasz.alumni.ms_cv_v2.repository.CvRepository;
import uasz.alumni.ms_cv_v2.repository.TemplateRepository;
import uasz.alumni.ms_cv_v2.clients.UserClient;
import uasz.alumni.ms_cv_v2.clients.dto.UtilisateurResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CvService {

        private final CvRepository cvRepository;
        private final TemplateRepository templateRepository;
        private final UserClient userClient;

        /* ================= CREATE ================= */

        public CvResponseDTO createCv(CvRequestDTO dto, Long userId) {

                Template template = templateRepository.findById(dto.getTemplateId())
                                .orElseThrow(() -> new EntityNotFoundException("Template introuvable"));

                Cv cv = CvMapper.toEntity(dto, template, userId);

                Cv saved = cvRepository.save(cv);

                // Récupération info utilisateur depuis ms-user
                UtilisateurResponseDto user = userClient.getUtilisateur(userId);

                CvResponseDTO cvDto = CvMapper.toResponse(saved);

                // Ajout info utilisateur
                cvDto.setPrenom(user.getPrenom());
                cvDto.setNom(user.getNom());
                cvDto.setEmail(user.getEmail());

                return cvDto;
        }

        /* ================= UPDATE ================= */

        public CvResponseDTO updateCv(Long cvId, CvRequestDTO dto, Long userId) {

                Cv existing = cvRepository.findByIdAndUserId(cvId, userId)
                                .orElseThrow(() -> new EntityNotFoundException("CV introuvable ou accès interdit"));

                Template template = templateRepository.findById(dto.getTemplateId())
                                .orElseThrow(() -> new EntityNotFoundException("Template introuvable"));

                /* ---- champs simples ---- */

                existing.setTemplate(template);
                existing.setTitreProfil(dto.getTitreProfil());
                existing.setTelephone(dto.getTelephone());
                existing.setEmail(dto.getEmail());
                existing.setAdresse(dto.getAdresse());
                existing.setResumeProfil(dto.getResumeProfil());

                /* ---- nettoyage relations (orphanRemoval) ---- */

                existing.getFormations().clear();
                existing.getExperiences().clear();
                existing.getCompetences().clear();
                existing.getLangues().clear();
                existing.getInterets().clear();

                /* ---- re-ajout depuis DTO ---- */

                if (dto.getFormations() != null) {
                        dto.getFormations().forEach(f -> existing.getFormations().add(
                                        Formation.builder()
                                                        .diplome(f.getDiplome())
                                                        .etablissement(f.getEtablissement())
                                                        .ville(f.getVille())
                                                        .anneeDebut(f.getAnneeDebut())
                                                        .anneeFin(f.getAnneeFin())
                                                        .cv(existing)
                                                        .build()));
                }

                if (dto.getExperiences() != null) {
                        dto.getExperiences().forEach(e -> existing.getExperiences().add(
                                        Experience.builder()
                                                        .poste(e.getPoste())
                                                        .entreprise(e.getEntreprise())
                                                        .ville(e.getVille())
                                                        .dateDebut(e.getDateDebut())
                                                        .dateFin(e.getDateFin())
                                                        .description(e.getDescription())
                                                        .cv(existing)
                                                        .build()));
                }

                if (dto.getCompetences() != null) {
                        dto.getCompetences().forEach(c -> existing.getCompetences().add(
                                        Competence.builder()
                                                        .nom(c.getNom())
                                                        .niveau(c.getNiveau())
                                                        .cv(existing)
                                                        .build()));
                }

                if (dto.getLangues() != null) {
                        dto.getLangues().forEach(l -> existing.getLangues().add(
                                        Langue.builder()
                                                        .nom(l.getNom())
                                                        .niveau(l.getNiveau())
                                                        .cv(existing)
                                                        .build()));
                }

                if (dto.getInterets() != null) {
                        dto.getInterets().forEach(i -> existing.getInterets().add(
                                        Interet.builder()
                                                        .libelle(i.getLibelle())
                                                        .cv(existing)
                                                        .build()));
                }

                Cv saved = cvRepository.save(existing);

                return CvMapper.toResponse(saved);
        }

        /* ================= READ ================= */

        @Transactional(readOnly = true)
        public List<CvResponseDTO> getMyCvs(Long userId) {

                return cvRepository.findByUserId(userId)
                                .stream()
                                .map(CvMapper::toResponse)
                                .toList();
        }

        @Transactional(readOnly = true)
        public CvResponseDTO getCvById(Long cvId, Long userId) {

                Cv cv = cvRepository.findByIdAndUserId(cvId, userId)
                                .orElseThrow(() -> new EntityNotFoundException("CV introuvable ou accès interdit"));

                // Récupération info utilisateur depuis ms-user
                UtilisateurResponseDto user = userClient.getUtilisateur(userId);

                CvResponseDTO dto = CvMapper.toResponse(cv);

                // Ajout info utilisateur
                dto.setPrenom(user.getPrenom());
                dto.setNom(user.getNom());
                dto.setEmail(user.getEmail());

                return dto;
        }

        /* ================= DELETE ================= */

        public void deleteCv(Long cvId, Long userId) {

                Cv cv = cvRepository.findByIdAndUserId(cvId, userId)
                                .orElseThrow(() -> new EntityNotFoundException("CV introuvable ou accès interdit"));

                cvRepository.delete(cv);
        }
}
