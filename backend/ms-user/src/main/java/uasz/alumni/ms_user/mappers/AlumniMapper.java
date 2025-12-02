package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dtos.AlumniRequestDTO;
import uasz.alumni.ms_user.dtos.AlumniResponseDTO;
import uasz.alumni.ms_user.entities.Alumni;

@Component
public class AlumniMapper {

    /**
     * Convertit le DTO record en entité Alumni
     */
    public Alumni toEntity(AlumniRequestDTO dto) {
        Alumni alumni = new Alumni();
        alumni.setNom(dto.nom());
        alumni.setPrenom(dto.prenom());
        alumni.setEmail(dto.email());
        alumni.setUsername(dto.username());
        alumni.setMotDePasse(dto.motDePasse());
        alumni.setTelephone(dto.telephone());
        alumni.setProfession(dto.profession());
        alumni.setEntreprise(dto.entreprise());
        return alumni;
    }

    /**
     * Convertit une entité Alumni en DTO record immuable
     */
    public AlumniResponseDTO toResponse(Alumni alumni) {
        return new AlumniResponseDTO(
                alumni.getId(),
                alumni.getNom(),
                alumni.getPrenom(),
                alumni.getEmail(),
                alumni.getUsername(),
                alumni.getTelephone(),
                alumni.getProfession(),
                alumni.getEntreprise(),
                alumni.isActif(),
                alumni.getRole() != null ? alumni.getRole().getLibelle() : null,
                alumni.isDeleted()
        );
    }
}
