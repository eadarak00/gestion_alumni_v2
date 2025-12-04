package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndexStatusResponseDTOCurrentJob
 */

@JsonTypeName("IndexStatusResponseDTO_currentJob")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T22:57:30.862958208Z[Africa/Dakar]")
public class IndexStatusResponseDTOCurrentJob {

  private String jobId;

  private String status;

  private Integer progress;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startedAt;

  public IndexStatusResponseDTOCurrentJob jobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

  /**
   * Get jobId
   * @return jobId
  */
  
  @Schema(name = "jobId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("jobId")
  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public IndexStatusResponseDTOCurrentJob status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public IndexStatusResponseDTOCurrentJob progress(Integer progress) {
    this.progress = progress;
    return this;
  }

  /**
   * Get progress
   * @return progress
  */
  
  @Schema(name = "progress", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("progress")
  public Integer getProgress() {
    return progress;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public IndexStatusResponseDTOCurrentJob startedAt(OffsetDateTime startedAt) {
    this.startedAt = startedAt;
    return this;
  }

  /**
   * Get startedAt
   * @return startedAt
  */
  @Valid 
  @Schema(name = "startedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startedAt")
  public OffsetDateTime getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(OffsetDateTime startedAt) {
    this.startedAt = startedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexStatusResponseDTOCurrentJob indexStatusResponseDTOCurrentJob = (IndexStatusResponseDTOCurrentJob) o;
    return Objects.equals(this.jobId, indexStatusResponseDTOCurrentJob.jobId) &&
        Objects.equals(this.status, indexStatusResponseDTOCurrentJob.status) &&
        Objects.equals(this.progress, indexStatusResponseDTOCurrentJob.progress) &&
        Objects.equals(this.startedAt, indexStatusResponseDTOCurrentJob.startedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, status, progress, startedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexStatusResponseDTOCurrentJob {\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
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

