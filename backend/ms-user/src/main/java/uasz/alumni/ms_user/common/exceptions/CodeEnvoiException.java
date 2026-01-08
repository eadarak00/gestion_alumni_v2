package uasz.alumni.ms_user.common.exceptions;


public class CodeEnvoiException extends RuntimeException {
    
    public CodeEnvoiException(String message) {
        super(message);
    }

    public CodeEnvoiException(String message, Throwable cause) {
        super(message, cause);
    }
}