package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AlumniRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T15:59:08.700783195Z[Africa/Dakar]")
public class AlumniRequestDTO {

  private String nom;

  private String prenom;

  private String email;

  private String username;

  private String motDePasse;

  private String telephone;

  private String profession;

  private String entreprise;

  public AlumniRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AlumniRequestDTO(String nom, String prenom, String email, String motDePasse, String telephone) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.motDePasse = motDePasse;
    this.telephone = telephone;
  }

  public AlumniRequestDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Nom de famille
   * @return nom
  */
  @NotNull 
  @Schema(name = "nom", example = "Sow", description = "Nom de famille", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public AlumniRequestDTO prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Prénom
   * @return prenom
  */
  @NotNull 
  @Schema(name = "prenom", example = "Aïssatou", description = "Prénom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public AlumniRequestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Adresse email
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "aissatou.sow@alumni.uasz.sn", description = "Adresse email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AlumniRequestDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Nom d'utilisateur (optionnel)
   * @return username
  */
  
  @Schema(name = "username", example = "asow", description = "Nom d'utilisateur (optionnel)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AlumniRequestDTO motDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
    return this;
  }

  /**
   * Mot de passe
   * @return motDePasse
  */
  @NotNull 
  @Schema(name = "motDePasse", example = "MotDePasse123!", description = "Mot de passe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("motDePasse")
  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public AlumniRequestDTO telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Numéro de téléphone (format Sénégal)
   * @return telephone
  */
  @NotNull @Pattern(regexp = "^(\\+221|00221)?7[015678]\\d{7}$") 
  @Schema(name = "telephone", example = "+221781234568", description = "Numéro de téléphone (format Sénégal)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public AlumniRequestDTO profession(String profession) {
    this.profession = profession;
    return this;
  }

  /**
   * Profession actuelle
   * @return profession
  */
  
  @Schema(name = "profession", example = "Data Scientist", description = "Profession actuelle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profession")
  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public AlumniRequestDTO entreprise(String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Entreprise actuelle
   * @return entreprise
  */
  
  @Schema(name = "entreprise", example = "Sonatel", description = "Entreprise actuelle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entreprise")
  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlumniRequestDTO alumniRequestDTO = (AlumniRequestDTO) o;
    return Objects.equals(this.nom, alumniRequestDTO.nom) &&
        Objects.equals(this.prenom, alumniRequestDTO.prenom) &&
        Objects.equals(this.email, alumniRequestDTO.email) &&
        Objects.equals(this.username, alumniRequestDTO.username) &&
        Objects.equals(this.motDePasse, alumniRequestDTO.motDePasse) &&
        Objects.equals(this.telephone, alumniRequestDTO.telephone) &&
        Objects.equals(this.profession, alumniRequestDTO.profession) &&
        Objects.equals(this.entreprise, alumniRequestDTO.entreprise);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom, prenom, email, username, motDePasse, telephone, profession, entreprise);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlumniRequestDTO {\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    motDePasse: ").append("*").append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    profession: ").append(toIndentedString(profession)).append("\n");
    sb.append("    entreprise: ").append(toIndentedString(entreprise)).append("\n");
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

