package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import uasz.alumni.spi.model.TypeTemplate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CVResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-16T22:17:05.074030704Z[Africa/Dakar]")
public class CVResponse {

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

  public CVResponse id(Integer id) {
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

  public CVResponse titre(String titre) {
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

  public CVResponse resume(String resume) {
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

  public CVResponse photo(String photo) {
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

  public CVResponse linkedin(String linkedin) {
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

  public CVResponse github(String github) {
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

  public CVResponse portfolio(String portfolio) {
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

  public CVResponse telephone(String telephone) {
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

  public CVResponse email(String email) {
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

  public CVResponse adresse(String adresse) {
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

  public CVResponse utilisateurId(Integer utilisateurId) {
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

  public CVResponse template(TypeTemplate template) {
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

  public CVResponse dateCreation(OffsetDateTime dateCreation) {
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

  public CVResponse dateDerniereModification(OffsetDateTime dateDerniereModification) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CVResponse cvResponse = (CVResponse) o;
    return Objects.equals(this.id, cvResponse.id) &&
        Objects.equals(this.titre, cvResponse.titre) &&
        Objects.equals(this.resume, cvResponse.resume) &&
        Objects.equals(this.photo, cvResponse.photo) &&
        Objects.equals(this.linkedin, cvResponse.linkedin) &&
        Objects.equals(this.github, cvResponse.github) &&
        Objects.equals(this.portfolio, cvResponse.portfolio) &&
        Objects.equals(this.telephone, cvResponse.telephone) &&
        Objects.equals(this.email, cvResponse.email) &&
        Objects.equals(this.adresse, cvResponse.adresse) &&
        Objects.equals(this.utilisateurId, cvResponse.utilisateurId) &&
        Objects.equals(this.template, cvResponse.template) &&
        Objects.equals(this.dateCreation, cvResponse.dateCreation) &&
        Objects.equals(this.dateDerniereModification, cvResponse.dateDerniereModification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, titre, resume, photo, linkedin, github, portfolio, telephone, email, adresse, utilisateurId, template, dateCreation, dateDerniereModification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CVResponse {\n");
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

