package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uasz.alumni.spi.model.UtilisateurResponseDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetAllUtilisateursFiltered200Response
 */

@JsonTypeName("getAllUtilisateursFiltered_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-29T15:17:49.845979476Z[Africa/Dakar]")
public class GetAllUtilisateursFiltered200Response {

  @Valid
  private List<@Valid UtilisateurResponseDTO> content;

  private Integer totalElements;

  private Integer totalPages;

  private Integer size;

  private Integer number;

  public GetAllUtilisateursFiltered200Response content(List<@Valid UtilisateurResponseDTO> content) {
    this.content = content;
    return this;
  }

  public GetAllUtilisateursFiltered200Response addContentItem(UtilisateurResponseDTO contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Get content
   * @return content
  */
  @Valid 
  @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("content")
  public List<@Valid UtilisateurResponseDTO> getContent() {
    return content;
  }

  public void setContent(List<@Valid UtilisateurResponseDTO> content) {
    this.content = content;
  }

  public GetAllUtilisateursFiltered200Response totalElements(Integer totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
  */
  
  @Schema(name = "totalElements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalElements")
  public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public GetAllUtilisateursFiltered200Response totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  
  @Schema(name = "totalPages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public GetAllUtilisateursFiltered200Response size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
  */
  
  @Schema(name = "size", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public GetAllUtilisateursFiltered200Response number(Integer number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  
  @Schema(name = "number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAllUtilisateursFiltered200Response getAllUtilisateursFiltered200Response = (GetAllUtilisateursFiltered200Response) o;
    return Objects.equals(this.content, getAllUtilisateursFiltered200Response.content) &&
        Objects.equals(this.totalElements, getAllUtilisateursFiltered200Response.totalElements) &&
        Objects.equals(this.totalPages, getAllUtilisateursFiltered200Response.totalPages) &&
        Objects.equals(this.size, getAllUtilisateursFiltered200Response.size) &&
        Objects.equals(this.number, getAllUtilisateursFiltered200Response.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, totalPages, size, number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAllUtilisateursFiltered200Response {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

