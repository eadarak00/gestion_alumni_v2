package uasz.alumni.ms_cv_v2.services;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.repository.TemplateRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class TemplateService {

    private final TemplateRepository templateRepository;

    /**
     * Créer un template pour un utilisateur donné
     */
    public Template createTemplate(Template template, Long userId) {
        template.setUserId(userId); // on stocke juste l'id du user
        return templateRepository.save(template);
    }

    /**
     * Modifier un template (uniquement si c'est le owner ou template global)
     */
    public Template updateTemplate(Long templateId, Template template, Long userId) {
        Template existing = getTemplateById(templateId, userId);
        existing.setNom(template.getNom());
        existing.setGlobal(template.isGlobal());
        existing.getSections().clear();
        if (template.getSections() != null) {
            template.getSections().forEach(s -> s.setTemplate(existing));
            existing.getSections().addAll(template.getSections());
        }
        return templateRepository.save(existing);
    }

    /**
     * Lister tous les templates accessibles par l'utilisateur
     */
    public List<Template> getAllTemplates(Long userId) {
        return templateRepository.findByIsGlobalTrueOrUserId(userId);
    }

    /**
     * Récupérer un template par id si accessible par l'utilisateur
     */
    public Template getTemplateById(Long templateId, Long userId) {
        Template template = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        if (!template.isGlobal() && !template.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized");
        }

        return template;
    }

    /**
     * Supprimer un template (uniquement si owner)
     */
    public void deleteTemplate(Long templateId, Long userId) {
        Template template = getTemplateById(templateId, userId);

        if (!template.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized");
        }

        templateRepository.delete(template);
    }
}
