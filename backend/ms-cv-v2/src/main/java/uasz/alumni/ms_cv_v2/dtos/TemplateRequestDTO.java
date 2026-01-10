package uasz.alumni.ms_cv_v2.dtos;

import java.util.List;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateRequestDTO {
    private String nom;
    private Boolean isGlobal;
    
    @Valid
    private List<SectionRequestDTO> sections;
}