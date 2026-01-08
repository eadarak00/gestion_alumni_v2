package uasz.alumni.ms_user.repositories;


import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.entities.CodeValidation;
import uasz.alumni.ms_user.entities.Utilisateur;

import java.util.List;

@Repository
public interface CodeValidationRepository extends JpaRepository<CodeValidation, Long> {

    // Récupérer tous les codes d’un utilisateur (utile pour l’historique)
    List<CodeValidation> findAllByUtilisateur(Utilisateur utilisateur);

    // Vérifier si un utilisateur a un code non utilisé
    boolean existsByUtilisateurAndUtiliseFalse(Utilisateur utilisateur);

    // Récupérer le dernier code généré pour un utilisateur
    Optional<CodeValidation> findTopByUtilisateurOrderByDateCreationDesc(Utilisateur utilisateur);

    // Récupérer un code encore valide (non utilisé et non expiré)
    Optional<CodeValidation> findByUtilisateurAndUtiliseFalseAndDateExpirationAfter(
            Utilisateur utilisateur,
            Instant maintenant
    );

    // Vérification OTP : par code + utilisateur + non expiré + non utilisé
    Optional<CodeValidation> findByCodeAndUtilisateurAndUtiliseFalseAndDateExpirationAfter(
            String code,
            Utilisateur utilisateur,
            Instant maintenant
    );
}