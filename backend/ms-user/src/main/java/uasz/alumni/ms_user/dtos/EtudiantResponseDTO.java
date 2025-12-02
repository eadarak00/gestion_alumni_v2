package uasz.alumni.ms_user.dtos;

public record EtudiantResponseDTO(
    Long id,
    String nom,
    String prenom,
    String email,
    String username,
    String telephone,
    String numeroCarteEtudiant,
    String niveau,
    String filiere,
    boolean actif,
    String role,
    boolean deleted
) {
    public boolean isActive() {
        return !deleted;
    }
}
