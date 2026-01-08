package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class InvalidCVException extends ApplicationException {
    
    public InvalidCVException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "INVALID_CV");
    }
}