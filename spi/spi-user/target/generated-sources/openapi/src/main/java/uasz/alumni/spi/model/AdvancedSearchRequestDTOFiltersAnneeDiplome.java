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
 * AdvancedSearchRequestDTOFiltersAnneeDiplome
 */

@JsonTypeName("AdvancedSearchRequestDTO_filters_anneeDiplome")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-05T18:32:33.604147700Z[Atlantic/Reykjavik]")
public class AdvancedSearchRequestDTOFiltersAnneeDiplome {

  private Integer min;

  private Integer max;

  public AdvancedSearchRequestDTOFiltersAnneeDiplome min(Integer min) {
    this.min = min;
    return this;
  }

  /**
   * Get min
   * @return min
  */
  
  @Schema(name = "min", example = "2018", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("min")
  public Integer getMin() {
    return min;
  }

  public void setMin(Integer min) {
    this.min = min;
  }

  public AdvancedSearchRequestDTOFiltersAnneeDiplome max(Integer max) {
    this.max = max;
    return this;
  }

  /**
   * Get max
   * @return max
  */
  
  @Schema(name = "max", example = "2023", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max")
  public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvancedSearchRequestDTOFiltersAnneeDiplome advancedSearchRequestDTOFiltersAnneeDiplome = (AdvancedSearchRequestDTOFiltersAnneeDiplome) o;
    return Objects.equals(this.min, advancedSearchRequestDTOFiltersAnneeDiplome.min) &&
        Objects.equals(this.max, advancedSearchRequestDTOFiltersAnneeDiplome.max);
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvancedSearchRequestDTOFiltersAnneeDiplome {\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
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

