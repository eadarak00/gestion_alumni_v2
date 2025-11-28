package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uasz.alumni.spi.model.AdvancedSearchRequestDTOFilters;
import uasz.alumni.spi.model.AdvancedSearchRequestDTOPagination;
import uasz.alumni.spi.model.AdvancedSearchRequestDTOSortInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdvancedSearchRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-28T23:40:28.904143835Z[Africa/Dakar]")
public class AdvancedSearchRequestDTO {

  private String text;

  private AdvancedSearchRequestDTOFilters filters;

  @Valid
  private List<@Valid AdvancedSearchRequestDTOSortInner> sort;

  private AdvancedSearchRequestDTOPagination pagination;

  public AdvancedSearchRequestDTO text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  */
  
  @Schema(name = "text", example = "développeur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("text")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public AdvancedSearchRequestDTO filters(AdvancedSearchRequestDTOFilters filters) {
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
  public AdvancedSearchRequestDTOFilters getFilters() {
    return filters;
  }

  public void setFilters(AdvancedSearchRequestDTOFilters filters) {
    this.filters = filters;
  }

  public AdvancedSearchRequestDTO sort(List<@Valid AdvancedSearchRequestDTOSortInner> sort) {
    this.sort = sort;
    return this;
  }

  public AdvancedSearchRequestDTO addSortItem(AdvancedSearchRequestDTOSortInner sortItem) {
    if (this.sort == null) {
      this.sort = new ArrayList<>();
    }
    this.sort.add(sortItem);
    return this;
  }

  /**
   * Get sort
   * @return sort
  */
  @Valid 
  @Schema(name = "sort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sort")
  public List<@Valid AdvancedSearchRequestDTOSortInner> getSort() {
    return sort;
  }

  public void setSort(List<@Valid AdvancedSearchRequestDTOSortInner> sort) {
    this.sort = sort;
  }

  public AdvancedSearchRequestDTO pagination(AdvancedSearchRequestDTOPagination pagination) {
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
  public AdvancedSearchRequestDTOPagination getPagination() {
    return pagination;
  }

  public void setPagination(AdvancedSearchRequestDTOPagination pagination) {
    this.pagination = pagination;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvancedSearchRequestDTO advancedSearchRequestDTO = (AdvancedSearchRequestDTO) o;
    return Objects.equals(this.text, advancedSearchRequestDTO.text) &&
        Objects.equals(this.filters, advancedSearchRequestDTO.filters) &&
        Objects.equals(this.sort, advancedSearchRequestDTO.sort) &&
        Objects.equals(this.pagination, advancedSearchRequestDTO.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, filters, sort, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvancedSearchRequestDTO {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

