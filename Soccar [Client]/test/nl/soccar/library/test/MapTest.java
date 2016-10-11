package nl.soccar.library.test;

import javafx.scene.shape.Rectangle;
import nl.soccar.library.Ball;
import nl.soccar.library.Car;
import nl.soccar.library.Map;
import nl.soccar.library.Player;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.MapType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.util.MapUtilities;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Map class.
 *
 * @author PTS34A
 */
public class MapTest {

    // Declaration of test objects.
    private Player player;
    private Car car;
    private Map map;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        car = new Car(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, player.getCarType(), player);
        map = new Map(new Rectangle(0, 0, 10, 10), new Ball(0.0F, 0.0F, 0.0F, 0.0F, BallType.HOCKEY));
    }

    /**
     * Tests the addCar and getCarFromPlayer methods.
     */
    @Test
    public void addCarAndGetCarFromPlayerTest() {
        map.addCar(car);
        assertEquals(car, map.getCarFromPlayer(player));
    }

    /**
     * Tests the getSize method.
     */
    @Test
    public void getSizeTest() {
        assertEquals(new Rectangle(0, 0, 10, 10), map.getSize());
    }

    /**
     * Tests the getGoalBlue method.
     */
    @Test
    public void getGoalBlueTest() {
        assertEquals(MapUtilities.getLeftGoal(), map.getGoalBlue());
    }

    /**
     * Tests the getGoalBlue method.
     */
    @Test
    public void getGoalRedTest() {
        assertEquals(MapUtilities.getRightGoal(), map.getGoalRed());
    }
    
    /**
     * Tests the getMapType and setMapType methods.
     */
    @Test
    public void getMapTypeTest() {
        map.setMapType(MapType.MOON);
        assertEquals(MapType.MOON, map.getMapType());
    }
    
}
