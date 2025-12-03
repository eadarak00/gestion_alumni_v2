package uasz.alumni.ms_user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uasz.alumni.ms_user.entities.RefreshToken;
import uasz.alumni.ms_user.entities.Utilisateur;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByTokenHash(String tokenHash);
    void deleteByUtilisateur(Utilisateur utilisateur);
}
