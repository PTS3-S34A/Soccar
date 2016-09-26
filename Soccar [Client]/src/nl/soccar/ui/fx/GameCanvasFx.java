package nl.soccar.ui.fx;

import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import nl.soccar.ui.Drawable;
import nl.soccar.ui.GameCanvas;

/**
 *
 * @author PTS34A
 */
public class GameCanvasFx extends GameCanvas {

    private GraphicsContext context;

    public GameCanvasFx(GraphicsContext context) {
        this.context = context;
    }

    public void render() {
        clear();
        
        List<Drawable> drawables = super.getDrawables();
        drawables.stream().forEach(d -> d.draw(context));
    }

    private void clear() {
        Canvas canvas = context.getCanvas();
        context.clearRect(0D, 0D, canvas.getWidth(), canvas.getHeight());
    }

}
