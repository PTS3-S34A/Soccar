package nl.soccar.ui.physics.models;

import nl.soccar.library.Car;
import nl.soccar.ui.input.Keyboard;
import nl.soccar.ui.physics.PhysicsContants;
import nl.soccar.ui.physics.WorldObject;
import nl.soccar.ui.physics.enumeration.HandbrakeAction;
import nl.soccar.ui.physics.enumeration.SteerAction;
import nl.soccar.ui.physics.enumeration.ThrottleAction;
import nl.soccar.util.PhysicsUtilities;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.*;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author PTS34A
 */
public class CarPhysics implements WorldObject {

    private static final boolean BULLET = true;
    private static final float LINEAR_DAMPING = 0.2F;
    private static final float ANGULAR_DAMPING = 0.2F;

    private static final float DENSITY = 0.2F;
    private static final float RESTITUTION = 0.2F;

    private static final float WHEEL_POS_RATIO_X = 2.3F;
    private static final float WHEEL_POS_RATIO_Y = 4.0F;

    private final Body body;
    private float steerAngle = 0.0F;

    private List<WheelPhysics> wheels;
    private ThrottleAction throttleAction;
    private SteerAction steerAction;
    private HandbrakeAction handbrakeAction;

    /**
     * Initiates a new CarPhysics Object using the given parameters.
     *
     * @param car The car model to keep track of.
     * @param world The world in which this model is placed.
     */
    public CarPhysics(Car car, World world) {

        float carWidth = car.getWidth();
        float carHeight = car.getHeight();

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(car.getX(), car.getY());
        bd.angle = (float) Math.toRadians(car.getDegree());
        bd.bullet = BULLET; // Prevents tunneling
        bd.linearDamping = LINEAR_DAMPING; // Simulates friction
        bd.angularDamping = ANGULAR_DAMPING;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(carWidth / 2, carHeight / 2);

        FixtureDef fd = new FixtureDef();
        fd.density = DENSITY;
        fd.restitution = RESTITUTION;
        fd.shape = shape;

        body = world.createBody(bd);
        body.createFixture(fd);

        throttleAction = ThrottleAction.IDLE;
        steerAction = SteerAction.NONE;

        wheels = new ArrayList<>();

        // TODO: Calculate wheel positions from PhysicsUtilities, WHEEL_POS_RATIO should be defined in DisplayConstants.
        float wheelWidth = PhysicsUtilities.calculateWheelWidth(car.getWidth()); // The wheel width is calculated from the car width
        float wheelHeight = PhysicsUtilities.calculateWheelHeight(wheelWidth);

        // Create wheels
        wheels.add(new WheelPhysics(-carWidth / WHEEL_POS_RATIO_X, carHeight / WHEEL_POS_RATIO_Y, wheelWidth, wheelHeight, true, true, this, world));
        wheels.add(new WheelPhysics(carWidth / WHEEL_POS_RATIO_X, carHeight / WHEEL_POS_RATIO_Y, wheelWidth, wheelHeight, true, true, this, world));
        wheels.add(new WheelPhysics(-carWidth / WHEEL_POS_RATIO_X, -carHeight / WHEEL_POS_RATIO_Y, wheelWidth, wheelHeight, false, false, this, world));
        wheels.add(new WheelPhysics(carWidth / WHEEL_POS_RATIO_X, -carHeight / WHEEL_POS_RATIO_Y, wheelWidth, wheelHeight, false, false, this, world));
    }

    @Override
    public void step() {

        // Update actions
        throttleAction = Keyboard.getThrottleAction();
        steerAction = Keyboard.getSteerAction();
        handbrakeAction = Keyboard.getHandbrakeAction();

        // Kill sideways velocity
        wheels.forEach(WheelPhysics::updateFriction);

        // Set acceleration on powered wheels
        wheels.stream().filter(WheelPhysics::isPowered).forEach(w -> w.setDesiredSpeed(throttleAction));

        // Update revolving wheels
        updateSteerAngle(steerAction);
        wheels.stream().filter(WheelPhysics::isSteerable).forEach(w -> w.setAngle(steerAngle));

        // Apply force to powered wheels
        wheels.stream().filter(WheelPhysics::isPowered).forEach(WheelPhysics::updateDrive);
    }

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
        return (float) Math.toDegrees(body.getAngle());
    }

    @Override
    public Body getBody() {
        return body;
    }

    public HandbrakeAction getHandbrakeAction() {
        return handbrakeAction;
    }

    public List<WheelPhysics> getWheels() {
        return Collections.unmodifiableList(wheels);
    }

}