package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;
import uasz.alumni.ms_cv.model.Langues;

public class LangueAlreadyExistsException extends ApplicationException {
    
    public LangueAlreadyExistsException(Langues langue, Integer cvId) {
        super(String.format("La langue '%s' est déjà enregistrée pour ce CV", langue),
              HttpStatus.CONFLICT,
              "LANGUE_ALREADY_EXISTS");
    }
}