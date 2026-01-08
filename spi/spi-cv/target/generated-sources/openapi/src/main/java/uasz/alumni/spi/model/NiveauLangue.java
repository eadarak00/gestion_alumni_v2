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
 * Gets or Sets NiveauLangue
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T15:53:54.746111Z[Africa/Dakar]")
public enum NiveauLangue {
  
  DEBUTANT("DEBUTANT"),
  
  INTERMEDIAIRE("INTERMEDIAIRE"),
  
  AVANCE("AVANCE"),
  
  COURANT("COURANT"),
  
  NATIF("NATIF");

  private String value;

  NiveauLangue(String value) {
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
  public static NiveauLangue fromValue(String value) {
    for (NiveauLangue b : NiveauLangue.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

