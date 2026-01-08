package uasz.alumni.ms_invitation.mapper;

import org.springframework.stereotype.Component;
import uasz.alumni.ms_invitation.entity.InvitationEntity;
import uasz.alumni.ms_invitation.enums.InvState;
import uasz.alumni.spi.model.Invitation;
import uasz.alumni.spi.model.SuiviInvitation;

import java.time.OffsetDateTime;

@Component
public class InvitationMapper {

    // Entity -> SPI Invitation
    public static Invitation toDto(InvitationEntity e) {
        if (e == null) return null;
        Invitation dto = new Invitation();
        dto.setId(e.getId());
        dto.setIdEnvoyeur(e.getIdEnvoyeur());
        dto.setRoleEnvoyeur(e.getRoleEnvoyeur());
        dto.setJeton(e.getJeton());
        dto.setUrlInvitation(e.getUrlInvitation());
        dto.setEtat(Invitation.EtatEnum.fromValue(e.getEtat().name()));
        dto.setDateCreation(e.getDateCreation());
        dto.setDateExpiration(e.getDateExpiration());
        dto.setDateAcceptation(e.getDateAcceptation().orElse(null)); 
        return dto;
    }


    public static InvitationEntity toEntity(String idEnvoyeur, String roleEnvoyeur, String jeton, String url, OffsetDateTime creation, OffsetDateTime expiration) {
        return InvitationEntity.builder()
                .idEnvoyeur(idEnvoyeur)
                .roleEnvoyeur(roleEnvoyeur)
                .jeton(jeton)
                .urlInvitation(url)
                .etat(InvState.EN_ATTENTE)
                .dateCreation(creation)
                .dateExpiration(expiration)
                .build();
    }
}

