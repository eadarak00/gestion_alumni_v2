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
 * ExperienceRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T15:53:54.746111Z[Africa/Dakar]")
public class ExperienceRequest {

  private Integer cvId;

  private String poste;

  private String entreprise;

  private String localisation;

  private String dateDebut;

  private String dateFin;

  private Boolean enCours;

  private String description;

  public ExperienceRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ExperienceRequest(Integer cvId, String poste, String entreprise, String dateDebut) {
    this.cvId = cvId;
    this.poste = poste;
    this.entreprise = entreprise;
    this.dateDebut = dateDebut;
  }

  public ExperienceRequest cvId(Integer cvId) {
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

  public ExperienceRequest poste(String poste) {
    this.poste = poste;
    return this;
  }

  /**
   * Get poste
   * @return poste
  */
  @NotNull @Size(min = 2, max = 100) 
  @Schema(name = "poste", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("poste")
  public String getPoste() {
    return poste;
  }

  public void setPoste(String poste) {
    this.poste = poste;
  }

  public ExperienceRequest entreprise(String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Get entreprise
   * @return entreprise
  */
  @NotNull @Size(min = 2, max = 100) 
  @Schema(name = "entreprise", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("entreprise")
  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public ExperienceRequest localisation(String localisation) {
    this.localisation = localisation;
    return this;
  }

  /**
   * Get localisation
   * @return localisation
  */
  @Size(max = 100) 
  @Schema(name = "localisation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("localisation")
  public String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(String localisation) {
    this.localisation = localisation;
  }

  public ExperienceRequest dateDebut(String dateDebut) {
    this.dateDebut = dateDebut;
    return this;
  }

  /**
   * Get dateDebut
   * @return dateDebut
  */
  @NotNull 
  @Schema(name = "dateDebut", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateDebut")
  public String getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(String dateDebut) {
    this.dateDebut = dateDebut;
  }

  public ExperienceRequest dateFin(String dateFin) {
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

  public ExperienceRequest enCours(Boolean enCours) {
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

  public ExperienceRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @Size(max = 2000) 
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExperienceRequest experienceRequest = (ExperienceRequest) o;
    return Objects.equals(this.cvId, experienceRequest.cvId) &&
        Objects.equals(this.poste, experienceRequest.poste) &&
        Objects.equals(this.entreprise, experienceRequest.entreprise) &&
        Objects.equals(this.localisation, experienceRequest.localisation) &&
        Objects.equals(this.dateDebut, experienceRequest.dateDebut) &&
        Objects.equals(this.dateFin, experienceRequest.dateFin) &&
        Objects.equals(this.enCours, experienceRequest.enCours) &&
        Objects.equals(this.description, experienceRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, poste, entreprise, localisation, dateDebut, dateFin, enCours, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExperienceRequest {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    poste: ").append(toIndentedString(poste)).append("\n");
    sb.append("    entreprise: ").append(toIndentedString(entreprise)).append("\n");
    sb.append("    localisation: ").append(toIndentedString(localisation)).append("\n");
    sb.append("    dateDebut: ").append(toIndentedString(dateDebut)).append("\n");
    sb.append("    dateFin: ").append(toIndentedString(dateFin)).append("\n");
    sb.append("    enCours: ").append(toIndentedString(enCours)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

