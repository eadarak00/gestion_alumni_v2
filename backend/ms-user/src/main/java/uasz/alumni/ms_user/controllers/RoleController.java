package uasz.alumni.ms_user.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.dtos.RoleRequestDTO;
import uasz.alumni.ms_user.dtos.RoleResponseDTO;
import uasz.alumni.ms_user.services.RoleService;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Validated
public class RoleController {

    private final RoleService roleService;

    /**
     * Récupère tous les rôles
     */
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRolesDto());
    }

    /**
     * Récupère un rôle par ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRoleById(@PathVariable Long id) {
        RoleResponseDTO dto = roleService.getRoleDtoById(id);
        return ResponseEntity.ok(dto);
    }

    /**
     * Crée un nouveau rôle
     */
    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(
            @Valid @RequestBody RoleRequestDTO dto) {
        RoleResponseDTO saved = roleService.createRole(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Met à jour un rôle existant
     */
    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> updateRole(
            @PathVariable Long id,
            @Valid @RequestBody RoleRequestDTO dto) {
        RoleResponseDTO updated = roleService.updateRole(id, dto);
        return ResponseEntity.ok(updated);
    }

    /**
     * Suppression logique (soft delete)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteRole(@PathVariable Long id) {
        roleService.softDeleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
