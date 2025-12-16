package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class FormationNotFoundException extends ApplicationException {
    
    public FormationNotFoundException(Integer formationId) {
        super(String.format("Formation non trouvée avec l'ID : %d", formationId),
              HttpStatus.NOT_FOUND,
              "FORMATION_NOT_FOUND");
    }
    
    public FormationNotFoundException(Integer formationId, Integer cvId) {
        super(String.format("Formation avec l'ID %d non trouvée pour le CV %d", formationId, cvId),
              HttpStatus.NOT_FOUND,
              "FORMATION_NOT_FOUND");
    }
}