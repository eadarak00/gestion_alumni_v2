package uasz.alumni.ms_cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_cv.model.Competence;
import uasz.alumni.spi.model.CategorieCompetence;
import uasz.alumni.spi.model.NiveauCompetence;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Integer> {
    
    /**
     * Trouver toutes les compétences d'un CV
     */
    List<Competence> findByCvId(Integer cvId);
    
    /**
     * Trouver une compétence par son ID et l'ID du CV
     */
    Optional<Competence> findByIdAndCvId(Integer id, Integer cvId);
    
    /**
     * Trouver les compétences par catégorie
     */
    List<Competence> findByCvIdAndCategorie(Integer cvId, CategorieCompetence categorie);
    
    /**
     * Trouver les compétences par niveau
     */
    List<Competence> findByCvIdAndNiveau(Integer cvId, NiveauCompetence niveau);
    
    /**
     * Trouver les compétences par nom
     */
    List<Competence> findByNomContainingIgnoreCase(String nom);
    
    /**
     * Vérifier si une compétence existe déjà pour un CV
     */
    boolean existsByCvIdAndNomIgnoreCase(Integer cvId, String nom);
    
    /**
     * Compter le nombre de compétences d'un CV
     */
    long countByCvId(Integer cvId);
    
    /**
     * Compter le nombre de compétences par catégorie pour un CV
     */
    long countByCvIdAndCategorie(Integer cvId, CategorieCompetence categorie);
    
    /**
     * Trouver les compétences triées par niveau (Expert -> Débutant)
     */
    @Query("SELECT c FROM Competence c WHERE c.cv.id = :cvId " +
           "ORDER BY c.niveau DESC, c.nom ASC")
    List<Competence> findByCvIdOrderByNiveau(@Param("cvId") Integer cvId);
    
    /**
     * Trouver les compétences groupées par catégorie
     */
    @Query("SELECT c FROM Competence c WHERE c.cv.id = :cvId " +
           "ORDER BY c.categorie ASC, c.niveau DESC")
    List<Competence> findByCvIdOrderByCategorie(@Param("cvId") Integer cvId);
    
    /**
     * Supprimer toutes les compétences d'un CV
     */
    void deleteByCvId(Integer cvId);
}