package uasz.alumni.ms_user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Liste des utilisateurs actifs
    List<Utilisateur> findByDeletedFalse();
    Page<Utilisateur> findByDeletedFalse(Pageable pageable);

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
}
