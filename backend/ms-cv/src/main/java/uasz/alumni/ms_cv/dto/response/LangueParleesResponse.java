package uasz.alumni.ms_cv.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.alumni.ms_cv.model.Langues;
import uasz.alumni.ms_cv.model.NiveauLangue;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LangueParleesResponse {
    
    private Integer id;
    private Integer cvId;
    private Langues langue;
    private NiveauLangue niveau;
    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereModification;
}