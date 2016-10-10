package nl.soccar.exception;

/**
 *
 * @author PTS34A
 */
public class UIException extends Exception{
    private String title;
    
    public UIException(String title, String message) {
        super(message);
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
}
