package uasz.alumni.ms_user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO pour la requête d'indexation en masse d'alumni
 * T3.1.2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndexRequestDTO {
    private String userId;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String filiere;
    private String niveau;
    private Integer anneeDiplome;
    private String profession;
    private String entreprise;
    private String ville;
    private Boolean actif;
}
