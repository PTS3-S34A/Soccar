package nl.soccar.exception;

/**
 * A DuplicateValueException is an Exception that is thrown when the user fills
 * out a value that allready excists; For example: Duplicate room-name.
 *
 * @author PTS34A
 */
public class DuplicateValueException extends UIException {

    /**
     * Initiates a new DuplicateValueException object.
     *
     * @param title The title for the exception, it will be used to display an
     * alert. The title shouldn't be null or empty.
     * @param message The exception-message, it wil be used to display an alert.
     * The message shouldn't be null or empty.
     */
    public DuplicateValueException(String title, String message) {
        super(title, message);
    }

}
