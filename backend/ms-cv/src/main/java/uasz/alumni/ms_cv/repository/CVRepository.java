package uasz.alumni.ms_cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_cv.model.CV;
import uasz.alumni.spi.model.TypeTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public interface CVRepository extends JpaRepository<CV, Integer> {
    
    /**
     * Trouver tous les CVs d'un utilisateur
     */
    List<CV> findByUtilisateurId(Integer utilisateurId);
    
    /**
     * Trouver un CV par son ID et l'ID de l'utilisateur (sécurité)
     */
    Optional<CV> findByIdAndUtilisateurId(Integer id, Integer utilisateurId);
    
    /**
     * Trouver les CVs par template
     */
    List<CV> findByTemplate(TypeTemplate template);
    
    /**
     * Trouver les CVs par titre contenant un mot-clé
     */
    List<CV> findByTitreContainingIgnoreCase(String titre);
    
    /**
     * Vérifier si un utilisateur a déjà un CV
     */
    boolean existsByUtilisateurId(Integer utilisateurId);
    
    /**
     * Compter le nombre de CVs d'un utilisateur
     */
    long countByUtilisateurId(Integer utilisateurId);
    
    /**
     * Trouver les CVs avec leurs expériences (fetch eager)
     */
    @Query("SELECT DISTINCT cv FROM CV cv LEFT JOIN FETCH cv.experiences WHERE cv.id = :id")
    Optional<CV> findByIdWithExperiences(@Param("id") Integer id);
    
    /**
     * Trouver les CVs avec leurs formations (fetch eager)
     */
    @Query("SELECT DISTINCT cv FROM CV cv LEFT JOIN FETCH cv.formations WHERE cv.id = :id")
    Optional<CV> findByIdWithFormations(@Param("id") Integer id);
    
    /**
     * Trouver un CV complet avec toutes ses sections
     */
    @Query("SELECT DISTINCT cv FROM CV cv " +
           "LEFT JOIN FETCH cv.experiences " +
           "LEFT JOIN FETCH cv.formations " +
           "LEFT JOIN FETCH cv.competences " +
           "LEFT JOIN FETCH cv.languesParlees " +
           "LEFT JOIN FETCH cv.certifications " +
           "WHERE cv.id = :id")
    Optional<CV> findByIdComplet(@Param("id") Integer id);
    
    /**
     * Supprimer tous les CVs d'un utilisateur
     */
    void deleteByUtilisateurId(Integer utilisateurId);
}