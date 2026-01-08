package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class LangueParleesNotFoundException extends ApplicationException {
    
    public LangueParleesNotFoundException(Integer langueId) {
        super(String.format("Langue parlée non trouvée avec l'ID : %d", langueId),
              HttpStatus.NOT_FOUND,
              "LANGUE_PARLEES_NOT_FOUND");
    }
    
    public LangueParleesNotFoundException(Integer langueId, Integer cvId) {
        super(String.format("Langue parlée avec l'ID %d non trouvée pour le CV %d", langueId, cvId),
              HttpStatus.NOT_FOUND,
              "LANGUE_PARLEES_NOT_FOUND");
    }
}