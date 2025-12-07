package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CodeValidationRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-05T18:32:33.604147700Z[Atlantic/Reykjavik]")
public class CodeValidationRequestDTO {

  private String email;

  /**
   * Gets or Sets typeCode
   */
  public enum TypeCodeEnum {
    INSCRIPTION("INSCRIPTION"),
    
    REINITIALISATION_MDP("REINITIALISATION_MDP"),
    
    VALIDATION_EMAIL("VALIDATION_EMAIL");

    private String value;

    TypeCodeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeCodeEnum fromValue(String value) {
      for (TypeCodeEnum b : TypeCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeCodeEnum typeCode;

  public CodeValidationRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CodeValidationRequestDTO(String email, TypeCodeEnum typeCode) {
    this.email = email;
    this.typeCode = typeCode;
  }

  public CodeValidationRequestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "mamadou.diallo@uasz.sn", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CodeValidationRequestDTO typeCode(TypeCodeEnum typeCode) {
    this.typeCode = typeCode;
    return this;
  }

  /**
   * Get typeCode
   * @return typeCode
  */
  @NotNull 
  @Schema(name = "typeCode", example = "INSCRIPTION", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("typeCode")
  public TypeCodeEnum getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(TypeCodeEnum typeCode) {
    this.typeCode = typeCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodeValidationRequestDTO codeValidationRequestDTO = (CodeValidationRequestDTO) o;
    return Objects.equals(this.email, codeValidationRequestDTO.email) &&
        Objects.equals(this.typeCode, codeValidationRequestDTO.typeCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, typeCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeValidationRequestDTO {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    typeCode: ").append(toIndentedString(typeCode)).append("\n");
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

