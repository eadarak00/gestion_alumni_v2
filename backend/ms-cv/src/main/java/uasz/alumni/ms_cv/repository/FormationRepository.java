package uasz.alumni.ms_cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_cv.model.Formation;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {
    
    /**
     * Trouver toutes les formations d'un CV
     */
    List<Formation> findByCvId(Integer cvId);
    
    /**
     * Trouver une formation par son ID et l'ID du CV
     */
    Optional<Formation> findByIdAndCvId(Integer id, Integer cvId);
    
    /**
     * Trouver les formations en cours
     */
    List<Formation> findByCvIdAndEnCours(Integer cvId, Boolean enCours);
    
    /**
     * Trouver les formations par établissement
     */
    List<Formation> findByEtablissementContainingIgnoreCase(String etablissement);
    
    /**
     * Trouver les formations par diplôme
     */
    List<Formation> findByDiplomeContainingIgnoreCase(String diplome);
    
    /**
     * Compter le nombre de formations d'un CV
     */
    long countByCvId(Integer cvId);
    
    /**
     * Trouver les formations triées par date (les plus récentes en premier)
     */
    @Query("SELECT f FROM Formation f WHERE f.cv.id = :cvId " +
           "ORDER BY f.enCours DESC, f.dateDebut DESC")
    List<Formation> findByCvIdOrderByDate(@Param("cvId") Integer cvId);
    
    /**
     * Supprimer toutes les formations d'un CV
     */
    void deleteByCvId(Integer cvId);
}