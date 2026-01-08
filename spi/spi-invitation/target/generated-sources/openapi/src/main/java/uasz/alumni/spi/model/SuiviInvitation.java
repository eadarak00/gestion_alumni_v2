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
 * SuiviInvitation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-01T18:01:20.684089Z[Atlantic/Reykjavik]")
public class SuiviInvitation {

  /**
   * Gets or Sets etat
   */
  public enum EtatEnum {
    EN_ATTENTE("EN_ATTENTE"),
    
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
  private OffsetDateTime dateOuverture;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateAcceptation;

  public SuiviInvitation etat(EtatEnum etat) {
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

  public SuiviInvitation dateOuverture(OffsetDateTime dateOuverture) {
    this.dateOuverture = dateOuverture;
    return this;
  }

  /**
   * Get dateOuverture
   * @return dateOuverture
  */
  @Valid 
  @Schema(name = "dateOuverture", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateOuverture")
  public OffsetDateTime getDateOuverture() {
    return dateOuverture;
  }

  public void setDateOuverture(OffsetDateTime dateOuverture) {
    this.dateOuverture = dateOuverture;
  }

  public SuiviInvitation dateAcceptation(OffsetDateTime dateAcceptation) {
    this.dateAcceptation = dateAcceptation;
    return this;
  }

  /**
   * Get dateAcceptation
   * @return dateAcceptation
  */
  @Valid 
  @Schema(name = "dateAcceptation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateAcceptation")
  public OffsetDateTime getDateAcceptation() {
    return dateAcceptation;
  }

  public void setDateAcceptation(OffsetDateTime dateAcceptation) {
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
    SuiviInvitation suiviInvitation = (SuiviInvitation) o;
    return Objects.equals(this.etat, suiviInvitation.etat) &&
        Objects.equals(this.dateOuverture, suiviInvitation.dateOuverture) &&
        Objects.equals(this.dateAcceptation, suiviInvitation.dateAcceptation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(etat, dateOuverture, dateAcceptation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuiviInvitation {\n");
    sb.append("    etat: ").append(toIndentedString(etat)).append("\n");
    sb.append("    dateOuverture: ").append(toIndentedString(dateOuverture)).append("\n");
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

