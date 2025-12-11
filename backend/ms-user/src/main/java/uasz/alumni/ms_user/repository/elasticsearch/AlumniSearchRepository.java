package uasz.alumni.ms_user.repository.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.stereotype.Repository;
import uasz.alumni.ms_user.document.AlumniDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository facade pour les opérations Elasticsearch
 * Gère l'indexation et la recherche d'alumni
 */
@Repository
public class AlumniSearchRepository {

    private final ElasticsearchClient elasticsearchClient;
    private static final String INDEX_NAME = "alumni_profiles";

    public AlumniSearchRepository(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    /**
     * Recherche avec une requête préformée
     */
    public List<AlumniDocument> search(SearchRequest searchRequest) throws IOException {
        SearchResponse<AlumniDocument> response = elasticsearchClient.search(searchRequest, AlumniDocument.class);
        
        List<AlumniDocument> results = new ArrayList<>();
        if (response.hits() != null && response.hits().hits() != null) {
            for (Hit<AlumniDocument> hit : response.hits().hits()) {
                if (hit.source() != null) {
                    results.add(hit.source());
                }
            }
        }
        return results;
    }

    /**
     * Indexe un document alumni
     */
    public void indexDocument(String id, AlumniDocument document) throws IOException {
        elasticsearchClient.index(idx -> idx
                .index(INDEX_NAME)
                .id(id)
                .document(document)
        );
    }

    /**
     * Récupère un document par ID
     */
    public AlumniDocument getDocumentById(String id) throws IOException {
        var response = elasticsearchClient.get(req -> req.index(INDEX_NAME).id(id), AlumniDocument.class);
        return response.source();
    }

    /**
     * Supprime un document par ID
     */
    public void deleteDocument(String id) throws IOException {
        elasticsearchClient.delete(del -> del.index(INDEX_NAME).id(id));
    }

    /**
     * Crée l'index avec les mappings
     */
    public void createIndexIfNotExists() throws IOException {
        boolean exists = elasticsearchClient.indices().exists(e -> e.index(INDEX_NAME)).value();
        
        if (!exists) {
            elasticsearchClient.indices().create(c -> c
                    .index(INDEX_NAME)
                    .mappings(m -> m
                            .properties("nom", p -> p.text(t -> t.analyzer("standard")))
                            .properties("prenom", p -> p.text(t -> t.analyzer("standard")))
                            .properties("fullName", p -> p.text(t -> t.analyzer("standard")))
                            .properties("email", p -> p.keyword(k -> k))
                            .properties("filiere", p -> p.keyword(k -> k))
                            .properties("niveau", p -> p.keyword(k -> k))
                            .properties("entreprise", p -> p.text(t -> t.analyzer("standard")))
                            .properties("profession", p -> p.text(t -> t.analyzer("standard")))
                            .properties("ville", p -> p.keyword(k -> k))
                            .properties("actif", p -> p.boolean_(b -> b))
                            .properties("anneeDiplome", p -> p.integer(i -> i))
                            .properties("indexed_at", p -> p.date(d -> d))
                    )
            );
        }
    }
}
