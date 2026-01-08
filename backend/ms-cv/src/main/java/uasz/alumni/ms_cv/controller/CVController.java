package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.service.CVService;
import uasz.alumni.spi.api.CvsApi;
import uasz.alumni.spi.model.CVCompletResponse;
import uasz.alumni.spi.model.CVRequest;
import uasz.alumni.spi.model.CVResponse;
import uasz.alumni.spi.model.PageResponseCVResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cvs")
@RequiredArgsConstructor
public class CVController implements CvsApi {

    private final CVService cvService;
    private final Logger logger = LoggerFactory.getLogger(CVController.class);
    
    @Override
    public CVResponse creerCV(@Valid CVRequest cvRequest) {
        logger.info("\n\nRequête reçue pour créer un CV - Utilisateur: {}, Titre: {}\n", 
                 cvRequest.getUtilisateurId(), cvRequest.getTitre());
        
        CVResponse response = cvService.creerCV(cvRequest);
        return response;
    }
    @Override
    public List<CVResponse> getAllCVs() {
        logger.info("\n\nRequête reçue pour récupérer tous les CVs\n");
        
        List<CVResponse> responses = cvService.getAllCVs();
        return responses;

    }

    @Override
    public PageResponseCVResponse getAllCVsPage(@Valid Integer page, @Valid Integer size, @Valid String sortBy,
            @Valid String direction) {
        // logger.info("\n\nRequête reçue pour récupérer les CVs paginés - Page: {}, Taille: {}, Tri: {} {}\n", 
        //         page, size, sortBy, direction);

        //     // Pageable pageable = direction.equalsIgnoreCase("ASC") ?
        //     // Pageable.ofSize(size).withPage(page).withSort(Sort.by(Sort.Direction.ASC, sortBy)) :
        //     // Pageable.ofSize(size).withPage(page).withSort(Sort.by(Sort.Direction.DESC, sortBy));

        // PageResponseCVResponse response = cvService.getAllCVsPage(page, size, sortBy, direction);
        // return response;
        return null;
    }

    @Override
    public CVResponse getCVById(Integer id) {
        logger.info("\n\nRequête reçue pour récupérer le CV avec ID: {}\n", id);
        
        CVResponse response = cvService.getCVById(id);
        return response;
    }

    @Override
    public CVResponse getCVByIdAndUtilisateur(Integer id, Integer utilisateurId) {
        logger.info("\n\nRequête reçue pour récupérer le CV {} de l'utilisateur {}\n", id, utilisateurId);
        
        CVResponse response = cvService.getCVByIdAndUtilisateur(id, utilisateurId);
        return response;
    }

    @Override
    public CVCompletResponse getCVComplet(Integer id) {
        logger.info("\n\nRequête reçue pour récupérer le CV complet avec ID: {}\n", id);
        
        CVCompletResponse response = cvService.getCVComplet(id);
        return response;
    }

    @Override
    public List<CVResponse> getCVsByUtilisateur(Integer utilisateurId) {
        logger.info("\n\nRequête reçue pour récupérer les CVs de l'utilisateur: {}\n", utilisateurId);
        
        List<CVResponse> responses = cvService.getCVsByUtilisateur(utilisateurId);
        return responses;
    }

    @Override
    public void supprimerCV(Integer id) {
        logger.info("\n\nRequête reçue pour supprimer le CV avec ID: {}\n", id);
        
        cvService.supprimerCV(id);
    }

    @Override
    public CVResponse updateCV(Integer id, @Valid CVRequest cvRequest) {
        logger.info("\n\nRequête reçue pour mettre à jour le CV avec ID: {}\n", id);
        
        CVResponse response = cvService.updateCV(id, cvRequest);
        return response;
    }
}