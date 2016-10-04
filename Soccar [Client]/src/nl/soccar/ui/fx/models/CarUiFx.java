package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import nl.soccar.library.Car;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.PhysicsDrawableFx;
import nl.soccar.ui.input.Keyboard;
import nl.soccar.ui.physics.enumeration.SteerAction;
import nl.soccar.ui.physics.enumeration.ThrottleAction;
import nl.soccar.ui.physics.models.CarPhysics;
import nl.soccar.ui.physics.models.WheelPhysics;
import nl.soccar.util.PhysicsUtilities;

/**
 *
 * @author PTS34A
 */
public class CarUiFx extends PhysicsDrawableFx<Car, CarPhysics> {

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
        gc.setFill(Color.RED);
        gc.fillRect(-width / 2, -height / 2, width, height); // Draw the rectangle from the top left.

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
