package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApplicationException {
    
    public ForbiddenException(String message) {
        super(message, HttpStatus.FORBIDDEN, "FORBIDDEN");
    }
    
    public ForbiddenException() {
        super("Vous n'avez pas les permissions nécessaires pour effectuer cette action",
              HttpStatus.FORBIDDEN,
              "FORBIDDEN");
    }
}