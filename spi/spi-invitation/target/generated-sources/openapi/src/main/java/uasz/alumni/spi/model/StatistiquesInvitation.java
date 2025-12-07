package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uasz.alumni.spi.model.StatistiquesInvitationTopEnvoyeursInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * StatistiquesInvitation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-05T18:32:29.145661100Z[Atlantic/Reykjavik]")
public class StatistiquesInvitation {

  private Integer totalInvitations;

  private Integer totalAcceptees;

  private Integer totalExpirees;

  private Float tauxConversion;

  @Valid
  private List<@Valid StatistiquesInvitationTopEnvoyeursInner> topEnvoyeurs;

  public StatistiquesInvitation totalInvitations(Integer totalInvitations) {
    this.totalInvitations = totalInvitations;
    return this;
  }

  /**
   * Get totalInvitations
   * @return totalInvitations
  */
  
  @Schema(name = "totalInvitations", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalInvitations")
  public Integer getTotalInvitations() {
    return totalInvitations;
  }

  public void setTotalInvitations(Integer totalInvitations) {
    this.totalInvitations = totalInvitations;
  }

  public StatistiquesInvitation totalAcceptees(Integer totalAcceptees) {
    this.totalAcceptees = totalAcceptees;
    return this;
  }

  /**
   * Get totalAcceptees
   * @return totalAcceptees
  */
  
  @Schema(name = "totalAcceptees", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAcceptees")
  public Integer getTotalAcceptees() {
    return totalAcceptees;
  }

  public void setTotalAcceptees(Integer totalAcceptees) {
    this.totalAcceptees = totalAcceptees;
  }

  public StatistiquesInvitation totalExpirees(Integer totalExpirees) {
    this.totalExpirees = totalExpirees;
    return this;
  }

  /**
   * Get totalExpirees
   * @return totalExpirees
  */
  
  @Schema(name = "totalExpirees", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalExpirees")
  public Integer getTotalExpirees() {
    return totalExpirees;
  }

  public void setTotalExpirees(Integer totalExpirees) {
    this.totalExpirees = totalExpirees;
  }

  public StatistiquesInvitation tauxConversion(Float tauxConversion) {
    this.tauxConversion = tauxConversion;
    return this;
  }

  /**
   * Pourcentage d'invitations acceptées
   * @return tauxConversion
  */
  
  @Schema(name = "tauxConversion", description = "Pourcentage d'invitations acceptées", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tauxConversion")
  public Float getTauxConversion() {
    return tauxConversion;
  }

  public void setTauxConversion(Float tauxConversion) {
    this.tauxConversion = tauxConversion;
  }

  public StatistiquesInvitation topEnvoyeurs(List<@Valid StatistiquesInvitationTopEnvoyeursInner> topEnvoyeurs) {
    this.topEnvoyeurs = topEnvoyeurs;
    return this;
  }

  public StatistiquesInvitation addTopEnvoyeursItem(StatistiquesInvitationTopEnvoyeursInner topEnvoyeursItem) {
    if (this.topEnvoyeurs == null) {
      this.topEnvoyeurs = new ArrayList<>();
    }
    this.topEnvoyeurs.add(topEnvoyeursItem);
    return this;
  }

  /**
   * Get topEnvoyeurs
   * @return topEnvoyeurs
  */
  @Valid 
  @Schema(name = "topEnvoyeurs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("topEnvoyeurs")
  public List<@Valid StatistiquesInvitationTopEnvoyeursInner> getTopEnvoyeurs() {
    return topEnvoyeurs;
  }

  public void setTopEnvoyeurs(List<@Valid StatistiquesInvitationTopEnvoyeursInner> topEnvoyeurs) {
    this.topEnvoyeurs = topEnvoyeurs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatistiquesInvitation statistiquesInvitation = (StatistiquesInvitation) o;
    return Objects.equals(this.totalInvitations, statistiquesInvitation.totalInvitations) &&
        Objects.equals(this.totalAcceptees, statistiquesInvitation.totalAcceptees) &&
        Objects.equals(this.totalExpirees, statistiquesInvitation.totalExpirees) &&
        Objects.equals(this.tauxConversion, statistiquesInvitation.tauxConversion) &&
        Objects.equals(this.topEnvoyeurs, statistiquesInvitation.topEnvoyeurs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalInvitations, totalAcceptees, totalExpirees, tauxConversion, topEnvoyeurs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatistiquesInvitation {\n");
    sb.append("    totalInvitations: ").append(toIndentedString(totalInvitations)).append("\n");
    sb.append("    totalAcceptees: ").append(toIndentedString(totalAcceptees)).append("\n");
    sb.append("    totalExpirees: ").append(toIndentedString(totalExpirees)).append("\n");
    sb.append("    tauxConversion: ").append(toIndentedString(tauxConversion)).append("\n");
    sb.append("    topEnvoyeurs: ").append(toIndentedString(topEnvoyeurs)).append("\n");
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

