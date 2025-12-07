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
 * Requête de rafraîchissement du token JWT
 */

@Schema(name = "RefreshTokenRequestDTO", description = "Requête de rafraîchissement du token JWT")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-05T18:32:33.604147700Z[Atlantic/Reykjavik]")
public class RefreshTokenRequestDTO {

  private String refreshToken;

  public RefreshTokenRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RefreshTokenRequestDTO(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public RefreshTokenRequestDTO refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Token de rafraîchissement obtenu lors de la connexion
   * @return refreshToken
  */
  @NotNull 
  @Schema(name = "refreshToken", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...", description = "Token de rafraîchissement obtenu lors de la connexion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("refreshToken")
  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefreshTokenRequestDTO refreshTokenRequestDTO = (RefreshTokenRequestDTO) o;
    return Objects.equals(this.refreshToken, refreshTokenRequestDTO.refreshToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refreshToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefreshTokenRequestDTO {\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
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

