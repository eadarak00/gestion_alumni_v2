package uasz.alumni.ms_cv_v2.controller;

import lombok.RequiredArgsConstructor;
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

@RestController
@RequestMapping("/api-ms-cv2/v1/templates")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;
    private final JwtService jwtService;

    private Long getUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof Long userId) {
            return userId;
        }
        return null;
    }

    private String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getDetails() instanceof String username) {
            return username;
        }
        return auth != null ? auth.getName() : null;
    }

    /**
     * Créer un template pour l'utilisateur courant
     */
    @PostMapping
    public ResponseEntity<Template> createTemplate(@RequestBody Template template) {
        Long userId = getUserId();
        Template created = templateService.createTemplate(template, userId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * Modifier un template existant (uniquement si owner ou global)
     */
    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public ResponseEntity<Template> updateTemplate(
            @PathVariable("id") Long templateId,
            @RequestBody Template template) {
        Long userId = getUserId();
        Template updated = templateService.updateTemplate(templateId, template, userId);
        return ResponseEntity.ok(updated);
    }

    /**
     * Récupérer tous les templates accessibles par l'utilisateur
     */
    /**
     * Récupérer tous les templates accessibles par l'utilisateur
     */
    @GetMapping
    public ResponseEntity<List<Template>> getAllTemplates() {
        Long userId = getUserId();
        List<Template> templates = templateService.getAllTemplates(userId);
        return ResponseEntity.ok(templates);
    }

    /**
     * Récupérer un template par id
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplateById(
            @PathVariable("id") Long templateId) {
        Long userId = getUserId();
        Template template = templateService.getTemplateById(templateId, userId);
        return ResponseEntity.ok(template);
    }

    /**
     * Supprimer un template (uniquement si owner)
     */
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(
            @PathVariable("id") Long templateId) {
        Long userId = getUserId();
        templateService.deleteTemplate(templateId, userId);
        return ResponseEntity.noContent().build();
    }
}
