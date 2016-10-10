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
