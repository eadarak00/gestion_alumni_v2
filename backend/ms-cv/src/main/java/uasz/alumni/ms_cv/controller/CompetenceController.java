package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.service.CompetenceService;
import uasz.alumni.spi.api.CompetencesApi;
import uasz.alumni.spi.model.CategorieCompetence;
import uasz.alumni.spi.model.CompetenceRequest;
import uasz.alumni.spi.model.CompetenceResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/api/competences")
@RequiredArgsConstructor
public class CompetenceController implements CompetencesApi {
    
    private final CompetenceService competenceService;
    private final Logger logger = LoggerFactory.getLogger(CompetenceController.class);

    @Override
    public CompetenceResponse creerCompetence(@Valid CompetenceRequest competenceRequest) {
        logger.info("\n\nRequête reçue pour créer une compétence - CV: {}, Nom: {}\n", 
                     competenceRequest.getCvId(), competenceRequest.getNom());

        CompetenceResponse response = competenceService.creerCompetence(competenceRequest);
        return response;
    }

    @Override
    public CompetenceResponse getCompetenceById(Integer id) {
        logger.info("\n\nRequête reçue pour récupérer la compétence avec ID: {}\n", id);
        
        CompetenceResponse response = competenceService.getCompetenceById(id);
        return response;
    }

    @Override
    public CompetenceResponse getCompetenceByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer la compétence avec ID: {} pour le CV: {}\n", id, cvId);
        
        CompetenceResponse response = competenceService.getCompetenceByIdAndCvId(id, cvId);
        return response;
    }
    @Override
    public List<CompetenceResponse> getCompetencesByCategorie(Integer cvId, CategorieCompetence categorie) {
        logger.info("\n\nRequête reçue pour récupérer les compétences de catégorie {} du CV: {}\n", 
                categorie, cvId);

        List<CompetenceResponse> responses = competenceService.getCompetencesByCategorie(cvId, categorie);
        return responses;
    }

    @Override
    public List<CompetenceResponse> getCompetencesByCvId(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les compétences du CV: {}\n", cvId);
        
        List<CompetenceResponse> responses = competenceService.getCompetencesByCvId(cvId);
        return responses;
    }

    @Override
    public List<CompetenceResponse> getCompetencesByNiveau(Integer cvId,
            uasz.alumni.spi.model.NiveauCompetence niveau) {
        logger.info("\n\nRequête reçue pour récupérer les compétences de niveau {} du CV: {}\n", 
                niveau, cvId);
        
        List<CompetenceResponse> responses = competenceService.getCompetencesByNiveau(cvId, niveau);
        return responses;
    }

    @Override
    public void supprimerCompetence(Integer id) {
        logger.info("\n\nRequête reçue pour supprimer la compétence avec ID: {}\n", id);
        
        competenceService.supprimerCompetence(id);
        
    }
    @Override
    public CompetenceResponse updateCompetence(Integer id, @Valid CompetenceRequest competenceRequest) {
        logger.info("\n\nRequête reçue pour mettre à jour la compétence avec ID: {}\n", id);
        
        CompetenceResponse response = competenceService.updateCompetence(id, competenceRequest);
        return response;
    }
}