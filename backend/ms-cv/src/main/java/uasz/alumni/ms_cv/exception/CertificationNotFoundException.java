package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class CertificationNotFoundException extends ApplicationException {
    
    public CertificationNotFoundException(Integer certificationId) {
        super(String.format("Certification non trouvée avec l'ID : %d", certificationId),
              HttpStatus.NOT_FOUND,
              "CERTIFICATION_NOT_FOUND");
    }
    
    public CertificationNotFoundException(Integer certificationId, Integer cvId) {
        super(String.format("Certification avec l'ID %d non trouvée pour le CV %d", certificationId, cvId),
              HttpStatus.NOT_FOUND,
              "CERTIFICATION_NOT_FOUND");
    }
}