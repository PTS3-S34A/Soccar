package nl.soccar.library;

/**
 * An Entity is an Object which is placed on a Map.
 * It contains it's own method of moving around.
 * 
 * @author PTS34A
 */
public abstract class Entity {
    
    protected float x;
    protected float y;
    protected float degree;
    protected float velocity;

    /**
     * Initiates a new Entity Object.
     * 
     * @param x The x-position of this Entity.
     * @param y The y-position of this Entity.
     * @param degree The degree which this Entity is going.
     */
    public Entity(float x, float y, float degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
        velocity = 0;
    }
    
    /**
     * Moves this Entity around on the Map.
     * 
     * @param x The new x-position.
     * @param y The new y-position.
     * @param degree The new degree.
     */
    public void move(float x, float y, float degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
    }
    
    /**
     * Gets the x-position of this Entity.
     * 
     * @return The x-position of this Entity.
     */
    public final float getX() {
        return x;
    }

    /**
     * Gets the y-position of this Entity.
     * 
     * @return The y-position of this Entity.
     */
    public final float getY() {
        return y;
    }

    /**
     * Gets the degree of this Entity.
     * 
     * @return The degree of this Entity.
     */
    public final float getDegree() {
        return degree;
    }

    /**
     * Gets the velocity (speed) of this Entity.
     * 
     * @return The velocity of this Entity.
     */
    public final float getVelocity() {
        return velocity;
    }

}
