package uasz.alumni.ms_invitation.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvitationExist.class)
    public ResponseEntity<Object> handleInvitationExist(InvitationExist ex) {
        return buildResponse(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvitationNotFoundException.class)
    public ResponseEntity<Object> handleInvitationNotFound(InvitationNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvitationExpiredException.class)
    public ResponseEntity<Object> handleInvitationExpired(InvitationExpiredException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.GONE);
    }

    @ExceptionHandler(InvalidInvitationStateException.class)
    public ResponseEntity<Object> handleInvalidState(InvalidInvitationStateException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Object> handleInvalidToken(InvalidTokenException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StatisticsNotAvailableException.class)
    public ResponseEntity<Object> handleStatisticsError(StatisticsNotAvailableException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneric(Exception ex, HttpServletRequest request) {
        String uri = request.getRequestURI();
        // NE PAS intercepter les ressources Swagger/OpenAPI
        if (uri.startsWith("/swagger-ui") || uri.startsWith("/v3/api-docs")) {
            throw new RuntimeException(ex); // Laisser Spring gérer la 404 ou autres
        }
        return buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> buildResponse(String message, HttpStatus status) {
        ApiExceptionResponse response = new ApiExceptionResponse(
                message,
                status,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(response, status);
    }
}
