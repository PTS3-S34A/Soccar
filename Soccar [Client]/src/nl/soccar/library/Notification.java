package nl.soccar.library;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Class that represents the Notification model.
 * 
 * @author Robin Laugs
 */
public class Notification extends Entity {

    private final String content;
    private final Font font;
    private final Color fill;
    private final Color stroke;

    /**
     * Initiates a new Notification using the given parameters.
     * @param x The x-coordinate, relative to the map, of this Notification.
     * @param y The y-coordinate, relative to the map, of this Notification.
     * @param degree The angle of this Notification.
     * @param content The text to be displayed.
     * @param font The font for the text to be displayed.
     * @param fill The fill color for the text.
     * @param stroke The stroke color for the text.
     */
    public Notification(float x, float y, float degree, String content, Font font, Color fill, Color stroke) {
        super(x, y, degree);
        this.content = content;
        this.font = font;
        this.fill = fill;
        this.stroke = stroke;
    }

    public String getContent() {
        return content;
    }

    public Font getFont() {
        return font;
    }

    public Color getStroke() {
        return stroke;
    }

    public Color getFill() {
        return fill;
    }
}
