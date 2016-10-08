package nl.soccar.library.test;

import nl.soccar.library.Car;
import nl.soccar.library.Player;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Car class.
 *
 * @author PTS34A
 */
public class CarTest {

    //Declaration of test objects.
    private Player player;
    private Car car;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        player = new Player("username", "password", Privilege.NORMAL, CarType.CASUAL);
        car = new Car(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, player.getCarType(), player);
    }

    /**
     * Tests the move method.
     */
    @Test
    public void moveTest() {
        float newX = 1.0F;
        float newY = 1.0F;
        float newDegree = 1.0F;

        car.move(newX, newY, newDegree);

        assertSame(Math.round(newX), Math.round(car.getX()));
        assertSame(Math.round(newY), Math.round(car.getY()));
        assertSame(Math.round(newDegree), Math.round(car.getDegree()));
    }

    /**
     * Tests the getWidth method.
     */
    @Test
    public void getWidthTest() {
        assertEquals(Math.round(10.0F), Math.round(car.getWidth()));
    }

    /**
     * Tests the getHeight method.
     */
    @Test
    public void getHeightTest() {
        assertEquals(Math.round(10.0F), Math.round(car.getHeight()));
    }

    /**
     * Tests the getBooster method.
     */
    @Test
    public void getBooster() {
        // TODO
        // assertEquals(100, car.getBooster());
    }
    
    /**
     * Tests the getType method.
     */
    @Test
    public void getTypeTest () {
        assertEquals(CarType.CASUAL, car.getType());
    }

    /**
     * Tests the getPlayer method.
     */
    @Test
    public void getPlayer() {
        assertEquals(player, car.getPlayer());
    }

}
