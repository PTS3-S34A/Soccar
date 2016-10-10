package nl.soccar.library;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import nl.soccar.library.enumeration.MapType;
import nl.soccar.util.MapUtilities;

/**
 * Class that represents the Map model.
 *
 * @author PTS34A
 */
public class Map {

    private Rectangle size;
    private Rectangle goalBlue;
    private Rectangle goalRed;
    private MapType type;

    private List<Car> cars;
    private Ball ball;

    /**
     * Initiates a new Map Object.
     *
     * @param size The size of this Map.
     * @param ball The ball of this Map.
     */
    public Map(Rectangle size, Ball ball) {
        this(size, ball, MapUtilities.getLeftGoal(), MapUtilities.getRightGoal());
    }

    /**
     * Constructor used for instantiation of a Map object.
     *
     * @param size The size of this map.
     * @param goalBlue Rectangle position of the blue goal.
     * @param goalRed Rectangle pisition of the red goal.
     * @param ball The ball of this Map.
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
     * Method that adds a car to the map.
     *
     * @param car Car that needs to be added to the map.
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     * Method that gets the car of the player that is passed as an argument.
     *
     * @param player Player whose car needs to be retrieved.
     * @return
     */
    public Car getCarFromPlayer(Player player) {
        return cars.stream().filter(c -> c.getPlayer().equals(player)).findFirst().get();
    }

    /**
     * Method that gets the map rectangle.
     *
     * @return Rectangle of the map.
     */
    public Rectangle getSize() {
        return size;
    }

    /**
     * Method that gets the blue goal rectangle.
     *
     * @return Recangle of the blue goal.
     */
    public Rectangle getGoalBlue() {
        return goalBlue;
    }

    /**
     * Method that gets the red goal rectangle.
     *
     * @return Recangle of the red goal.
     */
    public Rectangle getGoalRed() {
        return goalRed;
    }

    /**
     * Method that gets the type of this map.
     *
     * @return Map type of this map.
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

}
