package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dtos.EtudiantRequestDTO;
import uasz.alumni.ms_user.dtos.EtudiantResponseDTO;
import uasz.alumni.ms_user.entities.Etudiant;

@Component
public class EtudiantMapper {

    public Etudiant toEntity(EtudiantRequestDTO dto) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(dto.nom());
        etudiant.setPrenom(dto.prenom());
        etudiant.setEmail(dto.email());
        etudiant.setUsername(dto.username());
        etudiant.setMotDePasse(dto.motDePasse());
        etudiant.setTelephone(dto.telephone());
        etudiant.setNumeroCarteEtudiant(dto.numeroCarteEtudiant());
        etudiant.setNiveau(dto.niveau());
        etudiant.setFiliere(dto.filiere());
        etudiant.setActif(false); // inactif par défaut
        return etudiant;
    }

    public EtudiantResponseDTO toResponse(Etudiant etudiant) {
        return new EtudiantResponseDTO(
            etudiant.getId(),
            etudiant.getNom(),
            etudiant.getPrenom(),
            etudiant.getEmail(),
            etudiant.getUsername(),
            etudiant.getTelephone(),
            etudiant.getNumeroCarteEtudiant(),
            etudiant.getNiveau(),
            etudiant.getFiliere(),
            etudiant.isActif(),
            etudiant.getRole() != null ? etudiant.getRole().getLibelle() : null,
            etudiant.isDeleted()
        );
    }
}
