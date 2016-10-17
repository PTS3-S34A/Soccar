package nl.soccar.exception;

/**
 * An InvalidCredentialException is an Exception that is thrown when the user
 * fills out the wrong credentials; For example: Wrong password for a room.
 *
 * @author PTS34A
 */
public class InvalidCredentialException extends UIException {

    /**
     * Initiates a new InvalidCredentialException object.
     *
     * @param title The title of the exception, it will be used to display an
     * alert. The title shouldn't be null or empty.
     * @param message The exception-message, it will be used to display an
     * alert. The message shouldn't be null or empty.
     */
    public InvalidCredentialException(String title, String message) {
        super(title, message);
    }

}
