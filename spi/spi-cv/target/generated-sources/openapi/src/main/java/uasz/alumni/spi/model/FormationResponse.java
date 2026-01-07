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
 * FormationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T16:18:31.988765597Z[Africa/Dakar]")
public class FormationResponse {

  private Integer id;

  private Integer cvId;

  private String diplome;

  private String etablissement;

  private String localisation;

  private String dateDebut;

  private String dateFin;

  private Boolean enCours;

  private String description;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateDerniereModification;

  public FormationResponse id(Integer id) {
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

  public FormationResponse cvId(Integer cvId) {
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

  public FormationResponse diplome(String diplome) {
    this.diplome = diplome;
    return this;
  }

  /**
   * Get diplome
   * @return diplome
  */
  
  @Schema(name = "diplome", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("diplome")
  public String getDiplome() {
    return diplome;
  }

  public void setDiplome(String diplome) {
    this.diplome = diplome;
  }

  public FormationResponse etablissement(String etablissement) {
    this.etablissement = etablissement;
    return this;
  }

  /**
   * Get etablissement
   * @return etablissement
  */
  
  @Schema(name = "etablissement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("etablissement")
  public String getEtablissement() {
    return etablissement;
  }

  public void setEtablissement(String etablissement) {
    this.etablissement = etablissement;
  }

  public FormationResponse localisation(String localisation) {
    this.localisation = localisation;
    return this;
  }

  /**
   * Get localisation
   * @return localisation
  */
  
  @Schema(name = "localisation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("localisation")
  public String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(String localisation) {
    this.localisation = localisation;
  }

  public FormationResponse dateDebut(String dateDebut) {
    this.dateDebut = dateDebut;
    return this;
  }

  /**
   * Get dateDebut
   * @return dateDebut
  */
  
  @Schema(name = "dateDebut", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateDebut")
  public String getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(String dateDebut) {
    this.dateDebut = dateDebut;
  }

  public FormationResponse dateFin(String dateFin) {
    this.dateFin = dateFin;
    return this;
  }

  /**
   * Get dateFin
   * @return dateFin
  */
  
  @Schema(name = "dateFin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateFin")
  public String getDateFin() {
    return dateFin;
  }

  public void setDateFin(String dateFin) {
    this.dateFin = dateFin;
  }

  public FormationResponse enCours(Boolean enCours) {
    this.enCours = enCours;
    return this;
  }

  /**
   * Get enCours
   * @return enCours
  */
  
  @Schema(name = "enCours", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enCours")
  public Boolean getEnCours() {
    return enCours;
  }

  public void setEnCours(Boolean enCours) {
    this.enCours = enCours;
  }

  public FormationResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FormationResponse dateCreation(OffsetDateTime dateCreation) {
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

  public FormationResponse dateDerniereModification(OffsetDateTime dateDerniereModification) {
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
    FormationResponse formationResponse = (FormationResponse) o;
    return Objects.equals(this.id, formationResponse.id) &&
        Objects.equals(this.cvId, formationResponse.cvId) &&
        Objects.equals(this.diplome, formationResponse.diplome) &&
        Objects.equals(this.etablissement, formationResponse.etablissement) &&
        Objects.equals(this.localisation, formationResponse.localisation) &&
        Objects.equals(this.dateDebut, formationResponse.dateDebut) &&
        Objects.equals(this.dateFin, formationResponse.dateFin) &&
        Objects.equals(this.enCours, formationResponse.enCours) &&
        Objects.equals(this.description, formationResponse.description) &&
        Objects.equals(this.dateCreation, formationResponse.dateCreation) &&
        Objects.equals(this.dateDerniereModification, formationResponse.dateDerniereModification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, diplome, etablissement, localisation, dateDebut, dateFin, enCours, description, dateCreation, dateDerniereModification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormationResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    diplome: ").append(toIndentedString(diplome)).append("\n");
    sb.append("    etablissement: ").append(toIndentedString(etablissement)).append("\n");
    sb.append("    localisation: ").append(toIndentedString(localisation)).append("\n");
    sb.append("    dateDebut: ").append(toIndentedString(dateDebut)).append("\n");
    sb.append("    dateFin: ").append(toIndentedString(dateFin)).append("\n");
    sb.append("    enCours: ").append(toIndentedString(enCours)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

