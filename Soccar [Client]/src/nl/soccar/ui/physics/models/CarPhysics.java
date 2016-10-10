package nl.soccar.ui.physics.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nl.soccar.library.Car;
import nl.soccar.ui.physics.PhysicsContants;
import nl.soccar.ui.physics.WorldObject;
import nl.soccar.ui.physics.enumeration.SteerAction;
import nl.soccar.ui.physics.enumeration.ThrottleAction;
import nl.soccar.util.PhysicsUtilities;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * CarPhysics is a physics-model that keeps track of the physics of a Car.
 * 
 * @author PTS34A
 */
public class CarPhysics implements WorldObject {

    private static final float LINEAR_DAMPING = 0.15F;
    private static final float ANGULAR_DAMPING = 0.3F;
    private static final boolean BULLET = true;
    private static final float DENSITY = 1.0F;
    private static final float FRICTION = 0.0F;
    private static final float RESTITUTION = 1.0F;

    private final Body body;

    private final float width;
    private final float height;
    
    private float steerAngle;

    private ThrottleAction throttleAction;
    private SteerAction steerAction;

    private List<WheelPhysics> wheels;

    /**
     * Initiates a new CarPhysics Object using the given parameters.
     * 
     * @param car The car model to keep track of.
     * @param world The world in which this model is placed.
     */
    public CarPhysics(Car car, World world) {
        width = car.getWidth();
        height = car.getHeight();
        steerAngle = 0.0F;

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(car.getX(), car.getY());
        bd.angle = (float) Math.toRadians(car.getDegree());
        bd.linearDamping = LINEAR_DAMPING; // Simulates friction
        bd.bullet = BULLET; // Prevents tunneling
        bd.angularDamping = ANGULAR_DAMPING;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2);

        FixtureDef fd = new FixtureDef();
        fd.density = DENSITY;
        fd.friction = FRICTION;
        fd.restitution = RESTITUTION;
        fd.shape = shape;

        body = world.createBody(bd);
        body.createFixture(fd);

        throttleAction = ThrottleAction.IDLE;
        steerAction = SteerAction.NONE;

        wheels = new ArrayList<>();

        float wheelWidth = PhysicsUtilities.calculateWheelWidth(width);
        float wheelHeight = PhysicsUtilities.calculateWheelHeight(wheelWidth);
                
        // Create wheels
        wheels.add(new WheelPhysics(-width / 2.3F, height / 4.0F, wheelWidth, wheelHeight, true, true, body, world));
        wheels.add(new WheelPhysics(width / 2.3F, height / 4.0F, wheelWidth, wheelHeight, true, true, body, world));
        wheels.add(new WheelPhysics(-width / 2.3F, -height / 4.0F, wheelWidth, wheelHeight, false, false, body, world));
        wheels.add(new WheelPhysics(width / 2.3F, -height / 4.0F, wheelWidth, wheelHeight, false, false, body, world));
    }

    @Override
    public void step() {
        // Kill sideways velocity        
        wheels.forEach(WheelPhysics::updateFriction);

        // Set acceleration on powered wheels
        wheels.stream().filter(WheelPhysics::isPowered).forEach(w -> w.setAcceleration(throttleAction));

        // Update revolving wheels
        updateSteerAngle(steerAction);
        wheels.stream().filter(WheelPhysics::isSteerable).forEach(w -> w.setAngle(steerAngle));

        // Apply force to powered wheels
        wheels.stream().filter(WheelPhysics::isPowered).forEach(WheelPhysics::updateDrive);
    }

    // TODO create local variable wheel steer angle
    private void updateSteerAngle(SteerAction steerAction) {
        float wheelMaxSteerAngle = (float) Math.toRadians(PhysicsContants.WHEEL_MAX_STEER_ANGLE);
        float angleDiff = (wheelMaxSteerAngle / PhysicsContants.WHEEL_MAX_TURN_IN_MS) * PhysicsContants.MS_PER_FRAME;

        switch (steerAction) {
            case STEER_LEFT:
                steerAngle = Math.min(Math.max(steerAngle, 0) + angleDiff, wheelMaxSteerAngle);
                break;
            case STEER_RIGHT:
                steerAngle = Math.max(Math.min(steerAngle, 0) - angleDiff, -wheelMaxSteerAngle);
                break;
            default:
                steerAngle = 0;
                break;
        }
    }

    public void setThrottleAction(ThrottleAction throttleAction) {
        this.throttleAction = throttleAction;
    }

    public void setSteerAction(SteerAction steerAction) {
        this.steerAction = steerAction;
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

    public List<WheelPhysics> getWheels() {
        return Collections.unmodifiableList(wheels);
    } 

}
