package uasz.alumni.ms_cv.controller;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import uasz.alumni.ms_cv.service.TelechargementService;
import uasz.alumni.spi.api.TelechargementsApi;
import uasz.alumni.spi.model.TelechargementsDemandePostRequest;
import uasz.alumni.spi.model.TelechargementsLogsGet200ResponseInner;

@RestController
public class TelechargementsController implements TelechargementsApi {

    private final TelechargementService service;

    public TelechargementsController(TelechargementService service) {
        this.service = service;
    }

    //POST /telechargements/demande
    @Override
    public void telechargementsDemandePost(
            TelechargementsDemandePostRequest request) {

        service.creerDemande(request);
    }

    // POST /telechargements/demande/{id}/valider
    @Override
    public void telechargementsDemandeIdValiderPost(Integer id) {
        service.validerDemande(id);
    }

    // POST /telechargements/demande/{id}/refuser
    @Override
    public void telechargementsDemandeIdRefuserPost(Integer id) {
        service.refuserDemande(id);
    }

    // GET /telechargements/demandes
    @Override
    public void telechargementsDemandesGet(String statut) {
        service.listerDemandes(statut);
    }

    // GET /telechargements/logs
    @Override
    public List<TelechargementsLogsGet200ResponseInner> telechargementsLogsGet(
            Integer utilisateurId,
            Integer cvId,
            OffsetDateTime depuis,
            OffsetDateTime jusquA
    ) {
        return List.of(); // à connecter avec table logs plus tard
    }
}
