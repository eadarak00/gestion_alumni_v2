package uasz.alumni.ms_user.mappers;

import java.util.Locale;

import org.springframework.stereotype.Component;

import uasz.alumni.ms_user.dtos.RoleRequestDTO;
import uasz.alumni.ms_user.dtos.RoleResponseDTO;
import uasz.alumni.ms_user.entities.Role;

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
                .libelle(normalizeLibelle(dto.libelle()))
                .build();
    }

    /**
     * Mise à jour d'une entité existante à partir du DTO
     */
    public void updateEntity(Role role, RoleRequestDTO dto) {
        role.setLibelle(normalizeLibelle(dto.libelle()));
    }

    /**
     * Convertit Entity → Response DTO
     */
    public RoleResponseDTO toResponse(Role role) {
        return new RoleResponseDTO(
                role.getId(),
                role.getLibelle(),
                role.isDeleted()
        );
    }
}
