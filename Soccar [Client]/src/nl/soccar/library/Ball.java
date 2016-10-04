package nl.soccar.library;

import nl.soccar.library.enumeration.BallType;

/**
 * A Ball, placed on a Map, is an Entity that moves around.
 *
 * @author PTS34A
 */
public class Ball extends Entity {

    private final float radius;
    private final BallType type;

    /**
     * Initiates a new Ball Object.
     *
     * @param x The x-position of this Ball.
     * @param y The y-position of this Ball.
     * @param degree The degree which this Ball is going in.
     * @param radius The radius of this Ball.
     * @param type The type of this Ball.
     */
    public Ball(float x, float y, float degree, float radius, BallType type) {
        super(x, y, degree);
        this.radius = radius;
        this.type = type;
    }

    @Override
    public void move(float x, float y, float degree) {
        super.x = x;
        super.y = y;
        super.degree = degree;
    }

    /**
     * Gets the radius of this Ball.
     * 
     * @return The radius of this ball.
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Gets the type of this Ball.
     *
     * @return The type of this Ball.
     */
    public BallType getType() {
        return type;
    }

}
