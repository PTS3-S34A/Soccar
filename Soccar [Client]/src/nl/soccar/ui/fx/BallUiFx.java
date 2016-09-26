package nl.soccar.ui.fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import nl.soccar.library.Ball;
import nl.soccar.ui.input.Keyboard;

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
        Ball ball = super.getModel();

        context.setFill(Color.BLACK);
        context.fillOval(ball.getX(), ball.getY(), 50, 50);
    }

    @Override
    public void update() {
        Ball ball = super.getModel();
        Keyboard keyboard = Keyboard.getInstance();

        if (keyboard.isPressed(KeyCode.D) || keyboard.isPressed(KeyCode.RIGHT)) {
            ball.move(ball.getX() + 5, ball.getY(), ball.getDegree());
        } else if (keyboard.isPressed(KeyCode.A) || keyboard.isPressed(KeyCode.LEFT)) {
            ball.move(ball.getX() - 5, ball.getY(), ball.getDegree());
        }
        
        if (keyboard.isPressed(KeyCode.W) || keyboard.isPressed(KeyCode.UP)) {
            ball.move(ball.getX(), ball.getY() - 5, ball.getDegree());
        } else if (keyboard.isPressed(KeyCode.S) || keyboard.isPressed(KeyCode.DOWN)) {
            ball.move(ball.getX(), ball.getY() + 5, ball.getDegree());
        }
    }

}
