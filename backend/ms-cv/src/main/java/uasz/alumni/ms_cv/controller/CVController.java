package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.dto.request.CVRequest;
import uasz.alumni.ms_cv.dto.response.CVCompletResponse;
import uasz.alumni.ms_cv.dto.response.CVResponse;
import uasz.alumni.ms_cv.dto.response.PageResponse;
import uasz.alumni.ms_cv.service.CVService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cvs")
@RequiredArgsConstructor
public class CVController {
    
    private final CVService cvService;
    private final Logger logger = LoggerFactory.getLogger(CVController.class);
    
    /**
     * Crée un nouveau CV
     * POST /api/cvs
     */
    @PostMapping
    public ResponseEntity<CVResponse> creerCV(@Valid @RequestBody CVRequest request) {
        logger.info("\n\n========== CRÉATION D'UN NOUVEAU CV ==========\n");
        logger.info("\n\nRequête reçue pour créer un CV - Utilisateur: {}, Titre: {}\n", 
                request.getUtilisateurId(), request.getTitre());
        
        CVResponse response = cvService.creerCV(request);
        
        logger.info("\n\nCV créé avec succès - ID: {}\n", response.getId());
        logger.info("\n\n========== FIN CRÉATION CV ==========\n");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    /**
     * Récupère un CV par son ID
     * GET /api/cvs/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<CVResponse> getCVById(@PathVariable Integer id) {
        logger.info("\n\n========== RÉCUPÉRATION D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer le CV avec ID: {}\n", id);
        
        CVResponse response = cvService.getCVById(id);
        
        logger.info("\n\nCV récupéré avec succès - Titre: {}\n", response.getTitre());
        logger.info("\n\n========== FIN RÉCUPÉRATION CV ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère un CV complet avec toutes ses sections
     * GET /api/cvs/{id}/complet
     */
    @GetMapping("/{id}/complet")
    public ResponseEntity<CVCompletResponse> getCVComplet(@PathVariable Integer id) {
        logger.info("\n\n========== RÉCUPÉRATION D'UN CV COMPLET ==========\n");
        logger.info("\n\nRequête reçue pour récupérer le CV complet avec ID: {}\n", id);
        
        CVCompletResponse response = cvService.getCVComplet(id);
        
        logger.info("\n\nCV complet récupéré - Expériences: {}, Formations: {}, Compétences: {}\n", 
                response.getExperiences().size(), 
                response.getFormations().size(), 
                response.getCompetences().size());
        logger.info("\n\n========== FIN RÉCUPÉRATION CV COMPLET ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère un CV par ID et utilisateur (sécurité)
     * GET /api/cvs/{id}/utilisateur/{utilisateurId}
     */
    @GetMapping("/{id}/utilisateur/{utilisateurId}")
    public ResponseEntity<CVResponse> getCVByIdAndUtilisateur(
            @PathVariable Integer id,
            @PathVariable Integer utilisateurId) {
        logger.info("\n\n========== RÉCUPÉRATION CV PAR UTILISATEUR ==========\n");
        logger.info("\n\nRequête reçue pour récupérer le CV {} de l'utilisateur {}\n", id, utilisateurId);
        
        CVResponse response = cvService.getCVByIdAndUtilisateur(id, utilisateurId);
        
        logger.info("\n\nCV récupéré avec succès\n");
        logger.info("\n\n========== FIN RÉCUPÉRATION CV PAR UTILISATEUR ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère tous les CVs d'un utilisateur
     * GET /api/cvs/utilisateur/{utilisateurId}
     */
    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<CVResponse>> getCVsByUtilisateur(@PathVariable Integer utilisateurId) {
        logger.info("\n\n========== RÉCUPÉRATION DES CVS D'UN UTILISATEUR ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les CVs de l'utilisateur: {}\n", utilisateurId);
        
        List<CVResponse> responses = cvService.getCVsByUtilisateur(utilisateurId);
        
        logger.info("\n\n{} CV(s) récupéré(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION CVS UTILISATEUR ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère tous les CVs
     * GET /api/cvs
     */
    @GetMapping
    public ResponseEntity<List<CVResponse>> getAllCVs() {
        logger.info("\n\n========== RÉCUPÉRATION DE TOUS LES CVS ==========\n");
        
        List<CVResponse> responses = cvService.getAllCVs();
        
        logger.info("\n\n{} CV(s) récupéré(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION TOUS CVS ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère tous les CVs avec pagination
     * GET /api/cvs/page?page=0&size=10&sort=titre,asc
     */
    @GetMapping("/page")
    public ResponseEntity<PageResponse<CVResponse>> getAllCVsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") String direction) {
        logger.info("\n\n========== RÉCUPÉRATION DES CVS PAGINÉS ==========\n");
        logger.info("\n\nRequête reçue - Page: {}, Taille: {}, Tri: {} {}\n", 
                page, size, sortBy, direction);
        
        Sort.Direction sortDirection = direction.equalsIgnoreCase("ASC") ? 
                Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        
        PageResponse<CVResponse> response = cvService.getAllCVsPage(pageable);
        
        logger.info("\n\n{} CV(s) récupéré(s) sur cette page - Total: {}\n", 
                response.getNumberOfElements(), response.getTotalElements());
        logger.info("\n\n========== FIN RÉCUPÉRATION CVS PAGINÉS ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Met à jour un CV
     * PUT /api/cvs/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<CVResponse> updateCV(
            @PathVariable Integer id,
            @Valid @RequestBody CVRequest request) {
        logger.info("\n\n========== MISE À JOUR D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour mettre à jour le CV avec ID: {}\n", id);
        
        CVResponse response = cvService.updateCV(id, request);
        
        logger.info("\n\nCV mis à jour avec succès - Titre: {}\n", response.getTitre());
        logger.info("\n\n========== FIN MISE À JOUR CV ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Supprime un CV
     * DELETE /api/cvs/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCV(@PathVariable Integer id) {
        logger.info("\n\n========== SUPPRESSION D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour supprimer le CV avec ID: {}\n", id);
        
        cvService.supprimerCV(id);
        
        logger.info("\n\nCV supprimé avec succès\n");
        logger.info("\n\n========== FIN SUPPRESSION CV ==========\n");
        
        return ResponseEntity.noContent().build();
    }
}