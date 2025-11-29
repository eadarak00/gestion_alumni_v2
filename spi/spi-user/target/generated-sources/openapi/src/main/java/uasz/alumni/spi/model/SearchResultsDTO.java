package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uasz.alumni.spi.model.AlumniSearchResultDTO;
import uasz.alumni.spi.model.SearchResultsDTOFilters;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SearchResultsDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-29T08:40:07.510076584Z[Africa/Dakar]")
public class SearchResultsDTO {

  private String query;

  private SearchResultsDTOFilters filters;

  @Valid
  private List<@Valid AlumniSearchResultDTO> results;

  private Integer total;

  private Integer executionTime;

  public SearchResultsDTO query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
  */
  
  @Schema(name = "query", example = "informatique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("query")
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public SearchResultsDTO filters(SearchResultsDTOFilters filters) {
    this.filters = filters;
    return this;
  }

  /**
   * Get filters
   * @return filters
  */
  @Valid 
  @Schema(name = "filters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filters")
  public SearchResultsDTOFilters getFilters() {
    return filters;
  }

  public void setFilters(SearchResultsDTOFilters filters) {
    this.filters = filters;
  }

  public SearchResultsDTO results(List<@Valid AlumniSearchResultDTO> results) {
    this.results = results;
    return this;
  }

  public SearchResultsDTO addResultsItem(AlumniSearchResultDTO resultsItem) {
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

  public SearchResultsDTO total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  
  @Schema(name = "total", example = "2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public SearchResultsDTO executionTime(Integer executionTime) {
    this.executionTime = executionTime;
    return this;
  }

  /**
   * Get executionTime
   * @return executionTime
  */
  
  @Schema(name = "executionTime", example = "120", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    SearchResultsDTO searchResultsDTO = (SearchResultsDTO) o;
    return Objects.equals(this.query, searchResultsDTO.query) &&
        Objects.equals(this.filters, searchResultsDTO.filters) &&
        Objects.equals(this.results, searchResultsDTO.results) &&
        Objects.equals(this.total, searchResultsDTO.total) &&
        Objects.equals(this.executionTime, searchResultsDTO.executionTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, filters, results, total, executionTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResultsDTO {\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

