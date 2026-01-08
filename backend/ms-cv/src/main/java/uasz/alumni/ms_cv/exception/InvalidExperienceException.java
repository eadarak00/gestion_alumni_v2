package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class InvalidExperienceException extends ApplicationException {
    
    public InvalidExperienceException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "INVALID_EXPERIENCE");
    }
}