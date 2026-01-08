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
 * CertificationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-05T02:02:10.601143888Z[Africa/Dakar]")
public class CertificationRequest {

  private Integer cvId;

  private String nom;

  private String organisme;

  private String dateObtention;

  private String dateExpiration;

  private String numeroCredential;

  private String urlVerification;

  public CertificationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CertificationRequest(Integer cvId, String nom, String organisme, String dateObtention) {
    this.cvId = cvId;
    this.nom = nom;
    this.organisme = organisme;
    this.dateObtention = dateObtention;
  }

  public CertificationRequest cvId(Integer cvId) {
    this.cvId = cvId;
    return this;
  }

  /**
   * Get cvId
   * @return cvId
  */
  @NotNull 
  @Schema(name = "cvId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cvId")
  public Integer getCvId() {
    return cvId;
  }

  public void setCvId(Integer cvId) {
    this.cvId = cvId;
  }

  public CertificationRequest nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  @NotNull @Size(min = 2, max = 150) 
  @Schema(name = "nom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public CertificationRequest organisme(String organisme) {
    this.organisme = organisme;
    return this;
  }

  /**
   * Get organisme
   * @return organisme
  */
  @NotNull @Size(min = 2, max = 150) 
  @Schema(name = "organisme", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organisme")
  public String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(String organisme) {
    this.organisme = organisme;
  }

  public CertificationRequest dateObtention(String dateObtention) {
    this.dateObtention = dateObtention;
    return this;
  }

  /**
   * Get dateObtention
   * @return dateObtention
  */
  @NotNull 
  @Schema(name = "dateObtention", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateObtention")
  public String getDateObtention() {
    return dateObtention;
  }

  public void setDateObtention(String dateObtention) {
    this.dateObtention = dateObtention;
  }

  public CertificationRequest dateExpiration(String dateExpiration) {
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

  public CertificationRequest numeroCredential(String numeroCredential) {
    this.numeroCredential = numeroCredential;
    return this;
  }

  /**
   * Get numeroCredential
   * @return numeroCredential
  */
  @Size(max = 100) 
  @Schema(name = "numeroCredential", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numeroCredential")
  public String getNumeroCredential() {
    return numeroCredential;
  }

  public void setNumeroCredential(String numeroCredential) {
    this.numeroCredential = numeroCredential;
  }

  public CertificationRequest urlVerification(String urlVerification) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificationRequest certificationRequest = (CertificationRequest) o;
    return Objects.equals(this.cvId, certificationRequest.cvId) &&
        Objects.equals(this.nom, certificationRequest.nom) &&
        Objects.equals(this.organisme, certificationRequest.organisme) &&
        Objects.equals(this.dateObtention, certificationRequest.dateObtention) &&
        Objects.equals(this.dateExpiration, certificationRequest.dateExpiration) &&
        Objects.equals(this.numeroCredential, certificationRequest.numeroCredential) &&
        Objects.equals(this.urlVerification, certificationRequest.urlVerification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, nom, organisme, dateObtention, dateExpiration, numeroCredential, urlVerification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificationRequest {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    organisme: ").append(toIndentedString(organisme)).append("\n");
    sb.append("    dateObtention: ").append(toIndentedString(dateObtention)).append("\n");
    sb.append("    dateExpiration: ").append(toIndentedString(dateExpiration)).append("\n");
    sb.append("    numeroCredential: ").append(toIndentedString(numeroCredential)).append("\n");
    sb.append("    urlVerification: ").append(toIndentedString(urlVerification)).append("\n");
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

