package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.dto.request.CertificationRequest;
import uasz.alumni.ms_cv.dto.response.CertificationResponse;
import uasz.alumni.ms_cv.service.CertificationService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/certifications")
@RequiredArgsConstructor
public class CertificationController {
    
    private final CertificationService certificationService;
    private final Logger logger = LoggerFactory.getLogger(CertificationController.class);
    
    /**
     * Crée une nouvelle certification
     * POST /api/certifications
     */
    @PostMapping
    public ResponseEntity<CertificationResponse> creerCertification(@Valid @RequestBody CertificationRequest request) {
        logger.info("\n\n========== CRÉATION D'UNE NOUVELLE CERTIFICATION ==========\n");
        logger.info("\n\nRequête reçue pour créer une certification - CV: {}, Nom: {}\n", 
                request.getCvId(), request.getNom());
        
        CertificationResponse response = certificationService.creerCertification(request);
        
        logger.info("\n\nCertification créée avec succès - ID: {}\n", response.getId());
        logger.info("\n\n========== FIN CRÉATION CERTIFICATION ==========\n");
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    /**
     * Récupère une certification par son ID
     * GET /api/certifications/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<CertificationResponse> getCertificationById(@PathVariable Integer id) {
        logger.info("\n\n========== RÉCUPÉRATION D'UNE CERTIFICATION ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la certification avec ID: {}\n", id);
        
        CertificationResponse response = certificationService.getCertificationById(id);
        
        logger.info("\n\nCertification récupérée avec succès - Nom: {}\n", response.getNom());
        logger.info("\n\n========== FIN RÉCUPÉRATION CERTIFICATION ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère une certification par ID et CV ID
     * GET /api/certifications/{id}/cv/{cvId}
     */
    @GetMapping("/{id}/cv/{cvId}")
    public ResponseEntity<CertificationResponse> getCertificationByIdAndCvId(
            @PathVariable Integer id,
            @PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION CERTIFICATION PAR CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer la certification {} du CV {}\n", id, cvId);
        
        CertificationResponse response = certificationService.getCertificationByIdAndCvId(id, cvId);
        
        logger.info("\n\nCertification récupérée avec succès\n");
        logger.info("\n\n========== FIN RÉCUPÉRATION CERTIFICATION PAR CV ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Récupère toutes les certifications d'un CV
     * GET /api/certifications/cv/{cvId}
     */
    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<CertificationResponse>> getCertificationsByCvId(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION DES CERTIFICATIONS D'UN CV ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les certifications du CV: {}\n", cvId);
        
        List<CertificationResponse> responses = certificationService.getCertificationsByCvId(cvId);
        
        logger.info("\n\n{} certification(s) récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION CERTIFICATIONS CV ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère les certifications avec date d'expiration
     * GET /api/certifications/cv/{cvId}/avec-expiration
     */
    @GetMapping("/cv/{cvId}/avec-expiration")
    public ResponseEntity<List<CertificationResponse>> getCertificationsAvecExpiration(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION CERTIFICATIONS AVEC EXPIRATION ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les certifications avec expiration du CV: {}\n", cvId);
        
        List<CertificationResponse> responses = certificationService.getCertificationsAvecExpiration(cvId);
        
        logger.info("\n\n{} certification(s) avec expiration récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION CERTIFICATIONS AVEC EXPIRATION ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Récupère les certifications permanentes
     * GET /api/certifications/cv/{cvId}/permanentes
     */
    @GetMapping("/cv/{cvId}/permanentes")
    public ResponseEntity<List<CertificationResponse>> getCertificationsPermanentes(@PathVariable Integer cvId) {
        logger.info("\n\n========== RÉCUPÉRATION CERTIFICATIONS PERMANENTES ==========\n");
        logger.info("\n\nRequête reçue pour récupérer les certifications permanentes du CV: {}\n", cvId);
        
        List<CertificationResponse> responses = certificationService.getCertificationsPermanentes(cvId);
        
        logger.info("\n\n{} certification(s) permanente(s) récupérée(s)\n", responses.size());
        logger.info("\n\n========== FIN RÉCUPÉRATION CERTIFICATIONS PERMANENTES ==========\n");
        
        return ResponseEntity.ok(responses);
    }
    
    /**
     * Met à jour une certification
     * PUT /api/certifications/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<CertificationResponse> updateCertification(
            @PathVariable Integer id,
            @Valid @RequestBody CertificationRequest request) {
        logger.info("\n\n========== MISE À JOUR D'UNE CERTIFICATION ==========\n");
        logger.info("\n\nRequête reçue pour mettre à jour la certification avec ID: {}\n", id);
        
        CertificationResponse response = certificationService.updateCertification(id, request);
        
        logger.info("\n\nCertification mise à jour avec succès - Nom: {}\n", response.getNom());
        logger.info("\n\n========== FIN MISE À JOUR CERTIFICATION ==========\n");
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Supprime une certification
     * DELETE /api/certifications/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCertification(@PathVariable Integer id) {
        logger.info("\n\n========== SUPPRESSION D'UNE CERTIFICATION ==========\n");
        logger.info("\n\nRequête reçue pour supprimer la certification avec ID: {}\n", id);
        
        certificationService.supprimerCertification(id);
        
        logger.info("\n\nCertification supprimée avec succès\n");
        logger.info("\n\n========== FIN SUPPRESSION CERTIFICATION ==========\n");
        
        return ResponseEntity.noContent().build();
    }
}