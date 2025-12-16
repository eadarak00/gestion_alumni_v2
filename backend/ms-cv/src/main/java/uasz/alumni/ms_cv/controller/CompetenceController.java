package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.dto.request.CompetenceRequest;
import uasz.alumni.ms_cv.dto.response.CompetenceResponse;
import uasz.alumni.ms_cv.model.CategorieCompetence;
import uasz.alumni.ms_cv.model.NiveauCompetence;
import uasz.alumni.ms_cv.service.CompetenceService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/competences")
@RequiredArgsConstructor
public class CompetenceController {
    
    private final CompetenceService competenceService;
    private final Logger logger = LoggerFactory.getLogger(CompetenceController.class);
    
    /**
     * Crée une nouvelle compétence
     * POST /api/competences
     */
    @PostMapping
    public ResponseEntity<CompetenceResponse> creerCompetence(@Valid @RequestBody CompetenceRequest request) {
        logger.info("\n\n========== CRÉATION D'UNE NOUVELLE COMPÉTENCE ==========\n");
        logger.info("\n\nRequête reçue pour créer une compétence - CV: {}, Nom: {}\n", 
                request.getCvId(), request.getNom());
        
        CompetenceResponse response = competenceService.creerCompetence(request);
        
        logger.info("\n\nCompétence créée avec succès - ID: {}\n", response.getId());
        logger.info("\n\n========== FIN CRÉATION COMPÉTENCE ==========\n");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    /**
     * Récupère une compétence par son ID
     * GET /api/competences/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<CompetenceResponse> getCompetenceById(@PathVariable Integer id) {
        logger.info("\n\n========== RÉCUPÉRATION D'UNE COMPÉTENCE ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la compétence avec ID: {}\n", id);
        
        CompetenceResponse response = competenceService.getCompetenceById(id);
        
        logger.info("\n\nCompétence récupérée avec succès - Nom: {}\n", response.getNom());
        logger.info("\n\n========== FIN RÉCUPÉRATION COMPÉTENCE ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère une compétence par ID et CV ID
     * GET /api/competences/{id}/cv/{cvId}
     */
    @GetMapping("/{id}/cv/{cvId}")
    public ResponseEntity<CompetenceResponse> getCompetenceByIdAndCvId(
            @PathVariable Integer id,
            @PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION COMPÉTENCE PAR CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la compétence {} du CV {}\n", id, cvId);
        
        CompetenceResponse response = competenceService.getCompetenceByIdAndCvId(id, cvId);
        
        logger.info("\n\nCompétence récupérée avec succès\n");
        logger.info("\n\n========== FIN RÉCUPÉRATION COMPÉTENCE PAR CV ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère toutes les compétences d'un CV
     * GET /api/competences/cv/{cvId}
     */
    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<CompetenceResponse>> getCompetencesByCvId(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION DES COMPÉTENCES D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les compétences du CV: {}\n", cvId);
        
        List<CompetenceResponse> responses = competenceService.getCompetencesByCvId(cvId);
        
        logger.info("\n\n{} compétence(s) récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION COMPÉTENCES CV ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère les compétences par catégorie
     * GET /api/competences/cv/{cvId}/categorie/{categorie}
     */
    @GetMapping("/cv/{cvId}/categorie/{categorie}")
    public ResponseEntity<List<CompetenceResponse>> getCompetencesByCategorie(
            @PathVariable Integer cvId,
            @PathVariable CategorieCompetence categorie) {
        logger.info("\n\n========== RÉCUPÉRATION COMPÉTENCES PAR CATÉGORIE ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les compétences de catégorie {} du CV: {}\n", 
                categorie, cvId);
        
        List<CompetenceResponse> responses = competenceService.getCompetencesByCategorie(cvId, categorie);
        
        logger.info("\n\n{} compétence(s) de catégorie {} récupérée(s)\n", responses.size(), categorie);
        logger.info("\n\n========== FIN RÉCUPÉRATION COMPÉTENCES PAR CATÉGORIE ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère les compétences par niveau
     * GET /api/competences/cv/{cvId}/niveau/{niveau}
     */
    @GetMapping("/cv/{cvId}/niveau/{niveau}")
    public ResponseEntity<List<CompetenceResponse>> getCompetencesByNiveau(
            @PathVariable Integer cvId,
            @PathVariable NiveauCompetence niveau) {
        logger.info("\n\n========== RÉCUPÉRATION COMPÉTENCES PAR NIVEAU ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les compétences de niveau {} du CV: {}\n", 
                niveau, cvId);
        
        List<CompetenceResponse> responses = competenceService.getCompetencesByNiveau(cvId, niveau);
        
        logger.info("\n\n{} compétence(s) de niveau {} récupérée(s)\n", responses.size(), niveau);
        logger.info("\n\n========== FIN RÉCUPÉRATION COMPÉTENCES PAR NIVEAU ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Met à jour une compétence
     * PUT /api/competences/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<CompetenceResponse> updateCompetence(
            @PathVariable Integer id,
            @Valid @RequestBody CompetenceRequest request) {
        logger.info("\n\n========== MISE À JOUR D'UNE COMPÉTENCE ==========\n");
        logger.info("\n\nRequête reçue pour mettre à jour la compétence avec ID: {}\n", id);
        
        CompetenceResponse response = competenceService.updateCompetence(id, request);
        
        logger.info("\n\nCompétence mise à jour avec succès - Nom: {}\n", response.getNom());
        logger.info("\n\n========== FIN MISE À JOUR COMPÉTENCE ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Supprime une compétence
     * DELETE /api/competences/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCompetence(@PathVariable Integer id) {
        logger.info("\n\n========== SUPPRESSION D'UNE COMPÉTENCE ==========\n");
        logger.info("\n\nRequête reçue pour supprimer la compétence avec ID: {}\n", id);
        
        competenceService.supprimerCompetence(id);
        
        logger.info("\n\nCompétence supprimée avec succès\n");
        logger.info("\n\n========== FIN SUPPRESSION COMPÉTENCE ==========\n");
        
        return ResponseEntity.noContent().build();
    }
}