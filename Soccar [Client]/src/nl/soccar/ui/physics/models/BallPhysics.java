package nl.soccar.ui.physics.models;

import nl.soccar.ui.physics.WorldObject;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 *
 * @author PTS34A
 */
public class BallPhysics implements WorldObject {

    private final float DENSITY = 1.0F;
    private final float FRICTION = 0.0F;
    private final float RESTITUTION = 1.0F;

    private final Body body;
    private final float radius;

    public BallPhysics(float posX, float posY, int radius, World world) {
        this.radius = radius;

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(posX, posY);

        CircleShape cs = new CircleShape();
        cs.m_radius = radius;

        FixtureDef fd = new FixtureDef();
        fd.density = DENSITY;
        fd.friction = FRICTION;
        fd.density = RESTITUTION;

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

    public float getX() {
        return body.getPosition().x;
    }

    public float getY() {
        return body.getPosition().y;
    }

    public float getDegree() {
        return body.m_sweep.a;
    }
}
