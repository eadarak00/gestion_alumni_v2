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
 * RoleRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T11:28:05.959343872Z[Africa/Dakar]")
public class RoleRequestDTO {

  private String libelle;

  public RoleRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RoleRequestDTO(String libelle) {
    this.libelle = libelle;
  }

  public RoleRequestDTO libelle(String libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * Libellé du rôle (majuscules et underscores uniquement)
   * @return libelle
  */
  @NotNull @Pattern(regexp = "^[A-Z_]+$") @Size(min = 2, max = 50) 
  @Schema(name = "libelle", example = "ADMIN", description = "Libellé du rôle (majuscules et underscores uniquement)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("libelle")
  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
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

