package uasz.alumni.ms_cv_v2.exceptions;

public class CvGenerationException extends RuntimeException {
    public CvGenerationException(String message) {
        super(message);
    }
    
    public CvGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}