package nl.soccar.util;

import javafx.scene.shape.Rectangle;
import nl.soccar.ui.DisplayConstants;

/**
 * Utility class that provides methods regarding the Map. It provides methods 
 * for calculating goal placement and sizes.
 * 
 * @author PTS34A
 */
public final class MapUtilities {

    private MapUtilities() {
    }

    /**
     * Method that calculates and returns the rectangle of the left goal of the
     * map.
     *
     * @return Rectangle The rectangle of the the left goal of the map.
     */
    public static Rectangle getLeftGoal() {
        double goalPositionY = (DisplayConstants.MAP_HEIGHT / 2) + (DisplayConstants.GOAL_HEIGHT / 2);

        return new Rectangle(DisplayConstants.FIELD_MARGIN - DisplayConstants.GOAL_WIDTH, goalPositionY,
                DisplayConstants.GOAL_WIDTH, DisplayConstants.GOAL_HEIGHT);
    }

    /**
     * Method that calculates and returns the rectangle of the right goal of the
     * map.
     *
     * @return Rectangle The rectangle of the right goal of the map.
     */
    public static Rectangle getRightGoal() {
        double goalPositionY = (DisplayConstants.MAP_HEIGHT / 2) + (DisplayConstants.GOAL_HEIGHT / 2);

        return new Rectangle(DisplayConstants.MAP_WIDTH - DisplayConstants.FIELD_MARGIN, (int) goalPositionY,

                DisplayConstants.GOAL_WIDTH, (int) DisplayConstants.GOAL_HEIGHT);
    }

    /**
     * Method that calculates the center X-coordinate of the given rectangle.
     *
     * @param rectangle The rectangle of which the center X-coordinate needs to be calculated.
     * @return The center X-coordinate of the given rectangle.
     */
    public static double getCentreX(Rectangle rectangle) {
        return rectangle.getX() + rectangle.getWidth() / 2;
    }

    /**
     * Method that calculates the center Y-coordinate of the given rectangle.
     *
     * @param rectangle The rectangle of which the center Y-coordinate needs to be calculated.
     * @return The center Y-coordinate of the given rectangle.
     */
    public static double getCentreY(Rectangle rectangle) {
        return rectangle.getY() + rectangle.getHeight() / 2;
    }

}
