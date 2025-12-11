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
 * Données du rôle à créer
 */

@Schema(name = "RoleRequestDTO", description = "Données du rôle à créer")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T09:56:07.154792300Z[Etc/UTC]")
public class RoleRequestDTO {

  /**
   * Libellé unique du rôle. Doit contenir uniquement des lettres majuscules et des underscores.
   */
  public enum LibelleEnum {
    ADMIN("ADMIN"),
    
    ALUMNI("ALUMNI"),
    
    ETUDIANT("ETUDIANT");

    private String value;

    LibelleEnum(String value) {
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
    public static LibelleEnum fromValue(String value) {
      for (LibelleEnum b : LibelleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private LibelleEnum libelle;

  public RoleRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RoleRequestDTO(LibelleEnum libelle) {
    this.libelle = libelle;
  }

  public RoleRequestDTO libelle(LibelleEnum libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * Libellé unique du rôle. Doit contenir uniquement des lettres majuscules et des underscores.
   * @return libelle
  */
  @NotNull @Pattern(regexp = "^[A-Z_]+$") @Size(min = 2, max = 50) 
  @Schema(name = "libelle", example = "ADMIN", description = "Libellé unique du rôle. Doit contenir uniquement des lettres majuscules et des underscores.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("libelle")
  public LibelleEnum getLibelle() {
    return libelle;
  }

  public void setLibelle(LibelleEnum libelle) {
    this.libelle = libelle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleRequestDTO roleRequestDTO = (RoleRequestDTO) o;
    return Objects.equals(this.libelle, roleRequestDTO.libelle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(libelle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleRequestDTO {\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
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

