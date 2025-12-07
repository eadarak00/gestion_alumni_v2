package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import uasz.alumni.spi.model.Certification;
import uasz.alumni.spi.model.Competence;
import uasz.alumni.spi.model.Experience;
import uasz.alumni.spi.model.Formation;
import uasz.alumni.spi.model.Langue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CV
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-05T18:58:58.392024500Z[Atlantic/Reykjavik]")
public class CV {

  private Integer id;

  private Integer utilisateurId;

  private String titre;

  private String resume;

  private String photo;

  private String linkedin;

  private String github;

  private String portfolio;

  private String telephone;

  private String email;

  private String adresse;

  @Valid
  private List<@Valid Experience> experiences;

  @Valid
  private List<@Valid Formation> formations;

  @Valid
  private List<@Valid Competence> competences;

  @Valid
  private List<@Valid Langue> langues;

  @Valid
  private List<@Valid Certification> certifications;

  /**
   * Gets or Sets templateUtilise
   */
  public enum TemplateUtiliseEnum {
    MODERNE("MODERNE"),
    
    CLASSIQUE("CLASSIQUE"),
    
    PROFESSIONNEL("PROFESSIONNEL");

    private String value;

    TemplateUtiliseEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TemplateUtiliseEnum fromValue(String value) {
      for (TemplateUtiliseEnum b : TemplateUtiliseEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TemplateUtiliseEnum templateUtilise;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateModification;

  public CV id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CV utilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
    return this;
  }

  /**
   * Get utilisateurId
   * @return utilisateurId
  */
  
  @Schema(name = "utilisateurId", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("utilisateurId")
  public Integer getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public CV titre(String titre) {
    this.titre = titre;
    return this;
  }

  /**
   * Get titre
   * @return titre
  */
  
  @Schema(name = "titre", example = "Ingénieur Full Stack", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("titre")
  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public CV resume(String resume) {
    this.resume = resume;
    return this;
  }

  /**
   * Get resume
   * @return resume
  */
  
  @Schema(name = "resume", example = "Développeur passionné avec 5 ans d'expérience...", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resume")
  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  public CV photo(String photo) {
    this.photo = photo;
    return this;
  }

  /**
   * URL de la photo de profil
   * @return photo
  */
  
  @Schema(name = "photo", example = "https://storage.uasz.sn/photos/user1.jpg", description = "URL de la photo de profil", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("photo")
  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public CV linkedin(String linkedin) {
    this.linkedin = linkedin;
    return this;
  }

  /**
   * Get linkedin
   * @return linkedin
  */
  
  @Schema(name = "linkedin", example = "https://linkedin.com/in/johndoe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("linkedin")
  public String getLinkedin() {
    return linkedin;
  }

  public void setLinkedin(String linkedin) {
    this.linkedin = linkedin;
  }

  public CV github(String github) {
    this.github = github;
    return this;
  }

  /**
   * Get github
   * @return github
  */
  
  @Schema(name = "github", example = "https://github.com/johndoe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("github")
  public String getGithub() {
    return github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public CV portfolio(String portfolio) {
    this.portfolio = portfolio;
    return this;
  }

  /**
   * Get portfolio
   * @return portfolio
  */
  
  @Schema(name = "portfolio", example = "https://johndoe.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("portfolio")
  public String getPortfolio() {
    return portfolio;
  }

  public void setPortfolio(String portfolio) {
    this.portfolio = portfolio;
  }

  public CV telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  
  @Schema(name = "telephone", example = "+221 77 123 45 67", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public CV email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", example = "john.doe@uasz.sn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CV adresse(String adresse) {
    this.adresse = adresse;
    return this;
  }

  /**
   * Get adresse
   * @return adresse
  */
  
  @Schema(name = "adresse", example = "Dakar, Sénégal", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("adresse")
  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public CV experiences(List<@Valid Experience> experiences) {
    this.experiences = experiences;
    return this;
  }

  public CV addExperiencesItem(Experience experiencesItem) {
    if (this.experiences == null) {
      this.experiences = new ArrayList<>();
    }
    this.experiences.add(experiencesItem);
    return this;
  }

  /**
   * Get experiences
   * @return experiences
  */
  @Valid 
  @Schema(name = "experiences", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("experiences")
  public List<@Valid Experience> getExperiences() {
    return experiences;
  }

  public void setExperiences(List<@Valid Experience> experiences) {
    this.experiences = experiences;
  }

  public CV formations(List<@Valid Formation> formations) {
    this.formations = formations;
    return this;
  }

  public CV addFormationsItem(Formation formationsItem) {
    if (this.formations == null) {
      this.formations = new ArrayList<>();
    }
    this.formations.add(formationsItem);
    return this;
  }

  /**
   * Get formations
   * @return formations
  */
  @Valid 
  @Schema(name = "formations", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("formations")
  public List<@Valid Formation> getFormations() {
    return formations;
  }

  public void setFormations(List<@Valid Formation> formations) {
    this.formations = formations;
  }

  public CV competences(List<@Valid Competence> competences) {
    this.competences = competences;
    return this;
  }

  public CV addCompetencesItem(Competence competencesItem) {
    if (this.competences == null) {
      this.competences = new ArrayList<>();
    }
    this.competences.add(competencesItem);
    return this;
  }

  /**
   * Get competences
   * @return competences
  */
  @Valid 
  @Schema(name = "competences", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("competences")
  public List<@Valid Competence> getCompetences() {
    return competences;
  }

  public void setCompetences(List<@Valid Competence> competences) {
    this.competences = competences;
  }

  public CV langues(List<@Valid Langue> langues) {
    this.langues = langues;
    return this;
  }

  public CV addLanguesItem(Langue languesItem) {
    if (this.langues == null) {
      this.langues = new ArrayList<>();
    }
    this.langues.add(languesItem);
    return this;
  }

  /**
   * Get langues
   * @return langues
  */
  @Valid 
  @Schema(name = "langues", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("langues")
  public List<@Valid Langue> getLangues() {
    return langues;
  }

  public void setLangues(List<@Valid Langue> langues) {
    this.langues = langues;
  }

  public CV certifications(List<@Valid Certification> certifications) {
    this.certifications = certifications;
    return this;
  }

  public CV addCertificationsItem(Certification certificationsItem) {
    if (this.certifications == null) {
      this.certifications = new ArrayList<>();
    }
    this.certifications.add(certificationsItem);
    return this;
  }

  /**
   * Get certifications
   * @return certifications
  */
  @Valid 
  @Schema(name = "certifications", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("certifications")
  public List<@Valid Certification> getCertifications() {
    return certifications;
  }

  public void setCertifications(List<@Valid Certification> certifications) {
    this.certifications = certifications;
  }

  public CV templateUtilise(TemplateUtiliseEnum templateUtilise) {
    this.templateUtilise = templateUtilise;
    return this;
  }

  /**
   * Get templateUtilise
   * @return templateUtilise
  */
  
  @Schema(name = "templateUtilise", example = "MODERNE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("templateUtilise")
  public TemplateUtiliseEnum getTemplateUtilise() {
    return templateUtilise;
  }

  public void setTemplateUtilise(TemplateUtiliseEnum templateUtilise) {
    this.templateUtilise = templateUtilise;
  }

  public CV dateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
    return this;
  }

  /**
   * Get dateCreation
   * @return dateCreation
  */
  @Valid 
  @Schema(name = "dateCreation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateCreation")
  public OffsetDateTime getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
  }

  public CV dateModification(OffsetDateTime dateModification) {
    this.dateModification = dateModification;
    return this;
  }

  /**
   * Get dateModification
   * @return dateModification
  */
  @Valid 
  @Schema(name = "dateModification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateModification")
  public OffsetDateTime getDateModification() {
    return dateModification;
  }

  public void setDateModification(OffsetDateTime dateModification) {
    this.dateModification = dateModification;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CV CV = (CV) o;
    return Objects.equals(this.id, CV.id) &&
        Objects.equals(this.utilisateurId, CV.utilisateurId) &&
        Objects.equals(this.titre, CV.titre) &&
        Objects.equals(this.resume, CV.resume) &&
        Objects.equals(this.photo, CV.photo) &&
        Objects.equals(this.linkedin, CV.linkedin) &&
        Objects.equals(this.github, CV.github) &&
        Objects.equals(this.portfolio, CV.portfolio) &&
        Objects.equals(this.telephone, CV.telephone) &&
        Objects.equals(this.email, CV.email) &&
        Objects.equals(this.adresse, CV.adresse) &&
        Objects.equals(this.experiences, CV.experiences) &&
        Objects.equals(this.formations, CV.formations) &&
        Objects.equals(this.competences, CV.competences) &&
        Objects.equals(this.langues, CV.langues) &&
        Objects.equals(this.certifications, CV.certifications) &&
        Objects.equals(this.templateUtilise, CV.templateUtilise) &&
        Objects.equals(this.dateCreation, CV.dateCreation) &&
        Objects.equals(this.dateModification, CV.dateModification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, utilisateurId, titre, resume, photo, linkedin, github, portfolio, telephone, email, adresse, experiences, formations, competences, langues, certifications, templateUtilise, dateCreation, dateModification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CV {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    utilisateurId: ").append(toIndentedString(utilisateurId)).append("\n");
    sb.append("    titre: ").append(toIndentedString(titre)).append("\n");
    sb.append("    resume: ").append(toIndentedString(resume)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
    sb.append("    linkedin: ").append(toIndentedString(linkedin)).append("\n");
    sb.append("    github: ").append(toIndentedString(github)).append("\n");
    sb.append("    portfolio: ").append(toIndentedString(portfolio)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    adresse: ").append(toIndentedString(adresse)).append("\n");
    sb.append("    experiences: ").append(toIndentedString(experiences)).append("\n");
    sb.append("    formations: ").append(toIndentedString(formations)).append("\n");
    sb.append("    competences: ").append(toIndentedString(competences)).append("\n");
    sb.append("    langues: ").append(toIndentedString(langues)).append("\n");
    sb.append("    certifications: ").append(toIndentedString(certifications)).append("\n");
    sb.append("    templateUtilise: ").append(toIndentedString(templateUtilise)).append("\n");
    sb.append("    dateCreation: ").append(toIndentedString(dateCreation)).append("\n");
    sb.append("    dateModification: ").append(toIndentedString(dateModification)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

