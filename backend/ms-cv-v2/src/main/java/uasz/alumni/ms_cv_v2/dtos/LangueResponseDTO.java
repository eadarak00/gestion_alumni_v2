package uasz.alumni.ms_cv_v2.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LangueResponseDTO {
    private String nom;
    private String niveau;
}
