package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends ApplicationException {
    
    public ValidationException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "VALIDATION_ERROR");
    }
    
    public ValidationException(String field, String message) {
        super(String.format("Erreur de validation pour le champ '%s' : %s", field, message),
              HttpStatus.BAD_REQUEST,
              "VALIDATION_ERROR");
    }
}