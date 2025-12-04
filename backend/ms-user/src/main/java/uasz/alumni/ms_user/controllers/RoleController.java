package uasz.alumni.ms_user.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import uasz.alumni.ms_user.services.RoleService;
import uasz.alumni.spi.api.RolesApi;
import uasz.alumni.spi.model.RoleRequestDTO;
import uasz.alumni.spi.model.RoleResponseDTO;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RoleController implements RolesApi {

    private final RoleService roleService;

    @Override
    public ResponseEntity<RoleResponseDTO> createRole(
            @Valid RoleRequestDTO dto) {
        RoleResponseDTO saved = roleService.createRole(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRolesDto());
    }

    @Override
    public ResponseEntity<RoleResponseDTO> getRoleById(Long id) {
        RoleResponseDTO dto = roleService.getRoleDtoById(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> softDeleteRole(Long id) {
        roleService.softDeleteRole(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<RoleResponseDTO> updateRole(Long id,
            @Valid RoleRequestDTO dto) {
        RoleResponseDTO updated = roleService.updateRole(id, dto);
        return ResponseEntity.ok(updated);
    }
}
