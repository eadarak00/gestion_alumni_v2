package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class CompetenceNotFoundException extends ApplicationException {
    
    public CompetenceNotFoundException(Integer competenceId) {
        super(String.format("Compétence non trouvée avec l'ID : %d", competenceId),
              HttpStatus.NOT_FOUND,
              "COMPETENCE_NOT_FOUND");
    }
    
    public CompetenceNotFoundException(Integer competenceId, Integer cvId) {
        super(String.format("Compétence avec l'ID %d non trouvée pour le CV %d", competenceId, cvId),
              HttpStatus.NOT_FOUND,
              "COMPETENCE_NOT_FOUND");
    }
}