package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import nl.soccar.library.Ball;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.PhysicsDrawableFx;
import nl.soccar.ui.physics.models.BallPhysics;
import nl.soccar.util.PhysicsUtilities;

/**
 *
 * @author PTS34A
 */
public class BallUiFx extends PhysicsDrawableFx<Ball, BallPhysics> {

    private static final Color COLOR = Color.BLACK;

    public BallUiFx(GameCanvasFx canvas, Ball ball, BallPhysics physics) {
        super(canvas, ball, physics);
    }

    @Override
    public void update() {
        BallPhysics physics = super.getPhysicsModel();
        physics.step();

        Ball ball = super.getModel();
        ball.move(physics.getX(), physics.getY(), physics.getDegree());
    }

    @Override
    public void draw(GraphicsContext context) {
        Ball ball = super.getModel();

        float radius = PhysicsUtilities.toPixelWidth(ball.getRadius());
        float x = PhysicsUtilities.toPixelX(ball.getX()) - radius;
        float y = PhysicsUtilities.toPixelY(ball.getY()) - radius;

        context.setFill(COLOR);
        context.fillOval(x, y, radius * 2, radius * 2);
    }

}
