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
 * Données de connexion
 */

@Schema(name = "ConnexionRequestDTO", description = "Données de connexion")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:07:51.481060929Z[Africa/Dakar]")
public class ConnexionRequestDTO {

  private String identifiant;

  private String motDePasse;

  public ConnexionRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ConnexionRequestDTO(String identifiant, String motDePasse) {
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
  }

  public ConnexionRequestDTO identifiant(String identifiant) {
    this.identifiant = identifiant;
    return this;
  }

  /**
   * Email ou username de l'utilisateur
   * @return identifiant
  */
  @NotNull 
  @Schema(name = "identifiant", example = "etudiant@uasz.sn", description = "Email ou username de l'utilisateur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("identifiant")
  public String getIdentifiant() {
    return identifiant;
  }

  public void setIdentifiant(String identifiant) {
    this.identifiant = identifiant;
  }

  public ConnexionRequestDTO motDePasse(String motDePasse) {
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
    ConnexionRequestDTO connexionRequestDTO = (ConnexionRequestDTO) o;
    return Objects.equals(this.identifiant, connexionRequestDTO.identifiant) &&
        Objects.equals(this.motDePasse, connexionRequestDTO.motDePasse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifiant, motDePasse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnexionRequestDTO {\n");
    sb.append("    identifiant: ").append(toIndentedString(identifiant)).append("\n");
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

