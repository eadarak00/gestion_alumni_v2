package uasz.alumni.ms_user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.entities.Alumni;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {

    // Recherche par email ou username
    Optional<Alumni> findByEmail(String email);
    Optional<Alumni> findByUsername(String username);

    // Vérification d’unicité
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    // Pour soft delete
    List<Alumni> findByDeletedFalse();
    Optional<Alumni> findByEmailAndDeletedFalse(String email);
    Optional<Alumni> findByUsernameAndDeletedFalse(String username);

    // Filtrer par entreprise uniquement
    Page<Alumni> findByEntrepriseAndDeletedFalse(String entreprise, Pageable pageable);

    // Filtrer par profession uniquement
    Page<Alumni> findByProfessionAndDeletedFalse(String profession, Pageable pageable);

    // Filtrer par entreprise ET profession
    Page<Alumni> findByEntrepriseAndProfessionAndDeletedFalse(String entreprise, String profession, Pageable pageable);
}
