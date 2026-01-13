package uasz.alumni.ms_cv_v2.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "template_sections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateSection extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;

    private String type; // "formations", "experiences", "competences", "langues", "interets", etc.

    @Lob
    private String htmlContent; // fragment HTML avec placeholders ${cv.xxx}

    private int ordre; // ordre d'affichage
}
