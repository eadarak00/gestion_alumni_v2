package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.dto.request.FormationRequest;
import uasz.alumni.ms_cv.dto.response.FormationResponse;
import uasz.alumni.ms_cv.service.FormationService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/formations")
@RequiredArgsConstructor
public class FormationController {
    
    private final FormationService formationService;
    private final Logger logger = LoggerFactory.getLogger(FormationController.class);
    
    /**
     * Crée une nouvelle formation
     * POST /api/formations
     */
    @PostMapping
    public ResponseEntity<FormationResponse> creerFormation(@Valid @RequestBody FormationRequest request) {
        logger.info("\n\n========== CRÉATION D'UNE NOUVELLE FORMATION ==========\n");
        logger.info("\n\nRequête reçue pour créer une formation - CV: {}, Diplôme: {}\n", 
                request.getCvId(), request.getDiplome());
        
        FormationResponse response = formationService.creerFormation(request);
        
        logger.info("\n\nFormation créée avec succès - ID: {}\n", response.getId());
        logger.info("\n\n========== FIN CRÉATION FORMATION ==========\n");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    /**
     * Récupère une formation par son ID
     * GET /api/formations/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<FormationResponse> getFormationById(@PathVariable Integer id) {
        logger.info("\n\n========== RÉCUPÉRATION D'UNE FORMATION ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la formation avec ID: {}\n", id);
        
        FormationResponse response = formationService.getFormationById(id);
        
        logger.info("\n\nFormation récupérée avec succès - Diplôme: {}\n", response.getDiplome());
        logger.info("\n\n========== FIN RÉCUPÉRATION FORMATION ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère une formation par ID et CV ID
     * GET /api/formations/{id}/cv/{cvId}
     */
    @GetMapping("/{id}/cv/{cvId}")
    public ResponseEntity<FormationResponse> getFormationByIdAndCvId(
            @PathVariable Integer id,
            @PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION FORMATION PAR CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la formation {} du CV {}\n", id, cvId);
        
        FormationResponse response = formationService.getFormationByIdAndCvId(id, cvId);
        
        logger.info("\n\nFormation récupérée avec succès\n");
        logger.info("\n\n========== FIN RÉCUPÉRATION FORMATION PAR CV ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère toutes les formations d'un CV
     * GET /api/formations/cv/{cvId}
     */
    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<FormationResponse>> getFormationsByCvId(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION DES FORMATIONS D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les formations du CV: {}\n", cvId);
        
        List<FormationResponse> responses = formationService.getFormationsByCvId(cvId);
        
        logger.info("\n\n{} formation(s) récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION FORMATIONS CV ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère les formations en cours d'un CV
     * GET /api/formations/cv/{cvId}/en-cours
     */
    @GetMapping("/cv/{cvId}/en-cours")
    public ResponseEntity<List<FormationResponse>> getFormationsEnCours(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION FORMATIONS EN COURS ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les formations en cours du CV: {}\n", cvId);
        
        List<FormationResponse> responses = formationService.getFormationsEnCours(cvId);
        
        logger.info("\n\n{} formation(s) en cours récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION FORMATIONS EN COURS ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Met à jour une formation
     * PUT /api/formations/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<FormationResponse> updateFormation(
            @PathVariable Integer id,
            @Valid @RequestBody FormationRequest request) {
        logger.info("\n\n========== MISE À JOUR D'UNE FORMATION ==========\n");
        logger.info("\n\nRequête reçue pour mettre à jour la formation avec ID: {}\n", id);
        
        FormationResponse response = formationService.updateFormation(id, request);
        
        logger.info("\n\nFormation mise à jour avec succès - Diplôme: {}\n", response.getDiplome());
        logger.info("\n\n========== FIN MISE À JOUR FORMATION ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Supprime une formation
     * DELETE /api/formations/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFormation(@PathVariable Integer id) {
        logger.info("\n\n========== SUPPRESSION D'UNE FORMATION ==========\n");
        logger.info("\n\nRequête reçue pour supprimer la formation avec ID: {}\n", id);
        
        formationService.supprimerFormation(id);
        
        logger.info("\n\nFormation supprimée avec succès\n");
        logger.info("\n\n========== FIN SUPPRESSION FORMATION ==========\n");
        
        return ResponseEntity.noContent().build();
    }
}