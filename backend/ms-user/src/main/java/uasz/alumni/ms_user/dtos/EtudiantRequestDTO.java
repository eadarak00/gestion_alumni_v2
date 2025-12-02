package uasz.alumni.ms_user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EtudiantRequestDTO(
    @NotBlank(message = "Le nom est obligatoire")
    String nom,

    @NotBlank(message = "Le prénom est obligatoire")
    String prenom,

    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est obligatoire")
    String email,

    String username,

    @NotBlank(message = "Le mot de passe est obligatoire")
    String motDePasse,

    @Pattern(regexp = "^(\\+221|00221)?7[015678]\\d{7}$",
             message = "Numéro de téléphone invalide (format Sénégal)")
    String telephone,

    @NotBlank(message = "Le numéro de carte est obligatoire")
    String numeroCarteEtudiant,

    @NotBlank(message = "Le niveau est obligatoire")
    String niveau,

    @NotBlank(message = "La filière est obligatoire")
    String filiere
) {}
