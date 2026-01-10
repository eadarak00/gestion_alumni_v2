package uasz.alumni.ms_cv_v2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_cv_v2.entities.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
    
    // Récupérer un template avec ses sections
    @Query("SELECT DISTINCT t FROM Template t LEFT JOIN FETCH t.sections WHERE t.id = :id")
    Optional<Template> findByIdWithSections(@Param("id") Long id);
    
    // Récupérer tous les templates accessibles par un utilisateur, avec leurs sections
    @Query("SELECT DISTINCT t FROM Template t LEFT JOIN FETCH t.sections s WHERE t.isGlobal = true OR t.userId = :userId ORDER BY t.createdAt DESC")
    List<Template> findByIsGlobalTrueOrUserIdWithSections(@Param("userId") Long userId);
    
    // Récupérer les templates globaux
    List<Template> findByIsGlobalTrue();
    
    // Récupérer les templates d'un utilisateur spécifique
    List<Template> findByUserId(Long userId);
    
    // Récupérer les templates globaux triés
    List<Template> findByIsGlobalTrueOrderByNomAsc();
    List<Template> findByIsGlobalTrueOrderByCreatedAtDesc();
    
    // Récupérer les templates d'un utilisateur triés
    List<Template> findByUserIdOrderByNomAsc(Long userId);
    List<Template> findByUserIdOrderByCreatedAtDesc(Long userId);
    
    // Récupérer les templates accessibles (sans sections)
    List<Template> findByIsGlobalTrueOrUserId(Long userId);
    
    // Vérifier si un template existe pour un utilisateur
    boolean existsByIdAndUserId(Long id, Long userId);
    
    // Compter le nombre de templates
    long countByIsGlobalTrue();
    long countByUserId(Long userId);
    
    // Recherche par nom
    List<Template> findByNomContainingIgnoreCaseAndIsGlobalTrue(String nom);
    List<Template> findByNomContainingIgnoreCaseAndUserId(String nom, Long userId);
    
    // Récupérer les templates globaux avec sections
    @Query("SELECT DISTINCT t FROM Template t LEFT JOIN FETCH t.sections WHERE t.isGlobal = true ORDER BY t.nom ASC")
    List<Template> findGlobalTemplatesWithSections();
    
    // Récupérer les templates d'un utilisateur avec sections
    @Query("SELECT DISTINCT t FROM Template t LEFT JOIN FETCH t.sections WHERE t.userId = :userId ORDER BY t.nom ASC")
    List<Template> findUserTemplatesWithSections(@Param("userId") Long userId);
}