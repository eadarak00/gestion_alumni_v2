package uasz.alumni.ms_cv.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_cv.dto.request.FormationRequest;
import uasz.alumni.ms_cv.dto.response.FormationResponse;
import uasz.alumni.ms_cv.exception.*;
import uasz.alumni.ms_cv.model.CV;
import uasz.alumni.ms_cv.model.Formation;
import uasz.alumni.ms_cv.repository.CVRepository;
import uasz.alumni.ms_cv.repository.FormationRepository;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FormationService {
    
    private final FormationRepository formationRepository;
    private final CVRepository cvRepository;
    
    private final Logger logger = LoggerFactory.getLogger(FormationService.class);
    
    private static final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|1[0-2])/[0-9]{4}$");
    
    /**
     * Crée une nouvelle formation
     */
    public FormationResponse creerFormation(FormationRequest request) {
        logger.info("\n\nCréation d'une nouvelle formation pour le CV: {}\n", 
                request != null ? request.getCvId() : null);
        
        try {
            // Validation des paramètres
            validerParametresCreationFormation(request);
            
            // Vérifier que le CV existe
            CV cv = cvRepository.findById(request.getCvId())
                    .orElseThrow(() -> new CVNotFoundException(request.getCvId()));
            
            // Créer la formation
            Formation formation = mapToFormation(request, cv);
            Formation savedFormation = formationRepository.save(formation);
            
            logger.info("\n\nFormation créée avec succès - ID: {}, Diplôme: {}, Établissement: {}\n", 
                    savedFormation.getId(), savedFormation.getDiplome(), savedFormation.getEtablissement());
            
            return mapToFormationResponse(savedFormation);
            
        } catch (CVNotFoundException | ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la création de la formation: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la création de la formation: \n", e);
            throw new BadRequestException("Impossible de créer la formation. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une formation par son ID
     */
    @Transactional(readOnly = true)
    public FormationResponse getFormationById(Integer id) {
        logger.info("\n\nRecherche de la formation avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la formation est invalide");
            }
            
            Formation formation = formationRepository.findById(id)
                    .orElseThrow(() -> new FormationNotFoundException(id));
            
            logger.info("\n\nFormation trouvée: {} à {}\n", 
                    formation.getDiplome(), formation.getEtablissement());
            
            return mapToFormationResponse(formation);
            
        } catch (FormationNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la formation: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la formation {}: \n", id, e);
            throw new BadRequestException("Impossible de récupérer la formation. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une formation par ID et CV ID (sécurité)
     */
    @Transactional(readOnly = true)
    public FormationResponse getFormationByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRecherche de la formation {} pour le CV {}\n", id, cvId);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la formation est invalide");
            }
            
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            Formation formation = formationRepository.findByIdAndCvId(id, cvId)
                    .orElseThrow(() -> new FormationNotFoundException(id, cvId));
            
            logger.info("\n\nFormation trouvée: {}\n", formation.getDiplome());
            
            return mapToFormationResponse(formation);
            
        } catch (FormationNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la formation: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la formation: \n", e);
            throw new BadRequestException("Impossible de récupérer la formation. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère toutes les formations d'un CV
     */
    @Transactional(readOnly = true)
    public List<FormationResponse> getFormationsByCvId(Integer cvId) {
        logger.info("\n\nRecherche des formations du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            // Vérifier que le CV existe
            if (!cvRepository.existsById(cvId)) {
                throw new CVNotFoundException(cvId);
            }
            
            List<Formation> formations = formationRepository.findByCvIdOrderByDate(cvId);
            
            logger.info("\n\n{} formation(s) trouvée(s) pour le CV {}\n", formations.size(), cvId);
            
            return formations.stream()
                    .map(this::mapToFormationResponse)
                    .collect(Collectors.toList());
                    
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des formations: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des formations: \n", e);
            throw new BadRequestException("Impossible de récupérer les formations. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère les formations en cours d'un CV
     */
    @Transactional(readOnly = true)
    public List<FormationResponse> getFormationsEnCours(Integer cvId) {
        logger.info("\n\nRecherche des formations en cours du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            List<Formation> formations = formationRepository.findByCvIdAndEnCours(cvId, true);
            
            logger.info("\n\n{} formation(s) en cours trouvée(s)\n", formations.size());
            
            return formations.stream()
                    .map(this::mapToFormationResponse)
                    .collect(Collectors.toList());
                    
        } catch (BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des formations en cours: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des formations en cours: \n", e);
            throw new BadRequestException("Impossible de récupérer les formations en cours. Veuillez réessayer.");
        }
    }
    
    /**
     * Met à jour une formation
     */
    public FormationResponse updateFormation(Integer id, FormationRequest request) {
        logger.info("\n\nMise à jour de la formation avec ID: {}\n", id);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la formation est invalide");
            }
            
            validerParametresCreationFormation(request);
            
            Formation formation = formationRepository.findById(id)
                    .orElseThrow(() -> new FormationNotFoundException(id));
            
            // Vérifier que le CV ID correspond
            if (!formation.getCv().getId().equals(request.getCvId())) {
                throw new InvalidFormationException("Le CV ID ne correspond pas à la formation");
            }
            
            // Mettre à jour les champs
            formation.setDiplome(request.getDiplome().trim());
            formation.setEtablissement(request.getEtablissement().trim());
            formation.setLocalisation(request.getLocalisation());
            formation.setDateDebut(request.getDateDebut());
            formation.setDateFin(request.getDateFin());
            formation.setEnCours(request.getEnCours());
            formation.setDescription(request.getDescription());
            
            Formation updatedFormation = formationRepository.save(formation);
            
            logger.info("\n\nFormation mise à jour avec succès - ID: {}, Diplôme: {}\n", 
                    id, updatedFormation.getDiplome());
            
            return mapToFormationResponse(updatedFormation);
            
        } catch (FormationNotFoundException | InvalidFormationException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la mise à jour de la formation: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la mise à jour de la formation: \n", e);
            throw new BadRequestException("Impossible de mettre à jour la formation. Veuillez réessayer.");
        }
    }
    
    /**
     * Supprime une formation
     */
    public void supprimerFormation(Integer id) {
        logger.info("\n\nSuppression de la formation avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la formation est invalide");
            }
            
            Formation formation = formationRepository.findById(id)
                    .orElseThrow(() -> new FormationNotFoundException(id));
            
            formationRepository.deleteById(id);
            
            logger.info("\n\nFormation supprimée avec succès - ID: {}, Diplôme: {}\n", 
                    id, formation.getDiplome());
            
        } catch (FormationNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la suppression de la formation: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la suppression de la formation: \n", e);
            throw new BadRequestException("Impossible de supprimer la formation. Veuillez réessayer.");
        }
    }
    
    // ========== MÉTHODES PRIVÉES DE VALIDATION ==========
    
    /**
     * Valide les paramètres de création de formation
     */
    private void validerParametresCreationFormation(FormationRequest request) {
        if (request == null) {
            throw new BadRequestException("Les données de la formation sont manquantes");
        }
        
        // Validation du CV ID
        if (request.getCvId() == null || request.getCvId() <= 0) {
            throw new ValidationException("cvId", "L'identifiant du CV est invalide");
        }
        
        // Validation du diplôme
        if (request.getDiplome() == null || request.getDiplome().trim().isEmpty()) {
            throw new ValidationException("diplome", "Le diplôme est obligatoire");
        }
        
        if (request.getDiplome().trim().length() < 2) {
            throw new ValidationException("diplome", "Le diplôme doit contenir au moins 2 caractères");
        }
        
        if (request.getDiplome().length() > 150) {
            throw new ValidationException("diplome", "Le diplôme ne peut pas dépasser 150 caractères");
        }
        
        // Validation de l'établissement
        if (request.getEtablissement() == null || request.getEtablissement().trim().isEmpty()) {
            throw new ValidationException("etablissement", "L'établissement est obligatoire");
        }
        
        if (request.getEtablissement().trim().length() < 2) {
            throw new ValidationException("etablissement", "L'établissement doit contenir au moins 2 caractères");
        }
        
        if (request.getEtablissement().length() > 150) {
            throw new ValidationException("etablissement", "L'établissement ne peut pas dépasser 150 caractères");
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
                throw new InvalidFormationException(
                        "Une formation en cours ne peut pas avoir de date de fin");
            }
        } else {
            // Si pas en cours, date de fin doit être fournie
            if (request.getDateFin() == null || request.getDateFin().trim().isEmpty()) {
                throw new ValidationException("dateFin", 
                        "La date de fin est obligatoire pour une formation terminée");
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
                throw new InvalidFormationException(
                        "La date de fin doit être postérieure à la date de début");
            }
        } catch (NumberFormatException e) {
            throw new InvalidFormationException("Format de date invalide");
        }
    }
    
    // ========== MÉTHODES DE MAPPING ==========
    
    /**
     * Mappe FormationRequest vers Formation
     */
    private Formation mapToFormation(FormationRequest request, CV cv) {
        try {
            return Formation.builder()
                    .cv(cv)
                    .diplome(request.getDiplome().trim())
                    .etablissement(request.getEtablissement().trim())
                    .localisation(request.getLocalisation())
                    .dateDebut(request.getDateDebut())
                    .dateFin(request.getDateFin())
                    .enCours(request.getEnCours() != null ? request.getEnCours() : false)
                    .description(request.getDescription())
                    .build();
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping FormationRequest vers Formation: \n", e);
            throw new BadRequestException("Erreur lors de la création de la formation");
        }
    }
    
    /**
     * Mappe Formation vers FormationResponse
     */
    private FormationResponse mapToFormationResponse(Formation formation) {
        try {
            if (formation == null) {
                throw new BadRequestException("La formation ne peut pas être null");
            }
            
            return FormationResponse.builder()
                    .id(formation.getId())
                    .cvId(formation.getCv().getId())
                    .diplome(formation.getDiplome())
                    .etablissement(formation.getEtablissement())
                    .localisation(formation.getLocalisation())
                    .dateDebut(formation.getDateDebut())
                    .dateFin(formation.getDateFin())
                    .enCours(formation.getEnCours())
                    .description(formation.getDescription())
                    .dateCreation(formation.getDateCreation())
                    .dateDerniereModification(formation.getDateDerniereModification())
                    .build();
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping Formation vers FormationResponse: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse");
        }
    }
}