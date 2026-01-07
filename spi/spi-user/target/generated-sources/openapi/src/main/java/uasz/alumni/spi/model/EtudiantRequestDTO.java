package uasz.alumni.spi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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

<<<<<<< Updated upstream
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-16T20:10:41.247958539Z[Africa/Dakar]")
=======
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-16T18:41:26.566966538Z[Africa/Dakar]")
>>>>>>> Stashed changes
public class EtudiantRequestDTO {

  private String nom;

  private String prenom;

  private String email;

  private String username;

  private String motDePasse;

  private String telephone;

  private String numeroCarteEtudiant;

  private String niveau;

  private String filiere;

  public EtudiantRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EtudiantRequestDTO(String nom, String prenom, String email, String motDePasse, String numeroCarteEtudiant, String niveau, String filiere) {
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
   * Nom de famille
   * @return nom
  */
  @NotNull 
  @Schema(name = "nom", example = "Diallo", description = "Nom de famille", requiredMode = Schema.RequiredMode.REQUIRED)
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
   * Prénom
   * @return prenom
  */
  @NotNull 
  @Schema(name = "prenom", example = "Mamadou", description = "Prénom", requiredMode = Schema.RequiredMode.REQUIRED)
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
   * Adresse email
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "mamadou.diallo@uasz.sn", description = "Adresse email", requiredMode = Schema.RequiredMode.REQUIRED)
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
   * Nom d'utilisateur (optionnel)
   * @return username
  */
  
  @Schema(name = "username", example = "mdiallo", description = "Nom d'utilisateur (optionnel)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
   * Mot de passe
   * @return motDePasse
  */
  @NotNull 
  @Schema(name = "motDePasse", example = "MotDePasse123!", description = "Mot de passe", requiredMode = Schema.RequiredMode.REQUIRED)
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
   * Numéro de téléphone (format Sénégal)
   * @return telephone
  */
  @Pattern(regexp = "^(\\+221|00221)?7[015678]\\d{7}$") 
  @Schema(name = "telephone", example = "+221781234567", description = "Numéro de téléphone (format Sénégal)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
   * Numéro de carte étudiant
   * @return numeroCarteEtudiant
  */
  @NotNull 
  @Schema(name = "numeroCarteEtudiant", example = "ETU123456", description = "Numéro de carte étudiant", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroCarteEtudiant")
  public String getNumeroCarteEtudiant() {
    return numeroCarteEtudiant;
  }

  public void setNumeroCarteEtudiant(String numeroCarteEtudiant) {
    this.numeroCarteEtudiant = numeroCarteEtudiant;
  }

  public EtudiantRequestDTO niveau(String niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Niveau d'études
   * @return niveau
  */
  @NotNull 
  @Schema(name = "niveau", example = "MASTER", description = "Niveau d'études", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("niveau")
  public String getNiveau() {
    return niveau;
  }

  public void setNiveau(String niveau) {
    this.niveau = niveau;
  }

  public EtudiantRequestDTO filiere(String filiere) {
    this.filiere = filiere;
    return this;
  }

  /**
   * Filière d'études
   * @return filiere
  */
  @NotNull 
  @Schema(name = "filiere", example = "Informatique", description = "Filière d'études", requiredMode = Schema.RequiredMode.REQUIRED)
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

