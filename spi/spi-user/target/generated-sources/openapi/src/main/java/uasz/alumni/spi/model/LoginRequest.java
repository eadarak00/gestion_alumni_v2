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
 * LoginRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-31T20:24:47.749502200Z[Atlantic/Reykjavik]")
public class LoginRequest {

  private String email;

  private String motDePasse;

  public LoginRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoginRequest(String email, String motDePasse) {
    this.email = email;
    this.motDePasse = motDePasse;
  }

  public LoginRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email de l'utilisateur
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "etudiant@uasz.sn", description = "Email de l'utilisateur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LoginRequest motDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
    return this;
  }

  /**
   * Mot de passe de l'utilisateur
   * @return motDePasse
  */
  @NotNull 
  @Schema(name = "motDePasse", example = "MotDePasse123!", description = "Mot de passe de l'utilisateur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("motDePasse")
  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginRequest loginRequest = (LoginRequest) o;
    return Objects.equals(this.email, loginRequest.email) &&
        Objects.equals(this.motDePasse, loginRequest.motDePasse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, motDePasse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    motDePasse: ").append("*").append("\n");
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

