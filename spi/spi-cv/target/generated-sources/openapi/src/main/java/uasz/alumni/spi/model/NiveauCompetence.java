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

<<<<<<< Updated upstream
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-16T22:17:05.074030704Z[Africa/Dakar]")
=======
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-16T18:41:16.558845098Z[Africa/Dakar]")
>>>>>>> Stashed changes
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

