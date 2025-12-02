package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dtos.UtilisateurResponseDTO;
import uasz.alumni.ms_user.entities.Utilisateur;

@Component
public class UtilisateurMapper {

    public UtilisateurResponseDTO toDto(Utilisateur utilisateur) {
        if (utilisateur == null) return null;

        return new UtilisateurResponseDTO(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getEmail(),
                utilisateur.getTelephone(),
                utilisateur.getUsername(),
                utilisateur.isActif(),
                utilisateur.isDeleted(),
                utilisateur.getRole() != null ? utilisateur.getRole().getLibelle() : null
        );
    }
}
