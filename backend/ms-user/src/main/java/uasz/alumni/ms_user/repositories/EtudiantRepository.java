package uasz.alumni.ms_user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Optional<Etudiant> findByEmail(String email);

    Optional<Etudiant> findByUsername(String username);

    Optional<Etudiant> findByNumeroCarteEtudiant(String numeroCarteEtudiant);

    // Recherche uniquement les étudiants non supprimés (optionnel mais TRÈS utile)
    List<Etudiant> findByDeletedFalse();
}
