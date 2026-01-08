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
 * TelechargementsDemandePostRequest
 */

@JsonTypeName("_telechargements_demande_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T09:52:58.745245500Z[Etc/UTC]")
public class TelechargementsDemandePostRequest {

  private Integer cvId;

  private Integer demandeurId;

  private String message;

  public TelechargementsDemandePostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TelechargementsDemandePostRequest(Integer cvId, Integer demandeurId) {
    this.cvId = cvId;
    this.demandeurId = demandeurId;
  }

  public TelechargementsDemandePostRequest cvId(Integer cvId) {
    this.cvId = cvId;
    return this;
  }

  /**
   * Get cvId
   * @return cvId
  */
  @NotNull 
  @Schema(name = "cvId", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cvId")
  public Integer getCvId() {
    return cvId;
  }

  public void setCvId(Integer cvId) {
    this.cvId = cvId;
  }

  public TelechargementsDemandePostRequest demandeurId(Integer demandeurId) {
    this.demandeurId = demandeurId;
    return this;
  }

  /**
   * Get demandeurId
   * @return demandeurId
  */
  @NotNull 
  @Schema(name = "demandeurId", example = "22", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("demandeurId")
  public Integer getDemandeurId() {
    return demandeurId;
  }

  public void setDemandeurId(Integer demandeurId) {
    this.demandeurId = demandeurId;
  }

  public TelechargementsDemandePostRequest message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", example = "Je souhaiterais télécharger ce CV pour un partenariat.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelechargementsDemandePostRequest telechargementsDemandePostRequest = (TelechargementsDemandePostRequest) o;
    return Objects.equals(this.cvId, telechargementsDemandePostRequest.cvId) &&
        Objects.equals(this.demandeurId, telechargementsDemandePostRequest.demandeurId) &&
        Objects.equals(this.message, telechargementsDemandePostRequest.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, demandeurId, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelechargementsDemandePostRequest {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    demandeurId: ").append(toIndentedString(demandeurId)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

