package uasz.alumni.ms_invitation.entity;// Package: uasz.alumni.ms_invitation.entity
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;
import uasz.alumni.ms_invitation.enums.InvState;

import java.time.OffsetDateTime;


@Entity
@Table(name = "invitations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvitationEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String idEnvoyeur;


    @Column(nullable = false)
    private String roleEnvoyeur;


    @Column(nullable = false, unique = true)
    private String jeton;


    @Column(nullable = false)
    private String urlInvitation;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvState etat;


    @Column(nullable = false)
    private OffsetDateTime dateCreation;


    @Column(nullable = false)
    private OffsetDateTime dateExpiration;


    private JsonNullable<OffsetDateTime> dateAcceptation = JsonNullable.undefined();

}

