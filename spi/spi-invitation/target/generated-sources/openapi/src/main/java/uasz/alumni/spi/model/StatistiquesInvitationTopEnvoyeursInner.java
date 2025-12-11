package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * StatistiquesInvitationTopEnvoyeursInner
 */

@JsonTypeName("StatistiquesInvitation_topEnvoyeurs_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T09:56:03.264140400Z[Etc/UTC]")
public class StatistiquesInvitationTopEnvoyeursInner {

  private String idEnvoyeur;

  private Integer nombreInvitations;

  public StatistiquesInvitationTopEnvoyeursInner idEnvoyeur(String idEnvoyeur) {
    this.idEnvoyeur = idEnvoyeur;
    return this;
  }

  /**
   * Get idEnvoyeur
   * @return idEnvoyeur
  */
  
  @Schema(name = "idEnvoyeur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idEnvoyeur")
  public String getIdEnvoyeur() {
    return idEnvoyeur;
  }

  public void setIdEnvoyeur(String idEnvoyeur) {
    this.idEnvoyeur = idEnvoyeur;
  }

  public StatistiquesInvitationTopEnvoyeursInner nombreInvitations(Integer nombreInvitations) {
    this.nombreInvitations = nombreInvitations;
    return this;
  }

  /**
   * Get nombreInvitations
   * @return nombreInvitations
  */
  
  @Schema(name = "nombreInvitations", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nombreInvitations")
  public Integer getNombreInvitations() {
    return nombreInvitations;
  }

  public void setNombreInvitations(Integer nombreInvitations) {
    this.nombreInvitations = nombreInvitations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatistiquesInvitationTopEnvoyeursInner statistiquesInvitationTopEnvoyeursInner = (StatistiquesInvitationTopEnvoyeursInner) o;
    return Objects.equals(this.idEnvoyeur, statistiquesInvitationTopEnvoyeursInner.idEnvoyeur) &&
        Objects.equals(this.nombreInvitations, statistiquesInvitationTopEnvoyeursInner.nombreInvitations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEnvoyeur, nombreInvitations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatistiquesInvitationTopEnvoyeursInner {\n");
    sb.append("    idEnvoyeur: ").append(toIndentedString(idEnvoyeur)).append("\n");
    sb.append("    nombreInvitations: ").append(toIndentedString(nombreInvitations)).append("\n");
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

