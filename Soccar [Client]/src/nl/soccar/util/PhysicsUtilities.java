package nl.soccar.util;

import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.physics.PhysicsContants;

/**
 *
 * @author PTS34A
 */
public final class PhysicsUtilities {

    // Convert a JBox2D x coordinate to a JavaFX pixel x coordinate
    public static float toPixelX(float x) {
        return x * PhysicsContants.PIXELS_PER_METER;
    }

    // Convert a JBox2D y coordinate to a JavaFX pixel y coordinate
    public static float toPixelY(float y) {
        return DisplayConstants.MAP_HEIGHT - (y * PhysicsContants.PIXELS_PER_METER);
    }

    // Convert a JBox2D width to pixel width
    public static float toPixelWidth(float width) {
        return width * PhysicsContants.PIXELS_PER_METER;
    }

    // Convert a JBox2D height to pixel height
    public static float toPixelHeight(float height) {
        return height * PhysicsContants.PIXELS_PER_METER;
    }

    private PhysicsUtilities() {
    }
    
}
