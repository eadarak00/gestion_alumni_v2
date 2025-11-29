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
 * InvitationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T11:47:11.992595600Z[Africa/Dakar]")
public class InvitationRequest {

  private String emailInvite;

  public InvitationRequest emailInvite(String emailInvite) {
    this.emailInvite = emailInvite;
    return this;
  }

  /**
   * Get emailInvite
   * @return emailInvite
  */
  
  @Schema(name = "emailInvite", example = "invite@example.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("emailInvite")
  public String getEmailInvite() {
    return emailInvite;
  }

  public void setEmailInvite(String emailInvite) {
    this.emailInvite = emailInvite;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvitationRequest invitationRequest = (InvitationRequest) o;
    return Objects.equals(this.emailInvite, invitationRequest.emailInvite);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailInvite);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvitationRequest {\n");
    sb.append("    emailInvite: ").append(toIndentedString(emailInvite)).append("\n");
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

