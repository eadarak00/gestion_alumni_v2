package uasz.alumni.ms_cv.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificationRequest {
    
    @NotNull(message = "L'ID du CV est obligatoire")
    private Integer cvId;
    
    @NotBlank(message = "Le nom de la certification est obligatoire")
    @Size(min = 2, max = 150, message = "Le nom doit contenir entre 2 et 150 caractères")
    private String nom;
    
    @NotBlank(message = "L'organisme est obligatoire")
    @Size(min = 2, max = 150, message = "L'organisme doit contenir entre 2 et 150 caractères")
    private String organisme;
    
    @NotBlank(message = "La date d'obtention est obligatoire")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{4}$", 
             message = "La date doit être au format MM/YYYY")
    private String dateObtention;
    
    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{4}$", 
             message = "La date doit être au format MM/YYYY")
    private String dateExpiration;
    
    @Size(max = 100, message = "Le numéro de credential ne peut pas dépasser 100 caractères")
    private String numeroCredential;
    
    @Pattern(regexp = "^(https?://)?.*$", 
             message = "L'URL de vérification doit être valide")
    private String urlVerification;
}