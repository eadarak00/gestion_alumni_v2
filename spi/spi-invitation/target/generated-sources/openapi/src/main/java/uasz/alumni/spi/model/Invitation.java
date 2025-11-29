package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T11:47:11.992595600Z[Africa/Dakar]")
public class Invitation {

  private Long id;

  private String emailInvite;

  private String code;

  private String urlInvitation;

  /**
   * Gets or Sets statut
   */
  public enum StatutEnum {
    ENVOYEE("ENVOYEE"),
    
    ACCEPTEE("ACCEPTEE"),
    
    EXPIREE("EXPIREE");

    private String value;

    StatutEnum(String value) {
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
    public static StatutEnum fromValue(String value) {
      for (StatutEnum b : StatutEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatutEnum statut;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateEnvoi;

  public Invitation id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Invitation emailInvite(String emailInvite) {
    this.emailInvite = emailInvite;
    return this;
  }

  /**
   * Get emailInvite
   * @return emailInvite
  */
  
  @Schema(name = "emailInvite", example = "invite@example.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("emailInvite")
  public String getEmailInvite() {
    return emailInvite;
  }

  public void setEmailInvite(String emailInvite) {
    this.emailInvite = emailInvite;
  }

  public Invitation code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  
  @Schema(name = "code", example = "INV-9X83KD", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Invitation urlInvitation(String urlInvitation) {
    this.urlInvitation = urlInvitation;
    return this;
  }

  /**
   * Get urlInvitation
   * @return urlInvitation
  */
  
  @Schema(name = "urlInvitation", example = "https://plateforme.com/invitation/INV-9X83KD", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("urlInvitation")
  public String getUrlInvitation() {
    return urlInvitation;
  }

  public void setUrlInvitation(String urlInvitation) {
    this.urlInvitation = urlInvitation;
  }

  public Invitation statut(StatutEnum statut) {
    this.statut = statut;
    return this;
  }

  /**
   * Get statut
   * @return statut
  */
  
  @Schema(name = "statut", example = "ENVOYEE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statut")
  public StatutEnum getStatut() {
    return statut;
  }

  public void setStatut(StatutEnum statut) {
    this.statut = statut;
  }

  public Invitation dateEnvoi(OffsetDateTime dateEnvoi) {
    this.dateEnvoi = dateEnvoi;
    return this;
  }

  /**
   * Get dateEnvoi
   * @return dateEnvoi
  */
  @Valid 
  @Schema(name = "dateEnvoi", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateEnvoi")
  public OffsetDateTime getDateEnvoi() {
    return dateEnvoi;
  }

  public void setDateEnvoi(OffsetDateTime dateEnvoi) {
    this.dateEnvoi = dateEnvoi;
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
        Objects.equals(this.emailInvite, invitation.emailInvite) &&
        Objects.equals(this.code, invitation.code) &&
        Objects.equals(this.urlInvitation, invitation.urlInvitation) &&
        Objects.equals(this.statut, invitation.statut) &&
        Objects.equals(this.dateEnvoi, invitation.dateEnvoi);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, emailInvite, code, urlInvitation, statut, dateEnvoi);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invitation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    emailInvite: ").append(toIndentedString(emailInvite)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    urlInvitation: ").append(toIndentedString(urlInvitation)).append("\n");
    sb.append("    statut: ").append(toIndentedString(statut)).append("\n");
    sb.append("    dateEnvoi: ").append(toIndentedString(dateEnvoi)).append("\n");
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

