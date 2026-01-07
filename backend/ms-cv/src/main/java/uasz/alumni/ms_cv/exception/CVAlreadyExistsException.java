package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class CVAlreadyExistsException extends ApplicationException {
    
    public CVAlreadyExistsException(Integer utilisateurId) {
        super(String.format("L'utilisateur %d possède déjà un CV", utilisateurId),
              HttpStatus.CONFLICT,
              "CV_ALREADY_EXISTS");
    }
    
    public CVAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT, "CV_ALREADY_EXISTS");
    }
}