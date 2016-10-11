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
     * @param title The title for the exception, which will be displayed.
     * @param message The exception-message, which will be displayed.
     */
    public UIException(String title, String message) {
        super(message);
        this.title = title;
    }

    /**
     * Returns the title of this exception object
     *
     * @return String The title of the exception.
     */
    public String getTitle() {
        return title;
    }

}
