package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * EtudiantRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-02T02:07:51.481060929Z[Africa/Dakar]")
public class EtudiantRequestDTO {

  private String nom;

  private String prenom;

  private String email;

  private String username;

  private String motDePasse;

  private String telephone;

  private String numeroCarteEtudiant;

  /**
   * Gets or Sets niveau
   */
  public enum NiveauEnum {
    LICENCE("LICENCE"),
    
    MASTER("MASTER"),
    
    DOCTORAT("DOCTORAT");

    private String value;

    NiveauEnum(String value) {
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
    public static NiveauEnum fromValue(String value) {
      for (NiveauEnum b : NiveauEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private NiveauEnum niveau;

  private String filiere;

  public EtudiantRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EtudiantRequestDTO(String nom, String prenom, String email, String motDePasse, String numeroCarteEtudiant, NiveauEnum niveau, String filiere) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.motDePasse = motDePasse;
    this.numeroCarteEtudiant = numeroCarteEtudiant;
    this.niveau = niveau;
    this.filiere = filiere;
  }

  public EtudiantRequestDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  @NotNull 
  @Schema(name = "nom", example = "Diallo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public EtudiantRequestDTO prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Get prenom
   * @return prenom
  */
  @NotNull 
  @Schema(name = "prenom", example = "Mamadou", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public EtudiantRequestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "mamadou.diallo@uasz.sn", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EtudiantRequestDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", example = "mdiallo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public EtudiantRequestDTO motDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
    return this;
  }

  /**
   * Get motDePasse
   * @return motDePasse
  */
  @NotNull 
  @Schema(name = "motDePasse", example = "MotDePasse123!", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("motDePasse")
  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public EtudiantRequestDTO telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  
  @Schema(name = "telephone", example = "+221781234567", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public EtudiantRequestDTO numeroCarteEtudiant(String numeroCarteEtudiant) {
    this.numeroCarteEtudiant = numeroCarteEtudiant;
    return this;
  }

  /**
   * Get numeroCarteEtudiant
   * @return numeroCarteEtudiant
  */
  @NotNull 
  @Schema(name = "numeroCarteEtudiant", example = "ETU123456", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroCarteEtudiant")
  public String getNumeroCarteEtudiant() {
    return numeroCarteEtudiant;
  }

  public void setNumeroCarteEtudiant(String numeroCarteEtudiant) {
    this.numeroCarteEtudiant = numeroCarteEtudiant;
  }

  public EtudiantRequestDTO niveau(NiveauEnum niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  @NotNull 
  @Schema(name = "niveau", example = "MASTER", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("niveau")
  public NiveauEnum getNiveau() {
    return niveau;
  }

  public void setNiveau(NiveauEnum niveau) {
    this.niveau = niveau;
  }

  public EtudiantRequestDTO filiere(String filiere) {
    this.filiere = filiere;
    return this;
  }

  /**
   * Get filiere
   * @return filiere
  */
  @NotNull 
  @Schema(name = "filiere", example = "Informatique", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("filiere")
  public String getFiliere() {
    return filiere;
  }

  public void setFiliere(String filiere) {
    this.filiere = filiere;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EtudiantRequestDTO etudiantRequestDTO = (EtudiantRequestDTO) o;
    return Objects.equals(this.nom, etudiantRequestDTO.nom) &&
        Objects.equals(this.prenom, etudiantRequestDTO.prenom) &&
        Objects.equals(this.email, etudiantRequestDTO.email) &&
        Objects.equals(this.username, etudiantRequestDTO.username) &&
        Objects.equals(this.motDePasse, etudiantRequestDTO.motDePasse) &&
        Objects.equals(this.telephone, etudiantRequestDTO.telephone) &&
        Objects.equals(this.numeroCarteEtudiant, etudiantRequestDTO.numeroCarteEtudiant) &&
        Objects.equals(this.niveau, etudiantRequestDTO.niveau) &&
        Objects.equals(this.filiere, etudiantRequestDTO.filiere);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom, prenom, email, username, motDePasse, telephone, numeroCarteEtudiant, niveau, filiere);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EtudiantRequestDTO {\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    motDePasse: ").append("*").append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    numeroCarteEtudiant: ").append(toIndentedString(numeroCarteEtudiant)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    filiere: ").append(toIndentedString(filiere)).append("\n");
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

