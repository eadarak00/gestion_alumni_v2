package uasz.alumni.ms_cv.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {
    
    private final HttpStatus status;
    private final String code;
    
    public ApplicationException(String message, HttpStatus status, String code) {
        super(message);
        this.status = status;
        this.code = code;
    }
    
    public ApplicationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.code = status.name();
    }
}