package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import uasz.alumni.spi.model.Langues;
import uasz.alumni.spi.model.NiveauLangue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * LangueParleesRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-05T02:02:10.601143888Z[Africa/Dakar]")
public class LangueParleesRequest {

  private Integer cvId;

  private Langues langue;

  private NiveauLangue niveau;

  public LangueParleesRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LangueParleesRequest(Integer cvId, Langues langue, NiveauLangue niveau) {
    this.cvId = cvId;
    this.langue = langue;
    this.niveau = niveau;
  }

  public LangueParleesRequest cvId(Integer cvId) {
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

  public LangueParleesRequest langue(Langues langue) {
    this.langue = langue;
    return this;
  }

  /**
   * Get langue
   * @return langue
  */
  @NotNull @Valid 
  @Schema(name = "langue", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("langue")
  public Langues getLangue() {
    return langue;
  }

  public void setLangue(Langues langue) {
    this.langue = langue;
  }

  public LangueParleesRequest niveau(NiveauLangue niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  @NotNull @Valid 
  @Schema(name = "niveau", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("niveau")
  public NiveauLangue getNiveau() {
    return niveau;
  }

  public void setNiveau(NiveauLangue niveau) {
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
    LangueParleesRequest langueParleesRequest = (LangueParleesRequest) o;
    return Objects.equals(this.cvId, langueParleesRequest.cvId) &&
        Objects.equals(this.langue, langueParleesRequest.langue) &&
        Objects.equals(this.niveau, langueParleesRequest.niveau);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cvId, langue, niveau);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LangueParleesRequest {\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    langue: ").append(toIndentedString(langue)).append("\n");
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

