package uasz.alumni.ms_invitation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_invitation.entity.InvitationEntity;


import java.util.List;
import java.util.Optional;


@Repository
public interface InvitationRepository extends JpaRepository<InvitationEntity, Long> {
    Optional<InvitationEntity> findByJeton(String jeton);
    List<InvitationEntity> findByIdEnvoyeur(String idEnvoyeur);
    boolean existsByIdEnvoyeurAndEtat(String idEnvoyeur, String etat);
}