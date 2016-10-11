package nl.soccar.exception;

/**
 * An InvalidCredentialException is a Exception that is thrown when the user
 * fills-out the wrong credentials; For example: Wrong password for a room.
 *
 * @author PTS34A
 */
public class InvalidCredentialException extends UIException {

    /**
     * Initiates a new InvalidCredentialException object.
     *
     * @param title The title for the exception, which will be displayed.
     * @param message The exception-message, which will be displayed.
     */
    public InvalidCredentialException(String title, String message) {
        super(title, message);
    }

}
