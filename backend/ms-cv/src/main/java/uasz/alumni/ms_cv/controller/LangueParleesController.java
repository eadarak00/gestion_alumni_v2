package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.dto.request.LangueParleesRequest;
import uasz.alumni.ms_cv.dto.response.LangueParleesResponse;
import uasz.alumni.ms_cv.model.NiveauLangue;
import uasz.alumni.ms_cv.service.LangueParleesService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/langues-parlees")
@RequiredArgsConstructor
public class LangueParleesController {
    
    private final LangueParleesService langueParleesService;
    private final Logger logger = LoggerFactory.getLogger(LangueParleesController.class);
    
    /**
     * Crée une nouvelle langue parlée
     * POST /api/langues-parlees
     */
    @PostMapping
    public ResponseEntity<LangueParleesResponse> creerLangueParlees(@Valid @RequestBody LangueParleesRequest request) {
        logger.info("\n\n========== CRÉATION D'UNE NOUVELLE LANGUE PARLÉE ==========\n");
        logger.info("\n\nRequête reçue pour créer une langue parlée - CV: {}, Langue: {}\n", 
                request.getCvId(), request.getLangue());
        
        LangueParleesResponse response = langueParleesService.creerLangueParlees(request);
        
        logger.info("\n\nLangue parlée créée avec succès - ID: {}\n", response.getId());
        logger.info("\n\n========== FIN CRÉATION LANGUE PARLÉE ==========\n");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    /**
     * Récupère une langue parlée par son ID
     * GET /api/langues-parlees/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<LangueParleesResponse> getLangueParleesById(@PathVariable Integer id) {
        logger.info("\n\n========== RÉCUPÉRATION D'UNE LANGUE PARLÉE ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la langue parlée avec ID: {}\n", id);
        
        LangueParleesResponse response = langueParleesService.getLangueParleesById(id);
        
        logger.info("\n\nLangue parlée récupérée avec succès - Langue: {}\n", response.getLangue());
        logger.info("\n\n========== FIN RÉCUPÉRATION LANGUE PARLÉE ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère une langue parlée par ID et CV ID
     * GET /api/langues-parlees/{id}/cv/{cvId}
     */
    @GetMapping("/{id}/cv/{cvId}")
    public ResponseEntity<LangueParleesResponse> getLangueParleesByIdAndCvId(
            @PathVariable Integer id,
            @PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION LANGUE PARLÉE PAR CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la langue parlée {} du CV {}\n", id, cvId);
        
        LangueParleesResponse response = langueParleesService.getLangueParleesByIdAndCvId(id, cvId);
        
        logger.info("\n\nLangue parlée récupérée avec succès\n");
        logger.info("\n\n========== FIN RÉCUPÉRATION LANGUE PARLÉE PAR CV ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère toutes les langues parlées d'un CV
     * GET /api/langues-parlees/cv/{cvId}
     */
    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<LangueParleesResponse>> getLanguesParleesByCvId(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION DES LANGUES PARLÉES D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les langues parlées du CV: {}\n", cvId);
        
        List<LangueParleesResponse> responses = langueParleesService.getLanguesParleesByCvId(cvId);
        
        logger.info("\n\n{} langue(s) parlée(s) récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION LANGUES PARLÉES CV ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère les langues parlées par niveau
     * GET /api/langues-parlees/cv/{cvId}/niveau/{niveau}
     */
    @GetMapping("/cv/{cvId}/niveau/{niveau}")
    public ResponseEntity<List<LangueParleesResponse>> getLanguesParleesByNiveau(
            @PathVariable Integer cvId,
            @PathVariable NiveauLangue niveau) {
        logger.info("\n\n========== RÉCUPÉRATION LANGUES PARLÉES PAR NIVEAU ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les langues de niveau {} du CV: {}\n", 
                niveau, cvId);
        
        List<LangueParleesResponse> responses = langueParleesService.getLanguesParleesByNiveau(cvId, niveau);
        
        logger.info("\n\n{} langue(s) de niveau {} récupérée(s)\n", responses.size(), niveau);
        logger.info("\n\n========== FIN RÉCUPÉRATION LANGUES PARLÉES PAR NIVEAU ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Met à jour une langue parlée
     * PUT /api/langues-parlees/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<LangueParleesResponse> updateLangueParlees(
            @PathVariable Integer id,
            @Valid @RequestBody LangueParleesRequest request) {
        logger.info("\n\n========== MISE À JOUR D'UNE LANGUE PARLÉE ==========\n");
        logger.info("\n\nRequête reçue pour mettre à jour la langue parlée avec ID: {}\n", id);
        
        LangueParleesResponse response = langueParleesService.updateLangueParlees(id, request);
        
        logger.info("\n\nLangue parlée mise à jour avec succès - Langue: {}\n", response.getLangue());
        logger.info("\n\n========== FIN MISE À JOUR LANGUE PARLÉE ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Supprime une langue parlée
     * DELETE /api/langues-parlees/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerLangueParlees(@PathVariable Integer id) {
        logger.info("\n\n========== SUPPRESSION D'UNE LANGUE PARLÉE ==========\n");
        logger.info("\n\nRequête reçue pour supprimer la langue parlée avec ID: {}\n", id);
        
        langueParleesService.supprimerLangueParlees(id);
        
        logger.info("\n\nLangue parlée supprimée avec succès\n");
        logger.info("\n\n========== FIN SUPPRESSION LANGUE PARLÉE ==========\n");
        
        return ResponseEntity.noContent().build();
    }
}