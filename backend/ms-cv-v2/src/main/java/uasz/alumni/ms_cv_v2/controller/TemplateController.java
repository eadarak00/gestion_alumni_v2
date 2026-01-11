package uasz.alumni.ms_cv_v2.controller;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_cv_v2.dtos.TemplateRequestDTO;
import uasz.alumni.ms_cv_v2.dtos.TemplateResponseDTO;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.security.JwtService;
import uasz.alumni.ms_cv_v2.services.TemplateService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-ms-cv2/v1/templates")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    // private Long getUserId() {
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     if (auth != null && auth.getPrincipal() instanceof Long userId) {
    //         return userId;
    //     }
    //     return null;
    // }

    private Long getUserId() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    
    // Log de debug
    System.out.println("=== DEBUG getUserId() ===");
    System.out.println("Authentication: " + auth);
    if (auth != null) {
        System.out.println("Principal: " + auth.getPrincipal());
        System.out.println("Principal type: " + 
            (auth.getPrincipal() != null ? auth.getPrincipal().getClass().getName() : "null"));
        System.out.println("Principal is Long? " + (auth.getPrincipal() instanceof Long));
        System.out.println("Details: " + auth.getDetails());
    }
    System.out.println("=== FIN DEBUG ===");
    
    if (auth != null && auth.getPrincipal() instanceof Long userId) {
        return userId;
    }
    return null;
}

    /**
     * Créer un template avec ses sections
     */
    @PostMapping
    public ResponseEntity<TemplateResponseDTO> createTemplate(
            @Valid @RequestBody TemplateRequestDTO templateRequest) {
        
        Long userId = getUserId();
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        Template created = templateService.createTemplate(templateRequest, userId);
        TemplateResponseDTO response = templateService.convertToResponseDTO(created);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Modifier un template avec ses sections
     */
    @PutMapping("/{id}")
    public ResponseEntity<TemplateResponseDTO> updateTemplate(
            @PathVariable("id") Long templateId,
            @Valid @RequestBody TemplateRequestDTO templateRequest) {
        
        Long userId = getUserId();
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        Template updated = templateService.updateTemplate(templateId, templateRequest, userId);
        TemplateResponseDTO response = templateService.convertToResponseDTO(updated);
        return ResponseEntity.ok(response);
    }

    /**
     * Récupérer tous les templates avec leurs sections
     */
    @GetMapping
    public ResponseEntity<List<TemplateResponseDTO>> getAllTemplates() {
        Long userId = getUserId();
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        List<TemplateResponseDTO> templates = templateService.getAllTemplatesWithSections(userId);
        return ResponseEntity.ok(templates);
    }

    /**
     * Récupérer un template par id avec ses sections
     */
    @GetMapping("/{id}")
    public ResponseEntity<TemplateResponseDTO> getTemplateById(
            @PathVariable("id") Long templateId) {
        
        Long userId = getUserId();
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        Template template = templateService.getTemplateByIdWithSections(templateId, userId);
        TemplateResponseDTO response = templateService.convertToResponseDTO(template);
        return ResponseEntity.ok(response);
    }

    /**
     * Supprimer un template (uniquement si owner)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(
            @PathVariable("id") Long templateId) {
        
        Long userId = getUserId();
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        templateService.deleteTemplate(templateId, userId);
        return ResponseEntity.noContent().build();
    }
}