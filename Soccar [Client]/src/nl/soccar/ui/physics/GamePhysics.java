package nl.soccar.ui.physics;

import org.jbox2d.dynamics.World;

/**
 *
 * @author PTS34A
 */
public class GamePhysics {

    private final World world;

    public GamePhysics() {
        // doSleep (second parameter) is true for better performance
        world = new World(PhysicsContants.GRAVITY_ANGLE, true);
    }

    public void step() {
        world.step(1.0F / PhysicsContants.FPS, PhysicsContants.VELOCITY_ITERATIONS, PhysicsContants.POSITION_ITERATIONS);
    }

}
