package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException extends ApplicationException {
    
    public ResourceAlreadyExistsException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s existe déjà avec %s : '%s'", resourceName, fieldName, fieldValue),
              HttpStatus.CONFLICT,
              "RESOURCE_ALREADY_EXISTS");
    }
    
    public ResourceAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT, "RESOURCE_ALREADY_EXISTS");
    }
}