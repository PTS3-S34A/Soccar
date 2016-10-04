package nl.soccar.util;

import java.awt.Rectangle;
import nl.soccar.ui.DisplayConstants;

/**
 *
 * @author PTS34A
 */
public final class MapUtilities {

    public static Rectangle getLeftGoal() {
        double goalPositionY = (DisplayConstants.SCREEN_HEIGHT / 2) - (DisplayConstants.GOAL_HEIGHT / 2);

        return new Rectangle(DisplayConstants.FIELD_MARGIN - DisplayConstants.GOAL_WIDTH, (int) goalPositionY,
                DisplayConstants.GOAL_WIDTH, (int) DisplayConstants.GOAL_HEIGHT);
    }

    public static Rectangle getRightGoal() {
        double goalPositionY = (DisplayConstants.SCREEN_HEIGHT / 2) - (DisplayConstants.GOAL_HEIGHT / 2);
        
        return new Rectangle(DisplayConstants.SCREEN_WIDTH - DisplayConstants.FIELD_MARGIN, (int) goalPositionY,
                DisplayConstants.GOAL_WIDTH, (int) DisplayConstants.GOAL_HEIGHT);
    }

    private MapUtilities() {
    }

}
