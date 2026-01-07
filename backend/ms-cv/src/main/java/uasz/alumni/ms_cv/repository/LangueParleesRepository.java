package uasz.alumni.ms_cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_cv.model.LangueParlees;
import uasz.alumni.spi.model.Langues;
import uasz.alumni.spi.model.NiveauLangue;

import java.util.List;
import java.util.Optional;

@Repository
public interface LangueParleesRepository extends JpaRepository<LangueParlees, Integer> {
    
    /**
     * Trouver toutes les langues parlées d'un CV
     */
    List<LangueParlees> findByCvId(Integer cvId);
    
    /**
     * Trouver une langue parlée par son ID et l'ID du CV
     */
    Optional<LangueParlees> findByIdAndCvId(Integer id, Integer cvId);
    
    /**
     * Trouver une langue spécifique pour un CV
     */
    Optional<LangueParlees> findByCvIdAndLangue(Integer cvId, Langues langue);
    
    /**
     * Trouver les langues par niveau
     */
    List<LangueParlees> findByCvIdAndNiveau(Integer cvId, NiveauLangue niveau);
    
    /**
     * Vérifier si une langue existe déjà pour un CV
     */
    boolean existsByCvIdAndLangue(Integer cvId, Langues langue);
    
    /**
     * Compter le nombre de langues parlées d'un CV
     */
    long countByCvId(Integer cvId);
    
    /**
     * Trouver les langues triées par niveau (Natif -> Débutant)
     */
    @Query("SELECT l FROM LangueParlees l WHERE l.cv.id = :cvId " +
           "ORDER BY l.niveau DESC")
    List<LangueParlees> findByCvIdOrderByNiveau(@Param("cvId") Integer cvId);
    
    /**
     * Supprimer toutes les langues parlées d'un CV
     */
    void deleteByCvId(Integer cvId);
}