package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdvancedSearchRequestDTOSortInner
 */

@JsonTypeName("AdvancedSearchRequestDTO_sort_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T22:57:30.862958208Z[Africa/Dakar]")
public class AdvancedSearchRequestDTOSortInner {

  private String field;

  private String order;

  public AdvancedSearchRequestDTOSortInner field(String field) {
    this.field = field;
    return this;
  }

  /**
   * Get field
   * @return field
  */
  
  @Schema(name = "field", example = "score", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("field")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public AdvancedSearchRequestDTOSortInner order(String order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  */
  
  @Schema(name = "order", example = "desc", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("order")
  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdvancedSearchRequestDTOSortInner advancedSearchRequestDTOSortInner = (AdvancedSearchRequestDTOSortInner) o;
    return Objects.equals(this.field, advancedSearchRequestDTOSortInner.field) &&
        Objects.equals(this.order, advancedSearchRequestDTOSortInner.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdvancedSearchRequestDTOSortInner {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

