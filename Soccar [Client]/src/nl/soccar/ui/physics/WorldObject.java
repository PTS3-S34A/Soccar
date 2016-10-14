package nl.soccar.ui.physics;
import org.jbox2d.dynamics.Body;

/**
 * A WorldObject represents a physics-model which are eventually tracked by
 * Drawables. It provides methods to update this model, and provides getters for
 * location purposes.
 *
 * @author PTS34A
 */
public interface WorldObject {

    /**
     * The step method will be executed every tick. It should be used to
     * update states of physics-objects, such as: applying velocity to a wheel.
     */
    void step();

    /**
     * Gets the x-coordinate of this physics-model, relative to the map it is
     * placed in.
     *
     * @return The x-coordinate of this WorldObject.
     */
    float getX();

    /**
     * Gets the y-coordinate of this physics-model, relative to the map it is
     * placed in.
     *
     * @return The y-coordinate of this WorldObject.
     */
    float getY();

    /**
     * Gets the angle of this physics-model, relative to the map it is placed
     * in.
     *
     * @return the angle of this WorldObject.
     */
    float getDegree();

    Body getBody();

}