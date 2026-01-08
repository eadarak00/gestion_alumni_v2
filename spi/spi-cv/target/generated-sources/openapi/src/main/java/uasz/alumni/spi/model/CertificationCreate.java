package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CertificationCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T01:09:53.014692443Z[Africa/Dakar]")
public class CertificationCreate {

  private Integer cvId;

  private String nom;

  private String organisme;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateObtention;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateExpiration;

  private String lienCredential;

  public CertificationCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CertificationCreate(Integer cvId, String nom, String organisme) {
    this.cvId = cvId;
    this.nom = nom;
    this.organisme = organisme;
  }

  public CertificationCreate cvId(Integer cvId) {
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

  public CertificationCreate nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  @NotNull 
  @Schema(name = "nom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public CertificationCreate organisme(String organisme) {
    this.organisme = organisme;
    return this;
  }

  /**
   * Get organisme
   * @return organisme
  */
  @NotNull 
  @Schema(name = "organisme", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organisme")
  public String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(String organisme) {
    this.organisme = organisme;
  }

  public CertificationCreate dateObtention(LocalDate dateObtention) {
    this.dateObtention = dateObtention;
    return this;
  }

  /**
   * Get dateObtention
   * @return dateObtention
  */
  @Valid 
  @Schema(name = "dateObtention", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateObtention")
  public LocalDate getDateObtention() {
    return dateObtention;
  }

  public void setDateObtention(LocalDate dateObtention) {
    this.dateObtention = dateObtention;
  }

  public CertificationCreate dateExpiration(LocalDate dateExpiration) {
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
  public LocalDate getDateExpiration() {
    return dateExpiration;
  }

  public void setDateExpiration(LocalDate dateExpiration) {
    this.dateExpiration = dateExpiration;
  }

  public CertificationCreate lienCredential(String lienCredential) {
    this.lienCredential = lienCredential;
    return this;
  }

  /**
   * Get lienCredential
   * @return lienCredential
  */
  
  @Schema(name = "lienCredential", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lienCredential")
  public String getLienCredential() {
    return lienCredential;
  }

  public void setLienCredential(String lienCredential) {
    this.lienCredential = lienCredential;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificationCreate certificationCreate = (CertificationCreate) o;
    return Objects.equals(this.cvId, certificationCreate.cvId) &&
        Objects.equals(this.nom, certificationCreate.nom) &&
        Objects.equals(this.organisme, certificationCreate.organisme) &&
        Objects.equals(this.dateObtention, certificationCreate.dateObtention) &&
        Objects.equals(this.dateExpiration, certificationCreate.dateExpiration) &&
        Objects.equals(this.lienCredential, certificationCreate.lienCredential);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, nom, organisme, dateObtention, dateExpiration, lienCredential);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificationCreate {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    organisme: ").append(toIndentedString(organisme)).append("\n");
    sb.append("    dateObtention: ").append(toIndentedString(dateObtention)).append("\n");
    sb.append("    dateExpiration: ").append(toIndentedString(dateExpiration)).append("\n");
    sb.append("    lienCredential: ").append(toIndentedString(lienCredential)).append("\n");
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

