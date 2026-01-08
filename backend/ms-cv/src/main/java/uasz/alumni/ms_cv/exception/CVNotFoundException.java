package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class CVNotFoundException extends ApplicationException {
    
    public CVNotFoundException(Integer cvId) {
        super(String.format("CV non trouvé avec l'ID : %d", cvId),
              HttpStatus.NOT_FOUND,
              "CV_NOT_FOUND");
    }
    
    public CVNotFoundException(Integer cvId, Integer utilisateurId) {
        super(String.format("CV avec l'ID %d non trouvé pour l'utilisateur %d", cvId, utilisateurId),
              HttpStatus.NOT_FOUND,
              "CV_NOT_FOUND");
    }
    
    public CVNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, "CV_NOT_FOUND");
    }
}