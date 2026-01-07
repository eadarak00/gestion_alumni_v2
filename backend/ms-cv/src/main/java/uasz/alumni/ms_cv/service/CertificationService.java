package uasz.alumni.ms_cv.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_cv.exception.*;
import uasz.alumni.ms_cv.model.CV;
import uasz.alumni.ms_cv.model.Certification;
import uasz.alumni.ms_cv.repository.CVRepository;
import uasz.alumni.ms_cv.repository.CertificationRepository;
import uasz.alumni.spi.model.CertificationRequest;
import uasz.alumni.spi.model.CertificationResponse;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CertificationService {
    
    private final CertificationRepository certificationRepository;
    private final CVRepository cvRepository;
    
    private final Logger logger = LoggerFactory.getLogger(CertificationService.class);
    
    private static final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|1[0-2])/[0-9]{4}$");
    private static final Pattern URL_PATTERN = Pattern.compile("^(https?://)?.*$");
    
    /**
     * Crée une nouvelle certification
     */
    // public CertificationResponse creerCertification(CertificationRequest request) {
    public CertificationResponse creerCertification(CertificationRequest request) {
        logger.info("\n\nCréation d'une nouvelle certification pour le CV: {}\n", 
                request != null ? request.getCvId() : null);
        
        try {
            // Validation des paramètres
            validerParametresCreationCertification(request);
            
            // Vérifier que le CV existe
            CV cv = cvRepository.findById(request.getCvId())
                    .orElseThrow(() -> new CVNotFoundException(request.getCvId()));
            
            // Vérifier que la certification n'existe pas déjà
            if (certificationRepository.existsByCvIdAndNomIgnoreCaseAndOrganismeIgnoreCase(
                    request.getCvId(), request.getNom().trim(), request.getOrganisme().trim())) {
                throw new CertificationAlreadyExistsException(request.getNom().trim(), request.getOrganisme().trim());
            }
            
            // Créer la certification
            Certification certification = mapToCertification(request, cv);
            Certification savedCertification = certificationRepository.save(certification);
            
            logger.info("\n\nCertification créée avec succès - ID: {}, Nom: {}, Organisme: {}\n", 
                    savedCertification.getId(), savedCertification.getNom(), savedCertification.getOrganisme());
            
            return mapToCertificationResponse(savedCertification);
            
        } catch (CVNotFoundException | CertificationAlreadyExistsException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la création de la certification: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la création de la certification: \n", e);
            throw new BadRequestException("Impossible de créer la certification. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une certification par son ID
     */
    @Transactional(readOnly = true)
    public CertificationResponse getCertificationById(Integer id) {
        logger.info("\n\nRecherche de la certification avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la certification est invalide");
            }
            
            Certification certification = certificationRepository.findById(id)
                    .orElseThrow(() -> new CertificationNotFoundException(id));
            
            logger.info("\n\nCertification trouvée: {} - {}\n", 
                    certification.getNom(), certification.getOrganisme());
            
            return mapToCertificationResponse(certification);
            
        } catch (CertificationNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la certification: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la certification {}: \n", id, e);
            throw new BadRequestException("Impossible de récupérer la certification. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère une certification par ID et CV ID (sécurité)
     */
    @Transactional(readOnly = true)
    public CertificationResponse getCertificationByIdAndCvId(Integer id, Integer cvId) {
        logger.info("\n\nRecherche de la certification {} pour le CV {}\n", id, cvId);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la certification est invalide");
            }
            
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            Certification certification = certificationRepository.findByIdAndCvId(id, cvId)
                    .orElseThrow(() -> new CertificationNotFoundException(id, cvId));
            
            logger.info("\n\nCertification trouvée: {}\n", certification.getNom());
            
            return mapToCertificationResponse(certification);
            
        } catch (CertificationNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération de la certification: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération de la certification: \n", e);
            throw new BadRequestException("Impossible de récupérer la certification. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère toutes les certifications d'un CV
     */
    @Transactional(readOnly = true)
    public List<CertificationResponse> getCertificationsByCvId(Integer cvId) {
        logger.info("\n\nRecherche des certifications du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            // Vérifier que le CV existe
            if (!cvRepository.existsById(cvId)) {
                throw new CVNotFoundException(cvId);
            }
            
            List<Certification> certifications = certificationRepository.findByCvIdOrderByDate(cvId);
            
            logger.info("\n\n{} certification(s) trouvée(s) pour le CV {}\n", certifications.size(), cvId);
            
            return certifications.stream()
                    .map(this::mapToCertificationResponse)
                    .collect(Collectors.toList());
                    
        } catch (CVNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des certifications: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des certifications: \n", e);
            throw new BadRequestException("Impossible de récupérer les certifications. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère les certifications avec date d'expiration
     */
    @Transactional(readOnly = true)
    public List<CertificationResponse> getCertificationsAvecExpiration(Integer cvId) {
        logger.info("\n\nRecherche des certifications avec expiration du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            List<Certification> certifications = certificationRepository.findByCvIdWithExpiration(cvId);
            
            logger.info("\n\n{} certification(s) avec expiration trouvée(s)\n", certifications.size());
            
            return certifications.stream()
                    .map(this::mapToCertificationResponse)
                    .collect(Collectors.toList());
                    
        } catch (BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des certifications avec expiration: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des certifications avec expiration: \n", e);
            throw new BadRequestException("Impossible de récupérer les certifications. Veuillez réessayer.");
        }
    }
    
    /**
     * Récupère les certifications permanentes
     */
    @Transactional(readOnly = true)
    public List<CertificationResponse> getCertificationsPermanentes(Integer cvId) {
        logger.info("\n\nRecherche des certifications permanentes du CV: {}\n", cvId);
        
        try {
            // Validation du paramètre
            if (cvId == null || cvId <= 0) {
                throw new BadRequestException("L'identifiant du CV est invalide");
            }
            
            List<Certification> certifications = certificationRepository.findByCvIdWithoutExpiration(cvId);
            
            logger.info("\n\n{} certification(s) permanente(s) trouvée(s)\n", certifications.size());
            
            return certifications.stream()
                    .map(this::mapToCertificationResponse)
                    .collect(Collectors.toList());
                    
        } catch (BadRequestException e) {
            logger.error("\n\nErreur lors de la récupération des certifications permanentes: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la récupération des certifications permanentes: \n", e);
            throw new BadRequestException("Impossible de récupérer les certifications. Veuillez réessayer.");
        }
    }
    
    /**
     * Met à jour une certification
     */
    public CertificationResponse updateCertification(Integer id, CertificationRequest request) {
        logger.info("\n\nMise à jour de la certification avec ID: {}\n", id);
        
        try {
            // Validation des paramètres
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la certification est invalide");
            }
            
            validerParametresCreationCertification(request);
            
            Certification certification = certificationRepository.findById(id)
                    .orElseThrow(() -> new CertificationNotFoundException(id));
            
            // Vérifier que le CV ID correspond
            if (!certification.getCv().getId().equals(request.getCvId())) {
                throw new BadRequestException("Le CV ID ne correspond pas à la certification");
            }
            
            // Vérifier l'unicité si nom ou organisme changé
            if (!certification.getNom().equalsIgnoreCase(request.getNom().trim()) || 
                !certification.getOrganisme().equalsIgnoreCase(request.getOrganisme().trim())) {
                if (certificationRepository.existsByCvIdAndNomIgnoreCaseAndOrganismeIgnoreCase(
                        request.getCvId(), request.getNom().trim(), request.getOrganisme().trim())) {
                    throw new CertificationAlreadyExistsException(request.getNom().trim(), request.getOrganisme().trim());
                }
            }
            
            // Mettre à jour les champs
            certification.setNom(request.getNom().trim());
            certification.setOrganisme(request.getOrganisme().trim());
            certification.setDateObtention(request.getDateObtention());
            certification.setDateExpiration(request.getDateExpiration());
            certification.setNumeroCredential(request.getNumeroCredential());
            certification.setUrlVerification(request.getUrlVerification());
            
            Certification updatedCertification = certificationRepository.save(certification);
            
            logger.info("\n\nCertification mise à jour avec succès - ID: {}, Nom: {}\n", 
                    id, updatedCertification.getNom());
            
            return mapToCertificationResponse(updatedCertification);
            
        } catch (CertificationNotFoundException | CertificationAlreadyExistsException | 
                 ValidationException | BadRequestException e) {
            logger.error("\n\nErreur lors de la mise à jour de la certification: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la mise à jour de la certification: \n", e);
            throw new BadRequestException("Impossible de mettre à jour la certification. Veuillez réessayer.");
        }
    }
    
    /**
     * Supprime une certification
     */
    public void supprimerCertification(Integer id) {
        logger.info("\n\nSuppression de la certification avec ID: {}\n", id);
        
        try {
            // Validation du paramètre
            if (id == null || id <= 0) {
                throw new BadRequestException("L'identifiant de la certification est invalide");
            }
            
            Certification certification = certificationRepository.findById(id)
                    .orElseThrow(() -> new CertificationNotFoundException(id));
            
            certificationRepository.deleteById(id);
            
            logger.info("\n\nCertification supprimée avec succès - ID: {}, Nom: {}\n", 
                    id, certification.getNom());
            
        } catch (CertificationNotFoundException | BadRequestException e) {
            logger.error("\n\nErreur lors de la suppression de la certification: {}\n", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("\n\nErreur inattendue lors de la suppression de la certification: \n", e);
            throw new BadRequestException("Impossible de supprimer la certification. Veuillez réessayer.");
        }
    }
    
    // ========== MÉTHODES PRIVÉES DE VALIDATION ==========
    
    /**
     * Valide les paramètres de création de certification
     */
    private void validerParametresCreationCertification(CertificationRequest request) {
        if (request == null) {
            throw new BadRequestException("Les données de la certification sont manquantes");
        }
        
        // Validation du CV ID
        if (request.getCvId() == null || request.getCvId() <= 0) {
            throw new ValidationException("cvId", "L'identifiant du CV est invalide");
        }
        
        // Validation du nom
        if (request.getNom() == null || request.getNom().trim().isEmpty()) {
            throw new ValidationException("nom", "Le nom de la certification est obligatoire");
        }
        
        if (request.getNom().trim().length() < 2) {
            throw new ValidationException("nom", "Le nom doit contenir au moins 2 caractères");
        }
        
        if (request.getNom().length() > 150) {
            throw new ValidationException("nom", "Le nom ne peut pas dépasser 150 caractères");
        }
        
        // Validation de l'organisme
        if (request.getOrganisme() == null || request.getOrganisme().trim().isEmpty()) {
            throw new ValidationException("organisme", "L'organisme est obligatoire");
        }
        
        if (request.getOrganisme().trim().length() < 2) {
            throw new ValidationException("organisme", "L'organisme doit contenir au moins 2 caractères");
        }
        
        if (request.getOrganisme().length() > 150) {
            throw new ValidationException("organisme", "L'organisme ne peut pas dépasser 150 caractères");
        }
        
        // Validation de la date d'obtention
        if (request.getDateObtention() == null || request.getDateObtention().trim().isEmpty()) {
            throw new ValidationException("dateObtention", "La date d'obtention est obligatoire");
        }
        
        if (!DATE_PATTERN.matcher(request.getDateObtention()).matches()) {
            throw new ValidationException("dateObtention", "La date doit être au format MM/YYYY");
        }
        
        // Validation de la date d'expiration (optionnelle)
        if (request.getDateExpiration() != null && !request.getDateExpiration().trim().isEmpty()) {
            if (!DATE_PATTERN.matcher(request.getDateExpiration()).matches()) {
                throw new ValidationException("dateExpiration", "La date doit être au format MM/YYYY");
            }
            
            // Vérifier que date d'expiration > date d'obtention
            validerCoherenceDates(request.getDateObtention(), request.getDateExpiration());
        }
        
        // Validation de l'URL de vérification (optionnelle)
        if (request.getUrlVerification() != null && !request.getUrlVerification().trim().isEmpty()) {
            if (!URL_PATTERN.matcher(request.getUrlVerification()).matches()) {
                throw new ValidationException("urlVerification", "L'URL de vérification doit être valide");
            }
        }
        
        // Validation du numéro de credential (optionnel)
        if (request.getNumeroCredential() != null && request.getNumeroCredential().length() > 100) {
            throw new ValidationException("numeroCredential", 
                    "Le numéro de credential ne peut pas dépasser 100 caractères");
        }
    }
    
    /**
     * Valide la cohérence des dates
     */
    private void validerCoherenceDates(String dateObtention, String dateExpiration) {
        try {
            String[] obtentionParts = dateObtention.split("/");
            String[] expirationParts = dateExpiration.split("/");
            
            int moisObtention = Integer.parseInt(obtentionParts[0]);
            int anneeObtention = Integer.parseInt(obtentionParts[1]);
            
            int moisExpiration = Integer.parseInt(expirationParts[0]);
            int anneeExpiration = Integer.parseInt(expirationParts[1]);
            
            if (anneeExpiration < anneeObtention || 
                (anneeExpiration == anneeObtention && moisExpiration <= moisObtention)) {
                throw new ValidationException("dateExpiration", 
                        "La date d'expiration doit être postérieure à la date d'obtention");
            }
        } catch (NumberFormatException e) {
            throw new ValidationException("date", "Format de date invalide");
        }
    }
    
    // ========== MÉTHODES DE MAPPING ==========
    
    /**
     * Mappe CertificationRequest vers Certification
     */
    private Certification mapToCertification(CertificationRequest request, CV cv) {
        try {
            return Certification.builder()
                    .cv(cv)
                    .nom(request.getNom().trim())
                    .organisme(request.getOrganisme().trim())
                    .dateObtention(request.getDateObtention())
                    .dateExpiration(request.getDateExpiration())
                    .numeroCredential(request.getNumeroCredential())
                    .urlVerification(request.getUrlVerification())
                    .build();
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping CertificationRequest vers Certification: \n", e);
            throw new BadRequestException("Erreur lors de la création de la certification");
        }
    }
    
    /**
     * Mappe Certification vers CertificationResponse
     */
    private CertificationResponse mapToCertificationResponse(Certification certification) {
        try {
            if (certification == null) {
                throw new BadRequestException("La certification ne peut pas être null");
            }
            
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
                    
        } catch (Exception e) {
            logger.error("\n\nErreur lors du mapping Certification vers CertificationResponse: \n", e);
            throw new BadRequestException("Erreur lors de la construction de la réponse");
        }
    }
}