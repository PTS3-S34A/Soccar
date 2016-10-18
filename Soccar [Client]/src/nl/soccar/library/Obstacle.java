package nl.soccar.library;

import nl.soccar.library.enumeration.ObstacleType;

/**
 * An Obstacle is an Entity that, generally, is unable to move. It is used for
 * collision with other Entities.
 *
 * @author PTS34A
 */
public class Obstacle extends Entity {

    private final float width;
    private final float height;
    private final ObstacleType type;

    /**
     * Constructor used to instantiate a new Obstacle object.
     *
     * @param x The X-position of this Obstacle, relative to the Map this
     * Obstacle is placed on.
     * @param y The Y-position of this Obstacle, relative to the Map this
     * Obstacle is placed on.
     * @param degree The angle, in degrees, in which this Obstacle is going in,
     * relative to the Map this Obstacle is placed on.
     * @param width The width of this Obstacle, in JBox2D units.
     * @param height The height of this Obstacle, in JBox2D units.
     * @param type The ObstacleType of this Obstacle. The type determines how
     * this Obstacle will be drawn on the screen.
     */
    public Obstacle(float x, float y, float degree, float width, float height, ObstacleType type) {
        super(x, y, degree);
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public ObstacleType getObstacleType() {
        return type;
    }

}
