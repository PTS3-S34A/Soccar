package nl.soccar.ui.physics;

import org.jbox2d.dynamics.World;

/**
 * Container class to keep track of the world, and apply settings.
 *
 * @author PTS34A
 */
public class GamePhysics {

    private final World world;

    /**
     * Initiates a new GamePhysics Object. It creates a world using settings
     * defined in constants.
     */
    public GamePhysics() {
        // doSleep (second parameter) is true for better performance
        world = new World(PhysicsContants.GRAVITY_ANGLE, true);
    }

    /**
     * Steps the underlying world and applies all kinds of factors to update
     * all physics models.
     */
    public void step() {
        world.step(1.0F / PhysicsContants.FPS, PhysicsContants.VELOCITY_ITERATIONS, PhysicsContants.POSITION_ITERATIONS);
    }

    public World getWorld() {
        return world;
    }

}
