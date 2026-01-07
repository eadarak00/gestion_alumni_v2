package uasz.alumni.ms_cv.exception;

import org.springframework.http.HttpStatus;

import uasz.alumni.spi.model.TypeTemplate;

public class TemplateNotFoundException extends ApplicationException {
    
    public TemplateNotFoundException(TypeTemplate template) {
        super(String.format("Template '%s' non trouvé", template),
              HttpStatus.NOT_FOUND,
              "TEMPLATE_NOT_FOUND");
    }
    
    public TemplateNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, "TEMPLATE_NOT_FOUND");
    }
}