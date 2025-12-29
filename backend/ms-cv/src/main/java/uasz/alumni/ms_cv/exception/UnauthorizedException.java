package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApplicationException {
    
    public UnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
    }
    
    public UnauthorizedException() {
        super("Vous n'êtes pas autorisé à accéder à cette ressource",
              HttpStatus.UNAUTHORIZED,
              "UNAUTHORIZED");
    }
}