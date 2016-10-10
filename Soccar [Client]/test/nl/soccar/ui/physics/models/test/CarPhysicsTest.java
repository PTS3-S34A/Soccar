package nl.soccar.ui.physics.models.test;

import nl.soccar.library.Car;
import nl.soccar.library.Player;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.ui.physics.GamePhysics;
import nl.soccar.ui.physics.enumeration.SteerAction;
import nl.soccar.ui.physics.enumeration.ThrottleAction;
import nl.soccar.ui.physics.models.CarPhysics;
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
     * Test void methods for possible crashes.
     */
    @Test
    public void voidMethodsTest() {
        carPhysics.step();
        carPhysics.setThrottleAction(ThrottleAction.ACCELERATE);
        carPhysics.step();
        carPhysics.setThrottleAction(ThrottleAction.IDLE);
        carPhysics.step();
        carPhysics.setThrottleAction(ThrottleAction.REVERSE);
        carPhysics.step();
        carPhysics.setSteerAction(SteerAction.STEER_LEFT);
        carPhysics.step();
        carPhysics.setSteerAction(SteerAction.STEER_RIGHT);
        carPhysics.step();
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
     * Tests the getWheels method.
     */
    @Test
    public void getWheelsTest() {
        assertEquals(4, carPhysics.getWheels().size());
    }

}
