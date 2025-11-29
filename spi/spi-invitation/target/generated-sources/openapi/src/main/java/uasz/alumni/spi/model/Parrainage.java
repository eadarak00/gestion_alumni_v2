package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Parrainage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T11:47:11.992595600Z[Africa/Dakar]")
public class Parrainage {

  private Integer id;

  private Integer parrainId;

  private Integer filleulId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  public Parrainage id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "22", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Parrainage parrainId(Integer parrainId) {
    this.parrainId = parrainId;
    return this;
  }

  /**
   * Get parrainId
   * @return parrainId
  */
  
  @Schema(name = "parrainId", example = "5", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parrainId")
  public Integer getParrainId() {
    return parrainId;
  }

  public void setParrainId(Integer parrainId) {
    this.parrainId = parrainId;
  }

  public Parrainage filleulId(Integer filleulId) {
    this.filleulId = filleulId;
    return this;
  }

  /**
   * Get filleulId
   * @return filleulId
  */
  
  @Schema(name = "filleulId", example = "18", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filleulId")
  public Integer getFilleulId() {
    return filleulId;
  }

  public void setFilleulId(Integer filleulId) {
    this.filleulId = filleulId;
  }

  public Parrainage dateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
    return this;
  }

  /**
   * Get dateCreation
   * @return dateCreation
  */
  @Valid 
  @Schema(name = "dateCreation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateCreation")
  public OffsetDateTime getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Parrainage parrainage = (Parrainage) o;
    return Objects.equals(this.id, parrainage.id) &&
        Objects.equals(this.parrainId, parrainage.parrainId) &&
        Objects.equals(this.filleulId, parrainage.filleulId) &&
        Objects.equals(this.dateCreation, parrainage.dateCreation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parrainId, filleulId, dateCreation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Parrainage {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parrainId: ").append(toIndentedString(parrainId)).append("\n");
    sb.append("    filleulId: ").append(toIndentedString(filleulId)).append("\n");
    sb.append("    dateCreation: ").append(toIndentedString(dateCreation)).append("\n");
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

