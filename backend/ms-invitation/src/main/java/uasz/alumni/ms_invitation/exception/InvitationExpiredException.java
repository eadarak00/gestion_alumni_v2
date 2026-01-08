package uasz.alumni.ms_invitation.exception;

public class InvitationExpiredException extends RuntimeException {

    public InvitationExpiredException(String message) {
        super(message);
    }

    public InvitationExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
