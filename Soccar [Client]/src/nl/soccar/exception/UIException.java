package nl.soccar.exception;

/**
 * UIException is the super-class wich the individual UI-Exception classes
 * extend.
 *
 * @author PTS34A
 */
public class UIException extends Exception {

    private final String title;

    /**
     * Initiates a new UIException object.
     *
     * @param title The title for the exception, it will be used to display an
     * alert. The title shouldn't be null or empty.
     * @param message The exception-message, it will be used to display an
     * alert. The title shouldn't be null or empty.
     */
    public UIException(String title, String message) {
        super(message);
        this.title = title;
    }

    /**
     * Gets the title of this exception. The title, in turn, will be used to
     * display on an alert.
     *
     * @return String The title of the message. The title will never be null.
     */
    public String getTitle() {
        return title;
    }

}
