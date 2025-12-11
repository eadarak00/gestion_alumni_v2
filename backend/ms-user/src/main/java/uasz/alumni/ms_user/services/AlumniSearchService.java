package uasz.alumni.ms_user.services;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uasz.alumni.ms_user.document.AlumniDocument;
import uasz.alumni.ms_user.dto.request.AdvancedSearchRequestDTO;
import uasz.alumni.ms_user.dto.request.IndexRequestDTO;
import uasz.alumni.ms_user.dto.response.AlumniSearchResultDTO;
import uasz.alumni.ms_user.dto.response.SuggestionsResponseDTO;
import uasz.alumni.ms_user.repository.elasticsearch.AlumniSearchRepository;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service pour la recherche d'alumni
 * Implémente US3.1 : T3.1.1 (suggestions), T3.1.2 (indexation), T3.1.3 (filtres), T3.1.4 (recherche avancée)
 */
@Service
public class AlumniSearchService {

    private static final Logger logger = LoggerFactory.getLogger(AlumniSearchService.class);
    
    private final AlumniSearchRepository alumniSearchRepository;

    public AlumniSearchService(AlumniSearchRepository alumniSearchRepository) {
        this.alumniSearchRepository = alumniSearchRepository;
    }

    /**
     * T3.1.1 : Suggestions de recherche
     * Retourne des suggestions basées sur le début du mot (prefix matching)
     */
    public SuggestionsResponseDTO getSuggestions(String query, String field) {
        List<String> suggestions = new ArrayList<>();
        
        if (query == null || query.length() < 2) {
            return SuggestionsResponseDTO.builder()
                    .query(query)
                    .field(field)
                    .suggestions(suggestions)
                    .timestamp(System.currentTimeMillis())
                    .build();
        }

        try {
            // Construction d'une requête de suggestion par prefix matching
            Query prefixQuery = Query.of(q -> q
                    .match(m -> m
                            .field(field)
                            .query(query)
                    )
            );

            SearchRequest searchRequest = SearchRequest.of(s -> s
                    .index("alumni_profiles")
                    .query(prefixQuery)
                    .size(10)
            );

            var results = alumniSearchRepository.search(searchRequest);
            
            // Extraction des suggestions uniques
            suggestions = results.stream()
                    .map(doc -> getFieldValue(doc, field))
                    .filter(Objects::nonNull)
                    .distinct()
                    .limit(10)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            logger.error("Erreur lors de la recherche de suggestions", e);
        }

        return SuggestionsResponseDTO.builder()
                .query(query)
                .field(field)
                .suggestions(suggestions)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * T3.1.2 : Indexation asynchrone d'alumni
     * Index un alumni en Elasticsearch
     */
    @Async("taskExecutor")
    public void indexAlumni(IndexRequestDTO request) {
        try {
            AlumniDocument document = AlumniDocument.builder()
                    .id(request.getUserId())
                    .nom(request.getNom())
                    .prenom(request.getPrenom())
                    .email(request.getEmail())
                    .username(request.getUsername())
                    .filiere(request.getFiliere())
                    .niveau(request.getNiveau())
                    .anneeDiplome(request.getAnneeDiplome())
                    .profession(request.getProfession())
                    .entreprise(request.getEntreprise())
                    .ville(request.getVille())
                    .actif(request.getActif() != null ? request.getActif() : true)
                    .fullName(request.getPrenom() + " " + request.getNom())
                    .indexedAt(System.currentTimeMillis())
                    .build();

            alumniSearchRepository.indexDocument(request.getUserId(), document);
            logger.info("Alumni indexé : {}", request.getUserId());
        } catch (IOException e) {
            logger.error("Erreur lors de l'indexation d'un alumni", e);
        }
    }

    /**
     * T3.1.3 : Recherche simple avec filtres
     */
    public List<AlumniSearchResultDTO> searchAlumni(String q, String filiere, String niveau,
                                                     String entreprise, String ville) {
        List<Query> mustQueries = new ArrayList<>();

        if (q != null && !q.isBlank()) {
            mustQueries.add(Query.of(query -> query
                    .multiMatch(m -> m
                            .query(q)
                            .fields("nom^2", "prenom^2", "fullName^3", "profession", "entreprise", "ville")
                    )
            ));
        }

        if (filiere != null && !filiere.isBlank()) {
            mustQueries.add(Query.of(query -> query.term(t -> t.field("filiere").value(filiere))));
        }
        if (niveau != null && !niveau.isBlank()) {
            mustQueries.add(Query.of(query -> query.term(t -> t.field("niveau").value(niveau))));
        }
        if (entreprise != null && !entreprise.isBlank()) {
            mustQueries.add(Query.of(query -> query.match(m -> m.field("entreprise").query(entreprise))));
        }
        if (ville != null && !ville.isBlank()) {
            mustQueries.add(Query.of(query -> query.match(m -> m.field("ville").query(ville))));
        }

        mustQueries.add(Query.of(query -> query.term(t -> t.field("actif").value(true))));

        try {
            SearchRequest searchRequest = SearchRequest.of(s -> s
                    .index("alumni_profiles")
                    .query(q1 -> q1.bool(b -> b.must(mustQueries)))
                    .size(100)
            );

            var results = alumniSearchRepository.search(searchRequest);
            return results.stream()
                    .map(this::mapToResultDTO)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            logger.error("Erreur lors de la recherche d'alumni", e);
            return new ArrayList<>();
        }
    }

    /**
     * T3.1.4 : Recherche avancée avec paramètres complexes
     */
    public List<AlumniSearchResultDTO> advancedSearch(AdvancedSearchRequestDTO request) {
        List<Query> mustQueries = new ArrayList<>();

        if (request.getText() != null && !request.getText().isBlank()) {
            mustQueries.add(Query.of(query -> query
                    .multiMatch(m -> m
                            .query(request.getText())
                            .fields("nom^2", "prenom^2", "fullName^3", "profession", "entreprise", "ville")
                    )
            ));
        }

        if (request.getFilters() != null) {
            var filters = request.getFilters();

            if (filters.getFiliere() != null && !filters.getFiliere().isEmpty()) {
                List<Query> filiereQueries = filters.getFiliere().stream()
                        .map(f -> Query.of(q -> q.term(t -> t.field("filiere").value(f))))
                        .collect(Collectors.toList());
                mustQueries.add(Query.of(q -> q.bool(b -> b.should(filiereQueries))));
            }

            if (filters.getNiveau() != null && !filters.getNiveau().isEmpty()) {
                List<Query> niveauQueries = filters.getNiveau().stream()
                        .map(n -> Query.of(q -> q.term(t -> t.field("niveau").value(n))))
                        .collect(Collectors.toList());
                mustQueries.add(Query.of(q -> q.bool(b -> b.should(niveauQueries))));
            }

            if (filters.getAnneeDiplome() != null) {
                var anneeRange = filters.getAnneeDiplome();
                if (anneeRange.getMin() != null || anneeRange.getMax() != null) {
                    mustQueries.add(Query.of(q -> q.range(r -> {
                        var rangeQuery = r.field("anneeDiplome");
                        if (anneeRange.getMin() != null) {
                            rangeQuery.gte(co.elastic.clients.json.JsonData.of(anneeRange.getMin()));
                        }
                        if (anneeRange.getMax() != null) {
                            rangeQuery.lte(co.elastic.clients.json.JsonData.of(anneeRange.getMax()));
                        }
                        return rangeQuery;
                    })));
                }
            }
        }

        mustQueries.add(Query.of(query -> query.term(t -> t.field("actif").value(true))));

        int page = request.getPagination() != null ? request.getPagination().getPage() : 1;
        int size = request.getPagination() != null ? request.getPagination().getSize() : 20;
        int from = (page - 1) * size;

        try {
            SearchRequest searchRequest = SearchRequest.of(s -> s
                    .index("alumni_profiles")
                    .query(q -> q.bool(b -> b.must(mustQueries)))
                    .from(from)
                    .size(size)
            );

            var results = alumniSearchRepository.search(searchRequest);
            return results.stream()
                    .map(this::mapToResultDTO)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            logger.error("Erreur lors de la recherche avancée d'alumni", e);
            return new ArrayList<>();
        }
    }

    private String getFieldValue(AlumniDocument doc, String field) {
        return switch (field.toLowerCase()) {
            case "nom" -> doc.getNom();
            case "prenom" -> doc.getPrenom();
            case "entreprise" -> doc.getEntreprise();
            case "profession", "poste" -> doc.getProfession();
            case "filiere" -> doc.getFiliere();
            case "niveau" -> doc.getNiveau();
            case "ville" -> doc.getVille();
            default -> null;
        };
    }

    private AlumniSearchResultDTO mapToResultDTO(AlumniDocument doc) {
        return AlumniSearchResultDTO.builder()
                .id(doc.getId())
                .nom(doc.getNom())
                .prenom(doc.getPrenom())
                .email(doc.getEmail())
                .filiere(doc.getFiliere())
                .niveau(doc.getNiveau())
                .anneeDiplome(doc.getAnneeDiplome())
                .entreprise(doc.getEntreprise())
                .poste(doc.getProfession())
                .ville(doc.getVille())
                .score(0.0f)
                .build();
    }
}