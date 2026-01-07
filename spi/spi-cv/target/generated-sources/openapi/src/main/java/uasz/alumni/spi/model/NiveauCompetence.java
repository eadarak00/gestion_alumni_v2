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
 * Gets or Sets NiveauCompetence
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-05T02:02:10.601143888Z[Africa/Dakar]")
public enum NiveauCompetence {
  
  DEBUTANT("DEBUTANT"),
  
  INTERMEDIAIRE("INTERMEDIAIRE"),
  
  AVANCE("AVANCE"),
  
  EXPERT("EXPERT");

  private String value;

  NiveauCompetence(String value) {
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
  public static NiveauCompetence fromValue(String value) {
    for (NiveauCompetence b : NiveauCompetence.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

