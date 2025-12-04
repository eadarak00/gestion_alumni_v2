package uasz.alumni.ms_cv.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_cv.dto.request.LangueParleesRequest;
import uasz.alumni.ms_cv.dto.response.LangueParleesResponse;
import uasz.alumni.ms_cv.exception.*;
import uasz.alumni.ms_cv.model.CV;
import uasz.alumni.ms_cv.model.LangueParlees;
import uasz.alumni.ms_cv.model.NiveauLangue;
import uasz.alumni.ms_cv.repository.CVRepository;
import uasz.alumni.ms_cv.repository.LangueParleesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class LangueParleesService {
    
    private final LangueParleesRepository langueParleesRepository;
    private final CVRepository cvRepository;
    
    private final Logger logger = LoggerFactory.getLogger(LangueParleesService.class);
    
    /**
     * Crée une nouvelle langue parlée
     */
    public LangueParleesResponse creerLangueParlees(LangueParleesRequest request) {
        logger.info("\n\nCréation d'une nouvelle langue parlée pour le CV: {}\n", 
                request != null ? request.getCvId() : null);
        
        try {
            // Validation des paramètres
            validerParametresCreationLangueParlees(request);
            
            // Vérifier que le CV existe
            CV cv = cvRepository.findById(request.getCvId())
                    .orElseThrow(() -> new CVNotFoundException(request.getCvId()));
            
            // Vérifier que la langue n'existe pas déjà
            if (langueParleesRepository.existsByCvIdAndLangue(request.getCvId(), request.getLangue())) {
                throw new LangueAlreadyExistsException(request.getLangue(), request.getCvId());
            }
            
            // Créer la langue parlée
            LangueParlees langueParlees = mapToLangueParlees(request, cv);
            LangueParlees savedLangueParlees = langueParleesRepository.save(langueParlees);
            
            logger.info("\n\nLangue parlée créée avec succès - ID: {}, Langue: {}, Niveau: {}\n", 
                    savedLangueParlees.getId(), savedLangueParlees.getLangue(), savedLangueParlees.getNiveau());
            
            return mapToLangueParleesResponse(savedLangueParlees);
            
        } catch (CVNotFoundException | LangueAlreadyExistsException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la création de la langue parlée: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la création de la langue parlée: \n", e);
            throw new BadRequestException("Impossible de créer la langue parlée. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une langue parlée par son ID
     */
    @Transactional(readOnly = true)
    public LangueParleesResponse getLangueParleesById(Integer id) {
        logger.info("\n\nRecherche de la langue parlée avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la langue parlée est invalide");
            }
            
            LangueParlees langueParlees = langueParleesRepository.findById(id)
                    .orElseThrow(() -> new LangueParleesNotFoundException(id));
            
            logger.info("\n\nLangue parlée trouvée: {} - Niveau: {}\n", 
                    langueParlees.getLangue(), langueParlees.getNiveau());
            
            return mapToLangueParleesResponse(langueParlees);
            
        } catch (LangueParleesNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la langue parlée: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la langue parlée {}: \n", id, e);
            throw new BadRequestException("Impossible de récupérer la langue parlée. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une langue parlée par ID et CV ID (sécurité)
     */
    @Transactional(readOnly = true)
    public LangueParleesResponse getLangueParleesByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRecherche de la langue parlée {} pour le CV {}\n", id, cvId);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la langue parlée est invalide");
            }
            
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            LangueParlees langueParlees = langueParleesRepository.findByIdAndCvId(id, cvId)
                    .orElseThrow(() -> new LangueParleesNotFoundException(id, cvId));
            
            logger.info("\n\nLangue parlée trouvée: {}\n", langueParlees.getLangue());
            
            return mapToLangueParleesResponse(langueParlees);
            
        } catch (LangueParleesNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la langue parlée: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la langue parlée: \n", e);
            throw new BadRequestException("Impossible de récupérer la langue parlée. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère toutes les langues parlées d'un CV
     */
    @Transactional(readOnly = true)
    public List<LangueParleesResponse> getLanguesParleesByCvId(Integer cvId) {
        logger.info("\n\nRecherche des langues parlées du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            // Vérifier que le CV existe
            if (!cvRepository.existsById(cvId)) {
                throw new CVNotFoundException(cvId);
            }
            
            List<LangueParlees> languesParlees = langueParleesRepository.findByCvIdOrderByNiveau(cvId);
            
            logger.info("\n\n{} langue(s) parlée(s) trouvée(s) pour le CV {}\n", languesParlees.size(), cvId);
            
            return languesParlees.stream()
                    .map(this::mapToLangueParleesResponse)
                    .collect(Collectors.toList());
                    
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des langues parlées: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des langues parlées: \n", e);
            throw new BadRequestException("Impossible de récupérer les langues parlées. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère les langues parlées par niveau
     */
    @Transactional(readOnly = true)
    public List<LangueParleesResponse> getLanguesParleesByNiveau(Integer cvId, NiveauLangue niveau) {
        logger.info("\n\nRecherche des langues parlées de niveau {} pour le CV: {}\n", niveau, cvId);
        
        try {
            // Validation des paramètres
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            if (niveau == null) {
                throw new ValidationException("niveau", "Le niveau est obligatoire");
            }
            
            List<LangueParlees> languesParlees = langueParleesRepository.findByCvIdAndNiveau(cvId, niveau);
            
            logger.info("\n\n{} langue(s) parlée(s) de niveau {} trouvée(s)\n", languesParlees.size(), niveau);
            
            return languesParlees.stream()
                    .map(this::mapToLangueParleesResponse)
                    .collect(Collectors.toList());
                    
        } catch (ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des langues parlées par niveau: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des langues parlées par niveau: \n", e);
            throw new BadRequestException("Impossible de récupérer les langues parlées. Veuillez réessayer.");
        }
    }
    
    /**
     * Met à jour une langue parlée
     */
    public LangueParleesResponse updateLangueParlees(Integer id, LangueParleesRequest request) {
        logger.info("\n\nMise à jour de la langue parlée avec ID: {}\n", id);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la langue parlée est invalide");
            }
            
            validerParametresCreationLangueParlees(request);
            
            LangueParlees langueParlees = langueParleesRepository.findById(id)
                    .orElseThrow(() -> new LangueParleesNotFoundException(id));
            
            // Vérifier que le CV ID correspond
            if (!langueParlees.getCv().getId().equals(request.getCvId())) {
                throw new BadRequestException("Le CV ID ne correspond pas à la langue parlée");
            }
            
            // Vérifier l'unicité de la langue si changée
            if (!langueParlees.getLangue().equals(request.getLangue())) {
                if (langueParleesRepository.existsByCvIdAndLangue(request.getCvId(), request.getLangue())) {
                    throw new LangueAlreadyExistsException(request.getLangue(), request.getCvId());
                }
            }
            
            // Mettre à jour les champs
            langueParlees.setLangue(request.getLangue());
            langueParlees.setNiveau(request.getNiveau());
            
            LangueParlees updatedLangueParlees = langueParleesRepository.save(langueParlees);
            
            logger.info("\n\nLangue parlée mise à jour avec succès - ID: {}, Langue: {}\n", 
                    id, updatedLangueParlees.getLangue());
            
            return mapToLangueParleesResponse(updatedLangueParlees);
            
        } catch (LangueParleesNotFoundException | LangueAlreadyExistsException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la mise à jour de la langue parlée: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la mise à jour de la langue parlée: \n", e);
            throw new BadRequestException("Impossible de mettre à jour la langue parlée. Veuillez réessayer.");
        }
    }
    
    /**
     * Supprime une langue parlée
     */
    public void supprimerLangueParlees(Integer id) {
        logger.info("\n\nSuppression de la langue parlée avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la langue parlée est invalide");
            }
            
            LangueParlees langueParlees = langueParleesRepository.findById(id)
                    .orElseThrow(() -> new LangueParleesNotFoundException(id));
            
            langueParleesRepository.deleteById(id);
            
            logger.info("\n\nLangue parlée supprimée avec succès - ID: {}, Langue: {}\n", 
                    id, langueParlees.getLangue());
            
        } catch (LangueParleesNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la suppression de la langue parlée: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la suppression de la langue parlée: \n", e);
            throw new BadRequestException("Impossible de supprimer la langue parlée. Veuillez réessayer.");
        }
    }
    
    // ========== MÉTHODES PRIVÉES DE VALIDATION ==========
    
    /**
     * Valide les paramètres de création de langue parlée
     */
    private void validerParametresCreationLangueParlees(LangueParleesRequest request) {
        if (request == null) {
            throw new BadRequestException("Les données de la langue parlée sont manquantes");
        }
        
        // Validation du CV ID
        if (request.getCvId() == null || request.getCvId() <= 0) {
            throw new ValidationException("cvId", "L'identifiant du CV est invalide");
        }
        
        // Validation de la langue
        if (request.getLangue() == null) {
            throw new ValidationException("langue", "La langue est obligatoire");
        }
        
        // Validation du niveau
        if (request.getNiveau() == null) {
            throw new ValidationException("niveau", "Le niveau de la langue est obligatoire");
        }
    }
    
    // ========== MÉTHODES DE MAPPING ==========
    
    /**
     * Mappe LangueParleesRequest vers LangueParlees
     */
    private LangueParlees mapToLangueParlees(LangueParleesRequest request, CV cv) {
        try {
            return LangueParlees.builder()
                    .cv(cv)
                    .langue(request.getLangue())
                    .niveau(request.getNiveau())
                    .build();
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping LangueParleesRequest vers LangueParlees: \n", e);
            throw new BadRequestException("Erreur lors de la création de la langue parlée");
        }
    }
    
    /**
     * Mappe LangueParlees vers LangueParleesResponse
     */
    private LangueParleesResponse mapToLangueParleesResponse(LangueParlees langueParlees) {
        try {
            if (langueParlees == null) {
                throw new BadRequestException("La langue parlée ne peut pas être null");
            }
            
            return LangueParleesResponse.builder()
                    .id(langueParlees.getId())
                    .cvId(langueParlees.getCv().getId())
                    .langue(langueParlees.getLangue())
                    .niveau(langueParlees.getNiveau())
                    .dateCreation(langueParlees.getDateCreation())
                    .dateDerniereModification(langueParlees.getDateDerniereModification())
                    .build();
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping LangueParlees vers LangueParleesResponse: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse");
        }
    }
}