package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

public class PDFGenerationException extends ApplicationException {
    
    public PDFGenerationException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, "PDF_GENERATION_ERROR");
    }
    
    public PDFGenerationException(String message, Throwable cause) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, "PDF_GENERATION_ERROR");
        initCause(cause);
    }
}