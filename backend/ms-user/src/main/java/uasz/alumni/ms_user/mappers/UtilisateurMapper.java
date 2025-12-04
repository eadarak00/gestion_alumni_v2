package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.entities.Utilisateur;
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
}
