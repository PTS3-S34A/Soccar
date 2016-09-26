package nl.soccar.ui.fx;

import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import nl.soccar.library.Map;
import nl.soccar.library.enumeration.MapType;
import nl.soccar.ui.DisplayConstants;

/**
 *
 * @author PTS34A
 */
public class MapUiFx extends DrawableFx<Map> {

    public MapUiFx(GameCanvasFx canvas, Map model) {
        super(canvas, model);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(GraphicsContext context) {
        Map map = super.getModel();
        Rectangle size = map.getSize();

        double x = size.getX();
        double y = size.getY();

        double centreX = size.getCenterX();
        double centreY = size.getCenterY();

        double width = size.getWidth();
        double height = size.getHeight();
        
        double boxPositionY = (height / 2) - (DisplayConstants.BOX_HEIGHT / 2);
        double goalPositionY = (height / 2) - (DisplayConstants.GOAL_HEIGHT / 2);

        if (map.getMapType() == MapType.GRASSLAND) {
            context.setFill(Color.DARKGREEN);
            context.fillRect(x, y, width, height);
            
            context.setFill(Color.GREEN);
            for (int i = 0; i < 11; i++) {
                context.fillRect(DisplayConstants.FIELD_MARGIN + (width / 24 * i * 2), DisplayConstants.FIELD_MARGIN,
                        DisplayConstants.FIELD_MARGIN, height - DisplayConstants.FIELD_MARGIN * 2);
            }

            context.setStroke(Color.WHITE);
            context.setFill(Color.WHITE);
            context.setLineWidth(DisplayConstants.LINE_WIDTH);

            context.strokeLine(centreX, y + DisplayConstants.FIELD_MARGIN, centreX, height - DisplayConstants.FIELD_MARGIN); // Baseline
            context.strokeOval(centreX - (DisplayConstants.CENTRE_CIRCLE_SIZE / 2), centreY - (DisplayConstants.CENTRE_CIRCLE_SIZE / 2),
                    DisplayConstants.CENTRE_CIRCLE_SIZE, DisplayConstants.CENTRE_CIRCLE_SIZE); // Centre circle
            context.fillOval(centreX - (DisplayConstants.CENTRE_SPOT_SIZE / 2), centreY - (DisplayConstants.CENTRE_SPOT_SIZE / 2),
                    DisplayConstants.CENTRE_SPOT_SIZE, DisplayConstants.CENTRE_SPOT_SIZE); // Centre spot
            context.strokeRect(DisplayConstants.FIELD_MARGIN, DisplayConstants.FIELD_MARGIN,
                    width - (2 * DisplayConstants.FIELD_MARGIN), height - (2 * DisplayConstants.FIELD_MARGIN)); // Field 
            context.strokeRect(DisplayConstants.FIELD_MARGIN, boxPositionY, DisplayConstants.BOX_WIDTH,
                    DisplayConstants.BOX_HEIGHT); // Box left
            context.strokeRect(width - DisplayConstants.FIELD_MARGIN - DisplayConstants.BOX_WIDTH,
                    boxPositionY, DisplayConstants.BOX_WIDTH, DisplayConstants.BOX_HEIGHT); // Box right
            context.strokeRect(DisplayConstants.FIELD_MARGIN - DisplayConstants.GOAL_WIDTH, goalPositionY,
                    DisplayConstants.GOAL_WIDTH, DisplayConstants.GOAL_HEIGHT); // Goal left
            context.strokeRect(width - DisplayConstants.FIELD_MARGIN, goalPositionY,
                    DisplayConstants.GOAL_WIDTH, DisplayConstants.GOAL_HEIGHT); // Goal right
            
        }

    }

}
