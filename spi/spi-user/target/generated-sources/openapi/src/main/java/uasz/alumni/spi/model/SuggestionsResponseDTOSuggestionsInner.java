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
 * SuggestionsResponseDTOSuggestionsInner
 */

@JsonTypeName("SuggestionsResponseDTO_suggestions_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T09:53:11.934279900Z[Etc/UTC]")
public class SuggestionsResponseDTOSuggestionsInner {

  private String text;

  private Float score;

  private String highlight;

  public SuggestionsResponseDTOSuggestionsInner text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  */
  
  @Schema(name = "text", example = "Mamadou Diallo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("text")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public SuggestionsResponseDTOSuggestionsInner score(Float score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  */
  
  @Schema(name = "score", example = "0.95", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("score")
  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  public SuggestionsResponseDTOSuggestionsInner highlight(String highlight) {
    this.highlight = highlight;
    return this;
  }

  /**
   * Get highlight
   * @return highlight
  */
  
  @Schema(name = "highlight", example = "<em>Mam</em>adou Diallo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("highlight")
  public String getHighlight() {
    return highlight;
  }

  public void setHighlight(String highlight) {
    this.highlight = highlight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuggestionsResponseDTOSuggestionsInner suggestionsResponseDTOSuggestionsInner = (SuggestionsResponseDTOSuggestionsInner) o;
    return Objects.equals(this.text, suggestionsResponseDTOSuggestionsInner.text) &&
        Objects.equals(this.score, suggestionsResponseDTOSuggestionsInner.score) &&
        Objects.equals(this.highlight, suggestionsResponseDTOSuggestionsInner.highlight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, score, highlight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuggestionsResponseDTOSuggestionsInner {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    highlight: ").append(toIndentedString(highlight)).append("\n");
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

