package uasz.alumni.ms_cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_cv.model.Experience;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    
    /**
     * Trouver toutes les expériences d'un CV
     */
    List<Experience> findByCvId(Integer cvId);
    
    /**
     * Trouver une expérience par son ID et l'ID du CV
     */
    Optional<Experience> findByIdAndCvId(Integer id, Integer cvId);
    
    /**
     * Trouver les expériences en cours
     */
    List<Experience> findByCvIdAndEnCours(Integer cvId, Boolean enCours);
    
    /**
     * Trouver les expériences par entreprise
     */
    List<Experience> findByEntrepriseContainingIgnoreCase(String entreprise);
    
    /**
     * Trouver les expériences par poste
     */
    List<Experience> findByPosteContainingIgnoreCase(String poste);
    
    /**
     * Compter le nombre d'expériences d'un CV
     */
    long countByCvId(Integer cvId);
    
    /**
     * Trouver les expériences triées par date (les plus récentes en premier)
     */
    @Query("SELECT e FROM Experience e WHERE e.cv.id = :cvId " +
           "ORDER BY e.enCours DESC, e.dateDebut DESC")
    List<Experience> findByCvIdOrderByDate(@Param("cvId") Integer cvId);
    
    /**
     * Supprimer toutes les expériences d'un CV
     */
    void deleteByCvId(Integer cvId);
}