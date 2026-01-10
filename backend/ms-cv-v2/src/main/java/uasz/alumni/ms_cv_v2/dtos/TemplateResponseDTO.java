package uasz.alumni.ms_cv_v2.dtos;

import java.time.LocalDateTime;
import java.util.List;

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
public class TemplateResponseDTO {
    private Long id;
    private String nom;
    private Boolean isGlobal;
    private Long userId;
    private List<SectionResponseDTO> sections;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}