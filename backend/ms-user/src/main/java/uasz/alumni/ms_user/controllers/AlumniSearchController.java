package uasz.alumni.ms_user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_user.dto.request.AdvancedSearchRequestDTO;
import uasz.alumni.ms_user.dto.request.IndexRequestDTO;
import uasz.alumni.ms_user.dto.response.AlumniSearchResultDTO;
import uasz.alumni.ms_user.dto.response.SuggestionsResponseDTO;
import uasz.alumni.ms_user.services.AlumniSearchService;

import java.util.List;
import java.util.Map;

/**
 * Contrôleur REST pour la recherche d'alumni
 * Endpoints pour US3.1
 */
@RestController
@RequestMapping("/api/v1/alumni/search")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AlumniSearchController {

    private final AlumniSearchService alumniSearchService;

    public AlumniSearchController(AlumniSearchService alumniSearchService) {
        this.alumniSearchService = alumniSearchService;
    }

    /**
     * T3.1.1 : Suggestions de recherche
     * GET /api/v1/alumni/search/suggestions?query=xxx&field=nom
     */
    @GetMapping("/suggestions")
    public ResponseEntity<SuggestionsResponseDTO> getSuggestions(
            @RequestParam String query,
            @RequestParam(defaultValue = "nom") String field) {
        SuggestionsResponseDTO response = alumniSearchService.getSuggestions(query, field);
        return ResponseEntity.ok(response);
    }

    /**
     * T3.1.2 : Indexation d'un alumni
     * POST /api/v1/alumni/search/index
     */
    @PostMapping("/index")
    public ResponseEntity<Map<String, String>> indexAlumni(@RequestBody IndexRequestDTO request) {
        alumniSearchService.indexAlumni(request);
        return ResponseEntity.accepted().body(Map.of("message", "Indexation en cours"));
    }

    /**
     * T3.1.3 : Recherche simple avec filtres
     * GET /api/v1/alumni/search?q=xxx&filiere=xxx&niveau=xxx&entreprise=xxx&ville=xxx
     */
    @GetMapping
    public ResponseEntity<List<AlumniSearchResultDTO>> searchAlumni(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String filiere,
            @RequestParam(required = false) String niveau,
            @RequestParam(required = false) String entreprise,
            @RequestParam(required = false) String ville) {
        List<AlumniSearchResultDTO> results = alumniSearchService.searchAlumni(q, filiere, niveau, entreprise, ville);
        return ResponseEntity.ok(results);
    }

    /**
     * T3.1.4 : Recherche avancée
     * POST /api/v1/alumni/search/advanced
     */
    @PostMapping("/advanced")
    public ResponseEntity<List<AlumniSearchResultDTO>> advancedSearch(
            @RequestBody AdvancedSearchRequestDTO request) {
        List<AlumniSearchResultDTO> results = alumniSearchService.advancedSearch(request);
        return ResponseEntity.ok(results);
    }
}