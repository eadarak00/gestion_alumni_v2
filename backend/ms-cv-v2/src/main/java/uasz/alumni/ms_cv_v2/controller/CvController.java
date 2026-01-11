package uasz.alumni.ms_cv_v2.controller;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_cv_v2.dtos.CvRequestDTO;
import uasz.alumni.ms_cv_v2.dtos.CvResponseDTO;
import uasz.alumni.ms_cv_v2.services.CvPdfService;
import uasz.alumni.ms_cv_v2.services.CvService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-ms-cv2/v1/cvs")
@RequiredArgsConstructor
public class CvController {

    private final CvService cvService;
    private final CvPdfService cvPdfService;

    /* ================= Utils ================= */

    // private Long getUserId() {
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     if (auth != null && auth.getPrincipal() instanceof Long userId) {
    //         return userId;
    //     }
    //     return null;
    // }

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

    @PreAuthorize("hasRole('ETUDIANT')")
    @PostMapping
    public ResponseEntity<CvResponseDTO> createCv(@RequestBody CvRequestDTO dto) {

        Long userId = getUserId();

        CvResponseDTO response = cvService.createCv(dto, userId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /* ================= UPDATE ================= */
    @PreAuthorize("hasRole('ETUDIANT')")
    @PutMapping("/{id}")
    public ResponseEntity<CvResponseDTO> updateCv(
            @PathVariable Long id,
            @RequestBody CvRequestDTO dto) {

        Long userId = getUserId();

        CvResponseDTO response = cvService.updateCv(id, dto, userId);

        return ResponseEntity.ok(response);
    }

    /* ================= READ ================= */

    @PreAuthorize("hasRole('ETUDIANT')")

    @GetMapping("/me")
    public ResponseEntity<List<CvResponseDTO>> getMyCvs() {

        Long userId = getUserId();

        return ResponseEntity.ok(cvService.getMyCvs(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CvResponseDTO> getCvById(@PathVariable Long id) {

        Long userId = getUserId();

        return ResponseEntity.ok(cvService.getCvById(id, userId));
    }

    /* ================= DELETE ================= */
    @PreAuthorize("hasRole('ETUDIANT')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCv(@PathVariable Long id) {

        Long userId = getUserId();

        cvService.deleteCv(id, userId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> downloadCvPdf(@PathVariable Long id) throws Exception {

        Long userId = getUserId();

        CvResponseDTO cv = cvService.getCvById(id, userId);

        byte[] pdfBytes = cvPdfService.generatePdf(cv);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=cv-" + cv.getId() + ".pdf")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

}
