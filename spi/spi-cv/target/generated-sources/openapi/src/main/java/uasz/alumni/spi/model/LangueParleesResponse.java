package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import uasz.alumni.spi.model.Langues;
import uasz.alumni.spi.model.NiveauLangue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * LangueParleesResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-10T11:14:25.743819712Z[Africa/Dakar]")
public class LangueParleesResponse {

  private Integer id;

  private Integer cvId;

  private Langues langue;

  private NiveauLangue niveau;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateDerniereModification;

  public LangueParleesResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LangueParleesResponse cvId(Integer cvId) {
    this.cvId = cvId;
    return this;
  }

  /**
   * Get cvId
   * @return cvId
  */
  
  @Schema(name = "cvId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cvId")
  public Integer getCvId() {
    return cvId;
  }

  public void setCvId(Integer cvId) {
    this.cvId = cvId;
  }

  public LangueParleesResponse langue(Langues langue) {
    this.langue = langue;
    return this;
  }

  /**
   * Get langue
   * @return langue
  */
  @Valid 
  @Schema(name = "langue", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("langue")
  public Langues getLangue() {
    return langue;
  }

  public void setLangue(Langues langue) {
    this.langue = langue;
  }

  public LangueParleesResponse niveau(NiveauLangue niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  @Valid 
  @Schema(name = "niveau", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("niveau")
  public NiveauLangue getNiveau() {
    return niveau;
  }

  public void setNiveau(NiveauLangue niveau) {
    this.niveau = niveau;
  }

  public LangueParleesResponse dateCreation(OffsetDateTime dateCreation) {
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

  public LangueParleesResponse dateDerniereModification(OffsetDateTime dateDerniereModification) {
    this.dateDerniereModification = dateDerniereModification;
    return this;
  }

  /**
   * Get dateDerniereModification
   * @return dateDerniereModification
  */
  @Valid 
  @Schema(name = "dateDerniereModification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateDerniereModification")
  public OffsetDateTime getDateDerniereModification() {
    return dateDerniereModification;
  }

  public void setDateDerniereModification(OffsetDateTime dateDerniereModification) {
    this.dateDerniereModification = dateDerniereModification;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LangueParleesResponse langueParleesResponse = (LangueParleesResponse) o;
    return Objects.equals(this.id, langueParleesResponse.id) &&
        Objects.equals(this.cvId, langueParleesResponse.cvId) &&
        Objects.equals(this.langue, langueParleesResponse.langue) &&
        Objects.equals(this.niveau, langueParleesResponse.niveau) &&
        Objects.equals(this.dateCreation, langueParleesResponse.dateCreation) &&
        Objects.equals(this.dateDerniereModification, langueParleesResponse.dateDerniereModification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, langue, niveau, dateCreation, dateDerniereModification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LangueParleesResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    langue: ").append(toIndentedString(langue)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    dateCreation: ").append(toIndentedString(dateCreation)).append("\n");
    sb.append("    dateDerniereModification: ").append(toIndentedString(dateDerniereModification)).append("\n");
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

