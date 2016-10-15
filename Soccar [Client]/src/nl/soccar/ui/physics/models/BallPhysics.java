package nl.soccar.ui.physics.models;

import nl.soccar.library.Ball;
import nl.soccar.ui.physics.WorldObject;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.*;

/**
 * BallPhysics is a physics-model that keeps track of the physics of the Ball.
 *
 * @author PTS34A
 */
public class BallPhysics implements WorldObject {

    private static final float DENSITY = 0.01F;
    private static final float FRICTION = 1.0F;
    private static final float RESTITUTION = 0.8F;

    private static final float LINEAR_DAMPING = 1.0F;
    private static final float ANGULAR_DAMPING = 1.0F;

    private final Body body;
    private final float radius;

    /**
     * Initiates a new BallPhysics Object using the given parameter.
     *
     * @param ball  The ball model to keep track of.
     * @param world The world in which this model is placed.
     */
    public BallPhysics(Ball ball, World world) {
        radius = ball.getRadius();

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(ball.getX(), ball.getY());
        bd.linearDamping = LINEAR_DAMPING;
        bd.angularDamping = ANGULAR_DAMPING;

        CircleShape cs = new CircleShape();
        cs.m_radius = radius;

        FixtureDef fd = new FixtureDef();
        fd.density = DENSITY;
        fd.friction = FRICTION;
        fd.restitution = RESTITUTION;
        fd.shape = cs;

        body = world.createBody(bd);
        body.createFixture(fd);
    }

    @Override
    public void step() {
        // The step method is not implemented because Box2D handles all necessary updates.
    }

    @Override
    public float getX() {
        return body.getPosition().x;
    }

    @Override
    public float getY() {
        return body.getPosition().y;
    }

    @Override
    public float getDegree() {
        return (float) Math.toDegrees(body.getAngle());
    }

}
