package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import uasz.alumni.spi.model.TokenValidationResponseUtilisateur;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Réponse de validation du token JWT
 */

@Schema(name = "TokenValidationResponse", description = "Réponse de validation du token JWT")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T09:56:07.154792300Z[Etc/UTC]")
public class TokenValidationResponse {

  private Boolean valid;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime expiresAt;

  private TokenValidationResponseUtilisateur utilisateur;

  public TokenValidationResponse valid(Boolean valid) {
    this.valid = valid;
    return this;
  }

  /**
   * Indique si le token est valide
   * @return valid
  */
  
  @Schema(name = "valid", example = "true", description = "Indique si le token est valide", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("valid")
  public Boolean getValid() {
    return valid;
  }

  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  public TokenValidationResponse expiresAt(OffsetDateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * Date et heure d'expiration du token
   * @return expiresAt
  */
  @Valid 
  @Schema(name = "expiresAt", example = "2025-11-26T11:30Z", description = "Date et heure d'expiration du token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expiresAt")
  public OffsetDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(OffsetDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  public TokenValidationResponse utilisateur(TokenValidationResponseUtilisateur utilisateur) {
    this.utilisateur = utilisateur;
    return this;
  }

  /**
   * Get utilisateur
   * @return utilisateur
  */
  @Valid 
  @Schema(name = "utilisateur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("utilisateur")
  public TokenValidationResponseUtilisateur getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(TokenValidationResponseUtilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenValidationResponse tokenValidationResponse = (TokenValidationResponse) o;
    return Objects.equals(this.valid, tokenValidationResponse.valid) &&
        Objects.equals(this.expiresAt, tokenValidationResponse.expiresAt) &&
        Objects.equals(this.utilisateur, tokenValidationResponse.utilisateur);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valid, expiresAt, utilisateur);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenValidationResponse {\n");
    sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    utilisateur: ").append(toIndentedString(utilisateur)).append("\n");
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

