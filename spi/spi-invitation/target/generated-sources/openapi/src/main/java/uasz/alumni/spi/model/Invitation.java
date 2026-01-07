package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Invitation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-05T02:02:16.739320157Z[Africa/Dakar]")
public class Invitation {

  private Long id;

  private String idEnvoyeur;

  private String roleEnvoyeur;

  private String jeton;

  private String urlInvitation;

  /**
   * Gets or Sets etat
   */
  public enum EtatEnum {
    EN_ATTENTE_PARTAGE("EN_ATTENTE_PARTAGE"),
    
    OUVERTE("OUVERTE"),
    
    INSCRIPTION_INITIEE("INSCRIPTION_INITIEE"),
    
    ACCEPTEE("ACCEPTEE"),
    
    EXPIREE("EXPIREE");

    private String value;

    EtatEnum(String value) {
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
    public static EtatEnum fromValue(String value) {
      for (EtatEnum b : EtatEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private EtatEnum etat;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateExpiration;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private JsonNullable<OffsetDateTime> dateAcceptation = JsonNullable.<OffsetDateTime>undefined();

  public Invitation id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Invitation idEnvoyeur(String idEnvoyeur) {
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

  public Invitation roleEnvoyeur(String roleEnvoyeur) {
    this.roleEnvoyeur = roleEnvoyeur;
    return this;
  }

  /**
   * Get roleEnvoyeur
   * @return roleEnvoyeur
  */
  
  @Schema(name = "roleEnvoyeur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("roleEnvoyeur")
  public String getRoleEnvoyeur() {
    return roleEnvoyeur;
  }

  public void setRoleEnvoyeur(String roleEnvoyeur) {
    this.roleEnvoyeur = roleEnvoyeur;
  }

  public Invitation jeton(String jeton) {
    this.jeton = jeton;
    return this;
  }

  /**
   * Get jeton
   * @return jeton
  */
  
  @Schema(name = "jeton", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("jeton")
  public String getJeton() {
    return jeton;
  }

  public void setJeton(String jeton) {
    this.jeton = jeton;
  }

  public Invitation urlInvitation(String urlInvitation) {
    this.urlInvitation = urlInvitation;
    return this;
  }

  /**
   * Get urlInvitation
   * @return urlInvitation
  */
  
  @Schema(name = "urlInvitation", example = "https://alumni.com/invitation/valider?jeton=ABC123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("urlInvitation")
  public String getUrlInvitation() {
    return urlInvitation;
  }

  public void setUrlInvitation(String urlInvitation) {
    this.urlInvitation = urlInvitation;
  }

  public Invitation etat(EtatEnum etat) {
    this.etat = etat;
    return this;
  }

  /**
   * Get etat
   * @return etat
  */
  
  @Schema(name = "etat", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("etat")
  public EtatEnum getEtat() {
    return etat;
  }

  public void setEtat(EtatEnum etat) {
    this.etat = etat;
  }

  public Invitation dateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
    return this;
  }

  /**
   * Get dateCreation
   * @return dateCreation
  */
  @Valid 
  @Schema(name = "dateCreation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateCreation")
  public OffsetDateTime getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
  }

  public Invitation dateExpiration(OffsetDateTime dateExpiration) {
    this.dateExpiration = dateExpiration;
    return this;
  }

  /**
   * Get dateExpiration
   * @return dateExpiration
  */
  @Valid 
  @Schema(name = "dateExpiration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateExpiration")
  public OffsetDateTime getDateExpiration() {
    return dateExpiration;
  }

  public void setDateExpiration(OffsetDateTime dateExpiration) {
    this.dateExpiration = dateExpiration;
  }

  public Invitation dateAcceptation(OffsetDateTime dateAcceptation) {
    this.dateAcceptation = JsonNullable.of(dateAcceptation);
    return this;
  }

  /**
   * Get dateAcceptation
   * @return dateAcceptation
  */
  @Valid 
  @Schema(name = "dateAcceptation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateAcceptation")
  public JsonNullable<OffsetDateTime> getDateAcceptation() {
    return dateAcceptation;
  }

  public void setDateAcceptation(JsonNullable<OffsetDateTime> dateAcceptation) {
    this.dateAcceptation = dateAcceptation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invitation invitation = (Invitation) o;
    return Objects.equals(this.id, invitation.id) &&
        Objects.equals(this.idEnvoyeur, invitation.idEnvoyeur) &&
        Objects.equals(this.roleEnvoyeur, invitation.roleEnvoyeur) &&
        Objects.equals(this.jeton, invitation.jeton) &&
        Objects.equals(this.urlInvitation, invitation.urlInvitation) &&
        Objects.equals(this.etat, invitation.etat) &&
        Objects.equals(this.dateCreation, invitation.dateCreation) &&
        Objects.equals(this.dateExpiration, invitation.dateExpiration) &&
        equalsNullable(this.dateAcceptation, invitation.dateAcceptation);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idEnvoyeur, roleEnvoyeur, jeton, urlInvitation, etat, dateCreation, dateExpiration, hashCodeNullable(dateAcceptation));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invitation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idEnvoyeur: ").append(toIndentedString(idEnvoyeur)).append("\n");
    sb.append("    roleEnvoyeur: ").append(toIndentedString(roleEnvoyeur)).append("\n");
    sb.append("    jeton: ").append(toIndentedString(jeton)).append("\n");
    sb.append("    urlInvitation: ").append(toIndentedString(urlInvitation)).append("\n");
    sb.append("    etat: ").append(toIndentedString(etat)).append("\n");
    sb.append("    dateCreation: ").append(toIndentedString(dateCreation)).append("\n");
    sb.append("    dateExpiration: ").append(toIndentedString(dateExpiration)).append("\n");
    sb.append("    dateAcceptation: ").append(toIndentedString(dateAcceptation)).append("\n");
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

