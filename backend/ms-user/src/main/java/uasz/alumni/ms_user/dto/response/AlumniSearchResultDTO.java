package uasz.alumni.ms_user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO pour les résultats de recherche d'alumni
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumniSearchResultDTO {
    
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String filiere;
    private String niveau;
    private Integer anneeDiplome;
    private String entreprise;
    private String poste;
    private String ville;
    private Float score;
}
