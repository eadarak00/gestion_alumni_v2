package uasz.alumni.ms_cv_v2.dtos;

import java.time.LocalDateTime;

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
public class SectionResponseDTO {
    private Long id;
    private String type;
    private String htmlContent;
    private int ordre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}