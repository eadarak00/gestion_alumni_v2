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
 * Experience
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T09:55:58.495296900Z[Etc/UTC]")
public class Experience {

  private Integer id;

  private Integer cvId;

  private String poste;

  private String entreprise;

  private String localisation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateDebut;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateFin;

  private Boolean enCours;

  private String description;

  public Experience id(Integer id) {
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

  public Experience cvId(Integer cvId) {
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

  public Experience poste(String poste) {
    this.poste = poste;
    return this;
  }

  /**
   * Get poste
   * @return poste
  */
  
  @Schema(name = "poste", example = "Développeur Full Stack", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("poste")
  public String getPoste() {
    return poste;
  }

  public void setPoste(String poste) {
    this.poste = poste;
  }

  public Experience entreprise(String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Get entreprise
   * @return entreprise
  */
  
  @Schema(name = "entreprise", example = "Tech Company", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entreprise")
  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public Experience localisation(String localisation) {
    this.localisation = localisation;
    return this;
  }

  /**
   * Get localisation
   * @return localisation
  */
  
  @Schema(name = "localisation", example = "Dakar, Sénégal", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("localisation")
  public String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(String localisation) {
    this.localisation = localisation;
  }

  public Experience dateDebut(LocalDate dateDebut) {
    this.dateDebut = dateDebut;
    return this;
  }

  /**
   * Get dateDebut
   * @return dateDebut
  */
  @Valid 
  @Schema(name = "dateDebut", example = "Wed Jan 15 00:00:00 UTC 2020", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateDebut")
  public LocalDate getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(LocalDate dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Experience dateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
    return this;
  }

  /**
   * Get dateFin
   * @return dateFin
  */
  @Valid 
  @Schema(name = "dateFin", example = "Fri Jun 30 00:00:00 UTC 2023", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateFin")
  public LocalDate getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDate dateFin) {
    this.dateFin = dateFin;
  }

  public Experience enCours(Boolean enCours) {
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

  public Experience description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", example = "- Développement d'applications web - Gestion de bases de données", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    Experience experience = (Experience) o;
    return Objects.equals(this.id, experience.id) &&
        Objects.equals(this.cvId, experience.cvId) &&
        Objects.equals(this.poste, experience.poste) &&
        Objects.equals(this.entreprise, experience.entreprise) &&
        Objects.equals(this.localisation, experience.localisation) &&
        Objects.equals(this.dateDebut, experience.dateDebut) &&
        Objects.equals(this.dateFin, experience.dateFin) &&
        Objects.equals(this.enCours, experience.enCours) &&
        Objects.equals(this.description, experience.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, poste, entreprise, localisation, dateDebut, dateFin, enCours, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Experience {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

