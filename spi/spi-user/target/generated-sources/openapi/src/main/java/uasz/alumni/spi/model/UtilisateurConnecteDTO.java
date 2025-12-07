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
 * Informations détaillées de l&#39;utilisateur connecté
 */

@Schema(name = "UtilisateurConnecteDTO", description = "Informations détaillées de l'utilisateur connecté")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:07:51.481060929Z[Africa/Dakar]")
public class UtilisateurConnecteDTO {

  private Long id;

  private String nom;

  private String prenom;

  private String email;

  private String username;

  /**
   * Rôle de l'utilisateur dans le système
   */
  public enum RoleEnum {
    ADMIN("ADMIN"),
    
    ALUMNI("ALUMNI"),
    
    ETUDIANT("ETUDIANT");

    private String value;

    RoleEnum(String value) {
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
    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private RoleEnum role;

  private Boolean actif;

  public UtilisateurConnecteDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identifiant unique de l'utilisateur
   * @return id
  */
  
  @Schema(name = "id", example = "123", description = "Identifiant unique de l'utilisateur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UtilisateurConnecteDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Nom de famille de l'utilisateur
   * @return nom
  */
  
  @Schema(name = "nom", example = "Diallo", description = "Nom de famille de l'utilisateur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public UtilisateurConnecteDTO prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Prénom de l'utilisateur
   * @return prenom
  */
  
  @Schema(name = "prenom", example = "Mamadou", description = "Prénom de l'utilisateur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public UtilisateurConnecteDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Adresse email de l'utilisateur
   * @return email
  */
  @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "mamadou.diallo@uasz.sn", description = "Adresse email de l'utilisateur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UtilisateurConnecteDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Nom d'utilisateur unique
   * @return username
  */
  
  @Schema(name = "username", example = "mdiallo", description = "Nom d'utilisateur unique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UtilisateurConnecteDTO role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Rôle de l'utilisateur dans le système
   * @return role
  */
  
  @Schema(name = "role", example = "ETUDIANT", description = "Rôle de l'utilisateur dans le système", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public UtilisateurConnecteDTO actif(Boolean actif) {
    this.actif = actif;
    return this;
  }

  /**
   * Indique si le compte utilisateur est actif
   * @return actif
  */
  
  @Schema(name = "actif", example = "true", description = "Indique si le compte utilisateur est actif", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("actif")
  public Boolean getActif() {
    return actif;
  }

  public void setActif(Boolean actif) {
    this.actif = actif;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UtilisateurConnecteDTO utilisateurConnecteDTO = (UtilisateurConnecteDTO) o;
    return Objects.equals(this.id, utilisateurConnecteDTO.id) &&
        Objects.equals(this.nom, utilisateurConnecteDTO.nom) &&
        Objects.equals(this.prenom, utilisateurConnecteDTO.prenom) &&
        Objects.equals(this.email, utilisateurConnecteDTO.email) &&
        Objects.equals(this.username, utilisateurConnecteDTO.username) &&
        Objects.equals(this.role, utilisateurConnecteDTO.role) &&
        Objects.equals(this.actif, utilisateurConnecteDTO.actif);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, email, username, role, actif);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtilisateurConnecteDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    actif: ").append(toIndentedString(actif)).append("\n");
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

