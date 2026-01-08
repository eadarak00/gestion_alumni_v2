package uasz.alumni.ms_cv.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificationResponse {
    
    private Integer id;
    private Integer cvId;
    private String nom;
    private String organisme;
    private String dateObtention;
    private String dateExpiration;
    private String numeroCredential;
    private String urlVerification;
    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;
}