package uasz.alumni.ms_user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("ETUDIANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Etudiant extends Utilisateur {

    @Column(unique = true)
    private String numeroCarteEtudiant;

    private String niveau;

    private String filiere;
}
