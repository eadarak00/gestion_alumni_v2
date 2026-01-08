package uasz.alumni.ms_invitation.exception;

public class InvitationNotFoundException extends RuntimeException {

    public InvitationNotFoundException(Long idInvitation) {
        super("Invitation introuvable avec l'ID : " + idInvitation);
    }

    public InvitationNotFoundException(String message) {
        super(message);
    }
}
