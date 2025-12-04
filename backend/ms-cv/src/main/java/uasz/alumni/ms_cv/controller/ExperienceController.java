package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.dto.request.ExperienceRequest;
import uasz.alumni.ms_cv.dto.response.ExperienceResponse;
import uasz.alumni.ms_cv.service.ExperienceService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    
    private final ExperienceService experienceService;
    private final Logger logger = LoggerFactory.getLogger(ExperienceController.class);
    
    /**
     * Crée une nouvelle expérience
     * POST /api/experiences
     */
    @PostMapping
    public ResponseEntity<ExperienceResponse> creerExperience(@Valid @RequestBody ExperienceRequest request) {
        logger.info("\n\n========== CRÉATION D'UNE NOUVELLE EXPÉRIENCE ==========\n");
        logger.info("\n\nRequête reçue pour créer une expérience - CV: {}, Poste: {}\n", 
                request.getCvId(), request.getPoste());
        
        ExperienceResponse response = experienceService.creerExperience(request);
        
        logger.info("\n\nExpérience créée avec succès - ID: {}\n", response.getId());
        logger.info("\n\n========== FIN CRÉATION EXPÉRIENCE ==========\n");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    /**
     * Récupère une expérience par son ID
     * GET /api/experiences/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponse> getExperienceById(@PathVariable Integer id) {
        logger.info("\n\n========== RÉCUPÉRATION D'UNE EXPÉRIENCE ==========\n");
        logger.info("\n\nRequête reçue pour récupérer l'expérience avec ID: {}\n", id);
        
        ExperienceResponse response = experienceService.getExperienceById(id);
        
        logger.info("\n\nExpérience récupérée avec succès - Poste: {}\n", response.getPoste());
        logger.info("\n\n========== FIN RÉCUPÉRATION EXPÉRIENCE ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère une expérience par ID et CV ID
     * GET /api/experiences/{id}/cv/{cvId}
     */
    @GetMapping("/{id}/cv/{cvId}")
    public ResponseEntity<ExperienceResponse> getExperienceByIdAndCvId(
            @PathVariable Integer id,
            @PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION EXPÉRIENCE PAR CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer l'expérience {} du CV {}\n", id, cvId);
        
        ExperienceResponse response = experienceService.getExperienceByIdAndCvId(id, cvId);
        
        logger.info("\n\nExpérience récupérée avec succès\n");
        logger.info("\n\n========== FIN RÉCUPÉRATION EXPÉRIENCE PAR CV ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère toutes les expériences d'un CV
     * GET /api/experiences/cv/{cvId}
     */
    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<ExperienceResponse>> getExperiencesByCvId(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION DES EXPÉRIENCES D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les expériences du CV: {}\n", cvId);
        
        List<ExperienceResponse> responses = experienceService.getExperiencesByCvId(cvId);
        
        logger.info("\n\n{} expérience(s) récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION EXPÉRIENCES CV ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère les expériences en cours d'un CV
     * GET /api/experiences/cv/{cvId}/en-cours
     */
    @GetMapping("/cv/{cvId}/en-cours")
    public ResponseEntity<List<ExperienceResponse>> getExperiencesEnCours(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION EXPÉRIENCES EN COURS ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les expériences en cours du CV: {}\n", cvId);
        
        List<ExperienceResponse> responses = experienceService.getExperiencesEnCours(cvId);
        
        logger.info("\n\n{} expérience(s) en cours récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION EXPÉRIENCES EN COURS ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Met à jour une expérience
     * PUT /api/experiences/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponse> updateExperience(
            @PathVariable Integer id,
            @Valid @RequestBody ExperienceRequest request) {
        logger.info("\n\n========== MISE À JOUR D'UNE EXPÉRIENCE ==========\n");
        logger.info("\n\nRequête reçue pour mettre à jour l'expérience avec ID: {}\n", id);
        
        ExperienceResponse response = experienceService.updateExperience(id, request);
        
        logger.info("\n\nExpérience mise à jour avec succès - Poste: {}\n", response.getPoste());
        logger.info("\n\n========== FIN MISE À JOUR EXPÉRIENCE ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Supprime une expérience
     * DELETE /api/experiences/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerExperience(@PathVariable Integer id) {
        logger.info("\n\n========== SUPPRESSION D'UNE EXPÉRIENCE ==========\n");
        logger.info("\n\nRequête reçue pour supprimer l'expérience avec ID: {}\n", id);
        
        experienceService.supprimerExperience(id);
        
        logger.info("\n\nExpérience supprimée avec succès\n");
        logger.info("\n\n========== FIN SUPPRESSION EXPÉRIENCE ==========\n");
        
        return ResponseEntity.noContent().build();
    }
}