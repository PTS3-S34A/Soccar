package nl.soccar.exception;

/**
 * A RoomException is an Exception that is thrown when something's wrong with
 * the room; For example: Room is full.
 *
 * @author PTS34A
 */
public class RoomException extends UIException {

    /**
     * Initiates a new RoomException object.
     *
     * @param title The title for the exception, it will be used to display an
     * alert. The title shouldn't be null or empty.
     * @param message The exception-message, it will be used to display an
     * alert. The message shouldn't be null or empty.
     */
    public RoomException(String title, String message) {
        super(title, message);
    }

}
