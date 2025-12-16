package uasz.alumni.ms_cv.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_cv.dto.request.ExperienceRequest;
import uasz.alumni.ms_cv.dto.response.ExperienceResponse;
import uasz.alumni.ms_cv.exception.*;
import uasz.alumni.ms_cv.model.CV;
import uasz.alumni.ms_cv.model.Experience;
import uasz.alumni.ms_cv.repository.CVRepository;
import uasz.alumni.ms_cv.repository.ExperienceRepository;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ExperienceService {
    
    private final ExperienceRepository experienceRepository;
    private final CVRepository cvRepository;
    
    private final Logger logger = LoggerFactory.getLogger(ExperienceService.class);
    
    private static final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|1[0-2])/[0-9]{4}$");
    
    /**
     * Crée une nouvelle expérience
     */
    public ExperienceResponse creerExperience(ExperienceRequest request) {
        logger.info("\n\nCréation d'une nouvelle expérience pour le CV: {}\n", 
                request != null ? request.getCvId() : null);
        
        try {
            // Validation des paramètres
            validerParametresCreationExperience(request);
            
            // Vérifier que le CV existe
            CV cv = cvRepository.findById(request.getCvId())
                    .orElseThrow(() -> new CVNotFoundException(request.getCvId()));
            
            // Créer l'expérience
            Experience experience = mapToExperience(request, cv);
            Experience savedExperience = experienceRepository.save(experience);
            
            logger.info("\n\nExpérience créée avec succès - ID: {}, Poste: {}, Entreprise: {}\n", 
                    savedExperience.getId(), savedExperience.getPoste(), savedExperience.getEntreprise());
            
            return mapToExperienceResponse(savedExperience);
            
        } catch (CVNotFoundException | ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la création de l'expérience: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la création de l'expérience: \n", e);
            throw new BadRequestException("Impossible de créer l'expérience. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une expérience par son ID
     */
    @Transactional(readOnly = true)
    public ExperienceResponse getExperienceById(Integer id) {
        logger.info("\n\nRecherche de l'expérience avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de l'expérience est invalide");
            }
            
            Experience experience = experienceRepository.findById(id)
                    .orElseThrow(() -> new ExperienceNotFoundException(id));
            
            logger.info("\n\nExpérience trouvée: {} chez {}\n", 
                    experience.getPoste(), experience.getEntreprise());
            
            return mapToExperienceResponse(experience);
            
        } catch (ExperienceNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de l'expérience: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de l'expérience {}: \n", id, e);
            throw new BadRequestException("Impossible de récupérer l'expérience. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une expérience par ID et CV ID (sécurité)
     */
    @Transactional(readOnly = true)
    public ExperienceResponse getExperienceByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRecherche de l'expérience {} pour le CV {}\n", id, cvId);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de l'expérience est invalide");
            }
            
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            Experience experience = experienceRepository.findByIdAndCvId(id, cvId)
                    .orElseThrow(() -> new ExperienceNotFoundException(id, cvId));
            
            logger.info("\n\nExpérience trouvée: {}\n", experience.getPoste());
            
            return mapToExperienceResponse(experience);
            
        } catch (ExperienceNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de l'expérience: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de l'expérience: \n", e);
            throw new BadRequestException("Impossible de récupérer l'expérience. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère toutes les expériences d'un CV
     */
    @Transactional(readOnly = true)
    public List<ExperienceResponse> getExperiencesByCvId(Integer cvId) {
        logger.info("\n\nRecherche des expériences du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            // Vérifier que le CV existe
            if (!cvRepository.existsById(cvId)) {
                throw new CVNotFoundException(cvId);
            }
            
            List<Experience> experiences = experienceRepository.findByCvIdOrderByDate(cvId);
            
            logger.info("\n\n{} expérience(s) trouvée(s) pour le CV {}\n", experiences.size(), cvId);
            
            return experiences.stream()
                    .map(this::mapToExperienceResponse)
                    .collect(Collectors.toList());
                    
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des expériences: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des expériences: \n", e);
            throw new BadRequestException("Impossible de récupérer les expériences. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère les expériences en cours d'un CV
     */
    @Transactional(readOnly = true)
    public List<ExperienceResponse> getExperiencesEnCours(Integer cvId) {
        logger.info("\n\nRecherche des expériences en cours du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            List<Experience> experiences = experienceRepository.findByCvIdAndEnCours(cvId, true);
            
            logger.info("\n\n{} expérience(s) en cours trouvée(s)\n", experiences.size());
            
            return experiences.stream()
                    .map(this::mapToExperienceResponse)
                    .collect(Collectors.toList());
                    
        } catch (BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des expériences en cours: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des expériences en cours: \n", e);
            throw new BadRequestException("Impossible de récupérer les expériences en cours. Veuillez réessayer.");
        }
    }
    
    /**
     * Met à jour une expérience
     */
    public ExperienceResponse updateExperience(Integer id, ExperienceRequest request) {
        logger.info("\n\nMise à jour de l'expérience avec ID: {}\n", id);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de l'expérience est invalide");
            }
            
            validerParametresCreationExperience(request);
            
            Experience experience = experienceRepository.findById(id)
                    .orElseThrow(() -> new ExperienceNotFoundException(id));
            
            // Vérifier que le CV ID correspond
            if (!experience.getCv().getId().equals(request.getCvId())) {
                throw new InvalidExperienceException("Le CV ID ne correspond pas à l'expérience");
            }
            
            // Mettre à jour les champs
            experience.setPoste(request.getPoste().trim());
            experience.setEntreprise(request.getEntreprise().trim());
            experience.setLocalisation(request.getLocalisation());
            experience.setDateDebut(request.getDateDebut());
            experience.setDateFin(request.getDateFin());
            experience.setEnCours(request.getEnCours());
            experience.setDescription(request.getDescription());
            
            Experience updatedExperience = experienceRepository.save(experience);
            
            logger.info("\n\nExpérience mise à jour avec succès - ID: {}, Poste: {}\n", 
                    id, updatedExperience.getPoste());
            
            return mapToExperienceResponse(updatedExperience);
            
        } catch (ExperienceNotFoundException | InvalidExperienceException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la mise à jour de l'expérience: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la mise à jour de l'expérience: \n", e);
            throw new BadRequestException("Impossible de mettre à jour l'expérience. Veuillez réessayer.");
        }
    }
    
    /**
     * Supprime une expérience
     */
    public void supprimerExperience(Integer id) {
        logger.info("\n\nSuppression de l'expérience avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de l'expérience est invalide");
            }
            
            Experience experience = experienceRepository.findById(id)
                    .orElseThrow(() -> new ExperienceNotFoundException(id));
            
            experienceRepository.deleteById(id);
            
            logger.info("\n\nExpérience supprimée avec succès - ID: {}, Poste: {}\n", 
                    id, experience.getPoste());
            
        } catch (ExperienceNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la suppression de l'expérience: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la suppression de l'expérience: \n", e);
            throw new BadRequestException("Impossible de supprimer l'expérience. Veuillez réessayer.");
        }
    }
    
    // ========== MÉTHODES PRIVÉES DE VALIDATION ==========
    
    /**
     * Valide les paramètres de création d'expérience
     */
    private void validerParametresCreationExperience(ExperienceRequest request) {
        if (request == null) {
            throw new BadRequestException("Les données de l'expérience sont manquantes");
        }
        
        // Validation du CV ID
        if (request.getCvId() == null || request.getCvId() <= 0) {
            throw new ValidationException("cvId", "L'identifiant du CV est invalide");
        }
        
        // Validation du poste
        if (request.getPoste() == null || request.getPoste().trim().isEmpty()) {
            throw new ValidationException("poste", "Le poste est obligatoire");
        }
        
        if (request.getPoste().trim().length() < 2) {
            throw new ValidationException("poste", "Le poste doit contenir au moins 2 caractères");
        }
        
        if (request.getPoste().length() > 100) {
            throw new ValidationException("poste", "Le poste ne peut pas dépasser 100 caractères");
        }
        
        // Validation de l'entreprise
        if (request.getEntreprise() == null || request.getEntreprise().trim().isEmpty()) {
            throw new ValidationException("entreprise", "L'entreprise est obligatoire");
        }
        
        if (request.getEntreprise().trim().length() < 2) {
            throw new ValidationException("entreprise", "L'entreprise doit contenir au moins 2 caractères");
        }
        
        if (request.getEntreprise().length() > 100) {
            throw new ValidationException("entreprise", "L'entreprise ne peut pas dépasser 100 caractères");
        }
        
        // Validation de la date de début
        if (request.getDateDebut() == null || request.getDateDebut().trim().isEmpty()) {
            throw new ValidationException("dateDebut", "La date de début est obligatoire");
        }
        
        if (!DATE_PATTERN.matcher(request.getDateDebut()).matches()) {
            throw new ValidationException("dateDebut", "La date doit être au format MM/YYYY");
        }
        
        // Validation de la date de fin
        if (request.getEnCours() != null && request.getEnCours()) {
            // Si en cours, date de fin doit être null
            if (request.getDateFin() != null && !request.getDateFin().trim().isEmpty()) {
                throw new InvalidExperienceException(
                        "Une expérience en cours ne peut pas avoir de date de fin");
            }
        } else {
            // Si pas en cours, date de fin doit être fournie
            if (request.getDateFin() == null || request.getDateFin().trim().isEmpty()) {
                throw new ValidationException("dateFin", 
                        "La date de fin est obligatoire pour une expérience terminée");
            }
            
            if (!DATE_PATTERN.matcher(request.getDateFin()).matches()) {
                throw new ValidationException("dateFin", "La date doit être au format MM/YYYY");
            }
            
            // Vérifier que date de fin > date de début
            validerCoherenceDates(request.getDateDebut(), request.getDateFin());
        }
        
        // Validation de la description (optionnelle)
        if (request.getDescription() != null && request.getDescription().length() > 2000) {
            throw new ValidationException("description", 
                    "La description ne peut pas dépasser 2000 caractères");
        }
    }
    
    /**
     * Valide la cohérence des dates
     */
    private void validerCoherenceDates(String dateDebut, String dateFin) {
        try {
            String[] debutParts = dateDebut.split("/");
            String[] finParts = dateFin.split("/");
            
            int moisDebut = Integer.parseInt(debutParts[0]);
            int anneeDebut = Integer.parseInt(debutParts[1]);
            
            int moisFin = Integer.parseInt(finParts[0]);
            int anneeFin = Integer.parseInt(finParts[1]);
            
            if (anneeFin < anneeDebut || (anneeFin == anneeDebut && moisFin < moisDebut)) {
                throw new InvalidExperienceException(
                        "La date de fin doit être postérieure à la date de début");
            }
        } catch (NumberFormatException e) {
            throw new InvalidExperienceException("Format de date invalide");
        }
    }
    
    // ========== MÉTHODES DE MAPPING ==========
    
    /**
     * Mappe ExperienceRequest vers Experience
     */
    private Experience mapToExperience(ExperienceRequest request, CV cv) {
        try {
            return Experience.builder()
                    .cv(cv)
                    .poste(request.getPoste().trim())
                    .entreprise(request.getEntreprise().trim())
                    .localisation(request.getLocalisation())
                    .dateDebut(request.getDateDebut())
                    .dateFin(request.getDateFin())
                    .enCours(request.getEnCours() != null ? request.getEnCours() : false)
                    .description(request.getDescription())
                    .build();
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping ExperienceRequest vers Experience: \n", e);
            throw new BadRequestException("Erreur lors de la création de l'expérience");
        }
    }
    
    /**
     * Mappe Experience vers ExperienceResponse
     */
    private ExperienceResponse mapToExperienceResponse(Experience experience) {
        try {
            if (experience == null) {
                throw new BadRequestException("L'expérience ne peut pas être null");
            }
            
            return ExperienceResponse.builder()
                    .id(experience.getId())
                    .cvId(experience.getCv().getId())
                    .poste(experience.getPoste())
                    .entreprise(experience.getEntreprise())
                    .localisation(experience.getLocalisation())
                    .dateDebut(experience.getDateDebut())
                    .dateFin(experience.getDateFin())
                    .enCours(experience.getEnCours())
                    .description(experience.getDescription())
                    .dateCreation(experience.getDateCreation())
                    .dateDerniereModification(experience.getDateDerniereModification())
                    .build();
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping Experience vers ExperienceResponse: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse");
        }
    }
}