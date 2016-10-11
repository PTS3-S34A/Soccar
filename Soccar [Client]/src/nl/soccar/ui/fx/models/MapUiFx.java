package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import nl.soccar.library.Map;
import nl.soccar.library.Obstacle;
import nl.soccar.library.enumeration.ObstacleType;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.fx.DrawableFx;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.physics.models.ObstaclePhysics;
import nl.soccar.util.MapUtilities;
import nl.soccar.util.PhysicsUtilities;
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
    }

    public void addWalls() {
        Map map = super.getModel();
        Rectangle size = map.getSize();

        float mapWidth = (float) size.getWidth();
        float mapHeight = (float) size.getHeight();
        float wallWidth = 2;
        
        float cornerSize = 15;

        GameCanvasFx canvas = super.getCanvas();
        World world = canvas.getPhysics().getWorld();

        Obstacle westWall = new Obstacle(wallWidth / 2, mapHeight / 2, 0, wallWidth, mapHeight, ObstacleType.WALL);
        Obstacle eastWall = new Obstacle(mapWidth - (wallWidth / 2), mapHeight / 2, 0, wallWidth, mapHeight, ObstacleType.WALL);
        Obstacle northWall = new Obstacle(mapWidth / 2, mapHeight - (wallWidth / 2), 0, mapWidth, wallWidth, ObstacleType.WALL);
        Obstacle southWall = new Obstacle(mapWidth / 2, wallWidth / 2, 0, mapWidth, wallWidth, ObstacleType.WALL);
        Obstacle northWestWall = new Obstacle(0, mapHeight, 45, cornerSize, cornerSize, ObstacleType.WALL);
        Obstacle nortEastWall = new Obstacle(mapWidth, mapHeight, 45, cornerSize, cornerSize, ObstacleType.WALL);
        Obstacle southWestWall = new Obstacle(0, 0, 45, cornerSize, cornerSize, ObstacleType.WALL);
        Obstacle southEastWall = new Obstacle(mapWidth, 0, 45, cornerSize, cornerSize, ObstacleType.WALL);

        ObstaclePhysics westWallPhysics = new ObstaclePhysics(westWall, world);
        ObstaclePhysics eastWallPhysics = new ObstaclePhysics(eastWall, world);
        ObstaclePhysics northWallPhysics = new ObstaclePhysics(northWall, world);
        ObstaclePhysics southWallPhysics = new ObstaclePhysics(southWall, world);
        ObstaclePhysics northWestWallPhysics = new ObstaclePhysics(northWestWall, world);
        ObstaclePhysics northEastWallPhysics = new ObstaclePhysics(nortEastWall, world);
        ObstaclePhysics southWestWallPhysics = new ObstaclePhysics(southWestWall, world);
        ObstaclePhysics southEastWallPhysics = new ObstaclePhysics(southEastWall, world);

        ObstacleUiFx westWallUi = new ObstacleUiFx(canvas, westWall, westWallPhysics);
        ObstacleUiFx eastWallUi = new ObstacleUiFx(canvas, eastWall, eastWallPhysics);
        ObstacleUiFx northWallUi = new ObstacleUiFx(canvas, northWall, northWallPhysics);
        ObstacleUiFx southWallUi = new ObstacleUiFx(canvas, southWall, southWallPhysics);
        ObstacleUiFx northWestWallUi = new ObstacleUiFx(canvas, northWestWall, northWestWallPhysics);
        ObstacleUiFx northEastWallUi = new ObstacleUiFx(canvas, nortEastWall, northEastWallPhysics);
        ObstacleUiFx southWestWallUi = new ObstacleUiFx(canvas, southWestWall, southWestWallPhysics);
        ObstacleUiFx SouthEastWallUi = new ObstacleUiFx(canvas, southEastWall, southEastWallPhysics);

        canvas.addDrawable(westWallUi);
        canvas.addDrawable(eastWallUi);
        canvas.addDrawable(northWallUi);
        canvas.addDrawable(southWallUi);
        canvas.addDrawable(northWestWallUi);
        canvas.addDrawable(northEastWallUi);
        canvas.addDrawable(southWestWallUi);
        canvas.addDrawable(SouthEastWallUi);
    }

    @Override
    public void update() {
        // Map doesn't actually move or anything, so it doesn't have to be updated.
    }

    @Override
    public void draw(GraphicsContext context) {
        Map map = super.getModel();
        Rectangle size = map.getSize();
        
        double centreX = PhysicsUtilities.toPixelX((float) MapUtilities.getCentreX(size));
        double centreY = PhysicsUtilities.toPixelY((float) MapUtilities.getCentreY(size));
        double width = PhysicsUtilities.toPixelWidth((float) size.getWidth());
        double height = PhysicsUtilities.toPixelHeight((float) size.getHeight());

        double lineWidth = PhysicsUtilities.toPixelWidth(DisplayConstants.LINE_WIDTH);
        double fieldMargin = PhysicsUtilities.toPixelWidth(DisplayConstants.FIELD_MARGIN);

        double centreCircleSize = PhysicsUtilities.toPixelWidth(DisplayConstants.CENTRE_CIRCLE_SIZE);
        double centreSpotSize = PhysicsUtilities.toPixelWidth(DisplayConstants.CENTRE_SPOT_SIZE);
        
        double boxPositionY = PhysicsUtilities.toPixelY((float) (size.getHeight() / 2) + (DisplayConstants.BOX_HEIGHT / 2));
        double boxWidth = PhysicsUtilities.toPixelWidth(DisplayConstants.BOX_WIDTH);
        double boxHeight = PhysicsUtilities.toPixelHeight(DisplayConstants.BOX_HEIGHT);

        Rectangle leftGoal = map.getGoalBlue();
        double leftGoalX = PhysicsUtilities.toPixelX((float) leftGoal.getX());
        double leftGoalY = PhysicsUtilities.toPixelY((float) leftGoal.getY());
        double leftGoalWidth = PhysicsUtilities.toPixelWidth((float) leftGoal.getWidth());
        double leftGoalHeight = PhysicsUtilities.toPixelHeight((float) leftGoal.getHeight());

        Rectangle rightGoal = map.getGoalRed();
        double rightGoalX = PhysicsUtilities.toPixelX((float) rightGoal.getX());
        double rightGoalY = PhysicsUtilities.toPixelY((float) rightGoal.getY());
        double rightGoalWidth = PhysicsUtilities.toPixelWidth((float) rightGoal.getWidth());
        double rightGoalHeight = PhysicsUtilities.toPixelHeight((float) rightGoal.getHeight());

        switch (map.getMapType()) {
            case DESERT:
                context.drawImage(TEXTURE_DESERT, 0, 0, width, height);
                break;
            case MOON:
                context.drawImage(TEXTURE_MOON, 0, 0, width, height);
                break;
            default:
            case GRASSLAND:
                context.drawImage(TEXTURE_GRASS, 0, 0, width, height);
                break;
        }

        // Line color
        context.setStroke(Color.WHITE);
        context.setFill(Color.WHITE);

        // Line width
        context.setLineWidth(lineWidth);

        // Baseline
        context.strokeLine(
                centreX,
                fieldMargin,
                centreX,
                height - fieldMargin
        );

        // Centre circle
        context.strokeOval(
                centreX - (centreCircleSize / 2),
                centreY - (centreCircleSize / 2),
                centreCircleSize,
                centreCircleSize
        );

        // Centre spot
        context.fillOval(
                centreX - (centreSpotSize / 2),
                centreY - (centreSpotSize / 2),
                centreSpotSize,
                centreSpotSize
        );

        // Field
        context.strokeRect(
                fieldMargin,
                fieldMargin,
                width - (2 * fieldMargin),
                height - (2 * fieldMargin)
        );

        // Box left
        context.strokeRect(
                fieldMargin,
                boxPositionY,
                boxWidth,
                boxHeight
        );

        // Box right
        context.strokeRect(
                width - fieldMargin - boxWidth,
                boxPositionY,
                boxWidth,
                boxHeight
        );

        // Left goal
        context.strokeRect(leftGoalX, leftGoalY, leftGoalWidth, leftGoalHeight);

        // Right goal
        context.strokeRect(rightGoalX, rightGoalY, rightGoalWidth, rightGoalHeight);
    }

}
