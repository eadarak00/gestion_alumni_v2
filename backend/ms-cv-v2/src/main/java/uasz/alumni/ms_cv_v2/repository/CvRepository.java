package uasz.alumni.ms_cv_v2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import uasz.alumni.ms_cv_v2.entities.Cv;

import java.util.List;
import java.util.Optional;

public interface CvRepository extends JpaRepository<Cv, Long> {

    List<Cv> findByUserId(Long userId);

    Optional<Cv> findByIdAndUserId(Long id, Long userId);
}
