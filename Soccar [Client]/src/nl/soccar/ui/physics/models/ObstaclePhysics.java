package nl.soccar.ui.physics.models;

import nl.soccar.library.Game;
import nl.soccar.library.Obstacle;
import nl.soccar.ui.physics.WorldObject;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 *
 * @author PTS34A
 */
public class ObstaclePhysics implements WorldObject {

    private final float FRICTION = 0.0F;

    private final Body body;

    private float width;
    private float height;

    public ObstaclePhysics(Obstacle obstacle, World world) {
        BodyDef bd = new BodyDef();
        bd.position.set(obstacle.getX(), obstacle.getY());
        bd.angle = (float) Math.toRadians(obstacle.getDegree());

        PolygonShape ps = new PolygonShape();
        ps.setAsBox(width / 2, height / 2);

        FixtureDef fd = new FixtureDef();
        fd.friction = FRICTION;
        fd.shape = ps;

        body = world.createBody(bd);
        body.createFixture(fd);
    }

    @Override
    public void step() {
        // The step method is not implemented because obstacles never move on the map.
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
