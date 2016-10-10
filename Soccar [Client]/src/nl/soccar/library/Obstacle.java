package nl.soccar.library;

import nl.soccar.library.enumeration.ObstacleType;

/**
 * Class that represents the Obstacle model.
 * 
 * @author Robin Laugs
 */
public class Obstacle extends Entity {

    private final float width;
    private final float height;
    private final ObstacleType type;

    /**
     * Initiates a new Obstacle using the given parameters.
     * 
     * @param x The x-coordinate, relative to the map, of this Obstacle.
     * @param y The y-coordinate, relative to the map, of this Obstacle.
     * @param degree The angle of this Obstacle.
     * @param width The width of this Obstacle.
     * @param height The height of this Obstacle.
     * @param type The type of this Obstacle. An ObstacleType determines how this Obstacle will be drawn on the map.
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

    public ObstacleType getType() {
        return type;
    }
    
}
