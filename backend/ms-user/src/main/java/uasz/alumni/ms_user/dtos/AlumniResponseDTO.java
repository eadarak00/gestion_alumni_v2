package uasz.alumni.ms_user.dtos;

public record AlumniResponseDTO(
    Long id,
    String nom,
    String prenom,
    String email,
    String username,
    String telephone,
    String profession,
    String entreprise,
    boolean actif,
    String role,
    boolean deleted
) {
    /**
     * Retourne vrai si l'alumni est actif et non supprimé
     */
    public boolean isActive() {
        return !deleted && actif;
    }
}
