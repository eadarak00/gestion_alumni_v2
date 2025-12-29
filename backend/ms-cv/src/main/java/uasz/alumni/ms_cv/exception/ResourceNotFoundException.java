package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {
    
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s non trouvé(e) avec %s : '%s'", resourceName, fieldName, fieldValue),
              HttpStatus.NOT_FOUND,
              "RESOURCE_NOT_FOUND");
    }
    
    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, "RESOURCE_NOT_FOUND");
    }
}