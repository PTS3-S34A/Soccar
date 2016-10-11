package nl.soccar.exception;

/**
 * An DuplicateValueException is a Exception that is thrown when the user
 * fillsout a value that allready excists; For example: Duplicate room-name.
 *
 * @author PTS34A
 */
public class DuplicateValueException extends UIException {

    /**
     * Initiates a new DuplicateValueException object.
     *
     * @param title The title for the exception, which will be displayed.
     * @param message The exception-message, which will be displayed.
     */
    public DuplicateValueException(String title, String message) {
        super(title, message);
    }

}
