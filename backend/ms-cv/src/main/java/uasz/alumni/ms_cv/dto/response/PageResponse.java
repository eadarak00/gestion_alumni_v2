package uasz.alumni.ms_cv.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {
    
    /**
     * Contenu de la page
     */
    private List<T> content;
    
    /**
     * Numéro de la page actuelle (commence à 0)
     */
    private int pageNumber;
    
    /**
     * Taille de la page (nombre d'éléments par page)
     */
    private int pageSize;
    
    /**
     * Nombre total d'éléments
     */
    private long totalElements;
    
    /**
     * Nombre total de pages
     */
    private int totalPages;
    
    /**
     * Indique si c'est la dernière page
     */
    private boolean last;
    
    /**
     * Indique si c'est la première page
     */
    private boolean first;
    
    /**
     * Indique si la page est vide
     */
    public boolean isEmpty() {
        return content == null || content.isEmpty();
    }
    
    /**
     * Retourne le nombre d'éléments dans la page actuelle
     */
    public int getNumberOfElements() {
        return content != null ? content.size() : 0;
    }
    
    /**
     * Indique s'il y a une page suivante
     */
    public boolean hasNext() {
        return !last;
    }
    
    /**
     * Indique s'il y a une page précédente
     */
    public boolean hasPrevious() {
        return !first;
    }
}