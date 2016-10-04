package nl.soccar.util;

import java.awt.Rectangle;
import nl.soccar.ui.DisplayConstants;

/**
 *
 * @author PTS34A
 */
public final class MapUtilities {

    /**
     * Method that calculates and returns the rectangle of the left goal of the map.
     * 
     * @return Rectangle The rectangle of the the left goal of the map.
     */
    public static Rectangle getLeftGoal() {
        double goalPositionY = (DisplayConstants.SCREEN_HEIGHT / 2) - (DisplayConstants.GOAL_HEIGHT / 2);

        return new Rectangle(DisplayConstants.FIELD_MARGIN - DisplayConstants.GOAL_WIDTH, (int) goalPositionY,
                DisplayConstants.GOAL_WIDTH, (int) DisplayConstants.GOAL_HEIGHT);
    }

    /**
     * Method that calculates and returns the rectangle of the right goal of the map.
     * 
     * @return Rectangle The rectangle of the right goal of the map.
     */
    public static Rectangle getRightGoal() {
        double goalPositionY = (DisplayConstants.SCREEN_HEIGHT / 2) - (DisplayConstants.GOAL_HEIGHT / 2);
        
        return new Rectangle(DisplayConstants.SCREEN_WIDTH - DisplayConstants.FIELD_MARGIN, (int) goalPositionY,
                DisplayConstants.GOAL_WIDTH, (int) DisplayConstants.GOAL_HEIGHT);
    }

    private MapUtilities() {
    }

}
