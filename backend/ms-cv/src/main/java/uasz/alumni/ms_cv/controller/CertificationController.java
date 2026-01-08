package uasz.alumni.ms_cv.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.service.CertificationService;
import uasz.alumni.spi.api.CertificationsApi;
import uasz.alumni.spi.model.CertificationRequest;
import uasz.alumni.spi.model.CertificationResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/api/certifications")
@RequiredArgsConstructor
public class CertificationController implements CertificationsApi {

    private final CertificationService certificationService;
    private final Logger logger = LoggerFactory.getLogger(CertificationController.class);

    @Override
    public CertificationResponse creerCertification(CertificationRequest certificationRequest) {
        logger.info("\n\n========== CRÉATION D'UNE NOUVELLE CERTIFICATION ==========\n");
        logger.info("\n\nRequête reçue pour créer une certification - CV: {}, Nom: {}\n", 
        certificationRequest.getCvId(), certificationRequest.getNom());
        
        CertificationResponse response = certificationService.creerCertification(certificationRequest);
        
        logger.info("\n\nCertification créée avec succès - ID: {}\n", response.getId());
        logger.info("\n\n========== FIN CRÉATION CERTIFICATION ==========\n");
        
        // return new ResponseEntity<>(response, HttpStatus.CREATED);
        return response;
    }

    @Override
    public CertificationResponse getCertificationById(Integer id) {
        logger.info("\n\nRequête reçue pour récupérer la certification avec ID: {}\n", id);
        
        CertificationResponse response = certificationService.getCertificationById(id);

        return response;

    }

    @Override
    public CertificationResponse getCertificationByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer la certification avec ID: {} pour le CV: {}\n", id, cvId);
        
        CertificationResponse response = certificationService.getCertificationByIdAndCvId(id, cvId);

        return response;
    }

    @Override
    public List<CertificationResponse> getCertificationsAvecExpiration(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les certifications avec expiration du CV: {}\n", cvId);
        
        List<CertificationResponse> responses = certificationService.getCertificationsAvecExpiration(cvId);

        return responses;
    }

    @Override
    public List<CertificationResponse> getCertificationsByCvId(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les certifications du CV: {}\n", cvId);
        
        List<CertificationResponse> responses = certificationService.getCertificationsByCvId(cvId);

        return responses;
    }

    @Override
    public List<CertificationResponse> getCertificationsPermanentes(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les certifications permanentes du CV: {}\n", cvId);
        
        List<CertificationResponse> responses = certificationService.getCertificationsPermanentes(cvId);

        return responses;
    }

    @Override
    public void supprimerCertification(Integer id) {
        logger.info("\n\nRequête reçue pour supprimer la certification avec ID: {}\n", id);
        
        certificationService.supprimerCertification(id);
        
    }

    @Override
    public CertificationResponse updateCertification(Integer id, CertificationRequest certificationRequest) {
        logger.info("\n\nRequête reçue pour mettre à jour la certification avec ID: {}\n", id);
        
        CertificationResponse response = certificationService.updateCertification(id, certificationRequest);

        return response;
    }
}