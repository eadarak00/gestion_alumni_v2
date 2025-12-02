package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * LangueCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:08:49.971400101Z[Africa/Dakar]")
public class LangueCreate {

  private Integer cvId;

  private String nom;

  /**
   * Gets or Sets niveau
   */
  public enum NiveauEnum {
    DEBUTANT("DEBUTANT"),
    
    INTERMEDIAIRE("INTERMEDIAIRE"),
    
    AVANCE("AVANCE"),
    
    COURANT("COURANT"),
    
    LANGUE_MATERNELLE("LANGUE_MATERNELLE");

    private String value;

    NiveauEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NiveauEnum fromValue(String value) {
      for (NiveauEnum b : NiveauEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private NiveauEnum niveau;

  public LangueCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LangueCreate(Integer cvId, String nom, NiveauEnum niveau) {
    this.cvId = cvId;
    this.nom = nom;
    this.niveau = niveau;
  }

  public LangueCreate cvId(Integer cvId) {
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

  public LangueCreate nom(String nom) {
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

  public LangueCreate niveau(NiveauEnum niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  @NotNull 
  @Schema(name = "niveau", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("niveau")
  public NiveauEnum getNiveau() {
    return niveau;
  }

  public void setNiveau(NiveauEnum niveau) {
    this.niveau = niveau;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LangueCreate langueCreate = (LangueCreate) o;
    return Objects.equals(this.cvId, langueCreate.cvId) &&
        Objects.equals(this.nom, langueCreate.nom) &&
        Objects.equals(this.niveau, langueCreate.niveau);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, nom, niveau);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LangueCreate {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
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

