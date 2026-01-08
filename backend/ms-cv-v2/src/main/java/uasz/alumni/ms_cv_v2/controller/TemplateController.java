package uasz.alumni.ms_cv_v2.controller;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.services.TemplateService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-ms-v2/templates")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @GetMapping
    public List<Template> getAllTemplates() {
        return templateService.getAllTemplates();
    }
}
