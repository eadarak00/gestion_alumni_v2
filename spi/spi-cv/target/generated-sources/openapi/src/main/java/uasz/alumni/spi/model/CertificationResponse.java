package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * CertificationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T15:53:54.746111Z[Africa/Dakar]")
public class CertificationResponse {

  private Integer id;

  private Integer cvId;

  private String nom;

  private String organisme;

  private String dateObtention;

  private String dateExpiration;

  private String numeroCredential;

  private String urlVerification;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateDerniereModification;

  public CertificationResponse id(Integer id) {
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

  public CertificationResponse cvId(Integer cvId) {
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

  public CertificationResponse nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  
  @Schema(name = "nom", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public CertificationResponse organisme(String organisme) {
    this.organisme = organisme;
    return this;
  }

  /**
   * Get organisme
   * @return organisme
  */
  
  @Schema(name = "organisme", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("organisme")
  public String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(String organisme) {
    this.organisme = organisme;
  }

  public CertificationResponse dateObtention(String dateObtention) {
    this.dateObtention = dateObtention;
    return this;
  }

  /**
   * Get dateObtention
   * @return dateObtention
  */
  
  @Schema(name = "dateObtention", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateObtention")
  public String getDateObtention() {
    return dateObtention;
  }

  public void setDateObtention(String dateObtention) {
    this.dateObtention = dateObtention;
  }

  public CertificationResponse dateExpiration(String dateExpiration) {
    this.dateExpiration = dateExpiration;
    return this;
  }

  /**
   * Get dateExpiration
   * @return dateExpiration
  */
  
  @Schema(name = "dateExpiration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateExpiration")
  public String getDateExpiration() {
    return dateExpiration;
  }

  public void setDateExpiration(String dateExpiration) {
    this.dateExpiration = dateExpiration;
  }

  public CertificationResponse numeroCredential(String numeroCredential) {
    this.numeroCredential = numeroCredential;
    return this;
  }

  /**
   * Get numeroCredential
   * @return numeroCredential
  */
  
  @Schema(name = "numeroCredential", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numeroCredential")
  public String getNumeroCredential() {
    return numeroCredential;
  }

  public void setNumeroCredential(String numeroCredential) {
    this.numeroCredential = numeroCredential;
  }

  public CertificationResponse urlVerification(String urlVerification) {
    this.urlVerification = urlVerification;
    return this;
  }

  /**
   * Get urlVerification
   * @return urlVerification
  */
  
  @Schema(name = "urlVerification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("urlVerification")
  public String getUrlVerification() {
    return urlVerification;
  }

  public void setUrlVerification(String urlVerification) {
    this.urlVerification = urlVerification;
  }

  public CertificationResponse dateCreation(OffsetDateTime dateCreation) {
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

  public CertificationResponse dateDerniereModification(OffsetDateTime dateDerniereModification) {
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
    CertificationResponse certificationResponse = (CertificationResponse) o;
    return Objects.equals(this.id, certificationResponse.id) &&
        Objects.equals(this.cvId, certificationResponse.cvId) &&
        Objects.equals(this.nom, certificationResponse.nom) &&
        Objects.equals(this.organisme, certificationResponse.organisme) &&
        Objects.equals(this.dateObtention, certificationResponse.dateObtention) &&
        Objects.equals(this.dateExpiration, certificationResponse.dateExpiration) &&
        Objects.equals(this.numeroCredential, certificationResponse.numeroCredential) &&
        Objects.equals(this.urlVerification, certificationResponse.urlVerification) &&
        Objects.equals(this.dateCreation, certificationResponse.dateCreation) &&
        Objects.equals(this.dateDerniereModification, certificationResponse.dateDerniereModification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, nom, organisme, dateObtention, dateExpiration, numeroCredential, urlVerification, dateCreation, dateDerniereModification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificationResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    organisme: ").append(toIndentedString(organisme)).append("\n");
    sb.append("    dateObtention: ").append(toIndentedString(dateObtention)).append("\n");
    sb.append("    dateExpiration: ").append(toIndentedString(dateExpiration)).append("\n");
    sb.append("    numeroCredential: ").append(toIndentedString(numeroCredential)).append("\n");
    sb.append("    urlVerification: ").append(toIndentedString(urlVerification)).append("\n");
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

