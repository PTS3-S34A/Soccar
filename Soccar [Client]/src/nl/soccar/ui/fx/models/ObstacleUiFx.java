package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import nl.soccar.library.Obstacle;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.PhysicsDrawableFx;
import nl.soccar.ui.physics.models.ObstaclePhysics;
import nl.soccar.util.PhysicsUtilities;

/**
 * An ObstacleUiFx object represents a JavaFX Drawable of an Obstacle. It keeps track
 * of the Obstacle and ObstaclePhysics models and provides methods to draw and
 * update the models.
 *
 * @author PTS34A
 */
public class ObstacleUiFx extends PhysicsDrawableFx<Obstacle, ObstaclePhysics> {

    private static final Color WALL_COLOR;

    static {
        WALL_COLOR = Color.RED;
    }

    /**
     * Initiates a new ObstacleUiFx Object using the given parameters.
     *
     * @param canvas The canvas on which this Obstacle is placed.
     * @param obstacle The model to keep track of.
     * @param physics The physics-model to keep track of.
     */
    public ObstacleUiFx(GameCanvasFx canvas, Obstacle obstacle, ObstaclePhysics physics) {
        super(canvas, obstacle, physics);
    }

    @Override
    public void update() {
        // The update method is not implemented because obstacles never move on the map.
    }

    @Override
    public void draw(GraphicsContext context) {
        Obstacle obstacle = super.getModel();

        float x = PhysicsUtilities.toPixelX(obstacle.getX());
        float y = PhysicsUtilities.toPixelY(obstacle.getY());
        float width = PhysicsUtilities.toPixelWidth(obstacle.getWidth());
        float height = PhysicsUtilities.toPixelHeight(obstacle.getHeight());

        context.save(); // Save the canvas so we can draw a rotated rectangle.

        context.translate(x, y); // Set the origin point of the rotation.
        context.rotate(-obstacle.getDegree()); // Set the angle of the rotation.
        
        switch (obstacle.getType()) {            
            default:
            case WALL:
                // TODO: remove drawing implementation of the wall after testing.
                context.setFill(WALL_COLOR);
                context.fillRect(-width / 2, -height / 2, width, height); // Draw the rectangle from the top left
                break;
        }

        context.restore(); // Restore canvas to display a rotated image.
    }
}
