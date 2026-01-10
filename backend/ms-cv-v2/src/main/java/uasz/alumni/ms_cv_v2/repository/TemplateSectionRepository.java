package uasz.alumni.ms_cv_v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import uasz.alumni.ms_cv_v2.entities.TemplateSection;

import java.util.List;

public interface TemplateSectionRepository extends JpaRepository<TemplateSection, Long> {
    List<TemplateSection> findByTemplateIdOrderByOrdre(Long templateId);
}
