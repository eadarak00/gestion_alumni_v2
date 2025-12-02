package uasz.alumni.ms_user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CodeValidationCheckDTO(
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Email invalide")
    String email,

    @NotBlank(message = "Le code est obligatoire")
    String code
) {}