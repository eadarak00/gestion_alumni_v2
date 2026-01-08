package uasz.alumni.ms_cv.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.spi.model.TypeTemplate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CVRequest {
    
    @NotBlank(message = "Le titre du CV est obligatoire")
    @Size(min = 3, max = 100, message = "Le titre doit contenir entre 3 et 100 caractères")
    private String titre;
    
    @Size(max = 2000, message = "Le résumé ne peut pas dépasser 2000 caractères")
    private String resume;
    
    private String photo; // URL ou base64
    
    @Pattern(regexp = "^(https?://)?(www\\.)?linkedin\\.com/.*$", 
             message = "L'URL LinkedIn doit être valide")
    private String linkedin;
    
    @Pattern(regexp = "^(https?://)?(www\\.)?github\\.com/.*$", 
             message = "L'URL GitHub doit être valide")
    private String github;
    
    @Pattern(regexp = "^(https?://)?.*$", 
             message = "L'URL du portfolio doit être valide")
    private String portfolio;
    
    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    @Pattern(regexp = "^\\+221[0-9]{9}$", 
             message = "Le numéro de téléphone doit être au format sénégalais (+221XXXXXXXXX)")
    private String telephone;
    
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    @Size(max = 100, message = "L'email ne peut pas dépasser 100 caractères")
    private String email;
    
    @Size(max = 200, message = "L'adresse ne peut pas dépasser 200 caractères")
    private String adresse;
    
    @NotNull(message = "L'ID utilisateur est obligatoire")
    private Integer utilisateurId;
    
    private TypeTemplate template; // MODERNE, CLASSIQUE, PROFESSIONNEL
}