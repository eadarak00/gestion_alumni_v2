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
public class ExperienceRequest {
    
    @NotNull(message = "L'ID du CV est obligatoire")
    private Integer cvId;
    
    @NotBlank(message = "Le poste est obligatoire")
    @Size(min = 2, max = 100, message = "Le poste doit contenir entre 2 et 100 caractères")
    private String poste;
    
    @NotBlank(message = "L'entreprise est obligatoire")
    @Size(min = 2, max = 100, message = "L'entreprise doit contenir entre 2 et 100 caractères")
    private String entreprise;
    
    @Size(max = 100, message = "La localisation ne peut pas dépasser 100 caractères")
    private String localisation;
    
    @NotBlank(message = "La date de début est obligatoire")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{4}$", 
             message = "La date doit être au format MM/YYYY")
    private String dateDebut;
    
    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{4}$", 
             message = "La date doit être au format MM/YYYY")
    private String dateFin;
    
    private Boolean enCours;
    
    @Size(max = 2000, message = "La description ne peut pas dépasser 2000 caractères")
    private String description;
}