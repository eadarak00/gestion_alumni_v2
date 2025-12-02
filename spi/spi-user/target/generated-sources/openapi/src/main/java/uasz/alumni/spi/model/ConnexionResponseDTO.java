package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import uasz.alumni.spi.model.UtilisateurConnecteDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Réponse de connexion avec les tokens JWT et les informations utilisateur
 */

@Schema(name = "ConnexionResponseDTO", description = "Réponse de connexion avec les tokens JWT et les informations utilisateur")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:07:51.481060929Z[Africa/Dakar]")
public class ConnexionResponseDTO {

  private String token;

  private String refreshToken;

  private String type = "Bearer";

  private Long expiresIn;

  private Long refreshTokenExpiresIn;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  private UtilisateurConnecteDTO utilisateur;

  public ConnexionResponseDTO token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Token JWT d'authentification (Access Token)
   * @return token
  */
  
  @Schema(name = "token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...", description = "Token JWT d'authentification (Access Token)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ConnexionResponseDTO refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Token de rafraîchissement permettant d'obtenir un nouveau token JWT. Ce token est automatiquement roté à chaque utilisation pour renforcer la sécurité. 
   * @return refreshToken
  */
  
  @Schema(name = "refreshToken", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...", description = "Token de rafraîchissement permettant d'obtenir un nouveau token JWT. Ce token est automatiquement roté à chaque utilisation pour renforcer la sécurité. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("refreshToken")
  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public ConnexionResponseDTO type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type de token (toujours Bearer pour JWT)
   * @return type
  */
  
  @Schema(name = "type", example = "Bearer", description = "Type de token (toujours Bearer pour JWT)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ConnexionResponseDTO expiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

  /**
   * Durée de validité du token JWT en secondes
   * @return expiresIn
  */
  
  @Schema(name = "expiresIn", example = "3600", description = "Durée de validité du token JWT en secondes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expiresIn")
  public Long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }

  public ConnexionResponseDTO refreshTokenExpiresIn(Long refreshTokenExpiresIn) {
    this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    return this;
  }

  /**
   * Durée de validité du refresh token en secondes (généralement 7 jours)
   * @return refreshTokenExpiresIn
  */
  
  @Schema(name = "refreshTokenExpiresIn", example = "604800", description = "Durée de validité du refresh token en secondes (généralement 7 jours)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("refreshTokenExpiresIn")
  public Long getRefreshTokenExpiresIn() {
    return refreshTokenExpiresIn;
  }

  public void setRefreshTokenExpiresIn(Long refreshTokenExpiresIn) {
    this.refreshTokenExpiresIn = refreshTokenExpiresIn;
  }

  public ConnexionResponseDTO createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Date et heure de création du token
   * @return createdAt
  */
  @Valid 
  @Schema(name = "createdAt", example = "2025-11-26T10:30Z", description = "Date et heure de création du token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ConnexionResponseDTO utilisateur(UtilisateurConnecteDTO utilisateur) {
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
  public UtilisateurConnecteDTO getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(UtilisateurConnecteDTO utilisateur) {
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
    ConnexionResponseDTO connexionResponseDTO = (ConnexionResponseDTO) o;
    return Objects.equals(this.token, connexionResponseDTO.token) &&
        Objects.equals(this.refreshToken, connexionResponseDTO.refreshToken) &&
        Objects.equals(this.type, connexionResponseDTO.type) &&
        Objects.equals(this.expiresIn, connexionResponseDTO.expiresIn) &&
        Objects.equals(this.refreshTokenExpiresIn, connexionResponseDTO.refreshTokenExpiresIn) &&
        Objects.equals(this.createdAt, connexionResponseDTO.createdAt) &&
        Objects.equals(this.utilisateur, connexionResponseDTO.utilisateur);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, refreshToken, type, expiresIn, refreshTokenExpiresIn, createdAt, utilisateur);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnexionResponseDTO {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    refreshTokenExpiresIn: ").append(toIndentedString(refreshTokenExpiresIn)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

