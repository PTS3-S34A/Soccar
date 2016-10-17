package nl.soccar.exception;

/**
 * This class will keep up with all constants regarding the used Exceptions.
 *
 * @author PTS34A
 */
public final class ExceptionConstants {

    /**
     * Exception properties
     */
    public static final String DUPLICATE_ROOM_TITLE = "Invalid Room-name";
    public static final String DUPLICATE_ROOM_MESSAGE = "The roomname you specified has already been used.";

    public static final String WRONG_PASSWORD_TITLE = "Wrong Password";
    public static final String WRONG_PASSWORD_MESSAGE = "The password you entered is not correct.";

    public static final String ROOM_FULL_TITLE = "Room is overcrowded";
    public static final String ROOM_FULL_MESSAGE = "The room you want to enter is full";

    private ExceptionConstants() {
        // Private because this is a constants class, an instance should never be created.
    }

}
