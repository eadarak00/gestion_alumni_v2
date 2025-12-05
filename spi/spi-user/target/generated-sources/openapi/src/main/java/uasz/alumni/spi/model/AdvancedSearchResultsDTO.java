package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uasz.alumni.spi.model.AdvancedSearchRequestDTO;
import uasz.alumni.spi.model.AdvancedSearchResultsDTOPagination;
import uasz.alumni.spi.model.AlumniSearchResultDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdvancedSearchResultsDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-04T15:56:29.254042115Z[Etc/UTC]")
public class AdvancedSearchResultsDTO {

  private AdvancedSearchRequestDTO query;

  @Valid
  private List<@Valid AlumniSearchResultDTO> results;

  private AdvancedSearchResultsDTOPagination pagination;

  private Integer executionTime;

  public AdvancedSearchResultsDTO query(AdvancedSearchRequestDTO query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
  */
  @Valid 
  @Schema(name = "query", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("query")
  public AdvancedSearchRequestDTO getQuery() {
    return query;
  }

  public void setQuery(AdvancedSearchRequestDTO query) {
    this.query = query;
  }

  public AdvancedSearchResultsDTO results(List<@Valid AlumniSearchResultDTO> results) {
    this.results = results;
    return this;
  }

  public AdvancedSearchResultsDTO addResultsItem(AlumniSearchResultDTO resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  */
  @Valid 
  @Schema(name = "results", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("results")
  public List<@Valid AlumniSearchResultDTO> getResults() {
    return results;
  }

  public void setResults(List<@Valid AlumniSearchResultDTO> results) {
    this.results = results;
  }

  public AdvancedSearchResultsDTO pagination(AdvancedSearchResultsDTOPagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
  */
  @Valid 
  @Schema(name = "pagination", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pagination")
  public AdvancedSearchResultsDTOPagination getPagination() {
    return pagination;
  }

  public void setPagination(AdvancedSearchResultsDTOPagination pagination) {
    this.pagination = pagination;
  }

  public AdvancedSearchResultsDTO executionTime(Integer executionTime) {
    this.executionTime = executionTime;
    return this;
  }

  /**
   * Get executionTime
   * @return executionTime
  */
  
  @Schema(name = "executionTime", example = "185", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    AdvancedSearchResultsDTO advancedSearchResultsDTO = (AdvancedSearchResultsDTO) o;
    return Objects.equals(this.query, advancedSearchResultsDTO.query) &&
        Objects.equals(this.results, advancedSearchResultsDTO.results) &&
        Objects.equals(this.pagination, advancedSearchResultsDTO.pagination) &&
        Objects.equals(this.executionTime, advancedSearchResultsDTO.executionTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, results, pagination, executionTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvancedSearchResultsDTO {\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

