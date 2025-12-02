package uasz.alumni.ms_user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RoleRequestDTO(

        @NotBlank(message = "Le libellé du rôle est obligatoire")
        @Size(min = 2, max = 50, message = "Le libellé doit contenir entre 2 et 50 caractères")
        @Pattern(
            regexp = "^[A-Z_]+$",
            message = "Le libellé doit contenir uniquement des lettres majuscules et des underscores"
        )
        String libelle

) { }
