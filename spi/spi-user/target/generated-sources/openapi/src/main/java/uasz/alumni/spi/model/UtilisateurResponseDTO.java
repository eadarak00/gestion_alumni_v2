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
 * UtilisateurResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:07:51.481060929Z[Africa/Dakar]")
public class UtilisateurResponseDTO {

  private Long id;

  private String nom;

  private String prenom;

  private String email;

  private String telephone;

  private String username;

  private Boolean actif;

  private Boolean deleted;

  private String role;

  public UtilisateurResponseDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UtilisateurResponseDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  
  @Schema(name = "nom", example = "Diallo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public UtilisateurResponseDTO prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Get prenom
   * @return prenom
  */
  
  @Schema(name = "prenom", example = "Mamadou", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public UtilisateurResponseDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", example = "mamadou.diallo@uasz.sn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UtilisateurResponseDTO telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  
  @Schema(name = "telephone", example = "+221781234567", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public UtilisateurResponseDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", example = "mdiallo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UtilisateurResponseDTO actif(Boolean actif) {
    this.actif = actif;
    return this;
  }

  /**
   * Get actif
   * @return actif
  */
  
  @Schema(name = "actif", example = "true", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("actif")
  public Boolean getActif() {
    return actif;
  }

  public void setActif(Boolean actif) {
    this.actif = actif;
  }

  public UtilisateurResponseDTO deleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * Get deleted
   * @return deleted
  */
  
  @Schema(name = "deleted", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deleted")
  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public UtilisateurResponseDTO role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  */
  
  @Schema(name = "role", example = "ETUDIANT", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    UtilisateurResponseDTO utilisateurResponseDTO = (UtilisateurResponseDTO) o;
    return Objects.equals(this.id, utilisateurResponseDTO.id) &&
        Objects.equals(this.nom, utilisateurResponseDTO.nom) &&
        Objects.equals(this.prenom, utilisateurResponseDTO.prenom) &&
        Objects.equals(this.email, utilisateurResponseDTO.email) &&
        Objects.equals(this.telephone, utilisateurResponseDTO.telephone) &&
        Objects.equals(this.username, utilisateurResponseDTO.username) &&
        Objects.equals(this.actif, utilisateurResponseDTO.actif) &&
        Objects.equals(this.deleted, utilisateurResponseDTO.deleted) &&
        Objects.equals(this.role, utilisateurResponseDTO.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, email, telephone, username, actif, deleted, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UtilisateurResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    actif: ").append(toIndentedString(actif)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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

