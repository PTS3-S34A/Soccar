package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import nl.soccar.library.Car;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.PhysicsDrawableFx;
import nl.soccar.ui.input.Keyboard;
import nl.soccar.ui.physics.enumeration.SteerAction;
import nl.soccar.ui.physics.enumeration.ThrottleAction;
import nl.soccar.ui.physics.models.CarPhysics;
import nl.soccar.ui.physics.models.WheelPhysics;
import nl.soccar.util.PhysicsUtilities;

/**
 * A CarUiFx object represents a JavaFX Drawable of a Car.
 * It keeps track of the Car and CarPhysics models and provides methods to draw and
 * update the models.
 * 
 * @author PTS34A
 */
public class CarUiFx extends PhysicsDrawableFx<Car, CarPhysics> {

    private static final Image TEXTURE_CAR_RED;

    static {
        TEXTURE_CAR_RED = new Image(DisplayConstants.LOCATION_TEXTURE_CAR_RED);
    }

    /**
     * Initiates a new CarUiFx Object using the given parameters.
     * 
     * @param canvas The canvas on which this Car is placed.
     * @param car The model to keep track of.
     * @param physics The physics-model to keep track of.
     */
    public CarUiFx(GameCanvasFx canvas, Car car, CarPhysics physics) {
        super(canvas, car, physics);
    }

    @Override
    public void update() {
        CarPhysics physics = super.getPhysicsModel();

        Keyboard keyboard = Keyboard.getInstance();
        if (keyboard.isPressed(KeyCode.W)) {
            physics.setThrottleAction(ThrottleAction.ACCELERATE);
        } else if (keyboard.isPressed(KeyCode.S)) {
            physics.setThrottleAction(ThrottleAction.REVERSE);
        } else {
            physics.setThrottleAction(ThrottleAction.IDLE);
        }

        if (keyboard.isPressed(KeyCode.A)) {
            physics.setSteerAction(SteerAction.STEER_LEFT);
        } else if (keyboard.isPressed(KeyCode.D)) {
            physics.setSteerAction(SteerAction.STEER_RIGHT);
        } else {
            physics.setSteerAction(SteerAction.NONE);
        }

        physics.step();

        Car car = super.getModel();
        car.move(physics.getX(), physics.getY(), physics.getDegree());
    }

    @Override
    public void draw(GraphicsContext context) {
        CarPhysics physics = super.getPhysicsModel();

        physics.getWheels().forEach(w -> drawWheel(w, context));
        drawBody(context);
    }

    private void drawBody(GraphicsContext gc) {
        Car car = super.getModel();

        float x = PhysicsUtilities.toPixelX(car.getX());
        float y = PhysicsUtilities.toPixelY(car.getY());
        float width = PhysicsUtilities.toPixelWidth(car.getWidth());
        float height = PhysicsUtilities.toPixelHeight(car.getHeight());

        gc.save(); // Save the canvas so we can draw a rotated rectangle.

        gc.translate(x, y); // Set the origin point of the rotation.
        gc.rotate(-Math.toDegrees(car.getDegree())); // Set the angle of the rotation.
        gc.drawImage(TEXTURE_CAR_RED, -width / 2, -height / 2, width, height);

        gc.restore(); // Restore canvas to display a rotated image.
    }

    private void drawWheel(WheelPhysics wheel, GraphicsContext gc) {
        float x = PhysicsUtilities.toPixelX(wheel.getX());
        float y = PhysicsUtilities.toPixelY(wheel.getY());
        float width = PhysicsUtilities.toPixelWidth(wheel.getWidth());
        float height = PhysicsUtilities.toPixelHeight(wheel.getHeight());

        gc.save();

        gc.translate(x, y); // Set the origin point of the rotation.
        gc.rotate(Math.toDegrees(-wheel.getDegree())); // Set the angle of the rotation.
        gc.setFill(Color.GREY);
        gc.fillRect(-width / 2, -height / 2, width, height); // Draw the rectangle from the top left.

        gc.restore();
    }

}
