package uasz.alumni.ms_user.dtos;

public record RoleResponseDTO(
        Long id,
        String libelle,
        boolean deleted
) {
    public boolean isActive() {
        return !deleted;
    }
}
