package uasz.alumni.ms_cv.service;

import java.util.List;

import uasz.alumni.ms_cv.entity.DemandeTelechargement;
import uasz.alumni.ms_cv.repository.DemandeTelechargementRepository;
import uasz.alumni.spi.model.TelechargementsDemandePostRequest;

public class TelechargementService {

     private final DemandeTelechargementRepository repository;

     public TelechargementService(DemandeTelechargementRepository repository) {
        this.repository = repository;
    }
    // Création demande
    public void creerDemande(TelechargementsDemandePostRequest request) {

        DemandeTelechargement demande = new DemandeTelechargement();
        demande.setCvId(request.getCvId());
        demande.setDemandeurId(request.getDemandeurId());
        demande.setMessage(request.getMessage());
        demande.setStatut("EN_ATTENTE");

        repository.save(demande);
    }
    //Validation
    public void validerDemande(Integer id) {
        DemandeTelechargement demande = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande introuvable"));

        demande.setStatut("VALIDEE");
        repository.save(demande);
    }

    //Refus
    public void refuserDemande(Integer id) {
        DemandeTelechargement demande = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande introuvable"));

        demande.setStatut("REFUSEE");
        repository.save(demande);
    }

    //Liste des demandes
    public List<DemandeTelechargement> listerDemandes(String statut) {
        if (statut == null) {
            return repository.findAll();
        }
        return repository.findByStatut(statut);
    }
}
