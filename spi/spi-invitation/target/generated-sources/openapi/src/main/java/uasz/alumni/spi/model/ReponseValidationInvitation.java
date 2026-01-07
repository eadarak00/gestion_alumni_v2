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
 * ReponseValidationInvitation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-05T21:01:46.093610739Z[Africa/Dakar]")
public class ReponseValidationInvitation {

  private Boolean valide;

  private String message;

  public ReponseValidationInvitation valide(Boolean valide) {
    this.valide = valide;
    return this;
  }

  /**
   * Get valide
   * @return valide
  */
  
  @Schema(name = "valide", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("valide")
  public Boolean getValide() {
    return valide;
  }

  public void setValide(Boolean valide) {
    this.valide = valide;
  }

  public ReponseValidationInvitation message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ReponseValidationInvitation reponseValidationInvitation = (ReponseValidationInvitation) o;
    return Objects.equals(this.valide, reponseValidationInvitation.valide) &&
        Objects.equals(this.message, reponseValidationInvitation.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valide, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReponseValidationInvitation {\n");
    sb.append("    valide: ").append(toIndentedString(valide)).append("\n");
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

