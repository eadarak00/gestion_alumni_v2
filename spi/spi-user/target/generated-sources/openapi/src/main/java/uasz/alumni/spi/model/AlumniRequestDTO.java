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
 * AlumniRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T09:53:11.934279900Z[Etc/UTC]")
public class AlumniRequestDTO {

  private String nom;

  private String prenom;

  private String email;

  private String username;

  private String motDePasse;

  private String telephone;

  private String profession;

  private String entreprise;

  private String filiere;

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

  private Integer anneeDiplome;

  private String ville;

  public AlumniRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AlumniRequestDTO(String nom, String prenom, String email, String motDePasse, String telephone) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.motDePasse = motDePasse;
    this.telephone = telephone;
  }

  public AlumniRequestDTO nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  @NotNull 
  @Schema(name = "nom", example = "Sow", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nom")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public AlumniRequestDTO prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Get prenom
   * @return prenom
  */
  @NotNull 
  @Schema(name = "prenom", example = "Aïssatou", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("prenom")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public AlumniRequestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "aissatou.sow@alumni.uasz.sn", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AlumniRequestDTO username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  
  @Schema(name = "username", example = "asow", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AlumniRequestDTO motDePasse(String motDePasse) {
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

  public AlumniRequestDTO telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * Get telephone
   * @return telephone
  */
  @NotNull 
  @Schema(name = "telephone", example = "+221781234568", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telephone")
  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public AlumniRequestDTO profession(String profession) {
    this.profession = profession;
    return this;
  }

  /**
   * Get profession
   * @return profession
  */
  
  @Schema(name = "profession", example = "Data Scientist", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profession")
  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public AlumniRequestDTO entreprise(String entreprise) {
    this.entreprise = entreprise;
    return this;
  }

  /**
   * Get entreprise
   * @return entreprise
  */
  
  @Schema(name = "entreprise", example = "Sonatel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("entreprise")
  public String getEntreprise() {
    return entreprise;
  }

  public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
  }

  public AlumniRequestDTO filiere(String filiere) {
    this.filiere = filiere;
    return this;
  }

  /**
   * Get filiere
   * @return filiere
  */
  
  @Schema(name = "filiere", example = "Informatique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filiere")
  public String getFiliere() {
    return filiere;
  }

  public void setFiliere(String filiere) {
    this.filiere = filiere;
  }

  public AlumniRequestDTO niveau(NiveauEnum niveau) {
    this.niveau = niveau;
    return this;
  }

  /**
   * Get niveau
   * @return niveau
  */
  
  @Schema(name = "niveau", example = "MASTER", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("niveau")
  public NiveauEnum getNiveau() {
    return niveau;
  }

  public void setNiveau(NiveauEnum niveau) {
    this.niveau = niveau;
  }

  public AlumniRequestDTO anneeDiplome(Integer anneeDiplome) {
    this.anneeDiplome = anneeDiplome;
    return this;
  }

  /**
   * Get anneeDiplome
   * @return anneeDiplome
  */
  
  @Schema(name = "anneeDiplome", example = "2020", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anneeDiplome")
  public Integer getAnneeDiplome() {
    return anneeDiplome;
  }

  public void setAnneeDiplome(Integer anneeDiplome) {
    this.anneeDiplome = anneeDiplome;
  }

  public AlumniRequestDTO ville(String ville) {
    this.ville = ville;
    return this;
  }

  /**
   * Get ville
   * @return ville
  */
  
  @Schema(name = "ville", example = "Dakar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ville")
  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlumniRequestDTO alumniRequestDTO = (AlumniRequestDTO) o;
    return Objects.equals(this.nom, alumniRequestDTO.nom) &&
        Objects.equals(this.prenom, alumniRequestDTO.prenom) &&
        Objects.equals(this.email, alumniRequestDTO.email) &&
        Objects.equals(this.username, alumniRequestDTO.username) &&
        Objects.equals(this.motDePasse, alumniRequestDTO.motDePasse) &&
        Objects.equals(this.telephone, alumniRequestDTO.telephone) &&
        Objects.equals(this.profession, alumniRequestDTO.profession) &&
        Objects.equals(this.entreprise, alumniRequestDTO.entreprise) &&
        Objects.equals(this.filiere, alumniRequestDTO.filiere) &&
        Objects.equals(this.niveau, alumniRequestDTO.niveau) &&
        Objects.equals(this.anneeDiplome, alumniRequestDTO.anneeDiplome) &&
        Objects.equals(this.ville, alumniRequestDTO.ville);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom, prenom, email, username, motDePasse, telephone, profession, entreprise, filiere, niveau, anneeDiplome, ville);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlumniRequestDTO {\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    motDePasse: ").append("*").append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    profession: ").append(toIndentedString(profession)).append("\n");
    sb.append("    entreprise: ").append(toIndentedString(entreprise)).append("\n");
    sb.append("    filiere: ").append(toIndentedString(filiere)).append("\n");
    sb.append("    niveau: ").append(toIndentedString(niveau)).append("\n");
    sb.append("    anneeDiplome: ").append(toIndentedString(anneeDiplome)).append("\n");
    sb.append("    ville: ").append(toIndentedString(ville)).append("\n");
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

