package uasz.alumni.ms_user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import uasz.alumni.ms_user.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Liste des utilisateurs actifs
    // List<Utilisateur> findByDeletedFalse();

    // Recherche simple
    Optional<Utilisateur> findByEmail(String email);

    Optional<Utilisateur> findByUsername(String username);

    // Recherche active uniquement
    Optional<Utilisateur> findByEmailAndDeletedFalse(String email);

    Optional<Utilisateur> findByUsernameAndDeletedFalse(String username);

    // Login email ou username
    Optional<Utilisateur> findByEmailOrUsername(String email, String username);

    Optional<Utilisateur> findByEmailOrUsernameAndDeletedFalse(String email, String username);

    // Validation existence
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmailAndDeletedFalse(String email);

    boolean existsByUsernameAndDeletedFalse(String username);

    Page<Utilisateur> findByActifAndDeleted(Boolean actif, Boolean deleted, Pageable pageable);

    Page<Utilisateur> findByActif(Boolean actif, Pageable pageable);

    Page<Utilisateur> findByDeletedTrue(Pageable pageable);

    Page<Utilisateur> findByDeletedFalse(Pageable pageable);

}
