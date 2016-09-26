package nl.soccar.library;

import nl.soccar.library.enumeration.BallType;

/**
 * A Ball, placed on a Map, is an Entity that moves around.
 * 
 * @author PTS34A
 */
public class Ball extends Entity {

    private final BallType type;

    /**
     * Initiates a new Ball Object.
     * 
     * @param x The x-position of this Ball.
     * @param y The y-position of this Ball.
     * @param degree The degree which this Ball is going in.
     * @param type The type of this Ball.
     */
    public Ball(double x, double y, double degree, BallType type) {
        super(x, y, degree);
        this.type = type;
    }
    
    @Override
    public void move(double x, double y, double degree) {
        super.x = x;
        super.y = y;
        super.degree = degree;
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
