package nl.soccar.ui.physics.models;

import nl.soccar.ui.physics.PhysicsContants;
import nl.soccar.ui.physics.enumeration.ThrottleAction;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.PrismaticJointDef;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

/**
 *
 * @author PTS34A
 */
public class WheelPhysics {

    private final float DENSITY = 1.0F;
    private final boolean IS_SENSOR = true; // Do not include wheels in collision system (for performance).

    private final Body body;
    private final Body carBody;

    private final float width;
    private final float height;
    private boolean steerable;
    private boolean powered;

    private float acceleration = 0;

    public WheelPhysics(float relPosX, float relPosY, float width, float height, boolean steerable, boolean powered, Body carBody, World world) {
        this.width = width;
        this.height = height;
        this.steerable = steerable;
        this.powered = powered;
        this.carBody = carBody;

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position = carBody.getWorldPoint(new Vec2(relPosX, relPosY));
        bd.angle = carBody.getAngle();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2);

        FixtureDef fd = new FixtureDef();
        fd.density = DENSITY;
        fd.isSensor = IS_SENSOR;
        fd.shape = shape;

        body = world.createBody(bd);
        body.createFixture(fd);

        if (steerable) {
            RevoluteJointDef jd = new RevoluteJointDef();
            jd.initialize(carBody, body, body.getWorldCenter());
            jd.enableMotor = true;
            world.createJoint(jd);
        } else {
            PrismaticJointDef jd = new PrismaticJointDef();
            jd.initialize(carBody, body, body.getWorldCenter(), new Vec2(1, 0));
            jd.enableLimit = true;
            jd.lowerTranslation = 0;
            jd.upperTranslation = 0;
            world.createJoint(jd);
        }
    }

    public void updateFriction() {
        // Lateral velocity
        Vec2 impulse = getLateralVelocity().mul(-body.getMass());
        body.applyLinearImpulse(impulse, body.getWorldCenter());

        // Angular velocity
        body.applyAngularImpulse(0.1f * body.getInertia() * -body.getAngularVelocity());

        // Forward velocity
        Vec2 currentForwardNormal = getForwardVelocity();
        float currentForwardSpeed = currentForwardNormal.normalize();
        float dragForceMagnitude = -2 * currentForwardSpeed;
        body.applyForce(currentForwardNormal.mul(dragForceMagnitude), body.getWorldCenter());
    }

    public void updateDrive() {
        Vec2 currentForwardNormal = body.getWorldVector(new Vec2(0, 1));
        float currentSpeed = Vec2.dot(getForwardVelocity(), currentForwardNormal);

        float force;
        if (acceleration > currentSpeed) {
            force = PhysicsContants.CAR_POWER * 100;
        } else if (acceleration < currentSpeed) {
            force = -PhysicsContants.CAR_POWER * 100;
        } else {
            return;
        }

        body.applyForce(currentForwardNormal.mul(force), body.getWorldCenter());
    }

    public void setAcceleration(ThrottleAction throttleAction) {
        switch (throttleAction) {
            case ACCELERATE:
                acceleration = PhysicsContants.CAR_MAX_SPEED * 10;
                break;
            case REVERSE:
                acceleration = -PhysicsContants.CAR_MAX_REVERSE_SPEED * 10;
                break;
            default:
            case IDLE:
                acceleration = 0;
                break;
        }
    }

    /**
     * Sets wheel's angle relative to the car's body (in degrees).
     */
    public void setAngle(float angle) {
        body.m_sweep.a = carBody.getAngle() + angle;
    }

    /**
     * Sets wheel's velocity vector with sideways velocity subtracted.
     */
    private Vec2 getLateralVelocity() {
        Vec2 currentRightNormal = body.getWorldVector(new Vec2(1, 0));
        return currentRightNormal.mul(Vec2.dot(currentRightNormal, body.getLinearVelocity()));
    }

    private Vec2 getForwardVelocity() {
        Vec2 currentRightNormal = body.getWorldVector(new Vec2(0, 1));
        return currentRightNormal.mul(Vec2.dot(currentRightNormal, body.getLinearVelocity()));
    }

    public boolean isSteerable() {
        return steerable;
    }

    public boolean isPowered() {
        return powered;
    }
    
    public float getX() {
        return body.getPosition().x;
    }

    public float getY() {
        return body.getPosition().y;
    }

    public float getDegree() {
        return body.getAngle();
    }
    
    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

}
