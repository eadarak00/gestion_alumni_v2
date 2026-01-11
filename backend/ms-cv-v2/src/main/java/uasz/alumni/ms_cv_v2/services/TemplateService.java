package uasz.alumni.ms_cv_v2.services;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.entities.TemplateSection;
import uasz.alumni.ms_cv_v2.repository.TemplateRepository;
import uasz.alumni.spi.model.SectionRequestDTO;
import uasz.alumni.spi.model.SectionResponseDTO;
import uasz.alumni.spi.model.TemplateRequestDTO;
import uasz.alumni.spi.model.TemplateResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class TemplateService {

    private final TemplateRepository templateRepository;

    /**
     * Créer un template avec ses sections
     */
    public Template createTemplate(TemplateRequestDTO templateDTO, Long userId) {
        // Créer le template
        Template template = Template.builder()
                .nom(templateDTO.getNom())
                .isGlobal(templateDTO.getIsGlobal() != null ? templateDTO.getIsGlobal() : false)
                .userId(userId)
                .sections(new ArrayList<>())
                .build();
        
        // Créer et ajouter les sections
        if (templateDTO.getSections() != null && !templateDTO.getSections().isEmpty()) {
            for (SectionRequestDTO sectionDTO : templateDTO.getSections()) {
                TemplateSection section = TemplateSection.builder()
                        .template(template)
                        .type(sectionDTO.getType())
                        .htmlContent(sectionDTO.getHtmlContent())
                        .ordre(sectionDTO.getOrdre())
                        .build();
                
                template.getSections().add(section);
            }
        }
        
        // Une seule sauvegarde (cascade fonctionnera)
        return templateRepository.save(template);
    }

    /**
     * Récupérer un template par id (sans vérification de droits)
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Template getTemplateById(Long templateId) {
        return templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template non trouvé"));
    }

    /**
     * Récupérer un template par id avec vérification des droits
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Template getTemplateById(Long templateId, Long userId) {
        Template template = getTemplateByIdWithSections(templateId);
        
        // Vérifier les droits d'accès
        if (!template.getIsGlobal() && !template.getUserId().equals(userId)) {
            throw new RuntimeException("Non autorisé: vous n'avez pas accès à ce template");
        }
        
        return template;
    }

    /**
     * Récupérer un template par id avec ses sections (sans vérification de droits)
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Template getTemplateByIdWithSections(Long templateId) {
        return templateRepository.findByIdWithSections(templateId)
                .orElseThrow(() -> new RuntimeException("Template non trouvé"));
    }

    /**
     * Récupérer un template par id avec ses sections et vérification des droits
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Template getTemplateByIdWithSections(Long templateId, Long userId) {
        Template template = getTemplateByIdWithSections(templateId);
        
        // Vérifier les droits d'accès
        if (!template.getIsGlobal() && !template.getUserId().equals(userId)) {
            throw new RuntimeException("Non autorisé: vous n'avez pas accès à ce template");
        }
        
        return template;
    }

    /**
     * Modifier un template avec ses sections
     */
    public Template updateTemplate(Long templateId, TemplateRequestDTO templateDTO, Long userId) {
        // Récupérer le template existant avec ses sections
        Template existing = getTemplateByIdWithSections(templateId);
        
        // Vérifier les permissions
        if (!existing.getIsGlobal() && !existing.getUserId().equals(userId)) {
            throw new RuntimeException("Non autorisé");
        }
        
        // Mettre à jour les propriétés de base
        existing.setNom(templateDTO.getNom());
        if (templateDTO.getIsGlobal() != null) {
            existing.setIsGlobal(templateDTO.getIsGlobal());
        }
        
        // Mettre à jour les sections (orphanRemoval = true supprimera les anciennes)
        if (templateDTO.getSections() != null) {
            // Supprimer toutes les sections existantes
            existing.getSections().clear();
            
            // Ajouter les nouvelles sections
            for (SectionRequestDTO sectionDTO : templateDTO.getSections()) {
                TemplateSection section = TemplateSection.builder()
                        .template(existing)
                        .type(sectionDTO.getType())
                        .htmlContent(sectionDTO.getHtmlContent())
                        .ordre(sectionDTO.getOrdre())
                        .build();
                
                existing.getSections().add(section);
            }
        }
        
        return templateRepository.save(existing);
    }

    /**
     * Convertir Template en TemplateResponseDTO
     */
    // public TemplateResponseDTO convertToResponseDTO(Template template) {
    //     if (template == null) {
    //         return null;
    //     }
        
    //     TemplateResponseDTO responseDTO = TemplateResponseDTO.builder()
    //             .id(template.getId())
    //             .nom(template.getNom())
    //             .isGlobal(template.getIsGlobal())
    //             .userId(template.getUserId())
    //             .createdAt(template.getCreatedAt())
    //             .updatedAt(template.getUpdatedAt())
    //             .sections(new ArrayList<>())
    //             .build();
        
    //     // Convertir les sections
    //     if (template.getSections() != null && !template.getSections().isEmpty()) {
    //         // Trier les sections par ordre
    //         List<TemplateSection> sortedSections = template.getSections().stream()
    //                 .sorted(Comparator.comparingInt(TemplateSection::getOrdre))
    //                 .collect(Collectors.toList());
            
    //         for (TemplateSection section : sortedSections) {
    //             SectionResponseDTO sectionDTO = SectionResponseDTO.builder()
    //                     .id(section.getId())
    //                     .type(section.getType())
    //                     .htmlContent(section.getHtmlContent())
    //                     .ordre(section.getOrdre())
    //                     .createdAt(section.getCreatedAt())
    //                     .updatedAt(section.getUpdatedAt())
    //                     .build();
                
    //             responseDTO.getSections().add(sectionDTO);
    //         }
    //     }
        
    //     return responseDTO;
    // }

    public TemplateResponseDTO convertToResponseDTO(Template template) {
    if (template == null) {
        return null;
    }
    
    TemplateResponseDTO responseDTO = new TemplateResponseDTO();
    
    responseDTO.setId(template.getId());
    responseDTO.setNom(template.getNom());
    responseDTO.setIsGlobal(template.getIsGlobal());
    responseDTO.setUserId(template.getUserId());
    responseDTO.setCreatedAt(template.getCreatedAt().atOffset(ZoneOffset.UTC));
    responseDTO.setUpdatedAt(template.getUpdatedAt().atOffset(ZoneOffset.UTC));
    responseDTO.setSections(new ArrayList<>());
    
    // Convertir les sections
    if (template.getSections() != null && !template.getSections().isEmpty()) {
        // Trier les sections par ordre
        List<TemplateSection> sortedSections = template.getSections().stream()
                .sorted(Comparator.comparingInt(TemplateSection::getOrdre))
                .toList();
        
        for (TemplateSection section : sortedSections) {
            SectionResponseDTO sectionDTO = new SectionResponseDTO();
            
            sectionDTO.setId(section.getId());
            sectionDTO.setType(section.getType());
            sectionDTO.setHtmlContent(section.getHtmlContent());
            sectionDTO.setOrdre(section.getOrdre());
            sectionDTO.setCreatedAt(section.getCreatedAt().atOffset(ZoneOffset.UTC));
            sectionDTO.setUpdatedAt(section.getUpdatedAt().atOffset(ZoneOffset.UTC));
            
            responseDTO.getSections().add(sectionDTO);
        }
    }
    
    return responseDTO;
}

    /**
     * Récupérer un template sous forme de DTO avec vérification des droits
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public TemplateResponseDTO getTemplateDTOById(Long templateId, Long userId) {
        Template template = getTemplateByIdWithSections(templateId, userId);
        return convertToResponseDTO(template);
    }

    /**
     * Lister tous les templates avec leurs sections
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<TemplateResponseDTO> getAllTemplatesWithSections(Long userId) {
        List<Template> templates = templateRepository.findByIsGlobalTrueOrUserIdWithSections(userId);
        return templates.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Supprimer un template (uniquement si owner)
     */
    public void deleteTemplate(Long templateId, Long userId) {
        Template template = getTemplateById(templateId, userId);
        
        // Vérifier que l'utilisateur est le propriétaire
        if (!template.getUserId().equals(userId)) {
            throw new RuntimeException("Non autorisé: seuls les propriétaires peuvent supprimer leur template");
        }
        
        templateRepository.delete(template);
    }

    /**
     * Lister tous les templates (basique, sans sections)
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Template> getAllTemplates(Long userId) {
        return templateRepository.findByIsGlobalTrueOrUserId(userId);
    }

    /**
     * Récupérer les templates globaux
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Template> getGlobalTemplates() {
        return templateRepository.findByIsGlobalTrue();
    }

    /**
     * Récupérer les templates d'un utilisateur spécifique
     */
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Template> getUserTemplates(Long userId) {
        return templateRepository.findByUserId(userId);
    }
}