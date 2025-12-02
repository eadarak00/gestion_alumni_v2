package uasz.alumni.ms_user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AlumniRequestDTO(
    @NotBlank(message = "Le nom est obligatoire")
    String nom,

    @NotBlank(message = "Le prénom est obligatoire")
    String prenom,

    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est obligatoire")
    String email,

    /**
     * Username optionnel, pourra être généré automatiquement si absent
     */
    String username,

    @NotBlank(message = "Le mot de passe est obligatoire")
    String motDePasse,

    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    @Pattern(regexp = "^(\\+221|00221)?7[015678]\\d{7}$", 
             message = "Numéro de téléphone invalide (format Sénégal)")
    String telephone,

    String profession,
    String entreprise
) {}
