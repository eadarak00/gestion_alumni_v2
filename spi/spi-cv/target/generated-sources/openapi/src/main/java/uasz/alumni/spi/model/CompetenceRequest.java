package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import uasz.alumni.spi.model.CategorieCompetence;
import uasz.alumni.spi.model.NiveauCompetence;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CompetenceRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-14T00:56:32.665681389Z[Africa/Dakar]")
public class CompetenceRequest {

  private Integer cvId;

  private String nom;

  private NiveauCompetence niveau;

  private CategorieCompetence categorie;

  public CompetenceRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CompetenceRequest(Integer cvId, String nom, NiveauCompetence niveau) {
    this.cvId = cvId;
    this.nom = nom;
    this.niveau = niveau;
  }

  public CompetenceRequest cvId(Integer cvId) {
    this.cvId = cvId;
    return this;
  }

  /**
   * Get cvId
   * @return cvId
  */
  @NotNull 
  @Schema(name = "cvId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cvId")
  public Integer getCvId() {
    return cvId;
  }

  public void setCvId(Integer cvId) {
    this.cvId = cvId;
  }

  public CompetenceRequest nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  @NotNull @Size(min = 2, max = 100) 
  @Schema(name = "nom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public CompetenceRequest niveau(NiveauCompetence niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  @NotNull @Valid 
  @Schema(name = "niveau", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("niveau")
  public NiveauCompetence getNiveau() {
    return niveau;
  }

  public void setNiveau(NiveauCompetence niveau) {
    this.niveau = niveau;
  }

  public CompetenceRequest categorie(CategorieCompetence categorie) {
    this.categorie = categorie;
    return this;
  }

  /**
   * Get categorie
   * @return categorie
  */
  @Valid 
  @Schema(name = "categorie", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categorie")
  public CategorieCompetence getCategorie() {
    return categorie;
  }

  public void setCategorie(CategorieCompetence categorie) {
    this.categorie = categorie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompetenceRequest competenceRequest = (CompetenceRequest) o;
    return Objects.equals(this.cvId, competenceRequest.cvId) &&
        Objects.equals(this.nom, competenceRequest.nom) &&
        Objects.equals(this.niveau, competenceRequest.niveau) &&
        Objects.equals(this.categorie, competenceRequest.categorie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, nom, niveau, categorie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompetenceRequest {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    categorie: ").append(toIndentedString(categorie)).append("\n");
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

