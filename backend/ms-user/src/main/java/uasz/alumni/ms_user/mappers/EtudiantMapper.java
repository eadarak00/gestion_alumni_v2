package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.spi.model.EtudiantRequestDTO;
import uasz.alumni.spi.model.EtudiantResponseDTO;
import uasz.alumni.ms_user.entities.Etudiant;

@Component
public class EtudiantMapper {

    public Etudiant toEntity(EtudiantRequestDTO dto) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(dto.getNom());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setEmail(dto.getEmail());
        etudiant.setUsername(dto.getUsername());
        etudiant.setMotDePasse(dto.getMotDePasse());
        etudiant.setTelephone(dto.getTelephone());
        etudiant.setNumeroCarteEtudiant(dto.getNumeroCarteEtudiant());
        etudiant.setNiveau(dto.getNiveau());
        etudiant.setFiliere(dto.getFiliere());
        etudiant.setActif(false); // inactif par défaut
        return etudiant;
    }

    public EtudiantResponseDTO toResponse(Etudiant etudiant) {
        EtudiantResponseDTO response = new EtudiantResponseDTO();
        response.setId(etudiant.getId());
        response.setNom(etudiant.getNom());
        response.setPrenom(etudiant.getPrenom());
        response.setEmail(etudiant.getEmail());
        response.setUsername(etudiant.getUsername());
        response.setTelephone(etudiant.getTelephone());
        response.setNumeroCarteEtudiant(etudiant.getNumeroCarteEtudiant());
        response.setNiveau(etudiant.getNiveau());
        response.setFiliere(etudiant.getFiliere());
        response.setActif(etudiant.isActif());
        response.setRole(etudiant.getRole() != null ? etudiant.getRole().getLibelle() : null);
        response.setDeleted(etudiant.isDeleted());
        return response;
    }
}
