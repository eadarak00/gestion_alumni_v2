package uasz.alumni.ms_user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CodeValidationRequestDTO(
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Email invalide")
    String email
) {}