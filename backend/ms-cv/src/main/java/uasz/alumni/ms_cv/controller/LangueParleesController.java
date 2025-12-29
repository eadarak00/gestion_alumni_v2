package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.service.LangueParleesService;
import uasz.alumni.spi.api.LanguesParleesApi;
import uasz.alumni.spi.model.LangueParleesRequest;
import uasz.alumni.spi.model.LangueParleesResponse;
import uasz.alumni.spi.model.NiveauLangue;

import java.util.List;

@RestController
@RequestMapping("/v1/api/langues-parlees")
@RequiredArgsConstructor
public class LangueParleesController implements LanguesParleesApi {
    
    private final LangueParleesService langueParleesService;
    private final Logger logger = LoggerFactory.getLogger(LangueParleesController.class);

    @Override
    public LangueParleesResponse creerLangueParlees(@Valid LangueParleesRequest langueParleesRequest) {
        logger.info("\n\nRequête reçue pour créer une langue parlée - CV: {}, Langue: {}\n", 
                langueParleesRequest.getCvId(), langueParleesRequest.getLangue());

        LangueParleesResponse response = langueParleesService.creerLangueParlees(langueParleesRequest);
        return response;
    }

    @Override
    public LangueParleesResponse getLangueParleesById(Integer id) {
        logger.info("\n\nRequête reçue pour récupérer la langue parlée avec ID: {}\n", id);
        
        LangueParleesResponse response = langueParleesService.getLangueParleesById(id);
        return response;
    }

    @Override
    public LangueParleesResponse getLangueParleesByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer la langue parlée {} du CV {}\n", id, cvId);
        
        LangueParleesResponse response = langueParleesService.getLangueParleesByIdAndCvId(id, cvId);
        return response;
    }

    @Override
    public List<LangueParleesResponse> getLanguesParleesByCvId(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les langues parlées du CV: {}\n", cvId);

        List<LangueParleesResponse> responses = langueParleesService.getLanguesParleesByCvId(cvId);
        return responses;
    }

    @Override
    public List<LangueParleesResponse> getLanguesParleesByNiveau(Integer cvId, NiveauLangue niveau) {
        logger.info("\n\nRequête reçue pour récupérer les langues de niveau {} du CV: {}\n", 
                niveau, cvId);

        List<LangueParleesResponse> responses = langueParleesService.getLanguesParleesByNiveau(cvId, niveau);
        return responses;
    }

    @Override
    public void supprimerLangueParlees(Integer id) {
        logger.info("\n\nRequête reçue pour supprimer la langue parlée avec ID: {}\n", id);
        
        langueParleesService.supprimerLangueParlees(id);
    }

    @Override
    public LangueParleesResponse updateLangueParlees(Integer id, @Valid LangueParleesRequest langueParleesRequest) {
        logger.info("\n\nRequête reçue pour mettre à jour la langue parlée avec ID: {}\n", id);
        
        LangueParleesResponse response = langueParleesService.updateLangueParlees(id, langueParleesRequest);
        return response;
    }
}