package nl.soccar.exception;

/**
 * A RoomException is an Exception that is thrown when something's wrong with
 * the room; For example; Room is full.
 *
 * @author PTS34A
 */
public class RoomException extends UIException {

    /**
     * Initiates a new RoomException object.
     *
     * @param title The title for the exception, which will be displayed.
     * @param message The exception-message, which will be displayed.
     */
    public RoomException(String title, String message) {
        super(title, message);
    }

}
