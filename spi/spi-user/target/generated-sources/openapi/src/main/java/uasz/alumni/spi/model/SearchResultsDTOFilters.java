package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SearchResultsDTOFilters
 */

@JsonTypeName("SearchResultsDTO_filters")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T08:40:07.510076584Z[Africa/Dakar]")
public class SearchResultsDTOFilters {

  private String filiere;

  private String niveau;

  private String entreprise;

  private String ville;

  public SearchResultsDTOFilters filiere(String filiere) {
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

  public SearchResultsDTOFilters niveau(String niveau) {
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

  public SearchResultsDTOFilters entreprise(String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Get entreprise
   * @return entreprise
  */
  
  @Schema(name = "entreprise", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entreprise")
  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public SearchResultsDTOFilters ville(String ville) {
    this.ville = ville;
    return this;
  }

  /**
   * Get ville
   * @return ville
  */
  
  @Schema(name = "ville", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ville")
  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchResultsDTOFilters searchResultsDTOFilters = (SearchResultsDTOFilters) o;
    return Objects.equals(this.filiere, searchResultsDTOFilters.filiere) &&
        Objects.equals(this.niveau, searchResultsDTOFilters.niveau) &&
        Objects.equals(this.entreprise, searchResultsDTOFilters.entreprise) &&
        Objects.equals(this.ville, searchResultsDTOFilters.ville);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filiere, niveau, entreprise, ville);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResultsDTOFilters {\n");
    sb.append("    filiere: ").append(toIndentedString(filiere)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    entreprise: ").append(toIndentedString(entreprise)).append("\n");
    sb.append("    ville: ").append(toIndentedString(ville)).append("\n");
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

