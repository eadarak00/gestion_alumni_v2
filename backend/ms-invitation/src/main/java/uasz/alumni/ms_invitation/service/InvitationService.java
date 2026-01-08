package uasz.alumni.ms_invitation.service;

import uasz.alumni.spi.model.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface InvitationService {

    Invitation generateInvitation(String idEnvoyeur, String roleEnvoyeur);
    Invitation getInvitation(Long id);
    List<Invitation> getInvitationsByEnvoyeur(String idEnvoyeur);
    ReponseValidationInvitation validateToken(String jeton);
    SuiviInvitation getSuivi(String jeton);
    StatistiquesInvitation getGlobalStatistics();
    StatistiquesInvitation getStatisticsForEnvoyeur(String idEnvoyeur);
}
