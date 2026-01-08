package uasz.alumni.ms_cv_v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_cv_v2.entities.Competence;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}
