package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import nl.soccar.library.Obstacle;
import nl.soccar.library.enumeration.ObstacleType;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.PhysicsDrawableFx;
import nl.soccar.ui.physics.models.ObstaclePhysics;
import nl.soccar.util.PhysicsUtilities;
import org.jbox2d.dynamics.World;

/**
 * An ObstacleUiFx object represents a JavaFX Drawable of an Obstacle. It keeps track of the Obstacle and ObstaclePhysics models and provides methods to draw and update the models.
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
    private ObstacleUiFx(GameCanvasFx canvas, Obstacle obstacle, ObstaclePhysics physics) {
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
                // The wall obstacle is never drawn, it is invisible.
                break;
        }

        context.restore(); // Restore canvas to display a rotated image.
    }

    public static class ObstacleBuilder {

        private final GameCanvasFx canvas;
        private final World world;

        private float x;
        private float y;
        private float degree;
        private float width;
        private float height;
        private ObstacleType type;

        public ObstacleBuilder(GameCanvasFx canvas, World world) {
            this.canvas = canvas;
            this.world = world;
        }

        public ObstacleBuilder x(float x) {
            this.x = x;
            return this;
        }

        public ObstacleBuilder y(float y) {
            this.y = y;
            return this;
        }

        public ObstacleBuilder degree(float degree) {
            this.degree = degree;
            return this;
        }

        public ObstacleBuilder width(float width) {
            this.width = width;
            return this;
        }

        public ObstacleBuilder height(float height) {
            this.height = height;
            return this;
        }

        public ObstacleBuilder type(ObstacleType type) {
            this.type = type;
            return this;
        }

        public ObstacleUiFx build() {
            Obstacle obstacle = new Obstacle(x, y, degree, width, height, type);
            ObstaclePhysics obstaclePhysics = new ObstaclePhysics(obstacle, world);
            ObstacleUiFx obstacleUiFx = new ObstacleUiFx(canvas, obstacle, obstaclePhysics);
            return obstacleUiFx;
        }
        
    }
}
