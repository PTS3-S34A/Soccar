package nl.soccar.ui.fx.models;

import java.awt.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import nl.soccar.library.Map;
import nl.soccar.library.Obstacle;
import nl.soccar.library.enumeration.ObstacleType;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.fx.DrawableFx;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.physics.models.ObstaclePhysics;
import org.jbox2d.dynamics.World;

/**
 * A MapUiFx object represents a JavaFX Drawable of a Map. It keeps track of the
 * Map model and provides methods to draw and update the model.
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

    /**
     * Initiates a new MapUiFx Object using the given parameters.
     *
     * @param canvas The canvas on which this Map is placed.
     * @param model The model to keep track of.
     */
    public MapUiFx(GameCanvasFx canvas, Map model) {
        super(canvas, model);

        addWalls();
    }

    private void addWalls() {
        Map map = super.getModel();
        Rectangle size = map.getSize();

        float width = (float) size.getWidth();
        float height = (float) size.getHeight();
        float margin = DisplayConstants.FIELD_MARGIN;

        GameCanvasFx canvas = super.getCanvas();
        World world = canvas.getPhysics().getWorld();

        Obstacle westWall = new Obstacle(0, 0, 0, margin, height, ObstacleType.WALL);
        Obstacle eastWall = new Obstacle(width - margin, 0, 0, margin, height, ObstacleType.WALL);
        Obstacle northWall = new Obstacle(0, 0, 0, width, margin, ObstacleType.WALL);
        Obstacle southWall = new Obstacle(0, height - margin, 0, width, margin, ObstacleType.WALL);

        ObstaclePhysics westWallPhysics = new ObstaclePhysics(westWall, world);
        ObstaclePhysics eastWallPhysics = new ObstaclePhysics(eastWall, world);
        ObstaclePhysics northWallPhysics = new ObstaclePhysics(northWall, world);
        ObstaclePhysics southWallPhysics = new ObstaclePhysics(southWall, world);

        ObstacleUiFx westWallUi = new ObstacleUiFx(canvas, westWall, westWallPhysics);
        ObstacleUiFx eastWallUi = new ObstacleUiFx(canvas, eastWall, eastWallPhysics);
        ObstacleUiFx northWallUi = new ObstacleUiFx(canvas, northWall, northWallPhysics);
        ObstacleUiFx southWallUi = new ObstacleUiFx(canvas, southWall, southWallPhysics);

        canvas.addDrawable(westWallUi);
        canvas.addDrawable(eastWallUi);
        canvas.addDrawable(northWallUi);
        canvas.addDrawable(southWallUi);
    }

    @Override
    public void update() {
        // Map doesn't actually move or anything, so it doesn't have to be updated.
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

        switch (map.getMapType()) {
            case DESERT:
                context.drawImage(TEXTURE_DESERT, x, y, width, height);
                break;
            case MOON:
                context.drawImage(TEXTURE_MOON, x, y, width, height);
                break;
            case GRASSLAND:
            default:
                context.drawImage(TEXTURE_GRASS, x, y, width, height);
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
