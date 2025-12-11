package uasz.alumni.ms_user.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Document Elasticsearch pour l'index alumni_profiles
 * Représente un profil d'alumni indexé
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumniDocument {
    
    @JsonProperty("_id")
    private String id;
    
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
    
    @JsonProperty("fullName")
    private String fullName;
    
    @JsonProperty("indexed_at")
    private Long indexedAt;
}
