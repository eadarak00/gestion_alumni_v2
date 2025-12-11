package uasz.alumni.ms_user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO pour les recherches avancées d'alumni
 * T3.1.3, T3.1.4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvancedSearchRequestDTO {
    
    private String text;
    
    private AdvancedFilters filters;
    
    private PaginationParams pagination;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AdvancedFilters {
        private List<String> filiere;
        private List<String> niveau;
        private List<String> entreprise;
        private List<String> ville;
        private YearRange anneeDiplome;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class YearRange {
        private Integer min;
        private Integer max;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PaginationParams {
        private Integer page;
        private Integer size;
    }
}
