package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import nl.soccar.library.Car;
import nl.soccar.library.enumeration.TeamColour;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.PhysicsDrawableFx;
import nl.soccar.ui.physics.models.CarPhysics;
import nl.soccar.ui.physics.models.WheelPhysics;
import nl.soccar.util.ImageUtilities;
import nl.soccar.util.PhysicsUtilities;

/**
 * A CarUiFx object represents a JavaFX Drawable of a Car. It keeps track of the
 * Car and CarPhysics models and provides methods to draw and update the models.
 *
 * @author PTS34A
 */
public class CarUiFx extends PhysicsDrawableFx<Car, CarPhysics> {

    private static final Font PLAYER_FONT;
    private static final Color COLOR_WHEEL;


    static {
        COLOR_WHEEL = Color.grayRgb(50);
        PLAYER_FONT = new Font("Arial", 20);
    }

    private Image carTexture;

    /**
     * Initiates a new CarUiFx Object using the given parameters.
     *
     * @param canvas  The canvas on which this Car is placed.
     * @param car     The model to keep track of.
     * @param physics The physics-model to keep track of.
     */
    public CarUiFx(GameCanvasFx canvas, Car car, CarPhysics physics) {
        super(canvas, car, physics);

        carTexture = ImageUtilities.getCarImage(car.getType(), TeamColour.RED); // TODO get team colour.
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
        gc.rotate(-car.getDegree()); // Set the angle of the rotation.
        gc.drawImage(carTexture, -width / 2, -height / 2, width, height); // TODO: Find a solution for anti-aliasing

        gc.restore(); // Restore canvas to display a rotated image.

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(PLAYER_FONT);
        gc.setFill(Color.WHITE);
        gc.fillText(car.getPlayer().getUsername(), x, y - height / 1.5); // Draw playername.

    }

    private void drawWheel(WheelPhysics wheel, GraphicsContext gc) {
        float x = PhysicsUtilities.toPixelX(wheel.getX());
        float y = PhysicsUtilities.toPixelY(wheel.getY());
        float width = PhysicsUtilities.toPixelWidth(wheel.getWidth());
        float height = PhysicsUtilities.toPixelHeight(wheel.getHeight());

        gc.save();

        gc.translate(x, y); // Set the origin point of the rotation.
        gc.rotate(-wheel.getDegree()); // Set the angle of the rotation.
        gc.setFill(COLOR_WHEEL);
        gc.fillRect(-width / 2, -height / 2, width, height); // Draw the rectangle from the top left.

        gc.restore();
    }

}
