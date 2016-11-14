package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.TextAlignment;
import nl.soccar.library.Notification;
import nl.soccar.library.ScoreBoard;
import nl.soccar.ui.fx.DrawableFx;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.util.PhysicsUtilities;

/**
 * A NotificationUiFx object represents a JavaFX Drawable of a Notification.
 * It keeps track of the Notification and NotificationPhysics models and provides methods to draw and
 * update the models.
 *
 * @author PTS34A
 */
public class ScoreBoardUIFx extends DrawableFx<ScoreBoard> {

    /**
     * Initiates a new NotificationUiFx Object using the given parameters.
     *
     * @param canvas       The canvas on which this Notification is placed.
     * @param notification The notification model to keep track of.
     */
    public ScoreBoardUIFx(GameCanvasFx canvas, ScoreBoard scoreboard) {
        super(canvas, scoreboard);
    }

    @Override
    public void draw(GraphicsContext context) {
        ScoreBoard time = super.getModel();

        float x = PhysicsUtilities.toPixelX(time.getX());
        float y = time.getY();

        context.setTextAlign(TextAlignment.CENTER);
        context.setFont(time.getFont());
        context.setFill(time.getFill());
        context.fillText(time.getContent(), x, y);
        context.strokeText(time.getContent(), x, y);
    }

}
