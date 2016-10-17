package nl.soccar.library;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Rectangle;
import nl.soccar.library.enumeration.MapType;
import nl.soccar.util.MapUtilities;

/**
 * A Map keeps track of Cars and a Ball. Furthermore it specifies its size and
 * where the actual goals are placed. It contains a MapType that determines how
 * it will be drawn on the screen.
 *
 * @author PTS34A
 */
public class Map {

    private final Rectangle size;
    private final Rectangle goalBlue;
    private final Rectangle goalRed;
    private MapType type;

    private final List<Car> cars;
    private final Ball ball;

    /**
     * Constructor used to initiate a new Map object.
     *
     * @param size The size of this Map, not null.
     * @param ball The ball of this Map, not null.
     */
    public Map(Rectangle size, Ball ball) {
        this(size, ball, MapUtilities.getLeftGoal(), MapUtilities.getRightGoal());
    }

    /**
     * Constructor used to instantiate a new Map object. By default it sets the
     * MapType to grassland.
     *
     * @param size The size of this map, not null.
     * @param goalBlue The position of the blue goal, relative to this Map, not
     * null.
     * @param goalRed The Position of the red goal, relative to this Map, not
     * null.
     * @param ball The ball that is placed on this Map, not null.
     */
    public Map(Rectangle size, Ball ball, Rectangle goalBlue, Rectangle goalRed) {
        this.size = size;
        this.ball = ball;
        this.goalBlue = goalBlue;
        this.goalRed = goalRed;
        type = MapType.GRASSLAND;

        cars = new ArrayList<>();
    }

    /**
     * Adds a car to this Map.
     *
     * @param car The Car that will be added to this Map, not null.
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     * Retrieves a Car based on a given Player. It iterates through all Cars
     * (added to this Map) and compares the associated player with the given
     * player.
     *
     * @param player The Player, not null, to get the Car from.
     * @return A Car that is driven by the given Player. May be null if there's
     * no Car added in this Map that is driven by the given player.
     */
    public Car getCarFromPlayer(Player player) {
        return cars.stream().filter(c -> c.getPlayer().equals(player)).findFirst().get();
    }

    /**
     * Gets the size of this Map.
     *
     * @return A Rectangle containing the size, in JBox2D units, of this Map.
     */
    public Rectangle getSize() {
        return size;
    }

    /**
     * Gets the size, and position, of the blue goal.
     *
     * @return A Rectangle containing the size, and position, in JBox2D units,
     * of this Map.
     */
    public Rectangle getGoalBlue() {
        return goalBlue;
    }

    /**
     * Gets the size, and position, of the red goal.
     *
     * @return A Rectangle containing the size, and position, in JBox2D units,
     * of this Map.
     */
    public Rectangle getGoalRed() {
        return goalRed;
    }

    /**
     * Gets the MapType of this Map.
     *
     * @return The MapType of this Map.
     */
    public MapType getMapType() {
        return type;
    }

    /**
     * Method that sets the type of this map.
     *
     * @param type Map type that needs to be set.
     */
    public void setMapType(MapType type) {
        this.type = type;
    }

    /**
     * Method that gets the ball of this map.
     *
     * @return The ball of this map.
     */
    public Ball getBall() {
        return ball;
    }

}
