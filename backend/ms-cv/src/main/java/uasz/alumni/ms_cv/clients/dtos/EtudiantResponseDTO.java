package uasz.alumni.ms_cv.clients.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantResponseDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String username;

    private String telephone;

    private String numeroCarteEtudiant;

    private String niveau;

    private String filiere;

    private Boolean actif;

    private String role;

    private Boolean deleted;
}
