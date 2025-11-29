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
 * StatistiquesInvitation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T11:47:11.992595600Z[Africa/Dakar]")
public class StatistiquesInvitation {

  private Integer totalEnvoyees;

  private Integer totalAcceptees;

  private Integer totalExpirees;

  private Float tauxConversion;

  public StatistiquesInvitation totalEnvoyees(Integer totalEnvoyees) {
    this.totalEnvoyees = totalEnvoyees;
    return this;
  }

  /**
   * Get totalEnvoyees
   * @return totalEnvoyees
  */
  
  @Schema(name = "totalEnvoyees", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalEnvoyees")
  public Integer getTotalEnvoyees() {
    return totalEnvoyees;
  }

  public void setTotalEnvoyees(Integer totalEnvoyees) {
    this.totalEnvoyees = totalEnvoyees;
  }

  public StatistiquesInvitation totalAcceptees(Integer totalAcceptees) {
    this.totalAcceptees = totalAcceptees;
    return this;
  }

  /**
   * Get totalAcceptees
   * @return totalAcceptees
  */
  
  @Schema(name = "totalAcceptees", example = "40", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAcceptees")
  public Integer getTotalAcceptees() {
    return totalAcceptees;
  }

  public void setTotalAcceptees(Integer totalAcceptees) {
    this.totalAcceptees = totalAcceptees;
  }

  public StatistiquesInvitation totalExpirees(Integer totalExpirees) {
    this.totalExpirees = totalExpirees;
    return this;
  }

  /**
   * Get totalExpirees
   * @return totalExpirees
  */
  
  @Schema(name = "totalExpirees", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalExpirees")
  public Integer getTotalExpirees() {
    return totalExpirees;
  }

  public void setTotalExpirees(Integer totalExpirees) {
    this.totalExpirees = totalExpirees;
  }

  public StatistiquesInvitation tauxConversion(Float tauxConversion) {
    this.tauxConversion = tauxConversion;
    return this;
  }

  /**
   * Get tauxConversion
   * @return tauxConversion
  */
  
  @Schema(name = "tauxConversion", example = "40.0", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tauxConversion")
  public Float getTauxConversion() {
    return tauxConversion;
  }

  public void setTauxConversion(Float tauxConversion) {
    this.tauxConversion = tauxConversion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatistiquesInvitation statistiquesInvitation = (StatistiquesInvitation) o;
    return Objects.equals(this.totalEnvoyees, statistiquesInvitation.totalEnvoyees) &&
        Objects.equals(this.totalAcceptees, statistiquesInvitation.totalAcceptees) &&
        Objects.equals(this.totalExpirees, statistiquesInvitation.totalExpirees) &&
        Objects.equals(this.tauxConversion, statistiquesInvitation.tauxConversion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalEnvoyees, totalAcceptees, totalExpirees, tauxConversion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatistiquesInvitation {\n");
    sb.append("    totalEnvoyees: ").append(toIndentedString(totalEnvoyees)).append("\n");
    sb.append("    totalAcceptees: ").append(toIndentedString(totalAcceptees)).append("\n");
    sb.append("    totalExpirees: ").append(toIndentedString(totalExpirees)).append("\n");
    sb.append("    tauxConversion: ").append(toIndentedString(tauxConversion)).append("\n");
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

