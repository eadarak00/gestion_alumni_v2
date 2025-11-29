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
 * IndexStatusResponseDTOStatistics
 */

@JsonTypeName("IndexStatusResponseDTO_statistics")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T08:40:07.510076584Z[Africa/Dakar]")
public class IndexStatusResponseDTOStatistics {

  private Integer totalAlumni;

  private Integer indexedAlumni;

  private Integer failedAlumni;

  public IndexStatusResponseDTOStatistics totalAlumni(Integer totalAlumni) {
    this.totalAlumni = totalAlumni;
    return this;
  }

  /**
   * Get totalAlumni
   * @return totalAlumni
  */
  
  @Schema(name = "totalAlumni", example = "1250", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAlumni")
  public Integer getTotalAlumni() {
    return totalAlumni;
  }

  public void setTotalAlumni(Integer totalAlumni) {
    this.totalAlumni = totalAlumni;
  }

  public IndexStatusResponseDTOStatistics indexedAlumni(Integer indexedAlumni) {
    this.indexedAlumni = indexedAlumni;
    return this;
  }

  /**
   * Get indexedAlumni
   * @return indexedAlumni
  */
  
  @Schema(name = "indexedAlumni", example = "1250", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("indexedAlumni")
  public Integer getIndexedAlumni() {
    return indexedAlumni;
  }

  public void setIndexedAlumni(Integer indexedAlumni) {
    this.indexedAlumni = indexedAlumni;
  }

  public IndexStatusResponseDTOStatistics failedAlumni(Integer failedAlumni) {
    this.failedAlumni = failedAlumni;
    return this;
  }

  /**
   * Get failedAlumni
   * @return failedAlumni
  */
  
  @Schema(name = "failedAlumni", example = "0", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("failedAlumni")
  public Integer getFailedAlumni() {
    return failedAlumni;
  }

  public void setFailedAlumni(Integer failedAlumni) {
    this.failedAlumni = failedAlumni;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexStatusResponseDTOStatistics indexStatusResponseDTOStatistics = (IndexStatusResponseDTOStatistics) o;
    return Objects.equals(this.totalAlumni, indexStatusResponseDTOStatistics.totalAlumni) &&
        Objects.equals(this.indexedAlumni, indexStatusResponseDTOStatistics.indexedAlumni) &&
        Objects.equals(this.failedAlumni, indexStatusResponseDTOStatistics.failedAlumni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalAlumni, indexedAlumni, failedAlumni);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexStatusResponseDTOStatistics {\n");
    sb.append("    totalAlumni: ").append(toIndentedString(totalAlumni)).append("\n");
    sb.append("    indexedAlumni: ").append(toIndentedString(indexedAlumni)).append("\n");
    sb.append("    failedAlumni: ").append(toIndentedString(failedAlumni)).append("\n");
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

