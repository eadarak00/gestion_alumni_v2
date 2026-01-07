package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class CertificationAlreadyExistsException extends ApplicationException {
    
    public CertificationAlreadyExistsException(String nomCertification, String organisme) {
        super(String.format("La certification '%s' de '%s' existe déjà pour ce CV", 
              nomCertification, organisme),
              HttpStatus.CONFLICT,
              "CERTIFICATION_ALREADY_EXISTS");
    }
}