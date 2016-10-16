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
    private Ball ball;
    private Map map;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        car = new Car(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, player.getCarType(), player);
        ball = new Ball(0.0F, 0.0F, 0.0F, 0.0F, BallType.HOCKEY);
        map = new Map(new Rectangle(0, 0, 10, 10), ball);
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
        Rectangle expectedSize = new Rectangle(0, 0, 10, 10);
        Rectangle actualSize = map.getSize();

        assertEquals(Math.round(expectedSize.getX()), Math.round(actualSize.getX()));
        assertEquals(Math.round(expectedSize.getY()), Math.round(actualSize.getY()));
        assertEquals(Math.round(expectedSize.getWidth()), Math.round(actualSize.getWidth()));
        assertEquals(Math.round(expectedSize.getHeight()), Math.round(actualSize.getHeight()));
    }

    /**
     * Tests the getGoalBlue method.
     */
    @Test
    public void getGoalBlueTest() {
        Rectangle expectedLeftGoal = MapUtilities.getLeftGoal();
        Rectangle actualLeftGoal = map.getGoalBlue();

        assertEquals(Math.round(expectedLeftGoal.getX()), Math.round(actualLeftGoal.getX()));
        assertEquals(Math.round(expectedLeftGoal.getY()), Math.round(actualLeftGoal.getY()));
        assertEquals(Math.round(expectedLeftGoal.getWidth()), Math.round(actualLeftGoal.getWidth()));
        assertEquals(Math.round(expectedLeftGoal.getHeight()), Math.round(actualLeftGoal.getHeight()));
    }

    /**
     * Tests the getGoalBlue method.
     */
    @Test
    public void getGoalRedTest() {
        Rectangle expectedRightGoal = MapUtilities.getRightGoal();
        Rectangle actualRightGoal = map.getGoalRed();

        assertEquals(Math.round(expectedRightGoal.getX()), Math.round(actualRightGoal.getX()));
        assertEquals(Math.round(expectedRightGoal.getY()), Math.round(actualRightGoal.getY()));
        assertEquals(Math.round(expectedRightGoal.getWidth()), Math.round(actualRightGoal.getWidth()));
        assertEquals(Math.round(expectedRightGoal.getHeight()), Math.round(actualRightGoal.getHeight()));
    }

    /**
     * Tests the setMapType and getMapType methods.
     */
    @Test
    public void setMapTypeAndGetMapTypeTest() {
        map.setMapType(MapType.MOON);
        assertEquals(MapType.MOON, map.getMapType());
    }

    /**
     * Tests the getBall method.
     */
    @Test
    public void getBallTest() {
        assertEquals(ball, map.getBall());
    }

}
