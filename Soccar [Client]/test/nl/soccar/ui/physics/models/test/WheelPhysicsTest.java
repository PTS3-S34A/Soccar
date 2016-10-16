package nl.soccar.ui.physics.models.test;

import nl.soccar.library.Car;
import nl.soccar.library.Player;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.ui.physics.GamePhysics;
import nl.soccar.ui.physics.models.CarPhysics;
import nl.soccar.ui.physics.models.WheelPhysics;
import nl.soccar.util.PhysicsUtilities;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test that tests the nl.soccar.library.Wheel class.
 *
 * @author PTS34A
 */
public class WheelPhysicsTest {

    // Declaration of test objects.
    private GamePhysics gamePhysics;
    private Player player;
    private Car car;
    private CarPhysics carPhysics;
    private WheelPhysics leftFrontWheel;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        gamePhysics = new GamePhysics();
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        car = new Car(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, player.getCarType(), player);
        carPhysics = new CarPhysics(car, gamePhysics.getWorld());
        leftFrontWheel = carPhysics.getWheels().get(0);
    }

    /**
     * Tests the getX method.
     */
    @Test
    public void getXTest() {
        assertEquals(Math.round(-car.getWidth() / 2.3F), Math.round(leftFrontWheel.getX()));
    }

    /**
     * Tests the getY method.
     */
    @Test
    public void getYTest() {
        assertEquals(Math.round(car.getHeight() / 4.0F), Math.round(leftFrontWheel.getY()));
    }

    /**
     * Tests the getDegree method.
     */
    @Test
    public void getDegreeTest() {
        assertEquals(0, Math.round(leftFrontWheel.getDegree()));
    }

    /**
     * Tests the getWidth method.
     */
    @Test
    public void getWidthTest() {
        assertEquals(Math.round(PhysicsUtilities.calculateWheelWidth(car.getWidth())), Math.round(leftFrontWheel.getWidth()));
    }

    /**
     * Tests the getHeight method.
     */
    @Test
    public void getHeightTest() {
        assertEquals(Math.round(PhysicsUtilities.calculateWheelHeight(PhysicsUtilities.calculateWheelWidth(car.getWidth()))), Math.round(leftFrontWheel.getHeight()));
    }

    /**
     * Tests the isSteerable method.
     */
    @Test
    public void isSteerableTest() {
        assertTrue(leftFrontWheel.isSteerable());
    }

    /**
     * Tests the isPowered method.
     */
    @Test
    public void isPoweredTest() {
        assertTrue(leftFrontWheel.isPowered());
    }

}
