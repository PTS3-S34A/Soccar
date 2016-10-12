package nl.soccar.ui.fx.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import nl.soccar.library.Ball;
import nl.soccar.library.Map;
import nl.soccar.library.enumeration.ObstacleType;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.fx.DrawableFx;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.models.ObstacleUiFx.ObstacleBuilder;
import nl.soccar.util.MapUtilities;
import nl.soccar.util.PhysicsUtilities;
import org.jbox2d.dynamics.World;

/**
 * A MapUiFx object represents a JavaFX Drawable of a Map. It keeps track of the Map model and provides methods to draw and update the model.
 *
 * @author PTS34A
 */
public class MapUiFx extends DrawableFx<Map> {

    private static final Image TEXTURE_MOON;
    private static final Image TEXTURE_DESERT;
    private static final Image TEXTURE_GRASS;
    private static final float GOAL_TRIGGER_MARGIN;
    private static final float WALL_WIDTH;
    private static final float CORNER_SIZE;

    static {
        TEXTURE_MOON = new Image(DisplayConstants.LOCATION_TEXTURE_MOON);
        TEXTURE_DESERT = new Image(DisplayConstants.LOCATION_TEXTURE_DESERT);
        TEXTURE_GRASS = new Image(DisplayConstants.LOCATION_TEXTURE_GRASS);
        GOAL_TRIGGER_MARGIN = 1.2F;
        WALL_WIDTH = 2.0F;
        CORNER_SIZE = 15.0F;
    }

    private final World world;
    private final Map map;
    private final Ball ball;
    private float ballX;
    private float ballY;
    private final float ballWidth;
    private final float ballHeight;
    private final Rectangle goalLeft;
    private final Rectangle goalRight;

    /**
     * Initiates a new MapUiFx Object using the given parameters.
     *
     * @param canvas The canvas on which this Map is placed.
     * @param model The model to keep track of.
     */
    public MapUiFx(GameCanvasFx canvas, Map model) {
        super(canvas, model);

        world = canvas.getPhysics().getWorld();
        map = model;
        ball = map.getBall();
        ballWidth = PhysicsUtilities.toPixelWidth(ball.getRadius());
        ballHeight = PhysicsUtilities.toPixelHeight(ball.getRadius());

        Rectangle goalLeftJBox2D = map.getGoalBlue();
        Rectangle goalRightJBox2D = map.getGoalRed();

        /**
         * Convert the values of the JBox2D units to pixels.
         */
        float leftGoalWidth = PhysicsUtilities.toPixelWidth((float) goalLeftJBox2D.getWidth());
        float leftGoalHeight = PhysicsUtilities.toPixelHeight((float) goalLeftJBox2D.getHeight());
        float rightGoalWidth = PhysicsUtilities.toPixelWidth((float) goalRightJBox2D.getWidth());
        float rightGoalHeight = PhysicsUtilities.toPixelHeight((float) goalRightJBox2D.getHeight());

        goalLeft = new Rectangle(
                PhysicsUtilities.toPixelX((float) goalLeftJBox2D.getX()) + leftGoalWidth - ballWidth * GOAL_TRIGGER_MARGIN,
                PhysicsUtilities.toPixelY((float) goalLeftJBox2D.getY()) + ballHeight * GOAL_TRIGGER_MARGIN,
                leftGoalWidth,
                leftGoalHeight - ballHeight * GOAL_TRIGGER_MARGIN);

        goalRight = new Rectangle(
                PhysicsUtilities.toPixelX((float) goalRightJBox2D.getX()) + ballWidth * GOAL_TRIGGER_MARGIN,
                PhysicsUtilities.toPixelY((float) goalRightJBox2D.getY()) + ballHeight * GOAL_TRIGGER_MARGIN,
                rightGoalWidth,
                rightGoalHeight - ballHeight * GOAL_TRIGGER_MARGIN);
    }

    /**
     * Method that calls all methods that add map obstacles to the map.
     */
    public void addWalls() {
        Rectangle size = map.getSize();
        float mapWidth = (float) size.getWidth();
        float mapHeight = (float) size.getHeight();

        addWestWalls(mapHeight);
        addEastWalls(mapWidth, mapHeight);
        addNorthAndSouthWalls(mapWidth, mapHeight);
        addCornerWalls(mapWidth, mapHeight);
    }

    /**
     * Method that adds the obstacle drawables to the map that represent the west wall.
     * 
     * @param mapHeight The height of the map.
     */
    private void addWestWalls(float mapHeight) {
        GameCanvasFx canvas = super.getCanvas();
        Rectangle leftGoal = map.getGoalBlue();
        float leftGoalY = (float) leftGoal.getY();

        ObstacleUiFx westWallUpperUi = new ObstacleBuilder(canvas, world)
                .x(WALL_WIDTH / 2).y((mapHeight + leftGoalY) / 2).degree(0)
                .width(WALL_WIDTH).height(mapHeight - leftGoalY)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx westWallLowerUi = new ObstacleBuilder(canvas, world)
                .x(WALL_WIDTH / 2).y((mapHeight - leftGoalY) / 2).degree(0)
                .width(WALL_WIDTH).height(mapHeight - leftGoalY)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx westWallMiddleUi = new ObstacleBuilder(canvas, world)
                .x(-(WALL_WIDTH / 2)).y(mapHeight / 2).degree(0)
                .width(WALL_WIDTH).height(mapHeight)
                .type(ObstacleType.WALL).build();

        canvas.addDrawable(westWallUpperUi);
        canvas.addDrawable(westWallLowerUi);
        canvas.addDrawable(westWallMiddleUi);
    }

    /**
     * Method that adds the obstacle drawables to the map that represent the easts walls.
     * 
     * @param mapWidth The width of the map.
     * @param mapHeight The height of the map.
     */
    private void addEastWalls(float mapWidth, float mapHeight) {
        GameCanvasFx canvas = super.getCanvas();
        Rectangle rightGoal = map.getGoalRed();
        float rightGoalY = (float) rightGoal.getY();

        ObstacleUiFx eastWallUpperUi = new ObstacleBuilder(canvas, world)
                .x(mapWidth - (WALL_WIDTH / 2)).y((mapHeight + rightGoalY) / 2).degree(0)
                .width(WALL_WIDTH).height(mapHeight - rightGoalY)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx eastWallLowerUi = new ObstacleBuilder(canvas, world)
                .x(mapWidth - (WALL_WIDTH / 2)).y((mapHeight - rightGoalY) / 2).degree(0)
                .width(WALL_WIDTH).height(mapHeight - rightGoalY)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx eastWallMiddleUi = new ObstacleBuilder(canvas, world)
                .x((mapWidth + (WALL_WIDTH / 2))).y(mapHeight / 2).degree(0)
                .width(WALL_WIDTH).height(mapHeight)
                .type(ObstacleType.WALL).build();

        canvas.addDrawable(eastWallUpperUi);
        canvas.addDrawable(eastWallLowerUi);
        canvas.addDrawable(eastWallMiddleUi);
    }

    /**
     * Method that adds the obstacle drawables to the map that represent the north and south walls.
     * 
     * @param mapWidth The width of the map.
     * @param mapHeight The height of the map.
     */
    private void addNorthAndSouthWalls(float mapWidth, float mapHeight) {
        GameCanvasFx canvas = super.getCanvas();
        ObstacleUiFx northWallUi = new ObstacleBuilder(canvas, world)
                .x(mapWidth / 2).y(mapHeight - (WALL_WIDTH / 2)).degree(0)
                .width(mapWidth).height(WALL_WIDTH)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx southWallUi = new ObstacleBuilder(canvas, world)
                .x(mapWidth / 2).y(WALL_WIDTH / 2).degree(0)
                .width(mapWidth).height(WALL_WIDTH)
                .type(ObstacleType.WALL).build();

        canvas.addDrawable(northWallUi);
        canvas.addDrawable(southWallUi);
    }

    /**
     * Method that adds the obstacle drawables to the map that represent the nort and south walls.
     * 
     * @param mapWidth The width of the map.
     * @param mapHeight The height of the map.
     */
    private void addCornerWalls(float mapWidth, float mapHeight) {
        GameCanvasFx canvas = super.getCanvas();
        ObstacleUiFx northWestWallUi = new ObstacleBuilder(canvas, world)
                .x(0).y(mapHeight).degree(45)
                .width(CORNER_SIZE).height(CORNER_SIZE)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx northEastWallUi = new ObstacleBuilder(canvas, world)
                .x(mapWidth).y(mapHeight).degree(45)
                .width(CORNER_SIZE).height(CORNER_SIZE)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx southWestWallUi = new ObstacleBuilder(canvas, world)
                .x(0).y(0).degree(45)
                .width(CORNER_SIZE).height(CORNER_SIZE)
                .type(ObstacleType.WALL).build();

        ObstacleUiFx southEastWallUi = new ObstacleBuilder(canvas, world)
                .x(mapWidth).y(0).degree(45)
                .width(CORNER_SIZE).height(CORNER_SIZE)
                .type(ObstacleType.WALL).build();

        canvas.addDrawable(northWestWallUi);
        canvas.addDrawable(northEastWallUi);
        canvas.addDrawable(southWestWallUi);
        canvas.addDrawable(southEastWallUi);
    }

    @Override
    public void update() {
        ballX = PhysicsUtilities.toPixelX(ball.getX());
        ballY = PhysicsUtilities.toPixelY(ball.getY());

        if (goalLeft.intersects(ballX, ballY, ballWidth, ballHeight)) {
            System.out.println("GOAL BLUE");
        } else if (goalRight.intersects(ballX, ballY, ballWidth, ballHeight)) {
            System.out.println("GOAL RED");
        } else {
            System.out.println("NO GOAL");
        }
        
        // TODO: Take care of the goal that is made and reset the entities on the map.
    }

    @Override
    public void draw(GraphicsContext context) {
        Rectangle size = map.getSize();
        double width = PhysicsUtilities.toPixelWidth((float) size.getWidth());
        double height = PhysicsUtilities.toPixelHeight((float) size.getHeight());

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

        // Draw the grid lines on the map.
        drawGridLines(context, size);
    }

    /**
     * Method that draws the grid lines on the map.
     *
     * @param context The graphics context on which the grid lines need to be drawn.
     * @param mapSize The size of the map on which the grid lines need to be drawn.
     */
    private void drawGridLines(GraphicsContext context, Rectangle mapSize) {
        double mapWidth = PhysicsUtilities.toPixelWidth((float) mapSize.getWidth());
        double mapHeight = PhysicsUtilities.toPixelHeight((float) mapSize.getHeight());

        double centreX = PhysicsUtilities.toPixelX(MapUtilities.getCentreX(mapSize));
        double centreY = PhysicsUtilities.toPixelY(MapUtilities.getCentreY(mapSize));

        double lineWidth = PhysicsUtilities.toPixelWidth(DisplayConstants.LINE_WIDTH);
        double fieldMargin = PhysicsUtilities.toPixelWidth(DisplayConstants.FIELD_MARGIN);

        double centreCircleSize = PhysicsUtilities.toPixelWidth(DisplayConstants.CENTRE_CIRCLE_SIZE);
        double centreSpotSize = PhysicsUtilities.toPixelWidth(DisplayConstants.CENTRE_SPOT_SIZE);

        double boxPositionY = PhysicsUtilities.toPixelY((float) (mapSize.getHeight() / 2) + (DisplayConstants.BOX_HEIGHT / 2));
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
                mapHeight - fieldMargin
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
                mapWidth - (2 * fieldMargin),
                mapHeight - (2 * fieldMargin)
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
                mapWidth - fieldMargin - boxWidth,
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
