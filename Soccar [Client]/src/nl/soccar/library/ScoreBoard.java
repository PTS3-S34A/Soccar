package nl.soccar.library;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.soccar.ui.DisplayConstants;

/**
 * Class that represents the Notification model.
 * 
 * @author Robin Laugs
 */
public class ScoreBoard extends Entity {

    private int scoreBlue;
    private int scoreRed;
    private String time;
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
    public ScoreBoard() {
        super(DisplayConstants.MAP_WIDTH / 2, 45, 0);
        this.font = Font.font("Arial", FontWeight.LIGHT, 35);
        this.fill = Color.WHITE;
        this.stroke = Color.BLACK;
        scoreBlue = 0;
        scoreRed = 0;
    }

    public int getScoreBlue() {
        return scoreBlue;
    }

    public void setScoreBlue(int scoreBlue) {
        this.scoreBlue = scoreBlue;
    }

    public int getScoreRed() {
        return scoreRed;
    }

    public void setScoreRed(int scoreRed) {
        this.scoreRed = scoreRed;
    }

    public String getContent() {
        return this.scoreBlue + " - " + this.time + " - " + this.scoreRed;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
