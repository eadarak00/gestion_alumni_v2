package uasz.alumni.ms_cv.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_cv.model.Langues;
import uasz.alumni.ms_cv.model.NiveauLangue;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LangueParleesRequest {
    
    @NotNull(message = "L'ID du CV est obligatoire")
    private Integer cvId;
    
    @NotNull(message = "La langue est obligatoire")
    private Langues langue; // FRANCAIS, ANGLAIS, ESPAGNOL, etc.
    
    @NotNull(message = "Le niveau de la langue est obligatoire")
    private NiveauLangue niveau; // DEBUTANT, INTERMEDIAIRE, AVANCE, COURANT, NATIF
}