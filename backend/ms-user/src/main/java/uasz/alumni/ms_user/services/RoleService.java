package uasz.alumni.ms_user.services;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import uasz.alumni.ms_user.common.exceptions.ResourceAlreadyExistsException;
import uasz.alumni.ms_user.common.exceptions.ResourceNotFoundException;
import uasz.alumni.ms_user.dtos.RoleRequestDTO;
import uasz.alumni.ms_user.dtos.RoleResponseDTO;
import uasz.alumni.ms_user.entities.Role;
import uasz.alumni.ms_user.mappers.RoleMapper;
import uasz.alumni.ms_user.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    /**
     * Crée un rôle
     */
    public RoleResponseDTO createRole(@NonNull RoleRequestDTO dto) {
        String normalizedLibelle = dto.libelle().trim().toUpperCase(Locale.ROOT);

        if (roleRepository.existsByLibelle(normalizedLibelle)) {
            throw new ResourceAlreadyExistsException(
                    "Un rôle avec le libellé '" + normalizedLibelle + "' existe déjà");
        }

        Role role = roleMapper.toEntity(dto); // mapper normalise déjà
        role.setLibelle(normalizedLibelle);

        Role saved = roleRepository.save(role);
        return roleMapper.toResponse(saved);
    }

    /**
     * Met à jour un rôle existant
     */
    public RoleResponseDTO updateRole(@NonNull Long id, @NonNull RoleRequestDTO dto) {
        Role role = this.getRoleById(id);

        String normalizedLibelle = dto.libelle().trim().toUpperCase(Locale.ROOT);
        if (!role.getLibelle().equals(normalizedLibelle) &&
            roleRepository.existsByLibelle(normalizedLibelle)) {
            throw new ResourceAlreadyExistsException(
                    "Un rôle avec le libellé '" + normalizedLibelle + "' existe déjà");
        }

        roleMapper.updateEntity(role, dto);
        role.setLibelle(normalizedLibelle);

        Role updated = roleRepository.save(role);
        return roleMapper.toResponse(updated);
    }

    /**
     * Récupère un rôle par ID (Entity)
     */
    @Transactional(readOnly = true)
    public Role getRoleById(@NonNull Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Role avec ID " + id + " introuvable"));
    }

    /** 
     * Récupère un rôle par ID (DTO)
     */
    @Transactional(readOnly = true)
    public RoleResponseDTO getRoleDtoById(@NonNull Long id) {
        return roleMapper.toResponse(getRoleById(id));
    }

    /**
     * Récupère tous les rôles (DTO)
     */
    @Transactional(readOnly = true)
    public List<RoleResponseDTO> getAllRolesDto() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponse)
                .toList();
    }

    /**
     * Suppression logique (soft delete)
     */
    public void softDeleteRole(@NonNull Long id) {
        Role role = getRoleById(id);
        role.softDelete();
        roleRepository.save(role);
    }

    /**
     * Suppression permanente
     */
    public void deleteRolePermanently(@NonNull Long id) {
        if (!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Role avec ID " + id + " introuvable");
        }
        roleRepository.deleteById(id);
    }

    /**
     * Vérifie si un rôle existe par libellé
     */
    public boolean existsRoleParLibelle(@NonNull String libelle) {
        return roleRepository.existsByLibelle(libelle.trim().toUpperCase(Locale.ROOT));
    }
}
