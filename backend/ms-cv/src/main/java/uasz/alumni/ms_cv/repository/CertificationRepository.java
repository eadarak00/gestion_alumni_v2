package uasz.alumni.ms_cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_cv.model.Certification;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer> {
    
    /**
     * Trouver toutes les certifications d'un CV
     */
    List<Certification> findByCvId(Integer cvId);
    
    /**
     * Trouver une certification par son ID et l'ID du CV
     */
    Optional<Certification> findByIdAndCvId(Integer id, Integer cvId);
    
    /**
     * Trouver les certifications par organisme
     */
    List<Certification> findByOrganismeContainingIgnoreCase(String organisme);
    
    /**
     * Trouver les certifications par nom
     */
    List<Certification> findByNomContainingIgnoreCase(String nom);
    
    /**
     * Trouver les certifications avec une date d'expiration
     */
    @Query("SELECT c FROM Certification c WHERE c.cv.id = :cvId " +
           "AND c.dateExpiration IS NOT NULL")
    List<Certification> findByCvIdWithExpiration(@Param("cvId") Integer cvId);
    
    /**
     * Trouver les certifications sans date d'expiration (permanentes)
     */
    @Query("SELECT c FROM Certification c WHERE c.cv.id = :cvId " +
           "AND c.dateExpiration IS NULL")
    List<Certification> findByCvIdWithoutExpiration(@Param("cvId") Integer cvId);
    
    /**
     * Vérifier si une certification existe déjà pour un CV
     */
    boolean existsByCvIdAndNomIgnoreCaseAndOrganismeIgnoreCase(
        Integer cvId, String nom, String organisme);
    
    /**
     * Compter le nombre de certifications d'un CV
     */
    long countByCvId(Integer cvId);
    
    /**
     * Trouver les certifications triées par date (les plus récentes en premier)
     */
    @Query("SELECT c FROM Certification c WHERE c.cv.id = :cvId " +
           "ORDER BY c.dateObtention DESC")
    List<Certification> findByCvIdOrderByDate(@Param("cvId") Integer cvId);
    
    /**
     * Supprimer toutes les certifications d'un CV
     */
    void deleteByCvId(Integer cvId);
}