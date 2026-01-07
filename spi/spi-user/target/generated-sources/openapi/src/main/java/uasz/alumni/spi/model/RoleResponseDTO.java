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
 * RoleResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-16T20:10:41.247958539Z[Africa/Dakar]")
public class RoleResponseDTO {

  private Long id;

  private String libelle;

  private Boolean deleted;

  public RoleResponseDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identifiant unique du rôle
   * @return id
  */
  
  @Schema(name = "id", example = "1", description = "Identifiant unique du rôle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RoleResponseDTO libelle(String libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * Libellé du rôle
   * @return libelle
  */
  
  @Schema(name = "libelle", example = "ADMIN", description = "Libellé du rôle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("libelle")
  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public RoleResponseDTO deleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * Indique si le rôle est supprimé
   * @return deleted
  */
  
  @Schema(name = "deleted", example = "false", description = "Indique si le rôle est supprimé", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deleted")
  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleResponseDTO roleResponseDTO = (RoleResponseDTO) o;
    return Objects.equals(this.id, roleResponseDTO.id) &&
        Objects.equals(this.libelle, roleResponseDTO.libelle) &&
        Objects.equals(this.deleted, roleResponseDTO.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, libelle, deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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

