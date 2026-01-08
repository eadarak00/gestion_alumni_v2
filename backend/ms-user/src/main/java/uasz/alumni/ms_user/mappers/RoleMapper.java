package uasz.alumni.ms_user.mappers;

import java.util.Locale;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.entities.Role;
import uasz.alumni.spi.model.RoleRequestDTO;
import uasz.alumni.spi.model.RoleResponseDTO;

@Component
public class RoleMapper {

    /**
     * Normalise le libellé : trim + majuscules.
     */
    private String normalizeLibelle(String libelle) {
        return libelle == null
                ? null
                : libelle.trim().toUpperCase(Locale.ROOT);
    }

    /**
     * Convertit DTO → Entity (création)
     */
    public Role toEntity(RoleRequestDTO dto) {
        return Role.builder()
                .libelle(normalizeLibelle(dto.getLibelle()))
                .build();
    }

    /**
     * Mise à jour d'une entité existante à partir du DTO
     */
    public void updateEntity(Role role, RoleRequestDTO dto) {
        role.setLibelle(normalizeLibelle(dto.getLibelle()));
    }

    /**
     * Convertit Entity → Response DTO
     */
    public RoleResponseDTO toResponse(Role role) {
        RoleResponseDTO response = new RoleResponseDTO();
        response.setId(role.getId());
        response.setLibelle(role.getLibelle());
        response.setDeleted(role.isDeleted());
        return response;
    }
}
