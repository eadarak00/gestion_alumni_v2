package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class CompetenceAlreadyExistsException extends ApplicationException {
    
    public CompetenceAlreadyExistsException(String nomCompetence, Integer cvId) {
        super(String.format("La compétence '%s' existe déjà pour ce CV", nomCompetence),
              HttpStatus.CONFLICT,
              "COMPETENCE_ALREADY_EXISTS");
    }
}