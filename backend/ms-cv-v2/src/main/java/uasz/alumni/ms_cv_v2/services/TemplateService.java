package uasz.alumni.ms_cv_v2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.repository.TemplateRepository;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;

    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }
}
