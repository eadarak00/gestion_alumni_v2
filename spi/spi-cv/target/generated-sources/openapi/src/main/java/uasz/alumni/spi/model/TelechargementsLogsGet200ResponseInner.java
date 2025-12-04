package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * TelechargementsLogsGet200ResponseInner
 */

@JsonTypeName("_telechargements_logs_get_200_response_inner")
<<<<<<< HEAD
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T23:32:01.179463330Z[Africa/Dakar]")
=======
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T22:57:24.563704091Z[Africa/Dakar]")
>>>>>>> b68b570 (init ms-cv)
public class TelechargementsLogsGet200ResponseInner {

  private Integer id;

  private Integer cvId;

  private Integer telechargeurId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  /**
   * Gets or Sets format
   */
  public enum FormatEnum {
    PDF("PDF"),
    
    DOCX("DOCX");

    private String value;

    FormatEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FormatEnum fromValue(String value) {
      for (FormatEnum b : FormatEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private FormatEnum format;

  public TelechargementsLogsGet200ResponseInner id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TelechargementsLogsGet200ResponseInner cvId(Integer cvId) {
    this.cvId = cvId;
    return this;
  }

  /**
   * Get cvId
   * @return cvId
  */
  
  @Schema(name = "cvId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cvId")
  public Integer getCvId() {
    return cvId;
  }

  public void setCvId(Integer cvId) {
    this.cvId = cvId;
  }

  public TelechargementsLogsGet200ResponseInner telechargeurId(Integer telechargeurId) {
    this.telechargeurId = telechargeurId;
    return this;
  }

  /**
   * Get telechargeurId
   * @return telechargeurId
  */
  
  @Schema(name = "telechargeurId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telechargeurId")
  public Integer getTelechargeurId() {
    return telechargeurId;
  }

  public void setTelechargeurId(Integer telechargeurId) {
    this.telechargeurId = telechargeurId;
  }

  public TelechargementsLogsGet200ResponseInner date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public TelechargementsLogsGet200ResponseInner format(FormatEnum format) {
    this.format = format;
    return this;
  }

  /**
   * Get format
   * @return format
  */
  
  @Schema(name = "format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("format")
  public FormatEnum getFormat() {
    return format;
  }

  public void setFormat(FormatEnum format) {
    this.format = format;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelechargementsLogsGet200ResponseInner telechargementsLogsGet200ResponseInner = (TelechargementsLogsGet200ResponseInner) o;
    return Objects.equals(this.id, telechargementsLogsGet200ResponseInner.id) &&
        Objects.equals(this.cvId, telechargementsLogsGet200ResponseInner.cvId) &&
        Objects.equals(this.telechargeurId, telechargementsLogsGet200ResponseInner.telechargeurId) &&
        Objects.equals(this.date, telechargementsLogsGet200ResponseInner.date) &&
        Objects.equals(this.format, telechargementsLogsGet200ResponseInner.format);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cvId, telechargeurId, date, format);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelechargementsLogsGet200ResponseInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cvId: ").append(toIndentedString(cvId)).append("\n");
    sb.append("    telechargeurId: ").append(toIndentedString(telechargeurId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
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

