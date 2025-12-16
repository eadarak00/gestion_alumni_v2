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
 * Gets or Sets Langues
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-16T14:50:03.590683172Z[Africa/Dakar]")
public enum Langues {
  
  FRANCAIS("FRANCAIS"),
  
  ANGLAIS("ANGLAIS"),
  
  ESPAGNOL("ESPAGNOL"),
  
  ALLEMAND("ALLEMAND"),
  
  ITALIEN("ITALIEN"),
  
  PORTUGAIS("PORTUGAIS"),
  
  ARABE("ARABE"),
  
  CHINOIS("CHINOIS"),
  
  AUTRE("AUTRE");

  private String value;

  Langues(String value) {
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
  public static Langues fromValue(String value) {
    for (Langues b : Langues.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

