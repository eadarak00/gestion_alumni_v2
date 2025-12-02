package uasz.alumni.ms_user.dtos;

public record UtilisateurResponseDTO(
        Long id,
        String nom,
        String prenom,
        String email,
        String telephone,
        String username,
        Boolean actif,
        boolean deleted,
        String role
) {}
