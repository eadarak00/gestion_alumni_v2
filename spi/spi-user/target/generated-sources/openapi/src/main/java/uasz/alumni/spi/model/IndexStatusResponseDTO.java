package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import uasz.alumni.spi.model.IndexStatusResponseDTOCurrentJob;
import uasz.alumni.spi.model.IndexStatusResponseDTOStatistics;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndexStatusResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:07:51.481060929Z[Africa/Dakar]")
public class IndexStatusResponseDTO {

  private String status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastIndexedAt;

  private Integer documentsCount;

  private String indexSize;

  private IndexStatusResponseDTOStatistics statistics;

  private IndexStatusResponseDTOCurrentJob currentJob;

  public IndexStatusResponseDTO status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", example = "HEALTHY", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public IndexStatusResponseDTO lastIndexedAt(OffsetDateTime lastIndexedAt) {
    this.lastIndexedAt = lastIndexedAt;
    return this;
  }

  /**
   * Get lastIndexedAt
   * @return lastIndexedAt
  */
  @Valid 
  @Schema(name = "lastIndexedAt", example = "2025-11-26T08:00Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastIndexedAt")
  public OffsetDateTime getLastIndexedAt() {
    return lastIndexedAt;
  }

  public void setLastIndexedAt(OffsetDateTime lastIndexedAt) {
    this.lastIndexedAt = lastIndexedAt;
  }

  public IndexStatusResponseDTO documentsCount(Integer documentsCount) {
    this.documentsCount = documentsCount;
    return this;
  }

  /**
   * Get documentsCount
   * @return documentsCount
  */
  
  @Schema(name = "documentsCount", example = "1250", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("documentsCount")
  public Integer getDocumentsCount() {
    return documentsCount;
  }

  public void setDocumentsCount(Integer documentsCount) {
    this.documentsCount = documentsCount;
  }

  public IndexStatusResponseDTO indexSize(String indexSize) {
    this.indexSize = indexSize;
    return this;
  }

  /**
   * Get indexSize
   * @return indexSize
  */
  
  @Schema(name = "indexSize", example = "45.2 MB", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("indexSize")
  public String getIndexSize() {
    return indexSize;
  }

  public void setIndexSize(String indexSize) {
    this.indexSize = indexSize;
  }

  public IndexStatusResponseDTO statistics(IndexStatusResponseDTOStatistics statistics) {
    this.statistics = statistics;
    return this;
  }

  /**
   * Get statistics
   * @return statistics
  */
  @Valid 
  @Schema(name = "statistics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statistics")
  public IndexStatusResponseDTOStatistics getStatistics() {
    return statistics;
  }

  public void setStatistics(IndexStatusResponseDTOStatistics statistics) {
    this.statistics = statistics;
  }

  public IndexStatusResponseDTO currentJob(IndexStatusResponseDTOCurrentJob currentJob) {
    this.currentJob = currentJob;
    return this;
  }

  /**
   * Get currentJob
   * @return currentJob
  */
  @Valid 
  @Schema(name = "currentJob", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentJob")
  public IndexStatusResponseDTOCurrentJob getCurrentJob() {
    return currentJob;
  }

  public void setCurrentJob(IndexStatusResponseDTOCurrentJob currentJob) {
    this.currentJob = currentJob;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexStatusResponseDTO indexStatusResponseDTO = (IndexStatusResponseDTO) o;
    return Objects.equals(this.status, indexStatusResponseDTO.status) &&
        Objects.equals(this.lastIndexedAt, indexStatusResponseDTO.lastIndexedAt) &&
        Objects.equals(this.documentsCount, indexStatusResponseDTO.documentsCount) &&
        Objects.equals(this.indexSize, indexStatusResponseDTO.indexSize) &&
        Objects.equals(this.statistics, indexStatusResponseDTO.statistics) &&
        Objects.equals(this.currentJob, indexStatusResponseDTO.currentJob);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, lastIndexedAt, documentsCount, indexSize, statistics, currentJob);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexStatusResponseDTO {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    lastIndexedAt: ").append(toIndentedString(lastIndexedAt)).append("\n");
    sb.append("    documentsCount: ").append(toIndentedString(documentsCount)).append("\n");
    sb.append("    indexSize: ").append(toIndentedString(indexSize)).append("\n");
    sb.append("    statistics: ").append(toIndentedString(statistics)).append("\n");
    sb.append("    currentJob: ").append(toIndentedString(currentJob)).append("\n");
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

