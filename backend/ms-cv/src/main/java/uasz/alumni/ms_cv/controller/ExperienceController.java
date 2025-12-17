package uasz.alumni.ms_cv.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_cv.service.ExperienceService;
import uasz.alumni.spi.api.ExperiencesApi;
import uasz.alumni.spi.model.ExperienceRequest;
import uasz.alumni.spi.model.ExperienceResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/api/experiences")
@RequiredArgsConstructor
public class ExperienceController implements ExperiencesApi {

    private final ExperienceService experienceService;
    private final Logger logger = LoggerFactory.getLogger(ExperienceController.class);
    
    @Override
    public ExperienceResponse creerExperience(@Valid ExperienceRequest experienceRequest) {
        logger.info("\n\nRequête reçue pour créer une expérience - CV: {}, Poste: {}\n", 
                experienceRequest.getCvId(), experienceRequest.getPoste());

        ExperienceResponse response = experienceService.creerExperience(experienceRequest);
        return response;
    }

    @Override
    public ExperienceResponse getExperienceById(Integer id) {
        logger.info("\n\nRequête reçue pour récupérer l'expérience avec ID: {}\n", id);

        ExperienceResponse response = experienceService.getExperienceById(id);
        return response;
    }

    @Override
    public ExperienceResponse getExperienceByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer l'expérience avec ID: {}, CV ID: {}\n", id, cvId);

        ExperienceResponse response = experienceService.getExperienceByIdAndCvId(id, cvId);
        return response;
    }

    @Override
    public List<ExperienceResponse> getExperiencesByCvId(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les expériences du CV: {}\n", cvId);

        List<ExperienceResponse> responses = experienceService.getExperiencesByCvId(cvId);
        return responses;
    }

    @Override
    public List<ExperienceResponse> getExperiencesEnCours(Integer cvId) {
        logger.info("\n\nRequête reçue pour récupérer les expériences en cours du CV: {}\n", cvId);

        List<ExperienceResponse> responses = experienceService.getExperiencesEnCours(cvId);
        return responses;
    }

    @Override
    public void supprimerExperience(Integer id) {
        logger.info("\n\nRequête reçue pour supprimer l'expérience avec ID: {}\n", id);
        experienceService.supprimerExperience(id);
    }

    @Override
    public ExperienceResponse updateExperience(Integer id, @Valid ExperienceRequest experienceRequest) {
        logger.info("\n\nRequête reçue pour mettre à jour l'expérience avec ID: {}\n", id);

        ExperienceResponse response = experienceService.updateExperience(id, experienceRequest);
        return response;
    }
}