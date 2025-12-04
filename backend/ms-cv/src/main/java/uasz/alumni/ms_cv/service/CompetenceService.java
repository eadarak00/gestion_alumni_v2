package uasz.alumni.ms_cv.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_cv.dto.request.CompetenceRequest;
import uasz.alumni.ms_cv.dto.response.CompetenceResponse;
import uasz.alumni.ms_cv.exception.*;
import uasz.alumni.ms_cv.model.CV;
import uasz.alumni.ms_cv.model.CategorieCompetence;
import uasz.alumni.ms_cv.model.Competence;
import uasz.alumni.ms_cv.model.NiveauCompetence;
import uasz.alumni.ms_cv.repository.CVRepository;
import uasz.alumni.ms_cv.repository.CompetenceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetenceService {
    
    private final CompetenceRepository competenceRepository;
    private final CVRepository cvRepository;
    
    private final Logger logger = LoggerFactory.getLogger(CompetenceService.class);
    
    /**
     * Crée une nouvelle compétence
     */
    public CompetenceResponse creerCompetence(CompetenceRequest request) {
        logger.info("\n\nCréation d'une nouvelle compétence pour le CV: {}\n", 
                request != null ? request.getCvId() : null);
        
        try {
            // Validation des paramètres
            validerParametresCreationCompetence(request);
            
            // Vérifier que le CV existe
            CV cv = cvRepository.findById(request.getCvId())
                    .orElseThrow(() -> new CVNotFoundException(request.getCvId()));
            
            // Vérifier que la compétence n'existe pas déjà
            if (competenceRepository.existsByCvIdAndNomIgnoreCase(request.getCvId(), request.getNom().trim())) {
                throw new CompetenceAlreadyExistsException(request.getNom().trim(), request.getCvId());
            }
            
            // Créer la compétence
            Competence competence = mapToCompetence(request, cv);
            Competence savedCompetence = competenceRepository.save(competence);
            
            logger.info("\n\nCompétence créée avec succès - ID: {}, Nom: {}, Niveau: {}\n", 
                    savedCompetence.getId(), savedCompetence.getNom(), savedCompetence.getNiveau());
            
            return mapToCompetenceResponse(savedCompetence);
            
        } catch (CVNotFoundException | CompetenceAlreadyExistsException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la création de la compétence: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la création de la compétence: \n", e);
            throw new BadRequestException("Impossible de créer la compétence. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une compétence par son ID
     */
    @Transactional(readOnly = true)
    public CompetenceResponse getCompetenceById(Integer id) {
        logger.info("\n\nRecherche de la compétence avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la compétence est invalide");
            }
            
            Competence competence = competenceRepository.findById(id)
                    .orElseThrow(() -> new CompetenceNotFoundException(id));
            
            logger.info("\n\nCompétence trouvée: {} - Niveau: {}\n", 
                    competence.getNom(), competence.getNiveau());
            
            return mapToCompetenceResponse(competence);
            
        } catch (CompetenceNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la compétence: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la compétence {}: \n", id, e);
            throw new BadRequestException("Impossible de récupérer la compétence. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une compétence par ID et CV ID (sécurité)
     */
    @Transactional(readOnly = true)
    public CompetenceResponse getCompetenceByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRecherche de la compétence {} pour le CV {}\n", id, cvId);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la compétence est invalide");
            }
            
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            Competence competence = competenceRepository.findByIdAndCvId(id, cvId)
                    .orElseThrow(() -> new CompetenceNotFoundException(id, cvId));
            
            logger.info("\n\nCompétence trouvée: {}\n", competence.getNom());
            
            return mapToCompetenceResponse(competence);
            
        } catch (CompetenceNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la compétence: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la compétence: \n", e);
            throw new BadRequestException("Impossible de récupérer la compétence. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère toutes les compétences d'un CV
     */
    @Transactional(readOnly = true)
    public List<CompetenceResponse> getCompetencesByCvId(Integer cvId) {
        logger.info("\n\nRecherche des compétences du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            // Vérifier que le CV existe
            if (!cvRepository.existsById(cvId)) {
                throw new CVNotFoundException(cvId);
            }
            
            List<Competence> competences = competenceRepository.findByCvIdOrderByNiveau(cvId);
            
            logger.info("\n\n{} compétence(s) trouvée(s) pour le CV {}\n", competences.size(), cvId);
            
            return competences.stream()
                    .map(this::mapToCompetenceResponse)
                    .collect(Collectors.toList());
                    
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des compétences: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des compétences: \n", e);
            throw new BadRequestException("Impossible de récupérer les compétences. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère les compétences par catégorie
     */
    @Transactional(readOnly = true)
    public List<CompetenceResponse> getCompetencesByCategorie(Integer cvId, CategorieCompetence categorie) {
        logger.info("\n\nRecherche des compétences de catégorie {} pour le CV: {}\n", categorie, cvId);
        
        try {
            // Validation des paramètres
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            if (categorie == null) {
                throw new ValidationException("categorie", "La catégorie est obligatoire");
            }
            
            List<Competence> competences = competenceRepository.findByCvIdAndCategorie(cvId, categorie);
            
            logger.info("\n\n{} compétence(s) de catégorie {} trouvée(s)\n", competences.size(), categorie);
            
            return competences.stream()
                    .map(this::mapToCompetenceResponse)
                    .collect(Collectors.toList());
                    
        } catch (ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des compétences par catégorie: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des compétences par catégorie: \n", e);
            throw new BadRequestException("Impossible de récupérer les compétences. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère les compétences par niveau
     */
    @Transactional(readOnly = true)
    public List<CompetenceResponse> getCompetencesByNiveau(Integer cvId, NiveauCompetence niveau) {
        logger.info("\n\nRecherche des compétences de niveau {} pour le CV: {}\n", niveau, cvId);
        
        try {
            // Validation des paramètres
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            if (niveau == null) {
                throw new ValidationException("niveau", "Le niveau est obligatoire");
            }
            
            List<Competence> competences = competenceRepository.findByCvIdAndNiveau(cvId, niveau);
            
            logger.info("\n\n{} compétence(s) de niveau {} trouvée(s)\n", competences.size(), niveau);
            
            return competences.stream()
                    .map(this::mapToCompetenceResponse)
                    .collect(Collectors.toList());
                    
        } catch (ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des compétences par niveau: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des compétences par niveau: \n", e);
            throw new BadRequestException("Impossible de récupérer les compétences. Veuillez réessayer.");
        }
    }
    
    /**
     * Met à jour une compétence
     */
    public CompetenceResponse updateCompetence(Integer id, CompetenceRequest request) {
        logger.info("\n\nMise à jour de la compétence avec ID: {}\n", id);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la compétence est invalide");
            }
            
            validerParametresCreationCompetence(request);
            
            Competence competence = competenceRepository.findById(id)
                    .orElseThrow(() -> new CompetenceNotFoundException(id));
            
            // Vérifier que le CV ID correspond
            if (!competence.getCv().getId().equals(request.getCvId())) {
                throw new BadRequestException("Le CV ID ne correspond pas à la compétence");
            }
            
            // Vérifier l'unicité du nom si changé
            if (!competence.getNom().equalsIgnoreCase(request.getNom().trim())) {
                if (competenceRepository.existsByCvIdAndNomIgnoreCase(request.getCvId(), request.getNom().trim())) {
                    throw new CompetenceAlreadyExistsException(request.getNom().trim(), request.getCvId());
                }
            }
            
            // Mettre à jour les champs
            competence.setNom(request.getNom().trim());
            competence.setNiveau(request.getNiveau());
            competence.setCategorie(request.getCategorie());
            
            Competence updatedCompetence = competenceRepository.save(competence);
            
            logger.info("\n\nCompétence mise à jour avec succès - ID: {}, Nom: {}\n", 
                    id, updatedCompetence.getNom());
            
            return mapToCompetenceResponse(updatedCompetence);
            
        } catch (CompetenceNotFoundException | CompetenceAlreadyExistsException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la mise à jour de la compétence: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la mise à jour de la compétence: \n", e);
            throw new BadRequestException("Impossible de mettre à jour la compétence. Veuillez réessayer.");
        }
    }
    
    /**
     * Supprime une compétence
     */
    public void supprimerCompetence(Integer id) {
        logger.info("\n\nSuppression de la compétence avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la compétence est invalide");
            }
            
            Competence competence = competenceRepository.findById(id)
                    .orElseThrow(() -> new CompetenceNotFoundException(id));
            
            competenceRepository.deleteById(id);
            
            logger.info("\n\nCompétence supprimée avec succès - ID: {}, Nom: {}\n", 
                    id, competence.getNom());
            
        } catch (CompetenceNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la suppression de la compétence: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la suppression de la compétence: \n", e);
            throw new BadRequestException("Impossible de supprimer la compétence. Veuillez réessayer.");
        }
    }
    
    // ========== MÉTHODES PRIVÉES DE VALIDATION ==========
    
    /**
     * Valide les paramètres de création de compétence
     */
    private void validerParametresCreationCompetence(CompetenceRequest request) {
        if (request == null) {
            throw new BadRequestException("Les données de la compétence sont manquantes");
        }
        
        // Validation du CV ID
        if (request.getCvId() == null || request.getCvId() <= 0) {
            throw new ValidationException("cvId", "L'identifiant du CV est invalide");
        }
        
        // Validation du nom
        if (request.getNom() == null || request.getNom().trim().isEmpty()) {
            throw new ValidationException("nom", "Le nom de la compétence est obligatoire");
        }
        
        if (request.getNom().trim().length() < 2) {
            throw new ValidationException("nom", "Le nom doit contenir au moins 2 caractères");
        }
        
        if (request.getNom().length() > 100) {
            throw new ValidationException("nom", "Le nom ne peut pas dépasser 100 caractères");
        }
        
        // Validation du niveau
        if (request.getNiveau() == null) {
            throw new ValidationException("niveau", "Le niveau de compétence est obligatoire");
        }
        
        // La catégorie est optionnelle, pas besoin de validation
    }
    
    // ========== MÉTHODES DE MAPPING ==========
    
    /**
     * Mappe CompetenceRequest vers Competence
     */
    private Competence mapToCompetence(CompetenceRequest request, CV cv) {
        try {
            return Competence.builder()
                    .cv(cv)
                    .nom(request.getNom().trim())
                    .niveau(request.getNiveau())
                    .categorie(request.getCategorie() != null ? request.getCategorie() : CategorieCompetence.AUTRE)
                    .build();
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping CompetenceRequest vers Competence: \n", e);
            throw new BadRequestException("Erreur lors de la création de la compétence");
        }
    }
    
    /**
     * Mappe Competence vers CompetenceResponse
     */
    private CompetenceResponse mapToCompetenceResponse(Competence competence) {
        try {
            if (competence == null) {
                throw new BadRequestException("La compétence ne peut pas être null");
            }
            
            return CompetenceResponse.builder()
                    .id(competence.getId())
                    .cvId(competence.getCv().getId())
                    .nom(competence.getNom())
                    .niveau(competence.getNiveau())
                    .categorie(competence.getCategorie())
                    .dateCreation(competence.getDateCreation())
                    .dateDerniereModification(competence.getDateDerniereModification())
                    .build();
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping Competence vers CompetenceResponse: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse");
        }
    }
}