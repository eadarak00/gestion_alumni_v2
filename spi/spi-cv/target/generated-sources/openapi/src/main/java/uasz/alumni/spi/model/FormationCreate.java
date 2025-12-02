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
 * FormationCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:08:49.971400101Z[Africa/Dakar]")
public class FormationCreate {

  private Integer cvId;

  private String diplome;

  private String etablissement;

  private String localisation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateDebut;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateFin;

  private Boolean enCours = false;

  private String description;

  public FormationCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormationCreate(Integer cvId, String diplome, String etablissement, LocalDate dateDebut) {
    this.cvId = cvId;
    this.diplome = diplome;
    this.etablissement = etablissement;
    this.dateDebut = dateDebut;
  }

  public FormationCreate cvId(Integer cvId) {
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

  public FormationCreate diplome(String diplome) {
    this.diplome = diplome;
    return this;
  }

  /**
   * Get diplome
   * @return diplome
  */
  @NotNull 
  @Schema(name = "diplome", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("diplome")
  public String getDiplome() {
    return diplome;
  }

  public void setDiplome(String diplome) {
    this.diplome = diplome;
  }

  public FormationCreate etablissement(String etablissement) {
    this.etablissement = etablissement;
    return this;
  }

  /**
   * Get etablissement
   * @return etablissement
  */
  @NotNull 
  @Schema(name = "etablissement", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("etablissement")
  public String getEtablissement() {
    return etablissement;
  }

  public void setEtablissement(String etablissement) {
    this.etablissement = etablissement;
  }

  public FormationCreate localisation(String localisation) {
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

  public FormationCreate dateDebut(LocalDate dateDebut) {
    this.dateDebut = dateDebut;
    return this;
  }

  /**
   * Get dateDebut
   * @return dateDebut
  */
  @NotNull @Valid 
  @Schema(name = "dateDebut", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateDebut")
  public LocalDate getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(LocalDate dateDebut) {
    this.dateDebut = dateDebut;
  }

  public FormationCreate dateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
    return this;
  }

  /**
   * Get dateFin
   * @return dateFin
  */
  @Valid 
  @Schema(name = "dateFin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateFin")
  public LocalDate getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
  }

  public FormationCreate enCours(Boolean enCours) {
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

  public FormationCreate description(String description) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormationCreate formationCreate = (FormationCreate) o;
    return Objects.equals(this.cvId, formationCreate.cvId) &&
        Objects.equals(this.diplome, formationCreate.diplome) &&
        Objects.equals(this.etablissement, formationCreate.etablissement) &&
        Objects.equals(this.localisation, formationCreate.localisation) &&
        Objects.equals(this.dateDebut, formationCreate.dateDebut) &&
        Objects.equals(this.dateFin, formationCreate.dateFin) &&
        Objects.equals(this.enCours, formationCreate.enCours) &&
        Objects.equals(this.description, formationCreate.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, diplome, etablissement, localisation, dateDebut, dateFin, enCours, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormationCreate {\n");
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

