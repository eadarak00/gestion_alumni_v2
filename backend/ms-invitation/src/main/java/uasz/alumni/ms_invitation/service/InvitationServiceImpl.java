package uasz.alumni.ms_invitation.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uasz.alumni.ms_invitation.client.AlumniFeignClient;
import uasz.alumni.ms_invitation.entity.InvitationEntity;
import uasz.alumni.ms_invitation.enums.InvState;
import uasz.alumni.ms_invitation.exception.*;
import uasz.alumni.ms_invitation.mapper.InvitationMapper;
import uasz.alumni.ms_invitation.repository.InvitationRepository;
import uasz.alumni.spi.model.*;
import uasz.alumni.spi.model.Invitation;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InvitationServiceImpl implements InvitationService {

    private final InvitationRepository repository;
    private final AlumniFeignClient alumniFeignClient;

    private final String baseUrl = "https://alumni.com/invitation/valider?jeton=";
    private final long expirationHours = 48;

    // =====================================================
    // CREATION
    // =====================================================

    @Override
    public Invitation generateInvitation(String idEnvoyeur, String roleEnvoyeur) {

        boolean exists = repository.existsByIdEnvoyeurAndEtat(
                idEnvoyeur,
                InvState.EN_ATTENTE.name()
        );

        if (exists) {
            throw new DuplicateInvitationException(
                    "Une invitation en attente existe déjà pour cet utilisateur"
            );
        }

        // Tu fournis toi-même idEnvoyeur, pas besoin de Feign
        // AlumniResponseDTO user = alumniFeignClient.getUserById(idEnvoyeur);
        // if (!user.getRole().equalsIgnoreCase(roleEnvoyeur)) { ... }

        String jeton = UUID.randomUUID().toString();
        OffsetDateTime now = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        OffsetDateTime expiration = now.plusHours(expirationHours);
        String url = baseUrl + jeton;

        InvitationEntity entity = InvitationMapper.toEntity(
                idEnvoyeur,  // ici ton idEnvoyeur personnalisé
                roleEnvoyeur,
                jeton,
                url,
                now,
                expiration
        );

        InvitationEntity saved = repository.save(entity);
        return InvitationMapper.toDto(saved);
    }


    // =====================================================
    // CONSULTATION
    // =====================================================
    @Override
    public Invitation getInvitation(Long id) {
        InvitationEntity entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invitation introuvable")
                );
        return InvitationMapper.toDto(entity);
    }

    @Override
    public List<Invitation> getInvitationsByEnvoyeur(String idEnvoyeur) {
        return repository.findByIdEnvoyeur(idEnvoyeur)
                .stream()
                .map(InvitationMapper::toDto)
                .collect(Collectors.toList());
    }

    // =====================================================
    // VALIDATION
    // =====================================================
    @Override
    public ReponseValidationInvitation validateToken(String jeton) {

        InvitationEntity entity = repository.findByJeton(jeton)
                .orElseThrow(() ->
                        new InvalidTokenException("Jeton introuvable")
                );

        if (entity.getDateExpiration().isBefore(OffsetDateTime.now())) {
            entity.setEtat(InvState.EXPIREE);
            repository.save(entity);
            throw new InvitationExpiredException("Invitation expirée");
        }

        if (entity.getEtat() != InvState.EN_ATTENTE) {
            throw new InvalidInvitationStateException(
                    "Invitation déjà traitée"
            );
        }

        entity.setEtat(InvState.ACCEPTEE);
        entity.setDateAcceptation(
                JsonNullable.of(
                        OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS)
                )
        );

        repository.save(entity);

        ReponseValidationInvitation response = new ReponseValidationInvitation();
        response.setValide(true);
        response.setMessage("Invitation acceptée");

        return response;
    }

    // =====================================================
    // SUIVI
    // =====================================================
    @Override
    public SuiviInvitation getSuivi(String jeton) {

        InvitationEntity entity = repository.findByJeton(jeton)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Jeton introuvable")
            );

    SuiviInvitation suivi = new SuiviInvitation();
    suivi.setEtat(SuiviInvitation.EtatEnum.fromValue(entity.getEtat().name()));
    suivi.setDateOuverture(entity.getDateCreation());  // OffsetDateTime direct
    suivi.setDateAcceptation(entity.getDateAcceptation().orElse(null)); // extraction de JsonNullable

    return suivi;
    }

    // =====================================================
    // STATISTIQUES
    // =====================================================
    @Override
    public StatistiquesInvitation getGlobalStatistics() {
        return computeStats(repository.findAll());
    }

    @Override
    public StatistiquesInvitation getStatisticsForEnvoyeur(String idEnvoyeur) {
        return computeStats(repository.findByIdEnvoyeur(idEnvoyeur));
    }

    private StatistiquesInvitation computeStats(List<InvitationEntity> list) {

        int total = list.size();
        long accepted = list.stream()
                .filter(i -> i.getEtat() == InvState.ACCEPTEE)
                .count();
        long expired = list.stream()
                .filter(i -> i.getEtat() == InvState.EXPIREE)
                .count();

        StatistiquesInvitation stats = new StatistiquesInvitation();
        stats.setTotalInvitations(total);
        stats.setTotalAcceptees((int) accepted);
        stats.setTotalExpirees((int) expired);
        stats.setTauxConversion(
                total == 0 ? 0f : ((float) accepted / total) * 100
        );

        return stats;
    }
}
