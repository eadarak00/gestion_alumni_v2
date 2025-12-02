package uasz.alumni.ms_user.common.fixtures;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import uasz.alumni.ms_user.dtos.RoleRequestDTO;
import uasz.alumni.ms_user.services.RoleService;

@Component
@AllArgsConstructor
public class RoleFixture {

    private final RoleService roleService;

    /**
     * Initialise les rôles par défaut
     */
    public void init() {
        List<String> defaultRoles = List.of("ADMINISTRATEUR", "ETUDIANT", "ALUMNI");

        defaultRoles.forEach(libelle -> {
            String normalized = libelle.trim().toUpperCase(Locale.ROOT);
            if (!roleService.existsRoleParLibelle(normalized)) {
                RoleRequestDTO dto = new RoleRequestDTO(normalized);
                roleService.createRole(dto);
            }
        });
    }
}
