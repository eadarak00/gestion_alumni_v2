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
 * EtudiantProfilRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T13:41:16.508887909Z[Africa/Dakar]")
public class EtudiantProfilRequestDTO {

  private String numeroEtudiant;

  private String filiere;

  private String niveau;

  public EtudiantProfilRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EtudiantProfilRequestDTO(String numeroEtudiant, String filiere, String niveau) {
    this.numeroEtudiant = numeroEtudiant;
    this.filiere = filiere;
    this.niveau = niveau;
  }

  public EtudiantProfilRequestDTO numeroEtudiant(String numeroEtudiant) {
    this.numeroEtudiant = numeroEtudiant;
    return this;
  }

  /**
   * Numéro de carte étudiant (8 à 10 chiffres)
   * @return numeroEtudiant
  */
  @NotNull @Pattern(regexp = "^\\d{8,10}$") 
  @Schema(name = "numeroEtudiant", example = "12345678", description = "Numéro de carte étudiant (8 à 10 chiffres)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroEtudiant")
  public String getNumeroEtudiant() {
    return numeroEtudiant;
  }

  public void setNumeroEtudiant(String numeroEtudiant) {
    this.numeroEtudiant = numeroEtudiant;
  }

  public EtudiantProfilRequestDTO filiere(String filiere) {
    this.filiere = filiere;
    return this;
  }

  /**
   * Filière d'études
   * @return filiere
  */
  @NotNull 
  @Schema(name = "filiere", example = "Informatique", description = "Filière d'études", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("filiere")
  public String getFiliere() {
    return filiere;
  }

  public void setFiliere(String filiere) {
    this.filiere = filiere;
  }

  public EtudiantProfilRequestDTO niveau(String niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Niveau d'études
   * @return niveau
  */
  @NotNull 
  @Schema(name = "niveau", example = "MASTER", description = "Niveau d'études", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("niveau")
  public String getNiveau() {
    return niveau;
  }

  public void setNiveau(String niveau) {
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
    EtudiantProfilRequestDTO etudiantProfilRequestDTO = (EtudiantProfilRequestDTO) o;
    return Objects.equals(this.numeroEtudiant, etudiantProfilRequestDTO.numeroEtudiant) &&
        Objects.equals(this.filiere, etudiantProfilRequestDTO.filiere) &&
        Objects.equals(this.niveau, etudiantProfilRequestDTO.niveau);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroEtudiant, filiere, niveau);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EtudiantProfilRequestDTO {\n");
    sb.append("    numeroEtudiant: ").append(toIndentedString(numeroEtudiant)).append("\n");
    sb.append("    filiere: ").append(toIndentedString(filiere)).append("\n");
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

