package uasz.alumni.ms_cv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class CV extends EntiteDeBase {
    
    private String titre;
    
    @Column(length = 2000)
    private String resume;
    
    private String photo;
    private String linkedin;
    private String github;
    private String portfolio;
    private String telephone;
    private String email;
    private String adresse;
    
    private Integer utilisateurId; // Lien vers ms-user
    
    @Enumerated(EnumType.STRING)
    private TypeTemplate template; // MODERNE, CLASSIQUE, PROFESSIONNEL
    
    // Relations OneToMany
    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Experience> experiences = new ArrayList<>();
    
    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Formation> formations = new ArrayList<>();
    
    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Competence> competences = new ArrayList<>();
    
    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<LangueParlees> languesParlees = new ArrayList<>();
    
    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Certification> certifications = new ArrayList<>();
}