package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CategorieCompetence
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T15:59:02.955391208Z[Africa/Dakar]")
public enum CategorieCompetence {
  
  TECHNIQUE("TECHNIQUE"),
  
  LINGUISTIQUE("LINGUISTIQUE"),
  
  SOFT_SKILLS("SOFT_SKILLS"),
  
  AUTRE("AUTRE");

  private String value;

  CategorieCompetence(String value) {
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
  public static CategorieCompetence fromValue(String value) {
    for (CategorieCompetence b : CategorieCompetence.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

