package nl.soccar.library;

/**
 * An Entity is an Object which is placed on a Map. It contains a position which
 * is relative to the Map it is placed on. It also has the posibility to alter
 * its position.
 *
 * @author PTS34A
 */
public abstract class Entity {

    protected float x;
    protected float y;
    protected float degree;

    /**
     * Constructor used to instantiate a new Entity object.
     *
     * @param x The X-position of this Entity, relative to the Map this Entity
     * is placed on.
     * @param y The Y-position of this Entity, relative to the Map this Entity
     * is placed on.
     * @param degree The angle, in degrees, in which this Entity is going in,
     * relative to the Map this Entity is placed on.
     */
    public Entity(float x, float y, float degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
    }

    /**
     * Moves this Entity around on the Map.
     *
     * @param x The new X-position.
     * @param y The new Y-position.
     * @param degree The new angle, in degrees.
     */
    public void move(float x, float y, float degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
    }

    /**
     * Gets the X-position of this Entity.
     *
     * @return The X-position of this Entity, relative to the Map it is placed
     * on, not null.
     */
    public final float getX() {
        return x;
    }

    /**
     * Gets the Y-position of this Entity.
     *
     * @return The Y-position of this Entity, relative to the Map it is placed
     * on, not null.
     */
    public final float getY() {
        return y;
    }

    /**
     * Gets the angle of this Entity.
     *
     * @return The angle of this Entity, in degrees, not null.
     */
    public final float getDegree() {
        return degree;
    }

}
