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
 * Competence
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T13:19:18.635045928Z[Africa/Dakar]")
public class Competence {

  private Integer id;

  private Integer cvId;

  private String nom;

  /**
   * Gets or Sets niveau
   */
  public enum NiveauEnum {
    DEBUTANT("DEBUTANT"),
    
    INTERMEDIAIRE("INTERMEDIAIRE"),
    
    AVANCE("AVANCE"),
    
    EXPERT("EXPERT");

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

  private String categorie;

  public Competence id(Integer id) {
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

  public Competence cvId(Integer cvId) {
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

  public Competence nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  
  @Schema(name = "nom", example = "Java", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Competence niveau(NiveauEnum niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  
  @Schema(name = "niveau", example = "AVANCE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("niveau")
  public NiveauEnum getNiveau() {
    return niveau;
  }

  public void setNiveau(NiveauEnum niveau) {
    this.niveau = niveau;
  }

  public Competence categorie(String categorie) {
    this.categorie = categorie;
    return this;
  }

  /**
   * Get categorie
   * @return categorie
  */
  
  @Schema(name = "categorie", example = "Langage de programmation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categorie")
  public String getCategorie() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Competence competence = (Competence) o;
    return Objects.equals(this.id, competence.id) &&
        Objects.equals(this.cvId, competence.cvId) &&
        Objects.equals(this.nom, competence.nom) &&
        Objects.equals(this.niveau, competence.niveau) &&
        Objects.equals(this.categorie, competence.categorie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, nom, niveau, categorie);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Competence {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    categorie: ").append(toIndentedString(categorie)).append("\n");
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

