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
 * EtudiantResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-10T22:49:28.367020818Z[Africa/Dakar]")
public class EtudiantResponseDTO {

  private Long id;

  private String nom;

  private String prenom;

  private String email;

  private String username;

  private String telephone;

  private String numeroCarteEtudiant;

  private String niveau;

  private String filiere;

  private Boolean actif;

  private String role;

  private Boolean deleted;

  public EtudiantResponseDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identifiant unique
   * @return id
  */
  
  @Schema(name = "id", example = "123", description = "Identifiant unique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EtudiantResponseDTO nom(String nom) {
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

  public EtudiantResponseDTO prenom(String prenom) {
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

  public EtudiantResponseDTO email(String email) {
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

  public EtudiantResponseDTO username(String username) {
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

  public EtudiantResponseDTO telephone(String telephone) {
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

  public EtudiantResponseDTO numeroCarteEtudiant(String numeroCarteEtudiant) {
    this.numeroCarteEtudiant = numeroCarteEtudiant;
    return this;
  }

  /**
   * Get numeroCarteEtudiant
   * @return numeroCarteEtudiant
  */
  
  @Schema(name = "numeroCarteEtudiant", example = "ETU123456", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numeroCarteEtudiant")
  public String getNumeroCarteEtudiant() {
    return numeroCarteEtudiant;
  }

  public void setNumeroCarteEtudiant(String numeroCarteEtudiant) {
    this.numeroCarteEtudiant = numeroCarteEtudiant;
  }

  public EtudiantResponseDTO niveau(String niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  
  @Schema(name = "niveau", example = "MASTER", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("niveau")
  public String getNiveau() {
    return niveau;
  }

  public void setNiveau(String niveau) {
    this.niveau = niveau;
  }

  public EtudiantResponseDTO filiere(String filiere) {
    this.filiere = filiere;
    return this;
  }

  /**
   * Get filiere
   * @return filiere
  */
  
  @Schema(name = "filiere", example = "Informatique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filiere")
  public String getFiliere() {
    return filiere;
  }

  public void setFiliere(String filiere) {
    this.filiere = filiere;
  }

  public EtudiantResponseDTO actif(Boolean actif) {
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

  public EtudiantResponseDTO role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Rôle de l'utilisateur
   * @return role
  */
  
  @Schema(name = "role", example = "ETUDIANT", description = "Rôle de l'utilisateur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public EtudiantResponseDTO deleted(Boolean deleted) {
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
    EtudiantResponseDTO etudiantResponseDTO = (EtudiantResponseDTO) o;
    return Objects.equals(this.id, etudiantResponseDTO.id) &&
        Objects.equals(this.nom, etudiantResponseDTO.nom) &&
        Objects.equals(this.prenom, etudiantResponseDTO.prenom) &&
        Objects.equals(this.email, etudiantResponseDTO.email) &&
        Objects.equals(this.username, etudiantResponseDTO.username) &&
        Objects.equals(this.telephone, etudiantResponseDTO.telephone) &&
        Objects.equals(this.numeroCarteEtudiant, etudiantResponseDTO.numeroCarteEtudiant) &&
        Objects.equals(this.niveau, etudiantResponseDTO.niveau) &&
        Objects.equals(this.filiere, etudiantResponseDTO.filiere) &&
        Objects.equals(this.actif, etudiantResponseDTO.actif) &&
        Objects.equals(this.role, etudiantResponseDTO.role) &&
        Objects.equals(this.deleted, etudiantResponseDTO.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, email, username, telephone, numeroCarteEtudiant, niveau, filiere, actif, role, deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EtudiantResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    numeroCarteEtudiant: ").append(toIndentedString(numeroCarteEtudiant)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    filiere: ").append(toIndentedString(filiere)).append("\n");
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

