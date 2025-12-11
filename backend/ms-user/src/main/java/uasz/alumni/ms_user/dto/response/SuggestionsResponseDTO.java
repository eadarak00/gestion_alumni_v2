package uasz.alumni.ms_user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO pour les suggestions de recherche d'alumni
 * T3.1.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuggestionsResponseDTO {
    
    private String query;
    private String field;
    private List<String> suggestions;
    private Long timestamp;
}
