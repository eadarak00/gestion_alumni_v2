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
 * UtilisateurRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-08T16:20:02.280897137Z[Africa/Dakar]")
public class UtilisateurRequestDTO {

  private String nom;

  private String prenom;

  private String email;

  private String username;

  private String motDePasse;

  private String telephone;

  private String role;

  public UtilisateurRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UtilisateurRequestDTO(String nom, String prenom, String email, String username, String motDePasse, String telephone, String role) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.username = username;
    this.motDePasse = motDePasse;
    this.telephone = telephone;
    this.role = role;
  }

  public UtilisateurRequestDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Nom de famille
   * @return nom
  */
  @NotNull 
  @Schema(name = "nom", example = "Diallo", description = "Nom de famille", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public UtilisateurRequestDTO prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Prénom
   * @return prenom
  */
  @NotNull 
  @Schema(name = "prenom", example = "Mamadou", description = "Prénom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public UtilisateurRequestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Adresse email
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "mamadou.diallo@uasz.sn", description = "Adresse email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UtilisateurRequestDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Nom d'utilisateur
   * @return username
  */
  @NotNull 
  @Schema(name = "username", example = "mdiallo", description = "Nom d'utilisateur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UtilisateurRequestDTO motDePasse(String motDePasse) {
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

  public UtilisateurRequestDTO telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Numéro de téléphone (format Sénégal)
   * @return telephone
  */
  @NotNull @Pattern(regexp = "^(\\+221|00221)?7[015678]\\d{7}$") 
  @Schema(name = "telephone", example = "+221781234567", description = "Numéro de téléphone (format Sénégal)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public UtilisateurRequestDTO role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Rôle de l'utilisateur
   * @return role
  */
  @NotNull 
  @Schema(name = "role", example = "ETUDIANT", description = "Rôle de l'utilisateur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UtilisateurRequestDTO utilisateurRequestDTO = (UtilisateurRequestDTO) o;
    return Objects.equals(this.nom, utilisateurRequestDTO.nom) &&
        Objects.equals(this.prenom, utilisateurRequestDTO.prenom) &&
        Objects.equals(this.email, utilisateurRequestDTO.email) &&
        Objects.equals(this.username, utilisateurRequestDTO.username) &&
        Objects.equals(this.motDePasse, utilisateurRequestDTO.motDePasse) &&
        Objects.equals(this.telephone, utilisateurRequestDTO.telephone) &&
        Objects.equals(this.role, utilisateurRequestDTO.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom, prenom, email, username, motDePasse, telephone, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtilisateurRequestDTO {\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    motDePasse: ").append("*").append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

