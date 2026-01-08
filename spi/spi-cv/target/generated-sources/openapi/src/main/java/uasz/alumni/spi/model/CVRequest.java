package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import uasz.alumni.spi.model.TypeTemplate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CVRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T22:53:42.108661056Z[Africa/Dakar]")
public class CVRequest {

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

  public CVRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CVRequest(String titre, String telephone, String email, Integer utilisateurId) {
    this.titre = titre;
    this.telephone = telephone;
    this.email = email;
    this.utilisateurId = utilisateurId;
  }

  public CVRequest titre(String titre) {
    this.titre = titre;
    return this;
  }

  /**
   * Get titre
   * @return titre
  */
  @NotNull @Size(min = 3, max = 100) 
  @Schema(name = "titre", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("titre")
  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public CVRequest resume(String resume) {
    this.resume = resume;
    return this;
  }

  /**
   * Get resume
   * @return resume
  */
  @Size(max = 2000) 
  @Schema(name = "resume", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resume")
  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  public CVRequest photo(String photo) {
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

  public CVRequest linkedin(String linkedin) {
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

  public CVRequest github(String github) {
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

  public CVRequest portfolio(String portfolio) {
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

  public CVRequest telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  @NotNull 
  @Schema(name = "telephone", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public CVRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull @Size(max = 100) @jakarta.validation.constraints.Email 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CVRequest adresse(String adresse) {
    this.adresse = adresse;
    return this;
  }

  /**
   * Get adresse
   * @return adresse
  */
  @Size(max = 200) 
  @Schema(name = "adresse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("adresse")
  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public CVRequest utilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
    return this;
  }

  /**
   * Get utilisateurId
   * @return utilisateurId
  */
  @NotNull 
  @Schema(name = "utilisateurId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("utilisateurId")
  public Integer getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public CVRequest template(TypeTemplate template) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CVRequest cvRequest = (CVRequest) o;
    return Objects.equals(this.titre, cvRequest.titre) &&
        Objects.equals(this.resume, cvRequest.resume) &&
        Objects.equals(this.photo, cvRequest.photo) &&
        Objects.equals(this.linkedin, cvRequest.linkedin) &&
        Objects.equals(this.github, cvRequest.github) &&
        Objects.equals(this.portfolio, cvRequest.portfolio) &&
        Objects.equals(this.telephone, cvRequest.telephone) &&
        Objects.equals(this.email, cvRequest.email) &&
        Objects.equals(this.adresse, cvRequest.adresse) &&
        Objects.equals(this.utilisateurId, cvRequest.utilisateurId) &&
        Objects.equals(this.template, cvRequest.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(titre, resume, photo, linkedin, github, portfolio, telephone, email, adresse, utilisateurId, template);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CVRequest {\n");
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

