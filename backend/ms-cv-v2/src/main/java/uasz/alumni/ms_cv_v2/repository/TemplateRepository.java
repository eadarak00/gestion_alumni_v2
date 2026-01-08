package uasz.alumni.ms_cv_v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import feign.template.Template;

public interface TemplateRepository extends JpaRepository<Template, Long> {
}
