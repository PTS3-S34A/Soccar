package nl.soccar.util;

import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.physics.PhysicsContants;

/**
 * Class that containts static utility methods that are used for physics calculations.
 * 
 * @author PTS34A
 */
public final class PhysicsUtilities {

    // Convert a JBox2D X-coordinate to a JavaFX pixel X-coordinate.
    public static float toPixelX(float x) {
        return x * PhysicsContants.PIXELS_PER_METER;
    }

    // Convert a JBox2D Y-coordinate to a JavaFX pixel Y-coordinate.
    public static float toPixelY(float y) {
        return (DisplayConstants.MAP_HEIGHT - y) * PhysicsContants.PIXELS_PER_METER;
    }

    // Convert a JBox2D width to pixel width.
    public static float toPixelWidth(float width) {
        return width * PhysicsContants.PIXELS_PER_METER;
    }

    // Convert a JBox2D height to pixel height.
    public static float toPixelHeight(float height) {
        return height * PhysicsContants.PIXELS_PER_METER;
    }

    // Calculate relative car height based on giving width.
    public static float calculateCarHeight(float carWidth) {
        return carWidth * 47 / 20;
    }

    // Calculate relative wheel width based on given car width.
    public static float calculateWheelWidth(float carWidth) {
        return carWidth / 5;
    }

    // Calculate relative wheel height based on hiven car width.
    public static float calculateWheelHeight(float wheelWidth) {
        return wheelWidth * 2;
    }

    private PhysicsUtilities() {
    }

}
