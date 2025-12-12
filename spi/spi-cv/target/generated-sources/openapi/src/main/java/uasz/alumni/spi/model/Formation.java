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
 * Formation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-10T22:49:19.435775471Z[Africa/Dakar]")
public class Formation {

  private Integer id;

  private Integer cvId;

  private String diplome;

  private String etablissement;

  private String localisation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateDebut;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateFin;

  private Boolean enCours;

  private String description;

  public Formation id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Formation cvId(Integer cvId) {
    this.cvId = cvId;
    return this;
  }

  /**
   * Get cvId
   * @return cvId
  */
  
  @Schema(name = "cvId", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cvId")
  public Integer getCvId() {
    return cvId;
  }

  public void setCvId(Integer cvId) {
    this.cvId = cvId;
  }

  public Formation diplome(String diplome) {
    this.diplome = diplome;
    return this;
  }

  /**
   * Get diplome
   * @return diplome
  */
  
  @Schema(name = "diplome", example = "Licence en Informatique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("diplome")
  public String getDiplome() {
    return diplome;
  }

  public void setDiplome(String diplome) {
    this.diplome = diplome;
  }

  public Formation etablissement(String etablissement) {
    this.etablissement = etablissement;
    return this;
  }

  /**
   * Get etablissement
   * @return etablissement
  */
  
  @Schema(name = "etablissement", example = "UASZ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("etablissement")
  public String getEtablissement() {
    return etablissement;
  }

  public void setEtablissement(String etablissement) {
    this.etablissement = etablissement;
  }

  public Formation localisation(String localisation) {
    this.localisation = localisation;
    return this;
  }

  /**
   * Get localisation
   * @return localisation
  */
  
  @Schema(name = "localisation", example = "Ziguinchor, Sénégal", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("localisation")
  public String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(String localisation) {
    this.localisation = localisation;
  }

  public Formation dateDebut(LocalDate dateDebut) {
    this.dateDebut = dateDebut;
    return this;
  }

  /**
   * Get dateDebut
   * @return dateDebut
  */
  @Valid 
  @Schema(name = "dateDebut", example = "Thu Oct 01 00:00:00 GMT 2015", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateDebut")
  public LocalDate getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(LocalDate dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Formation dateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
    return this;
  }

  /**
   * Get dateFin
   * @return dateFin
  */
  @Valid 
  @Schema(name = "dateFin", example = "Mon Jul 30 00:00:00 GMT 2018", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateFin")
  public LocalDate getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
  }

  public Formation enCours(Boolean enCours) {
    this.enCours = enCours;
    return this;
  }

  /**
   * Get enCours
   * @return enCours
  */
  
  @Schema(name = "enCours", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enCours")
  public Boolean getEnCours() {
    return enCours;
  }

  public void setEnCours(Boolean enCours) {
    this.enCours = enCours;
  }

  public Formation description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", example = "Formation en développement logiciel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    Formation formation = (Formation) o;
    return Objects.equals(this.id, formation.id) &&
        Objects.equals(this.cvId, formation.cvId) &&
        Objects.equals(this.diplome, formation.diplome) &&
        Objects.equals(this.etablissement, formation.etablissement) &&
        Objects.equals(this.localisation, formation.localisation) &&
        Objects.equals(this.dateDebut, formation.dateDebut) &&
        Objects.equals(this.dateFin, formation.dateFin) &&
        Objects.equals(this.enCours, formation.enCours) &&
        Objects.equals(this.description, formation.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, diplome, etablissement, localisation, dateDebut, dateFin, enCours, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Formation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

