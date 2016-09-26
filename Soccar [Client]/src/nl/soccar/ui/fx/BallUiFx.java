package nl.soccar.ui.fx;

import javafx.scene.canvas.GraphicsContext;
import nl.soccar.library.Ball;

/**
 *
 * @author PTS34A
 */
public class BallUiFx extends DrawableFx<Ball> {

    public BallUiFx(GameCanvasFx canvas, Ball ball) {
        super(canvas, ball);
    }

    @Override
    public void draw(GraphicsContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
