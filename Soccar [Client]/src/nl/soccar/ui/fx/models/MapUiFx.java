package nl.soccar.ui.fx.models;

import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import nl.soccar.library.Map;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.fx.DrawableFx;
import nl.soccar.ui.fx.GameCanvasFx;

/**
 *
 * @author PTS34A
 */
public class MapUiFx extends DrawableFx<Map> {
    
    private static final Image TEXTURE_MOON;
    private static final Image TEXTURE_DESERT;
    private static final Image TEXTURE_GRASS;
    
    static {
        TEXTURE_MOON = new Image(DisplayConstants.LOCATION_TEXTURE_MOON);
        TEXTURE_DESERT = new Image(DisplayConstants.LOCATION_TEXTURE_DESERT);
        TEXTURE_GRASS = new Image(DisplayConstants.LOCATION_TEXTURE_GRASS);
    }
    
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
        
        switch (map.getMapType()) {
            case GRASSLAND:
                context.drawImage(TEXTURE_GRASS, x, y, width, height);
                break;
            case DESERT:
                context.drawImage(TEXTURE_DESERT, x, y, width, height);
                break;
            case MOON:
                context.drawImage(TEXTURE_MOON, x, y, width, height);
                break;
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
        
        Rectangle leftGoal = map.getGoalBlue();
        context.strokeRect(leftGoal.getX(), leftGoal.getY(), leftGoal.getWidth(), leftGoal.getHeight()); // Goal left
        
        Rectangle rightGoal = map.getGoalRed();
        context.strokeRect(rightGoal.getX(), rightGoal.getY(), rightGoal.getWidth(), rightGoal.getHeight()); // Goal left
        
    }
    
}
