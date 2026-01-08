package uasz.alumni.ms_cv_v2.clients.dto;

import lombok.Data;

@Data
public class UtilisateurResponseDto {

    private Long id;
    private String email;
    private String username;
    private String nom;
    private String prenom;
    private String role;
    private Boolean actif;
    private Boolean deleted;

}
