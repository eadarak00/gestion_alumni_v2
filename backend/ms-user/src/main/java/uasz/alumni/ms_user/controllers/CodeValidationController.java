package uasz.alumni.ms_user.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_user.dtos.CodeValidationCheckDTO;
import uasz.alumni.ms_user.dtos.CodeValidationRequestDTO;
import uasz.alumni.ms_user.services.CodeValidationService;


@RestController
@RequestMapping("/api/v1/validation")
@RequiredArgsConstructor
@Slf4j
@Validated
public class CodeValidationController {

    private final CodeValidationService codeValidationService;

    /**
     * Génère et envoie un code de validation à un utilisateur
     */
    @PostMapping("/envoyer")
    public ResponseEntity<Void> envoyerCode(@Valid @RequestBody CodeValidationRequestDTO dto) {
        log.info("Demande de génération de code pour {}", dto.email());

        codeValidationService.creerEtEnvoyerCode(dto.email());

        return ResponseEntity.status(201).build(); // 201 CREATED
    }

    /**
     * Valide un code fourni par l'utilisateur
     */
    @PostMapping("/verifier")
    public ResponseEntity<String> verifierCode(@Valid @RequestBody CodeValidationCheckDTO dto) {
        log.info("Validation du code pour {}", dto.email());

        boolean valide = codeValidationService.validerCode(dto.email(), dto.code());

        if (!valide) {
            return ResponseEntity.badRequest().body("Code invalide ou expiré");
        }

        return ResponseEntity.ok("Code validé avec succès");
    }

}