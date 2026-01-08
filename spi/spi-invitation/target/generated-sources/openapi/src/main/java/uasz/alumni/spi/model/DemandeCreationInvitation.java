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
 * DemandeCreationInvitation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-01T18:01:20.684089Z[Atlantic/Reykjavik]")
public class DemandeCreationInvitation {

  private String idEnvoyeur;

  /**
   * Gets or Sets roleEnvoyeur
   */
  public enum RoleEnvoyeurEnum {
    ETUDIANT("ETUDIANT"),
    
    ALUMNI("ALUMNI"),
    
    ADMIN("ADMIN");

    private String value;

    RoleEnvoyeurEnum(String value) {
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
    public static RoleEnvoyeurEnum fromValue(String value) {
      for (RoleEnvoyeurEnum b : RoleEnvoyeurEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private RoleEnvoyeurEnum roleEnvoyeur;

  public DemandeCreationInvitation() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DemandeCreationInvitation(String idEnvoyeur, RoleEnvoyeurEnum roleEnvoyeur) {
    this.idEnvoyeur = idEnvoyeur;
    this.roleEnvoyeur = roleEnvoyeur;
  }

  public DemandeCreationInvitation idEnvoyeur(String idEnvoyeur) {
    this.idEnvoyeur = idEnvoyeur;
    return this;
  }

  /**
   * Get idEnvoyeur
   * @return idEnvoyeur
  */
  @NotNull 
  @Schema(name = "idEnvoyeur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idEnvoyeur")
  public String getIdEnvoyeur() {
    return idEnvoyeur;
  }

  public void setIdEnvoyeur(String idEnvoyeur) {
    this.idEnvoyeur = idEnvoyeur;
  }

  public DemandeCreationInvitation roleEnvoyeur(RoleEnvoyeurEnum roleEnvoyeur) {
    this.roleEnvoyeur = roleEnvoyeur;
    return this;
  }

  /**
   * Get roleEnvoyeur
   * @return roleEnvoyeur
  */
  @NotNull 
  @Schema(name = "roleEnvoyeur", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("roleEnvoyeur")
  public RoleEnvoyeurEnum getRoleEnvoyeur() {
    return roleEnvoyeur;
  }

  public void setRoleEnvoyeur(RoleEnvoyeurEnum roleEnvoyeur) {
    this.roleEnvoyeur = roleEnvoyeur;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DemandeCreationInvitation demandeCreationInvitation = (DemandeCreationInvitation) o;
    return Objects.equals(this.idEnvoyeur, demandeCreationInvitation.idEnvoyeur) &&
        Objects.equals(this.roleEnvoyeur, demandeCreationInvitation.roleEnvoyeur);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEnvoyeur, roleEnvoyeur);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DemandeCreationInvitation {\n");
    sb.append("    idEnvoyeur: ").append(toIndentedString(idEnvoyeur)).append("\n");
    sb.append("    roleEnvoyeur: ").append(toIndentedString(roleEnvoyeur)).append("\n");
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

