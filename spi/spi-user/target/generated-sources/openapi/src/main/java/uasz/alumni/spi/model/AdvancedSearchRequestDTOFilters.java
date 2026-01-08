package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uasz.alumni.spi.model.AdvancedSearchRequestDTOFiltersAnneeDiplome;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdvancedSearchRequestDTOFilters
 */

@JsonTypeName("AdvancedSearchRequestDTO_filters")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T09:53:11.934279900Z[Etc/UTC]")
public class AdvancedSearchRequestDTOFilters {

  @Valid
  private List<String> filiere;

  @Valid
  private List<String> niveau;

  private AdvancedSearchRequestDTOFiltersAnneeDiplome anneeDiplome;

  public AdvancedSearchRequestDTOFilters filiere(List<String> filiere) {
    this.filiere = filiere;
    return this;
  }

  public AdvancedSearchRequestDTOFilters addFiliereItem(String filiereItem) {
    if (this.filiere == null) {
      this.filiere = new ArrayList<>();
    }
    this.filiere.add(filiereItem);
    return this;
  }

  /**
   * Get filiere
   * @return filiere
  */
  
  @Schema(name = "filiere", example = "[\"Informatique\",\"Mathématiques\"]", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filiere")
  public List<String> getFiliere() {
    return filiere;
  }

  public void setFiliere(List<String> filiere) {
    this.filiere = filiere;
  }

  public AdvancedSearchRequestDTOFilters niveau(List<String> niveau) {
    this.niveau = niveau;
    return this;
  }

  public AdvancedSearchRequestDTOFilters addNiveauItem(String niveauItem) {
    if (this.niveau == null) {
      this.niveau = new ArrayList<>();
    }
    this.niveau.add(niveauItem);
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  
  @Schema(name = "niveau", example = "[\"MASTER\"]", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("niveau")
  public List<String> getNiveau() {
    return niveau;
  }

  public void setNiveau(List<String> niveau) {
    this.niveau = niveau;
  }

  public AdvancedSearchRequestDTOFilters anneeDiplome(AdvancedSearchRequestDTOFiltersAnneeDiplome anneeDiplome) {
    this.anneeDiplome = anneeDiplome;
    return this;
  }

  /**
   * Get anneeDiplome
   * @return anneeDiplome
  */
  @Valid 
  @Schema(name = "anneeDiplome", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anneeDiplome")
  public AdvancedSearchRequestDTOFiltersAnneeDiplome getAnneeDiplome() {
    return anneeDiplome;
  }

  public void setAnneeDiplome(AdvancedSearchRequestDTOFiltersAnneeDiplome anneeDiplome) {
    this.anneeDiplome = anneeDiplome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvancedSearchRequestDTOFilters advancedSearchRequestDTOFilters = (AdvancedSearchRequestDTOFilters) o;
    return Objects.equals(this.filiere, advancedSearchRequestDTOFilters.filiere) &&
        Objects.equals(this.niveau, advancedSearchRequestDTOFilters.niveau) &&
        Objects.equals(this.anneeDiplome, advancedSearchRequestDTOFilters.anneeDiplome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filiere, niveau, anneeDiplome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvancedSearchRequestDTOFilters {\n");
    sb.append("    filiere: ").append(toIndentedString(filiere)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    anneeDiplome: ").append(toIndentedString(anneeDiplome)).append("\n");
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

