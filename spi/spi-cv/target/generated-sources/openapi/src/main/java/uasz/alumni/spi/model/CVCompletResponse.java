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
import uasz.alumni.spi.model.CertificationResponse;
import uasz.alumni.spi.model.CompetenceResponse;
import uasz.alumni.spi.model.ExperienceResponse;
import uasz.alumni.spi.model.FormationResponse;
import uasz.alumni.spi.model.LangueParleesResponse;
import uasz.alumni.spi.model.TypeTemplate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CVCompletResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-10T11:14:25.743819712Z[Africa/Dakar]")
public class CVCompletResponse {

  private Integer id;

  private String titre;

  private String resume;

  private String photo;

  private String linkedin;

  private String github;

  private String portfolio;

  private String telephone;

  private String email;

  private String adresse;

  private Integer utilisateurId;

  private TypeTemplate template;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateDerniereModification;

  @Valid
  private List<@Valid ExperienceResponse> experiences;

  @Valid
  private List<@Valid FormationResponse> formations;

  @Valid
  private List<@Valid CompetenceResponse> competences;

  @Valid
  private List<@Valid LangueParleesResponse> languesParlees;

  @Valid
  private List<@Valid CertificationResponse> certifications;

  public CVCompletResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CVCompletResponse titre(String titre) {
    this.titre = titre;
    return this;
  }

  /**
   * Get titre
   * @return titre
  */
  
  @Schema(name = "titre", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("titre")
  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public CVCompletResponse resume(String resume) {
    this.resume = resume;
    return this;
  }

  /**
   * Get resume
   * @return resume
  */
  
  @Schema(name = "resume", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resume")
  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  public CVCompletResponse photo(String photo) {
    this.photo = photo;
    return this;
  }

  /**
   * Get photo
   * @return photo
  */
  
  @Schema(name = "photo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("photo")
  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public CVCompletResponse linkedin(String linkedin) {
    this.linkedin = linkedin;
    return this;
  }

  /**
   * Get linkedin
   * @return linkedin
  */
  
  @Schema(name = "linkedin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("linkedin")
  public String getLinkedin() {
    return linkedin;
  }

  public void setLinkedin(String linkedin) {
    this.linkedin = linkedin;
  }

  public CVCompletResponse github(String github) {
    this.github = github;
    return this;
  }

  /**
   * Get github
   * @return github
  */
  
  @Schema(name = "github", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("github")
  public String getGithub() {
    return github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public CVCompletResponse portfolio(String portfolio) {
    this.portfolio = portfolio;
    return this;
  }

  /**
   * Get portfolio
   * @return portfolio
  */
  
  @Schema(name = "portfolio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("portfolio")
  public String getPortfolio() {
    return portfolio;
  }

  public void setPortfolio(String portfolio) {
    this.portfolio = portfolio;
  }

  public CVCompletResponse telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  
  @Schema(name = "telephone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public CVCompletResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CVCompletResponse adresse(String adresse) {
    this.adresse = adresse;
    return this;
  }

  /**
   * Get adresse
   * @return adresse
  */
  
  @Schema(name = "adresse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("adresse")
  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public CVCompletResponse utilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
    return this;
  }

  /**
   * Get utilisateurId
   * @return utilisateurId
  */
  
  @Schema(name = "utilisateurId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("utilisateurId")
  public Integer getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public CVCompletResponse template(TypeTemplate template) {
    this.template = template;
    return this;
  }

  /**
   * Get template
   * @return template
  */
  @Valid 
  @Schema(name = "template", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("template")
  public TypeTemplate getTemplate() {
    return template;
  }

  public void setTemplate(TypeTemplate template) {
    this.template = template;
  }

  public CVCompletResponse dateCreation(OffsetDateTime dateCreation) {
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

  public CVCompletResponse dateDerniereModification(OffsetDateTime dateDerniereModification) {
    this.dateDerniereModification = dateDerniereModification;
    return this;
  }

  /**
   * Get dateDerniereModification
   * @return dateDerniereModification
  */
  @Valid 
  @Schema(name = "dateDerniereModification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateDerniereModification")
  public OffsetDateTime getDateDerniereModification() {
    return dateDerniereModification;
  }

  public void setDateDerniereModification(OffsetDateTime dateDerniereModification) {
    this.dateDerniereModification = dateDerniereModification;
  }

  public CVCompletResponse experiences(List<@Valid ExperienceResponse> experiences) {
    this.experiences = experiences;
    return this;
  }

  public CVCompletResponse addExperiencesItem(ExperienceResponse experiencesItem) {
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
  public List<@Valid ExperienceResponse> getExperiences() {
    return experiences;
  }

  public void setExperiences(List<@Valid ExperienceResponse> experiences) {
    this.experiences = experiences;
  }

  public CVCompletResponse formations(List<@Valid FormationResponse> formations) {
    this.formations = formations;
    return this;
  }

  public CVCompletResponse addFormationsItem(FormationResponse formationsItem) {
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
  public List<@Valid FormationResponse> getFormations() {
    return formations;
  }

  public void setFormations(List<@Valid FormationResponse> formations) {
    this.formations = formations;
  }

  public CVCompletResponse competences(List<@Valid CompetenceResponse> competences) {
    this.competences = competences;
    return this;
  }

  public CVCompletResponse addCompetencesItem(CompetenceResponse competencesItem) {
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
  public List<@Valid CompetenceResponse> getCompetences() {
    return competences;
  }

  public void setCompetences(List<@Valid CompetenceResponse> competences) {
    this.competences = competences;
  }

  public CVCompletResponse languesParlees(List<@Valid LangueParleesResponse> languesParlees) {
    this.languesParlees = languesParlees;
    return this;
  }

  public CVCompletResponse addLanguesParleesItem(LangueParleesResponse languesParleesItem) {
    if (this.languesParlees == null) {
      this.languesParlees = new ArrayList<>();
    }
    this.languesParlees.add(languesParleesItem);
    return this;
  }

  /**
   * Get languesParlees
   * @return languesParlees
  */
  @Valid 
  @Schema(name = "languesParlees", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("languesParlees")
  public List<@Valid LangueParleesResponse> getLanguesParlees() {
    return languesParlees;
  }

  public void setLanguesParlees(List<@Valid LangueParleesResponse> languesParlees) {
    this.languesParlees = languesParlees;
  }

  public CVCompletResponse certifications(List<@Valid CertificationResponse> certifications) {
    this.certifications = certifications;
    return this;
  }

  public CVCompletResponse addCertificationsItem(CertificationResponse certificationsItem) {
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
  public List<@Valid CertificationResponse> getCertifications() {
    return certifications;
  }

  public void setCertifications(List<@Valid CertificationResponse> certifications) {
    this.certifications = certifications;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CVCompletResponse cvCompletResponse = (CVCompletResponse) o;
    return Objects.equals(this.id, cvCompletResponse.id) &&
        Objects.equals(this.titre, cvCompletResponse.titre) &&
        Objects.equals(this.resume, cvCompletResponse.resume) &&
        Objects.equals(this.photo, cvCompletResponse.photo) &&
        Objects.equals(this.linkedin, cvCompletResponse.linkedin) &&
        Objects.equals(this.github, cvCompletResponse.github) &&
        Objects.equals(this.portfolio, cvCompletResponse.portfolio) &&
        Objects.equals(this.telephone, cvCompletResponse.telephone) &&
        Objects.equals(this.email, cvCompletResponse.email) &&
        Objects.equals(this.adresse, cvCompletResponse.adresse) &&
        Objects.equals(this.utilisateurId, cvCompletResponse.utilisateurId) &&
        Objects.equals(this.template, cvCompletResponse.template) &&
        Objects.equals(this.dateCreation, cvCompletResponse.dateCreation) &&
        Objects.equals(this.dateDerniereModification, cvCompletResponse.dateDerniereModification) &&
        Objects.equals(this.experiences, cvCompletResponse.experiences) &&
        Objects.equals(this.formations, cvCompletResponse.formations) &&
        Objects.equals(this.competences, cvCompletResponse.competences) &&
        Objects.equals(this.languesParlees, cvCompletResponse.languesParlees) &&
        Objects.equals(this.certifications, cvCompletResponse.certifications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, titre, resume, photo, linkedin, github, portfolio, telephone, email, adresse, utilisateurId, template, dateCreation, dateDerniereModification, experiences, formations, competences, languesParlees, certifications);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CVCompletResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    titre: ").append(toIndentedString(titre)).append("\n");
    sb.append("    resume: ").append(toIndentedString(resume)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
    sb.append("    linkedin: ").append(toIndentedString(linkedin)).append("\n");
    sb.append("    github: ").append(toIndentedString(github)).append("\n");
    sb.append("    portfolio: ").append(toIndentedString(portfolio)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    adresse: ").append(toIndentedString(adresse)).append("\n");
    sb.append("    utilisateurId: ").append(toIndentedString(utilisateurId)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    dateCreation: ").append(toIndentedString(dateCreation)).append("\n");
    sb.append("    dateDerniereModification: ").append(toIndentedString(dateDerniereModification)).append("\n");
    sb.append("    experiences: ").append(toIndentedString(experiences)).append("\n");
    sb.append("    formations: ").append(toIndentedString(formations)).append("\n");
    sb.append("    competences: ").append(toIndentedString(competences)).append("\n");
    sb.append("    languesParlees: ").append(toIndentedString(languesParlees)).append("\n");
    sb.append("    certifications: ").append(toIndentedString(certifications)).append("\n");
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

