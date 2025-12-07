package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.entities.Utilisateur;
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
}
