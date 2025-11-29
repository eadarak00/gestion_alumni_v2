package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uasz.alumni.spi.model.SuggestionsResponseDTOSuggestionsInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SuggestionsResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T08:40:07.510076584Z[Africa/Dakar]")
public class SuggestionsResponseDTO {

  private String query;

  private String field;

  @Valid
  private List<@Valid SuggestionsResponseDTOSuggestionsInner> suggestions;

  private Integer count;

  private Integer executionTime;

  public SuggestionsResponseDTO query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
  */
  
  @Schema(name = "query", example = "mam", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("query")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public SuggestionsResponseDTO field(String field) {
    this.field = field;
    return this;
  }

  /**
   * Get field
   * @return field
  */
  
  @Schema(name = "field", example = "nom", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("field")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public SuggestionsResponseDTO suggestions(List<@Valid SuggestionsResponseDTOSuggestionsInner> suggestions) {
    this.suggestions = suggestions;
    return this;
  }

  public SuggestionsResponseDTO addSuggestionsItem(SuggestionsResponseDTOSuggestionsInner suggestionsItem) {
    if (this.suggestions == null) {
      this.suggestions = new ArrayList<>();
    }
    this.suggestions.add(suggestionsItem);
    return this;
  }

  /**
   * Get suggestions
   * @return suggestions
  */
  @Valid 
  @Schema(name = "suggestions", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("suggestions")
  public List<@Valid SuggestionsResponseDTOSuggestionsInner> getSuggestions() {
    return suggestions;
  }

  public void setSuggestions(List<@Valid SuggestionsResponseDTOSuggestionsInner> suggestions) {
    this.suggestions = suggestions;
  }

  public SuggestionsResponseDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
  */
  
  @Schema(name = "count", example = "2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public SuggestionsResponseDTO executionTime(Integer executionTime) {
    this.executionTime = executionTime;
    return this;
  }

  /**
   * Get executionTime
   * @return executionTime
  */
  
  @Schema(name = "executionTime", example = "45", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("executionTime")
  public Integer getExecutionTime() {
    return executionTime;
  }

  public void setExecutionTime(Integer executionTime) {
    this.executionTime = executionTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuggestionsResponseDTO suggestionsResponseDTO = (SuggestionsResponseDTO) o;
    return Objects.equals(this.query, suggestionsResponseDTO.query) &&
        Objects.equals(this.field, suggestionsResponseDTO.field) &&
        Objects.equals(this.suggestions, suggestionsResponseDTO.suggestions) &&
        Objects.equals(this.count, suggestionsResponseDTO.count) &&
        Objects.equals(this.executionTime, suggestionsResponseDTO.executionTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, field, suggestions, count, executionTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuggestionsResponseDTO {\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    suggestions: ").append(toIndentedString(suggestions)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    executionTime: ").append(toIndentedString(executionTime)).append("\n");
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

