package uasz.alumni.ms_cv.entity;

import java.time.OffsetDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "demande_telechargement")
public class DemandeTelechargement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cvId;
    
    private Integer demandeurId;

    private String message;

    private String statut; // EN_ATTENTE, VALIDEE, REFUSEE

    private OffsetDateTime dateCreation = OffsetDateTime.now();

    
}

