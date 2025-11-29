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
 * AlumniSearchResultDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T08:40:07.510076584Z[Africa/Dakar]")
public class AlumniSearchResultDTO {

  private Integer id;

  private String nom;

  private String prenom;

  private String email;

  private String filiere;

  private String niveau;

  private Integer anneeDiplome;

  private String entreprise;

  private String poste;

  private String ville;

  private Float score;

  public AlumniSearchResultDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AlumniSearchResultDTO nom(String nom) {
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

  public AlumniSearchResultDTO prenom(String prenom) {
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

  public AlumniSearchResultDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", example = "mamadou.diallo@example.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AlumniSearchResultDTO filiere(String filiere) {
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

  public AlumniSearchResultDTO niveau(String niveau) {
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

  public AlumniSearchResultDTO anneeDiplome(Integer anneeDiplome) {
    this.anneeDiplome = anneeDiplome;
    return this;
  }

  /**
   * Get anneeDiplome
   * @return anneeDiplome
  */
  
  @Schema(name = "anneeDiplome", example = "2020", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anneeDiplome")
  public Integer getAnneeDiplome() {
    return anneeDiplome;
  }

  public void setAnneeDiplome(Integer anneeDiplome) {
    this.anneeDiplome = anneeDiplome;
  }

  public AlumniSearchResultDTO entreprise(String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Get entreprise
   * @return entreprise
  */
  
  @Schema(name = "entreprise", example = "Orange Sénégal", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entreprise")
  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public AlumniSearchResultDTO poste(String poste) {
    this.poste = poste;
    return this;
  }

  /**
   * Get poste
   * @return poste
  */
  
  @Schema(name = "poste", example = "Développeur Senior", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("poste")
  public String getPoste() {
    return poste;
  }

  public void setPoste(String poste) {
    this.poste = poste;
  }

  public AlumniSearchResultDTO ville(String ville) {
    this.ville = ville;
    return this;
  }

  /**
   * Get ville
   * @return ville
  */
  
  @Schema(name = "ville", example = "Dakar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ville")
  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public AlumniSearchResultDTO score(Float score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  */
  
  @Schema(name = "score", example = "0.92", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("score")
  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlumniSearchResultDTO alumniSearchResultDTO = (AlumniSearchResultDTO) o;
    return Objects.equals(this.id, alumniSearchResultDTO.id) &&
        Objects.equals(this.nom, alumniSearchResultDTO.nom) &&
        Objects.equals(this.prenom, alumniSearchResultDTO.prenom) &&
        Objects.equals(this.email, alumniSearchResultDTO.email) &&
        Objects.equals(this.filiere, alumniSearchResultDTO.filiere) &&
        Objects.equals(this.niveau, alumniSearchResultDTO.niveau) &&
        Objects.equals(this.anneeDiplome, alumniSearchResultDTO.anneeDiplome) &&
        Objects.equals(this.entreprise, alumniSearchResultDTO.entreprise) &&
        Objects.equals(this.poste, alumniSearchResultDTO.poste) &&
        Objects.equals(this.ville, alumniSearchResultDTO.ville) &&
        Objects.equals(this.score, alumniSearchResultDTO.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, email, filiere, niveau, anneeDiplome, entreprise, poste, ville, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlumniSearchResultDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    filiere: ").append(toIndentedString(filiere)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    anneeDiplome: ").append(toIndentedString(anneeDiplome)).append("\n");
    sb.append("    entreprise: ").append(toIndentedString(entreprise)).append("\n");
    sb.append("    poste: ").append(toIndentedString(poste)).append("\n");
    sb.append("    ville: ").append(toIndentedString(ville)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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

