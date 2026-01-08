package uasz.alumni.ms_invitation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import uasz.alumni.ms_invitation.service.InvitationService;
import uasz.alumni.spi.api.InvitationsApi;
import uasz.alumni.spi.api.StatistiquesApi;
import uasz.alumni.spi.api.SuiviApi;
import uasz.alumni.spi.model.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvitationController  implements InvitationsApi,StatistiquesApi,SuiviApi {

    private final InvitationService invitationService;
    
    
    @Override
    public Invitation generateInvitation(@Valid DemandeCreationInvitation demandeCreationInvitation) {
        return invitationService.generateInvitation(
                demandeCreationInvitation.getIdEnvoyeur(),
                demandeCreationInvitation.getRoleEnvoyeur().getValue()
        );
    
    }

    @Override
    public Invitation getInvitationDetails(Long idInvitation) {
        return invitationService.getInvitation(idInvitation);
        // TODO Auto-generated method stub
    }

    @Override
    public List<Invitation> getInvitationsBySender(String idEnvoyeur) {
        return invitationService.getInvitationsByEnvoyeur(idEnvoyeur);
    }

    @Override
    public SuiviInvitation trackInvitationStatus(String jeton) {
        // TODO Auto-generated method stub
        return invitationService.getSuivi(jeton);}

    @Override
    public StatistiquesInvitation getGlobalStatistics() {
        // TODO Auto-generated method stub
        return invitationService.getGlobalStatistics();}

    @Override
    public StatistiquesInvitation getSenderStatistics(String idEnvoyeur) {
        return invitationService.getStatisticsForEnvoyeur(idEnvoyeur);
        // TODO Auto-generated method stub
    }

}