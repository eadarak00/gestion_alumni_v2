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
 * AlumniResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-05T21:01:52.688704211Z[Africa/Dakar]")
public class AlumniResponseDTO {

  private Long id;

  private String nom;

  private String prenom;

  private String email;

  private String username;

  private String telephone;

  private String profession;

  private String entreprise;

  private Boolean actif;

  private String role;

  private Boolean deleted;

  public AlumniResponseDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identifiant unique
   * @return id
  */
  
  @Schema(name = "id", example = "124", description = "Identifiant unique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AlumniResponseDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  
  @Schema(name = "nom", example = "Sow", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public AlumniResponseDTO prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Get prenom
   * @return prenom
  */
  
  @Schema(name = "prenom", example = "Aïssatou", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public AlumniResponseDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", example = "aissatou.sow@alumni.uasz.sn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AlumniResponseDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", example = "asow", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AlumniResponseDTO telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  
  @Schema(name = "telephone", example = "+221781234568", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public AlumniResponseDTO profession(String profession) {
    this.profession = profession;
    return this;
  }

  /**
   * Get profession
   * @return profession
  */
  
  @Schema(name = "profession", example = "Data Scientist", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profession")
  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public AlumniResponseDTO entreprise(String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Get entreprise
   * @return entreprise
  */
  
  @Schema(name = "entreprise", example = "Sonatel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entreprise")
  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public AlumniResponseDTO actif(Boolean actif) {
    this.actif = actif;
    return this;
  }

  /**
   * Indique si le compte est actif
   * @return actif
  */
  
  @Schema(name = "actif", example = "true", description = "Indique si le compte est actif", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("actif")
  public Boolean getActif() {
    return actif;
  }

  public void setActif(Boolean actif) {
    this.actif = actif;
  }

  public AlumniResponseDTO role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Rôle de l'utilisateur
   * @return role
  */
  
  @Schema(name = "role", example = "ALUMNI", description = "Rôle de l'utilisateur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public AlumniResponseDTO deleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * Indique si le compte est supprimé
   * @return deleted
  */
  
  @Schema(name = "deleted", example = "false", description = "Indique si le compte est supprimé", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deleted")
  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlumniResponseDTO alumniResponseDTO = (AlumniResponseDTO) o;
    return Objects.equals(this.id, alumniResponseDTO.id) &&
        Objects.equals(this.nom, alumniResponseDTO.nom) &&
        Objects.equals(this.prenom, alumniResponseDTO.prenom) &&
        Objects.equals(this.email, alumniResponseDTO.email) &&
        Objects.equals(this.username, alumniResponseDTO.username) &&
        Objects.equals(this.telephone, alumniResponseDTO.telephone) &&
        Objects.equals(this.profession, alumniResponseDTO.profession) &&
        Objects.equals(this.entreprise, alumniResponseDTO.entreprise) &&
        Objects.equals(this.actif, alumniResponseDTO.actif) &&
        Objects.equals(this.role, alumniResponseDTO.role) &&
        Objects.equals(this.deleted, alumniResponseDTO.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, email, username, telephone, profession, entreprise, actif, role, deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlumniResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    profession: ").append(toIndentedString(profession)).append("\n");
    sb.append("    entreprise: ").append(toIndentedString(entreprise)).append("\n");
    sb.append("    actif: ").append(toIndentedString(actif)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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

