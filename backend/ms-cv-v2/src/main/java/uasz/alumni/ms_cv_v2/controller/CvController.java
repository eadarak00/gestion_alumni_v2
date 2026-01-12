package uasz.alumni.ms_cv_v2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_cv_v2.exceptions.CvGenerationException;
// import uasz.alumni.ms_cv_v2.dtos.CvRequestDTO;
// import uasz.alumni.ms_cv_v2.dtos.CvResponseDTO;
import uasz.alumni.ms_cv_v2.services.CvPdfService;
import uasz.alumni.ms_cv_v2.services.CvService;
import uasz.alumni.spi.api.CvsApi;
import uasz.alumni.spi.model.CvRequestDTO;
import uasz.alumni.spi.model.CvResponseDTO;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api-ms-cv2/v1")
@RequiredArgsConstructor
@Slf4j
public class CvController implements CvsApi {

    private final CvService cvService;
    private final CvPdfService cvPdfService;

    /* ================= Utils ================= */

    private Long getUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Log de debug
        System.out.println("=== DEBUG getUserId() ===");
        System.out.println("Authentication: " + auth);
        if (auth != null) {
            System.out.println("Principal: " + auth.getPrincipal());
            System.out.println("Principal type: " +
                    (auth.getPrincipal() != null ? auth.getPrincipal().getClass().getName() : "null"));
            System.out.println("Principal is Long? " + (auth.getPrincipal() instanceof Long));
            System.out.println("Details: " + auth.getDetails());
        }
        System.out.println("=== FIN DEBUG ===");

        if (auth != null && auth.getPrincipal() instanceof Long userId) {
            return userId;
        }
        return null;
    }
    /* ================= CREATE ================= */

    // @PreAuthorize("hasRole('ETUDIANT')")
    // @PostMapping
    // public ResponseEntity<CvResponseDTO> createCv(@RequestBody CvRequestDTO dto)
    // {

    // Long userId = getUserId();

    // CvResponseDTO response = cvService.createCv(dto, userId);

    // return new ResponseEntity<>(response, HttpStatus.CREATED);
    // }

    /* ================= UPDATE ================= */
    // @PreAuthorize("hasRole('ETUDIANT')")
    // @PutMapping("/{id}")
    // public ResponseEntity<CvResponseDTO> updateCv(
    // @PathVariable Long id,
    // @RequestBody CvRequestDTO dto) {

    // Long userId = getUserId();

    // CvResponseDTO response = cvService.updateCv(id, dto, userId);

    // return ResponseEntity.ok(response);
    // }

    // /* ================= READ ================= */

    // @PreAuthorize("hasRole('ETUDIANT')")

    // @GetMapping("/me")
    // public ResponseEntity<List<CvResponseDTO>> getMyCvs() {

    // Long userId = getUserId();

    // return ResponseEntity.ok(cvService.getMyCvs(userId));
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<CvResponseDTO> getCvById(@PathVariable Long id) {

    // Long userId = getUserId();

    // return ResponseEntity.ok(cvService.getCvById(id, userId));
    // }

    // /* ================= DELETE ================= */
    // @PreAuthorize("hasRole('ETUDIANT')")
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteCv(@PathVariable Long id) {

    // Long userId = getUserId();

    // cvService.deleteCv(id, userId);

    // return ResponseEntity.noContent().build();
    // }

    // @GetMapping("/{id}/pdf")
    // public ResponseEntity<byte[]> downloadCvPdf(@PathVariable Long id) throws
    // Exception {

    // Long userId = getUserId();

    // CvResponseDTO cv = cvService.getCvById(id, userId);

    // byte[] pdfBytes = cvPdfService.generatePdf(cv);

    // return ResponseEntity.ok()
    // .header("Content-Disposition", "attachment; filename=cv-" + cv.getId() +
    // ".pdf")
    // .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
    // .body(pdfBytes);
    // }

    @Override
    @PreAuthorize("hasRole('ETUDIANT')")
    public ResponseEntity<CvResponseDTO> createCv(
            @Valid CvRequestDTO dto) {
        Long userId = getUserId();

        CvResponseDTO response = cvService.createCv(dto, userId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('ETUDIANT')")
    @Override
    public ResponseEntity<CvResponseDTO> updateCv(Long id,
            @Valid CvRequestDTO dto) {
        Long userId = getUserId();

        CvResponseDTO response = cvService.updateCv(id, dto, userId);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ETUDIANT')")
    @Override
    public ResponseEntity<Void> deleteCv(Long id) {
        Long userId = getUserId();

        cvService.deleteCv(id, userId);

        return ResponseEntity.noContent().build();

    }


    @Override
public ResponseEntity<Resource> downloadCvPdf(Long id) {
    Long userId = getUserId();

    try {
        CvResponseDTO cv = cvService.getCvById(id, userId);
        log.info("Téléchargement PDF demandé pour CV ID: {}", id);
        
        byte[] pdfBytes = cvPdfService.generatePdf(cv);
        
        if (pdfBytes == null || pdfBytes.length == 0) {
            log.error("PDF généré vide pour CV ID: {}", id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=cv-" + cv.getId() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdfBytes.length)
                .body(new ByteArrayResource(pdfBytes));
        
    } catch (CvGenerationException e) {
        log.error("Erreur technique lors de la génération PDF pour CV ID: {}", id, e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ByteArrayResource(
                    ("Erreur technique: " + e.getMessage()).getBytes()
                ));
        
    } catch (Exception e) {
        log.error("Erreur inattendue lors du téléchargement PDF pour CV ID: {}", id, e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null);
    }
}

    @Override
    public ResponseEntity<CvResponseDTO> getCvById(Long id) {
        Long userId = getUserId();

        return ResponseEntity.ok(cvService.getCvById(id, userId));

    }

    @PreAuthorize("hasRole('ETUDIANT')")
    @Override
    public ResponseEntity<List<CvResponseDTO>> getMyCvs() {
        Long userId = getUserId();

        return ResponseEntity.ok(cvService.getMyCvs(userId));
    }

}
