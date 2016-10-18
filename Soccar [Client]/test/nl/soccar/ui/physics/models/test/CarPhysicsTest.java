package nl.soccar.ui.physics.models.test;

import javafx.scene.input.KeyCode;
import nl.soccar.library.Car;
import nl.soccar.library.Player;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.ui.input.Keyboard;
import nl.soccar.physics.GamePhysics;
import nl.soccar.physics.enumeration.HandbrakeAction;
import nl.soccar.physics.enumeration.SteerAction;
import nl.soccar.physics.enumeration.ThrottleAction;
import nl.soccar.physics.models.CarPhysics;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Car class.
 *
 * @author PTS34A
 */
public class CarPhysicsTest {

    // Declaration of test objects.
    private GamePhysics gamePhysics;
    private Player player;
    private Car car;
    private CarPhysics carPhysics;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        gamePhysics = new GamePhysics();
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        car = new Car(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, player.getCarType(), player);
        carPhysics = new CarPhysics(car, gamePhysics.getWorld());
    }

    /**
     * Tests void methods for possible crashes.
     */
    @Test
    public void voidMethodsTest() {
        carPhysics.step();
    }

    /**
     * Tests the updateSteerAngle method.
     */
    @Test
    public void updateSteerAngleAndGetSteerActionTest() {
        assertEquals(SteerAction.NONE, carPhysics.getSteerAction());
        carPhysics.step();

        Keyboard.setKeyPressed(KeyCode.A);
        carPhysics.step();
        assertEquals(SteerAction.STEER_LEFT, carPhysics.getSteerAction());
        Keyboard.setKeyReleased(KeyCode.A);

        Keyboard.setKeyPressed(KeyCode.D);
        carPhysics.step();
        assertEquals(SteerAction.STEER_RIGHT, carPhysics.getSteerAction());
    }

    /**
     * Tests the getX method.
     */
    @Test
    public void getXTest() {
        assertEquals(Math.round(0.0F), Math.round(carPhysics.getX()));
    }

    /**
     * Tests the getY method.
     */
    @Test
    public void getYTest() {
        assertEquals(Math.round(0.0F), Math.round(carPhysics.getY()));
    }

    /**
     * Tests the getDegrees method.
     */
    @Test
    public void getDegreesTest() {
        assertEquals(Math.round(0.0F), Math.round(carPhysics.getDegree()));
    }

    /**
     * Tests the getSteerAngle method.
     */
    @Test
    public void getSteerAngleTest() {
        assertEquals(Math.round(0.0F), Math.round(carPhysics.getSteerAngle()));
    }

    /**
     * Tests the getBody method.
     */
    @Test
    public void getBodyTest() {
        assertNotNull(carPhysics.getBody());
    }

    /**
     * Tests the getThrottleAction method.
     */
    @Test
    public void getThrottleActionTest() {
        assertEquals(ThrottleAction.IDLE, carPhysics.getThrottleAction());
        carPhysics.step();

        Keyboard.setKeyPressed(KeyCode.W);
        carPhysics.step();
        assertEquals(ThrottleAction.ACCELERATE, carPhysics.getThrottleAction());
        Keyboard.setKeyReleased(KeyCode.W);

        Keyboard.setKeyPressed(KeyCode.S);
        carPhysics.step();
        assertEquals(ThrottleAction.REVERSE, carPhysics.getThrottleAction());
    }

    /**
     * Tests the getHandbrakeAction method.
     */
    @Test
    public void getHandbrakeActionTest() {
        assertEquals(HandbrakeAction.INACTIVE, carPhysics.getHandbrakeAction());
        carPhysics.step();

        Keyboard.setKeyPressed(KeyCode.SPACE);
        carPhysics.step();
        assertEquals(HandbrakeAction.ACTIVE, carPhysics.getHandbrakeAction());
    }

    /**
     * Tests the getWheels method.
     */
    @Test
    public void getWheelsTest() {
        assertEquals(4, carPhysics.getWheels().size());
    }

}
