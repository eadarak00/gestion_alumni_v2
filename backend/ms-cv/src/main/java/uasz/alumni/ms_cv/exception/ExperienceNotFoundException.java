package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class ExperienceNotFoundException extends ApplicationException {
    
    public ExperienceNotFoundException(Integer experienceId) {
        super(String.format("Expérience non trouvée avec l'ID : %d", experienceId),
              HttpStatus.NOT_FOUND,
              "EXPERIENCE_NOT_FOUND");
    }
    
    public ExperienceNotFoundException(Integer experienceId, Integer cvId) {
        super(String.format("Expérience avec l'ID %d non trouvée pour le CV %d", experienceId, cvId),
              HttpStatus.NOT_FOUND,
              "EXPERIENCE_NOT_FOUND");
    }
}