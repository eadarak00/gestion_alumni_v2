package uasz.alumni.ms_cv.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uasz.alumni.ms_cv.dto.response.PageResponse;
import uasz.alumni.ms_cv.exception.*;
import uasz.alumni.ms_cv.model.*;
import uasz.alumni.ms_cv.repository.*;
import uasz.alumni.spi.model.CVCompletResponse;
import uasz.alumni.spi.model.CVRequest;
import uasz.alumni.spi.model.CVResponse;
import uasz.alumni.spi.model.CertificationResponse;
import uasz.alumni.spi.model.CompetenceResponse;
import uasz.alumni.spi.model.ExperienceResponse;
import uasz.alumni.spi.model.FormationResponse;
import uasz.alumni.spi.model.LangueParleesResponse;
import uasz.alumni.spi.model.TypeTemplate;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CVService {
    
    private final CVRepository cvRepository;
    private final ExperienceRepository experienceRepository;
    private final FormationRepository formationRepository;
    private final CompetenceRepository competenceRepository;
    private final LangueParleesRepository langueParleesRepository;
    private final CertificationRepository certificationRepository;
    
    private final Logger logger = LoggerFactory.getLogger(CVService.class);
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+221[0-9]{9}$");
    private static final Pattern URL_PATTERN = Pattern.compile("^(https?://)?.*$");
    
    /**
     * Crée un nouveau CV
     */
    public CVResponse creerCV(CVRequest request) {
        logger.info("\n\nCréation d'un nouveau CV pour l'utilisateur: {}\n", 
                request != null ? request.getUtilisateurId() : null);
        
        try {
            // Validation des paramètres
            validerParametresCreationCV(request);
            
            // Vérifier que l'utilisateur n'a pas déjà un CV (optionnel selon vos besoins)
            // verifierUniciteUtilisateur(request.getUtilisateurId(), null);
            
            // Créer le CV
            CV cv = mapToCV(request);
            CV savedCV = cvRepository.save(cv);
            
            logger.info("\n\nCV créé avec succès - ID: {}, Titre: {}, Utilisateur: {}\n", 
                    savedCV.getId(), savedCV.getTitre(), savedCV.getUtilisateurId());
            
            return mapToCVResponse(savedCV);
            
        } catch (CVAlreadyExistsException | ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la création du CV: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la création du CV: \n", e);
            throw new BadRequestException("Impossible de créer le CV. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère un CV par son ID
     */
    @Transactional(readOnly = true)
    public CVResponse getCVById(Integer id) {
        logger.info("\n\nRecherche du CV avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            CV cv = cvRepository.findById(id)
                    .orElseThrow(() -> new CVNotFoundException(id));
            
            logger.info("\n\nCV trouvé: {}, Utilisateur: {}\n", 
                    cv.getTitre(), cv.getUtilisateurId());
            
            return mapToCVResponse(cv);
            
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération du CV: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération du CV {}: \n", id, e);
            throw new BadRequestException("Impossible de récupérer le CV. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère un CV complet avec toutes ses sections
     */
    @Transactional(readOnly = true)
    public CVCompletResponse getCVComplet(Integer id) {
        logger.info("\n\nRecherche du CV complet avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            CV cv = cvRepository.findByIdComplet(id)
                    .orElseThrow(() -> new CVNotFoundException(id));
            
            logger.info("\n\nCV complet trouvé - Expériences: {}, Formations: {}, Compétences: {}\n", 
                    cv.getExperiences().size(), 
                    cv.getFormations().size(), 
                    cv.getCompetences().size());
            
            return mapToCVCompletResponse(cv);
            
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération du CV complet: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération du CV complet {}: \n", id, e);
            throw new BadRequestException("Impossible de récupérer le CV complet. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère un CV par ID et utilisateur (sécurité)
     */
    @Transactional(readOnly = true)
    public CVResponse getCVByIdAndUtilisateur(Integer id, Integer utilisateurId) {
        logger.info("\n\nRecherche du CV {} pour l'utilisateur {}\n", id, utilisateurId);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            if (utilisateurId == null || utilisateurId <= 0) {
                throw new BadRequestException("L'identifiant de l'utilisateur est invalide");
            }
            
            CV cv = cvRepository.findByIdAndUtilisateurId(id, utilisateurId)
                    .orElseThrow(() -> new CVNotFoundException(id, utilisateurId));
            
            logger.info("\n\nCV trouvé: {}\n", cv.getTitre());
            
            return mapToCVResponse(cv);
            
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération du CV: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération du CV: \n", e);
            throw new BadRequestException("Impossible de récupérer le CV. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère tous les CVs d'un utilisateur
     */
    @Transactional(readOnly = true)
    public List<CVResponse> getCVsByUtilisateur(Integer utilisateurId) {
        logger.info("\n\nRecherche des CVs de l'utilisateur: {}\n", utilisateurId);
        
        try {
            // Validation du paramètre
            if (utilisateurId == null || utilisateurId <= 0) {
                throw new BadRequestException("L'identifiant de l'utilisateur est invalide");
            }
            
            List<CV> cvs = cvRepository.findByUtilisateurId(utilisateurId);
            
            logger.info("\n\n{} CV(s) trouvé(s) pour l'utilisateur {}\n", cvs.size(), utilisateurId);
            
            return cvs.stream()
                    .map(this::mapToCVResponse)
                    .collect(Collectors.toList());
                    
        } catch (BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des CVs: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des CVs: \n", e);
            throw new BadRequestException("Impossible de récupérer les CVs. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère tous les CVs
     */
    @Transactional(readOnly = true)
    public List<CVResponse> getAllCVs() {
        logger.info("\n\nRécupération de tous les CVs\n");
        
        try {
            List<CV> cvs = cvRepository.findAll();
            
            logger.info("\n\n{} CV(s) trouvé(s)\n", cvs.size());
            
            return cvs.stream()
                    .map(this::mapToCVResponse)
                    .collect(Collectors.toList());
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors de la récupération des CVs: \n", e);
            throw new BadRequestException("Impossible de récupérer les CVs. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère tous les CVs avec pagination
     */
    @Transactional(readOnly = true)
    public PageResponse<CVResponse> getAllCVsPage(Pageable pageable) {
        logger.info("\n\nRécupération des CVs - Page: {}, Taille: {}\n", 
                pageable != null ? pageable.getPageNumber() : 0,
                pageable != null ? pageable.getPageSize() : 0);
        
        try {
            // Validation du paramètre
            if (pageable == null) {
                throw new BadRequestException("Les paramètres de pagination sont requis");
            }
            
            Page<CV> cvPage = cvRepository.findAll(pageable);
            
            logger.info("\n\n{} CV(s) trouvé(s) sur cette page - Total: {}\n", 
                    cvPage.getNumberOfElements(), cvPage.getTotalElements());
            
            return mapToPageResponse(cvPage);
            
        } catch (BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des CVs: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des CVs: \n", e);
            throw new BadRequestException("Impossible de récupérer les CVs. Veuillez réessayer.");
        }
    }
    
    /**
     * Met à jour un CV
     */
    public CVResponse updateCV(Integer id, CVRequest request) {
        logger.info("\n\nMise à jour du CV avec ID: {}\n", id);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            validerParametresCreationCV(request);
            
            CV cv = cvRepository.findById(id)
                    .orElseThrow(() -> new CVNotFoundException(id));
            
            // Mettre à jour les champs
            cv.setTitre(request.getTitre().trim());
            cv.setResume(request.getResume() != null ? request.getResume().trim() : null);
            cv.setPhoto(request.getPhoto());
            cv.setLinkedin(request.getLinkedin());
            cv.setGithub(request.getGithub());
            cv.setPortfolio(request.getPortfolio());
            cv.setTelephone(request.getTelephone().trim());
            cv.setEmail(request.getEmail().trim().toLowerCase());
            cv.setAdresse(request.getAdresse());
            cv.setTemplate(request.getTemplate());
            
            CV updatedCV = cvRepository.save(cv);
            
            logger.info("\n\nCV mis à jour avec succès - ID: {}, Titre: {}\n", 
                    id, updatedCV.getTitre());
            
            return mapToCVResponse(updatedCV);
            
        } catch (CVNotFoundException | ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la mise à jour du CV: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la mise à jour du CV: \n", e);
            throw new BadRequestException("Impossible de mettre à jour le CV. Veuillez réessayer.");
        }
    }
    
    /**
     * Supprime un CV
     */
    public void supprimerCV(Integer id) {
        logger.info("\n\nSuppression du CV avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            CV cv = cvRepository.findById(id)
                    .orElseThrow(() -> new CVNotFoundException(id));
            
            cvRepository.deleteById(id);
            
            logger.info("\n\nCV supprimé avec succès - ID: {}, Titre: {}\n", 
                    id, cv.getTitre());
            
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la suppression du CV: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la suppression du CV: \n", e);
            throw new BadRequestException("Impossible de supprimer le CV. Veuillez réessayer.");
        }
    }
    
    // ========== MÉTHODES PRIVÉES DE VALIDATION ==========
    
    /**
     * Valide les paramètres de création de CV
     */
    private void validerParametresCreationCV(CVRequest request) {
        if (request == null) {
            throw new BadRequestException("Les données du CV sont manquantes");
        }
        
        // Validation du titre
        if (request.getTitre() == null || request.getTitre().trim().isEmpty()) {
            throw new ValidationException("titre", "Le titre est obligatoire");
        }
        
        if (request.getTitre().trim().length() < 3) {
            throw new ValidationException("titre", "Le titre doit contenir au moins 3 caractères");
        }
        
        if (request.getTitre().length() > 100) {
            throw new ValidationException("titre", "Le titre ne peut pas dépasser 100 caractères");
        }
        
        // Validation du résumé (optionnel)
        if (request.getResume() != null && request.getResume().length() > 2000) {
            throw new ValidationException("resume", "Le résumé ne peut pas dépasser 2000 caractères");
        }
        
        // Validation de l'email
        validerEmail(request.getEmail());
        
        // Validation du téléphone
        validerTelephone(request.getTelephone());
        
        // Validation des URLs (optionnelles)
        if (request.getLinkedin() != null && !request.getLinkedin().trim().isEmpty()) {
            validerLinkedIn(request.getLinkedin());
        }
        
        if (request.getGithub() != null && !request.getGithub().trim().isEmpty()) {
            validerGitHub(request.getGithub());
        }
        
        if (request.getPortfolio() != null && !request.getPortfolio().trim().isEmpty()) {
            validerURL(request.getPortfolio(), "portfolio");
        }
        
        // Validation de l'utilisateur ID
        if (request.getUtilisateurId() == null || request.getUtilisateurId() <= 0) {
            throw new ValidationException("utilisateurId", "L'identifiant de l'utilisateur est invalide");
        }
    }
    
    /**
     * Valide un email
     */
    private void validerEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("email", "L'email est obligatoire");
        }
        
        if (email.length() > 100) {
            throw new ValidationException("email", "L'email ne peut pas dépasser 100 caractères");
        }
        
        if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new ValidationException("email", "Format d'email invalide");
        }
    }
    
    /**
     * Valide un numéro de téléphone
     */
    private void validerTelephone(String telephone) {
        if (telephone == null || telephone.trim().isEmpty()) {
            throw new ValidationException("telephone", "Le téléphone est obligatoire");
        }
        
        String tel = telephone.trim();
        
        if (!PHONE_PATTERN.matcher(tel).matches()) {
            throw new ValidationException("telephone", 
                    "Le numéro de téléphone doit être au format sénégalais (+221XXXXXXXXX)");
        }
    }
    
    /**
     * Valide une URL LinkedIn
     */
    private void validerLinkedIn(String linkedin) {
        if (!linkedin.toLowerCase().contains("linkedin.com")) {
            throw new ValidationException("linkedin", "L'URL LinkedIn doit être valide");
        }
    }
    
    /**
     * Valide une URL GitHub
     */
    private void validerGitHub(String github) {
        if (!github.toLowerCase().contains("github.com")) {
            throw new ValidationException("github", "L'URL GitHub doit être valide");
        }
    }
    
    /**
     * Valide une URL générique
     */
    private void validerURL(String url, String fieldName) {
        if (!URL_PATTERN.matcher(url).matches()) {
            throw new ValidationException(fieldName, "L'URL doit être valide");
        }
    }
    
    /**
     * Vérifie qu'un utilisateur n'a pas déjà un CV
     */
    private void verifierUniciteUtilisateur(Integer utilisateurId, Integer excludeId) {
        if (utilisateurId == null) {
            return;
        }
        
        boolean exists;
        if (excludeId != null) {
            exists = cvRepository.findAll().stream()
                    .anyMatch(cv -> !cv.getId().equals(excludeId) && 
                                   cv.getUtilisateurId().equals(utilisateurId));
        } else {
            exists = cvRepository.existsByUtilisateurId(utilisateurId);
        }
        
        if (exists) {
            logger.error("\n\nL'utilisateur {} possède déjà un CV\n", utilisateurId);
            throw new CVAlreadyExistsException(utilisateurId);
        }
    }
    
    // ========== MÉTHODES DE MAPPING ==========
    
    /**
     * Mappe CVRequest vers CV
     */
    private CV mapToCV(CVRequest request) {
        try {
            return CV.builder()
                    .titre(request.getTitre().trim())
                    .resume(request.getResume() != null ? request.getResume().trim() : null)
                    .photo(request.getPhoto())
                    .linkedin(request.getLinkedin())
                    .github(request.getGithub())
                    .portfolio(request.getPortfolio())
                    .telephone(request.getTelephone().trim())
                    .email(request.getEmail().trim().toLowerCase())
                    .adresse(request.getAdresse())
                    .utilisateurId(request.getUtilisateurId())
                    .template(request.getTemplate() != null ? request.getTemplate() : TypeTemplate.MODERNE)
                    .build();
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping CVRequest vers CV: \n", e);
            throw new BadRequestException("Erreur lors de la création du CV");
        }
    }
    
    /**
     * Mappe CV vers CVResponse
     */
    private CVResponse mapToCVResponse(CV cv) {
        try {
            if (cv == null) {
                throw new BadRequestException("Le CV ne peut pas être null");
            }
            
            // return CVResponse.builder()
            //         .id(cv.getId())
            //         .titre(cv.getTitre())
            //         .resume(cv.getResume())
            //         .photo(cv.getPhoto())
            //         .linkedin(cv.getLinkedin())
            //         .github(cv.getGithub())
            //         .portfolio(cv.getPortfolio())
            //         .telephone(cv.getTelephone())
            //         .email(cv.getEmail())
            //         .adresse(cv.getAdresse())
            //         .utilisateurId(cv.getUtilisateurId())
            //         .template(cv.getTemplate())
            //         .dateCreation(cv.getDateCreation())
            //         .dateDerniereModification(cv.getDateDerniereModification())
            //         .build();

            CVResponse response = new CVResponse();
            response.setId(cv.getId());
            response.setTitre(cv.getTitre());
            response.setResume(cv.getResume());
            response.setPhoto(cv.getPhoto());
            response.setLinkedin(cv.getLinkedin());
            response.setGithub(cv.getGithub());
            response.setPortfolio(cv.getPortfolio());
            response.setTelephone(cv.getTelephone());
            response.setEmail(cv.getEmail());
            response.setAdresse(cv.getAdresse());
            response.setUtilisateurId(cv.getUtilisateurId());
            response.setTemplate(cv.getTemplate());
            response.setDateCreation(cv.getDateCreation());
            response.setDateDerniereModification(cv.getDateDerniereModification());
            return response;
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping CV vers CVResponse: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse");
        }
    }
    
    /**
     * Mappe CV vers CVCompletResponse
     */
    private CVCompletResponse mapToCVCompletResponse(CV cv) {
        try {
            if (cv == null) {
                throw new BadRequestException("Le CV ne peut pas être null");
            }
            
            // return CVCompletResponse.builder()
            //         .id(cv.getId())
            //         .titre(cv.getTitre())
            //         .resume(cv.getResume())
            //         .photo(cv.getPhoto())
            //         .linkedin(cv.getLinkedin())
            //         .github(cv.getGithub())
            //         .portfolio(cv.getPortfolio())
            //         .telephone(cv.getTelephone())
            //         .email(cv.getEmail())
            //         .adresse(cv.getAdresse())
            //         .utilisateurId(cv.getUtilisateurId())
            //         .template(cv.getTemplate())
            //         .experiences(cv.getExperiences().stream()
            //                 .map(this::mapToExperienceResponse)
            //                 .collect(Collectors.toList()))
            //         .formations(cv.getFormations().stream()
            //                 .map(this::mapToFormationResponse)
            //                 .collect(Collectors.toList()))
            //         .competences(cv.getCompetences().stream()
            //                 .map(this::mapToCompetenceResponse)
            //                 .collect(Collectors.toList()))
            //         .languesParlees(cv.getLanguesParlees().stream()
            //                 .map(this::mapToLangueParleesResponse)
            //                 .collect(Collectors.toList()))
            //         .certifications(cv.getCertifications().stream()
            //                 .map(this::mapToCertificationResponse)
            //                 .collect(Collectors.toList()))
            //         .dateCreation(cv.getDateCreation())
            //         .dateDerniereModification(cv.getDateDerniereModification())
            //         .build();

            CVCompletResponse response = new CVCompletResponse();
            response.setId(cv.getId());
            response.setTitre(cv.getTitre());
            response.setResume(cv.getResume());
            response.setPhoto(cv.getPhoto());
            response.setLinkedin(cv.getLinkedin());
            response.setGithub(cv.getGithub());
            response.setPortfolio(cv.getPortfolio());
            response.setTelephone(cv.getTelephone());
            response.setEmail(cv.getEmail());
            response.setAdresse(cv.getAdresse());
            response.setUtilisateurId(cv.getUtilisateurId());
            response.setTemplate(cv.getTemplate());
            response.setExperiences(cv.getExperiences().stream()
                    .map(this::mapToExperienceResponse)
                    .collect(Collectors.toList()));
            response.setFormations(cv.getFormations().stream()
                    .map(this::mapToFormationResponse)
                    .collect(Collectors.toList()));
            response.setCompetences(cv.getCompetences().stream()
                    .map(this::mapToCompetenceResponse)
                    .collect(Collectors.toList()));
            response.setLanguesParlees(cv.getLanguesParlees().stream()
                    .map(this::mapToLangueParleesResponse)
                    .collect(Collectors.toList()));
            response.setCertifications(cv.getCertifications().stream()
                    .map(this::mapToCertificationResponse)
                    .collect(Collectors.toList()));
            response.setDateCreation(cv.getDateCreation());
            response.setDateDerniereModification(cv.getDateDerniereModification());
            return response;
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping CV vers CVCompletResponse: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse complète");
        }
    }
    
    /**
     * Mappe Experience vers ExperienceResponse
     */
    private ExperienceResponse mapToExperienceResponse(Experience experience) {
        // return ExperienceResponse.builder()
        //         .id(experience.getId())
        //         .cvId(experience.getCv().getId())
        //         .poste(experience.getPoste())
        //         .entreprise(experience.getEntreprise())
        //         .localisation(experience.getLocalisation())
        //         .dateDebut(experience.getDateDebut())
        //         .dateFin(experience.getDateFin())
        //         .enCours(experience.getEnCours())
        //         .description(experience.getDescription())
        //         .dateCreation(experience.getDateCreation())
        //         .dateDerniereModification(experience.getDateDerniereModification())
        //         .build();

        ExperienceResponse response = new ExperienceResponse();
        response.setId(experience.getId());
        response.setCvId(experience.getCv().getId());
        response.setPoste(experience.getPoste());
        response.setEntreprise(experience.getEntreprise());
        response.setLocalisation(experience.getLocalisation());
        response.setDateDebut(experience.getDateDebut());
        response.setDateFin(experience.getDateFin());
        response.setEnCours(experience.getEnCours());
        response.setDescription(experience.getDescription());
        response.setDateCreation(experience.getDateCreation());
        response.setDateDerniereModification(experience.getDateDerniereModification());
        return response;
    }
    
    /**
     * Mappe Formation vers FormationResponse
     */
    private FormationResponse mapToFormationResponse(Formation formation) {
        // return FormationResponse.builder()
        //         .id(formation.getId())
        //         .cvId(formation.getCv().getId())
        //         .diplome(formation.getDiplome())
        //         .etablissement(formation.getEtablissement())
        //         .localisation(formation.getLocalisation())
        //         .dateDebut(formation.getDateDebut())
        //         .dateFin(formation.getDateFin())
        //         .enCours(formation.getEnCours())
        //         .description(formation.getDescription())
        //         .dateCreation(formation.getDateCreation())
        //         .dateDerniereModification(formation.getDateDerniereModification())
        //         .build();

        FormationResponse response = new FormationResponse();
        response.setId(formation.getId());
        response.setCvId(formation.getCv().getId());
        response.setDiplome(formation.getDiplome());
        response.setEtablissement(formation.getEtablissement());
        response.setLocalisation(formation.getLocalisation());
        response.setDateDebut(formation.getDateDebut());
        response.setDateFin(formation.getDateFin());
        response.setEnCours(formation.getEnCours());
        response.setDescription(formation.getDescription());
        response.setDateCreation(formation.getDateCreation());
        response.setDateDerniereModification(formation.getDateDerniereModification());
        return response;
    }
    
    /**
     * Mappe Competence vers CompetenceResponse
     */
    private CompetenceResponse mapToCompetenceResponse(Competence competence) {
        // return CompetenceResponse.builder()
        //         .id(competence.getId())
        //         .cvId(competence.getCv().getId())
        //         .nom(competence.getNom())
        //         .niveau(competence.getNiveau())
        //         .categorie(competence.getCategorie())
        //         .dateCreation(competence.getDateCreation())
        //         .dateDerniereModification(competence.getDateDerniereModification())
        //         .build();

        CompetenceResponse response = new CompetenceResponse();
        response.setId(competence.getId());
        response.setCvId(competence.getCv().getId());
        response.setNom(competence.getNom());
        response.setNiveau(competence.getNiveau());
        response.setCategorie(competence.getCategorie());
        response.setDateCreation(competence.getDateCreation());
        response.setDateDerniereModification(competence.getDateDerniereModification());
        return response;
    }
    
    /**
     * Mappe LangueParlees vers LangueParleesResponse
     */
    private LangueParleesResponse mapToLangueParleesResponse(LangueParlees langue) {
        // return LangueParleesResponse.builder()
        //         .id(langue.getId())
        //         .cvId(langue.getCv().getId())
        //         .langue(langue.getLangue())
        //         .niveau(langue.getNiveau())
        //         .dateCreation(langue.getDateCreation())
        //         .dateDerniereModification(langue.getDateDerniereModification())
        //         .build();

        LangueParleesResponse response = new LangueParleesResponse();
        response.setId(langue.getId());
        response.setCvId(langue.getCv().getId());
        response.setLangue(langue.getLangue());
        response.setNiveau(langue.getNiveau());
        response.setDateCreation(langue.getDateCreation());
        response.setDateDerniereModification(langue.getDateDerniereModification());
        return response;
    }
    
    /**
     * Mappe Certification vers CertificationResponse
     */
    private CertificationResponse mapToCertificationResponse(Certification certification) {
        // return CertificationResponse.builder()
        //         .id(certification.getId())
        //         .cvId(certification.getCv().getId())
        //         .nom(certification.getNom())
        //         .organisme(certification.getOrganisme())
        //         .dateObtention(certification.getDateObtention())
        //         .dateExpiration(certification.getDateExpiration())
        //         .numeroCredential(certification.getNumeroCredential())
        //         .urlVerification(certification.getUrlVerification())
        //         .dateCreation(certification.getDateCreation())
        //         .dateDerniereModification(certification.getDateDerniereModification())
        //         .build();

        CertificationResponse response = new CertificationResponse();
        response.setId(certification.getId());
        response.setCvId(certification.getCv().getId());
        response.setNom(certification.getNom());
        response.setOrganisme(certification.getOrganisme());
        response.setDateObtention(certification.getDateObtention());
        response.setDateExpiration(certification.getDateExpiration());
        response.setNumeroCredential(certification.getNumeroCredential());
        response.setUrlVerification(certification.getUrlVerification());
        response.setDateCreation(certification.getDateCreation());
        response.setDateDerniereModification(certification.getDateDerniereModification());
        return response;
    }
    
    /**
     * Mappe une Page vers PageResponse
     */
    private PageResponse<CVResponse> mapToPageResponse(Page<CV> cvPage) {
        try {
            if (cvPage == null) {
                throw new BadRequestException("La page ne peut pas être null");
            }
            
            List<CVResponse> cvs = cvPage.getContent()
                    .stream()
                    .map(this::mapToCVResponse)
                    .collect(Collectors.toList());
            
            return PageResponse.<CVResponse>builder()
                    .content(cvs)
                    .pageNumber(cvPage.getNumber())
                    .pageSize(cvPage.getSize())
                    .totalElements(cvPage.getTotalElements())
                    .totalPages(cvPage.getTotalPages())
                    .last(cvPage.isLast())
                    .first(cvPage.isFirst())
                    .build();
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping de la page: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse paginée");
        }
    }
}