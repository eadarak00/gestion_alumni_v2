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
 * CodeValidationCheckDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T15:59:08.700783195Z[Africa/Dakar]")
public class CodeValidationCheckDTO {

  private String email;

  private String code;

  public CodeValidationCheckDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CodeValidationCheckDTO(String email, String code) {
    this.email = email;
    this.code = code;
  }

  public CodeValidationCheckDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email de l'utilisateur
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "mamadou.diallo@uasz.sn", description = "Email de l'utilisateur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CodeValidationCheckDTO code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Code de validation reçu par email
   * @return code
  */
  @NotNull 
  @Schema(name = "code", example = "123456", description = "Code de validation reçu par email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodeValidationCheckDTO codeValidationCheckDTO = (CodeValidationCheckDTO) o;
    return Objects.equals(this.email, codeValidationCheckDTO.email) &&
        Objects.equals(this.code, codeValidationCheckDTO.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeValidationCheckDTO {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

