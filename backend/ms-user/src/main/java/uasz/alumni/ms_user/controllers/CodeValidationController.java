package uasz.alumni.ms_user.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import uasz.alumni.ms_user.services.CodeValidationService;
import uasz.alumni.spi.api.ValidationApi;
import uasz.alumni.spi.model.CodeValidationCheckDTO;
import uasz.alumni.spi.model.CodeValidationRequestDTO;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CodeValidationController implements ValidationApi {

    private final CodeValidationService codeValidationService;

    @Override
    public ResponseEntity<Void> envoyerCode(@Valid CodeValidationRequestDTO dto) {
        log.info("Demande de génération de code pour {}", dto.getEmail());

        codeValidationService.creerEtEnvoyerCode(dto.getEmail());

        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<String> verifierCode(@Valid CodeValidationCheckDTO dto) {
        log.info("Validation du code pour {}", dto.getEmail());

        boolean valide = codeValidationService.validerCode(dto.getEmail(), dto.getCode());

        if (!valide) {
            return ResponseEntity.badRequest().body("Code invalide ou expiré");
        }

        return ResponseEntity.ok("Code validé avec succès");
    }

}