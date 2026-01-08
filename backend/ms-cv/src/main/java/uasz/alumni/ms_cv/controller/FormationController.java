package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.service.FormationService;
import uasz.alumni.spi.api.FormationsApi;
import uasz.alumni.spi.model.FormationRequest;
import uasz.alumni.spi.model.FormationResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/api/formations")
@RequiredArgsConstructor
public class FormationController implements FormationsApi {
    
    private final FormationService formationService;
    private final Logger logger = LoggerFactory.getLogger(FormationController.class);

    @Override
    public FormationResponse creerFormation(@Valid FormationRequest formationRequest) {
                logger.info("\n\nRequête reçue pour créer une formation - CV: {}, Diplôme: {}\n", 
                        formationRequest.getCvId(), formationRequest.getDiplome());
        
         FormationResponse response = formationService.creerFormation(formationRequest);
         return response;
    }

    @Override
    public uasz.alumni.spi.model.FormationResponse getFormationById(Integer id) {
        logger.info("\n\nRequête reçue pour récupérer la formation avec ID: {}\n", id);

        uasz.alumni.spi.model.FormationResponse response = formationService.getFormationById(id);
        return response;
    }

    @Override
    public FormationResponse getFormationByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer la formation {} du CV {}\n", id, cvId);
        
        FormationResponse response = formationService.getFormationByIdAndCvId(id, cvId);
        return response;
    }

    @Override
    public List<FormationResponse> getFormationsByCvId(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les formations du CV: {}\n", cvId);

        List<FormationResponse> responses = formationService.getFormationsByCvId(cvId);
        return responses;
    }
    @Override
    public List<FormationResponse> getFormationsEnCours(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les formations en cours du CV: {}\n", cvId);

        List<FormationResponse> responses = formationService.getFormationsEnCours(cvId);
        return responses;
    }

    @Override
    public void supprimerFormation(Integer id) {
        logger.info("\n\nRequête reçue pour supprimer la formation avec ID: {}\n", id);
        
        formationService.supprimerFormation(id);
    }

    @Override
    public FormationResponse updateFormation(Integer id, @Valid FormationRequest formationRequest) {
        logger.info("\n\nRequête reçue pour mettre à jour la formation avec ID: {}\n", id);
        
        FormationResponse response = formationService.updateFormation(id, formationRequest);
        return response;
    }
}