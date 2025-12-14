package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.entities.Alumni;
import uasz.alumni.ms_user.entities.Etudiant;
import uasz.alumni.ms_user.entities.Utilisateur;
import uasz.alumni.spi.model.AlumniResponseDTO;
import uasz.alumni.spi.model.EtudiantResponseDTO;
import uasz.alumni.spi.model.UtilisateurRequestDTO;
import uasz.alumni.spi.model.UtilisateurResponseDTO;

@Component
public class UtilisateurMapper {

    public UtilisateurResponseDTO toDto(Utilisateur utilisateur) {
        if (utilisateur == null)
            return null;
        UtilisateurResponseDTO dto = new UtilisateurResponseDTO();
        dto.setId(utilisateur.getId());
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setEmail(utilisateur.getEmail());
        dto.setTelephone(utilisateur.getTelephone());
        dto.setUsername(utilisateur.getUsername());
        dto.setActif(utilisateur.isActif());
        dto.setDeleted(utilisateur.isDeleted());
        dto.setRole(utilisateur.getRole().getLibelle());
        return dto;
    }

    public Utilisateur toEntity(UtilisateurRequestDTO dto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setMotDePasse(dto.getMotDePasse());
        utilisateur.setTelephone(dto.getTelephone());
        utilisateur.setActif(false);
        return utilisateur;
    }

    // ================= Etudiant =================
    public EtudiantResponseDTO toEtudiantDto(Etudiant etudiant) {
        if (etudiant == null) return null;

        EtudiantResponseDTO dto = new EtudiantResponseDTO();
        dto.setId(etudiant.getId());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setEmail(etudiant.getEmail());
        dto.setUsername(etudiant.getUsername());
        dto.setTelephone(etudiant.getTelephone());
        dto.setNumeroCarteEtudiant(etudiant.getNumeroCarteEtudiant());
        dto.setFiliere(etudiant.getFiliere());
        dto.setNiveau(etudiant.getNiveau());
        dto.setActif(etudiant.isActif());
        dto.setDeleted(etudiant.isDeleted());
        dto.setRole(etudiant.getRole().getLibelle());

        return dto;
    }

    public AlumniResponseDTO toAlumniDto(Alumni alumni) {
        if (alumni == null) return null;

        AlumniResponseDTO dto = new AlumniResponseDTO();
        dto.setId(alumni.getId());
        dto.setNom(alumni.getNom());
        dto.setPrenom(alumni.getPrenom());
        dto.setEmail(alumni.getEmail());
        dto.setUsername(alumni.getUsername());
        dto.setTelephone(alumni.getTelephone());
        dto.setProfession(alumni.getProfession());
        dto.setEntreprise(alumni.getEntreprise());
        dto.setActif(alumni.isActif());
        dto.setDeleted(alumni.isDeleted());
        dto.setRole(alumni.getRole().getLibelle());

        return dto;
    }
}
