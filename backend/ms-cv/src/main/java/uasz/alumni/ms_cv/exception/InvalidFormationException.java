package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class InvalidFormationException extends ApplicationException {
    
    public InvalidFormationException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "INVALID_FORMATION");
    }
}