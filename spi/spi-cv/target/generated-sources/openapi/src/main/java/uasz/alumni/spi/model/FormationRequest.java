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
 * FormationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-14T00:56:32.665681389Z[Africa/Dakar]")
public class FormationRequest {

  private Integer cvId;

  private String diplome;

  private String etablissement;

  private String localisation;

  private String dateDebut;

  private String dateFin;

  private Boolean enCours;

  private String description;

  public FormationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormationRequest(Integer cvId, String diplome, String etablissement, String dateDebut) {
    this.cvId = cvId;
    this.diplome = diplome;
    this.etablissement = etablissement;
    this.dateDebut = dateDebut;
  }

  public FormationRequest cvId(Integer cvId) {
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

  public FormationRequest diplome(String diplome) {
    this.diplome = diplome;
    return this;
  }

  /**
   * Get diplome
   * @return diplome
  */
  @NotNull @Size(min = 2, max = 150) 
  @Schema(name = "diplome", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("diplome")
  public String getDiplome() {
    return diplome;
  }

  public void setDiplome(String diplome) {
    this.diplome = diplome;
  }

  public FormationRequest etablissement(String etablissement) {
    this.etablissement = etablissement;
    return this;
  }

  /**
   * Get etablissement
   * @return etablissement
  */
  @NotNull @Size(min = 2, max = 150) 
  @Schema(name = "etablissement", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("etablissement")
  public String getEtablissement() {
    return etablissement;
  }

  public void setEtablissement(String etablissement) {
    this.etablissement = etablissement;
  }

  public FormationRequest localisation(String localisation) {
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

  public FormationRequest dateDebut(String dateDebut) {
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

  public FormationRequest dateFin(String dateFin) {
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

  public FormationRequest enCours(Boolean enCours) {
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

  public FormationRequest description(String description) {
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
    FormationRequest formationRequest = (FormationRequest) o;
    return Objects.equals(this.cvId, formationRequest.cvId) &&
        Objects.equals(this.diplome, formationRequest.diplome) &&
        Objects.equals(this.etablissement, formationRequest.etablissement) &&
        Objects.equals(this.localisation, formationRequest.localisation) &&
        Objects.equals(this.dateDebut, formationRequest.dateDebut) &&
        Objects.equals(this.dateFin, formationRequest.dateFin) &&
        Objects.equals(this.enCours, formationRequest.enCours) &&
        Objects.equals(this.description, formationRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, diplome, etablissement, localisation, dateDebut, dateFin, enCours, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormationRequest {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    diplome: ").append(toIndentedString(diplome)).append("\n");
    sb.append("    etablissement: ").append(toIndentedString(etablissement)).append("\n");
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

