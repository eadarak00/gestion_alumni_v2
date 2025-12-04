package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CVCreate
 */

<<<<<<< HEAD
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T23:32:01.179463330Z[Africa/Dakar]")
=======
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T22:57:24.563704091Z[Africa/Dakar]")
>>>>>>> b68b570 (init ms-cv)
public class CVCreate {

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

  private TemplateUtiliseEnum templateUtilise = TemplateUtiliseEnum.MODERNE;

  public CVCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CVCreate(Integer utilisateurId, String titre, String telephone, String email) {
    this.utilisateurId = utilisateurId;
    this.titre = titre;
    this.telephone = telephone;
    this.email = email;
  }

  public CVCreate utilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
    return this;
  }

  /**
   * Get utilisateurId
   * @return utilisateurId
  */
  @NotNull 
  @Schema(name = "utilisateurId", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("utilisateurId")
  public Integer getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public CVCreate titre(String titre) {
    this.titre = titre;
    return this;
  }

  /**
   * Get titre
   * @return titre
  */
  @NotNull 
  @Schema(name = "titre", example = "Ingénieur Full Stack", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("titre")
  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public CVCreate resume(String resume) {
    this.resume = resume;
    return this;
  }

  /**
   * Get resume
   * @return resume
  */
  
  @Schema(name = "resume", example = "Développeur passionné...", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resume")
  public String getResume() {
    return resume;
  }

  public void setResume(String resume) {
    this.resume = resume;
  }

  public CVCreate photo(String photo) {
    this.photo = photo;
    return this;
  }

  /**
   * URL de la photo
   * @return photo
  */
  
  @Schema(name = "photo", description = "URL de la photo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("photo")
  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public CVCreate linkedin(String linkedin) {
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

  public CVCreate github(String github) {
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

  public CVCreate portfolio(String portfolio) {
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

  public CVCreate telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  @NotNull 
  @Schema(name = "telephone", example = "+221 77 123 45 67", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public CVCreate email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull 
  @Schema(name = "email", example = "john.doe@uasz.sn", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CVCreate adresse(String adresse) {
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

  public CVCreate templateUtilise(TemplateUtiliseEnum templateUtilise) {
    this.templateUtilise = templateUtilise;
    return this;
  }

  /**
   * Get templateUtilise
   * @return templateUtilise
  */
  
  @Schema(name = "templateUtilise", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("templateUtilise")
  public TemplateUtiliseEnum getTemplateUtilise() {
    return templateUtilise;
  }

  public void setTemplateUtilise(TemplateUtiliseEnum templateUtilise) {
    this.templateUtilise = templateUtilise;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CVCreate cvCreate = (CVCreate) o;
    return Objects.equals(this.utilisateurId, cvCreate.utilisateurId) &&
        Objects.equals(this.titre, cvCreate.titre) &&
        Objects.equals(this.resume, cvCreate.resume) &&
        Objects.equals(this.photo, cvCreate.photo) &&
        Objects.equals(this.linkedin, cvCreate.linkedin) &&
        Objects.equals(this.github, cvCreate.github) &&
        Objects.equals(this.portfolio, cvCreate.portfolio) &&
        Objects.equals(this.telephone, cvCreate.telephone) &&
        Objects.equals(this.email, cvCreate.email) &&
        Objects.equals(this.adresse, cvCreate.adresse) &&
        Objects.equals(this.templateUtilise, cvCreate.templateUtilise);
  }

  @Override
  public int hashCode() {
    return Objects.hash(utilisateurId, titre, resume, photo, linkedin, github, portfolio, telephone, email, adresse, templateUtilise);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CVCreate {\n");
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
    sb.append("    templateUtilise: ").append(toIndentedString(templateUtilise)).append("\n");
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

