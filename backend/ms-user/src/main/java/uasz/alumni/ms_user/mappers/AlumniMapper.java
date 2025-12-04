package uasz.alumni.ms_user.mappers;

import org.springframework.stereotype.Component;

import uasz.alumni.spi.model.AlumniRequestDTO;
import uasz.alumni.spi.model.AlumniResponseDTO;
import uasz.alumni.ms_user.entities.Alumni;

@Component
public class AlumniMapper {

    /**
     * Convertit le DTO record en entité Alumni
     */
    public Alumni toEntity(AlumniRequestDTO dto) {
        Alumni alumni = new Alumni();
        alumni.setNom(dto.getNom());
        alumni.setPrenom(dto.getPrenom());
        alumni.setEmail(dto.getEmail());
        alumni.setUsername(dto.getUsername());
        alumni.setMotDePasse(dto.getMotDePasse());
        alumni.setTelephone(dto.getTelephone());
        alumni.setProfession(dto.getProfession());
        alumni.setEntreprise(dto.getEntreprise());
        return alumni;
    }

    /**
     * Convertit une entité Alumni en DTO record immuable
     */
    public AlumniResponseDTO toResponse(Alumni alumni) {
        AlumniResponseDTO response = new AlumniResponseDTO();
        response.setId(alumni.getId());
        response.setNom(alumni.getNom());
        response.setPrenom(alumni.getPrenom());
        response.setEmail(alumni.getEmail());
        response.setUsername(alumni.getUsername());
        response.setTelephone(alumni.getTelephone());
        response.setProfession(alumni.getProfession());
        response.setEntreprise(alumni.getEntreprise());
        response.setActif(alumni.isActif());
        response.setRole(alumni.getRole() != null ? alumni.getRole().getLibelle() : null);
        response.setDeleted(alumni.isDeleted());
        return response;
    }
}
