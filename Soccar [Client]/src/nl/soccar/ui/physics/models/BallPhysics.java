package nl.soccar.ui.physics.models;

import nl.soccar.library.Ball;
import nl.soccar.ui.physics.WorldObject;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * BallPhysics is a physics-model that keeps track of the physics of the Ball.
 * 
 * @author PTS34A
 */
public class BallPhysics implements WorldObject {

    private static final float DENSITY = 1.0F;
    private static final float FRICTION = 0.0F;
    private static final float RESTITUTION = 1.0F;

    private final Body body;
    private final float radius;

    /**
     * Initiates a new BallPhysics Object using the given parameter.
     * 
     * @param ball The model to keep track of.
     * @param world The world in which this model is placed.
     */
    public BallPhysics(Ball ball, World world) {
        radius = ball.getRadius();

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(ball.getX(), ball.getY());

        CircleShape cs = new CircleShape();
        cs.m_radius = radius;

        FixtureDef fd = new FixtureDef();
        fd.density = DENSITY;
        fd.friction = FRICTION;
        fd.density = RESTITUTION;
        fd.shape = cs;

        body = world.createBody(bd);
        body.createFixture(fd);
    }

    @Override
    public void step() {
        // Lateral velocity
        Vec2 impulse = body.getLinearVelocity().mul(-1.0F);
        body.applyLinearImpulse(impulse, body.getWorldCenter());

        // Angular velocity
        body.applyAngularImpulse(0.1F * body.getInertia() * -body.getAngularVelocity());
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
        return body.m_sweep.a;
    }
}
