package nl.soccar.library;

import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PTS34A
 */
public class CarTest {
    
    //Declaration of test objects.
    private Car car;
    private Player player;
    private double x = 1D;
    private double y = 1D;
    private double degree = 1D;
    
    @Before
    public void setUp() {
        player = new Player("Testuser", "password", Privilege.NORMAL, CarType.CASUAL);
        car = new Car(0, 0, 0, player.getCarType(), player);
        
        x = 1D;
        y = 1D;
        degree = 1D;
    }
    
    /**
     * Test of move method, of class Car.
     */
    @Test
    public void testMove() {
        car.move(x, y, degree);
        assertSame(Math.round(x), Math.round(car.getX()));
        assertSame(Math.round(y), Math.round(car.getY()));
        assertSame(Math.round(degree), Math.round(car.getDegree()));
    }
    
}
