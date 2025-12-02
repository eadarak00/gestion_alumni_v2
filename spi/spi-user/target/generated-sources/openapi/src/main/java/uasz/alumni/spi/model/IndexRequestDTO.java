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
 * IndexRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:07:51.481060929Z[Africa/Dakar]")
public class IndexRequestDTO {

  private Boolean forceReindex;

  private Integer batchSize;

  public IndexRequestDTO forceReindex(Boolean forceReindex) {
    this.forceReindex = forceReindex;
    return this;
  }

  /**
   * Get forceReindex
   * @return forceReindex
  */
  
  @Schema(name = "forceReindex", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("forceReindex")
  public Boolean getForceReindex() {
    return forceReindex;
  }

  public void setForceReindex(Boolean forceReindex) {
    this.forceReindex = forceReindex;
  }

  public IndexRequestDTO batchSize(Integer batchSize) {
    this.batchSize = batchSize;
    return this;
  }

  /**
   * Get batchSize
   * @return batchSize
  */
  
  @Schema(name = "batchSize", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("batchSize")
  public Integer getBatchSize() {
    return batchSize;
  }

  public void setBatchSize(Integer batchSize) {
    this.batchSize = batchSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexRequestDTO indexRequestDTO = (IndexRequestDTO) o;
    return Objects.equals(this.forceReindex, indexRequestDTO.forceReindex) &&
        Objects.equals(this.batchSize, indexRequestDTO.batchSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forceReindex, batchSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexRequestDTO {\n");
    sb.append("    forceReindex: ").append(toIndentedString(forceReindex)).append("\n");
    sb.append("    batchSize: ").append(toIndentedString(batchSize)).append("\n");
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

