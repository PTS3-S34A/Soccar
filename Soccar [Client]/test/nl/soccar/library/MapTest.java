package nl.soccar.library;

import java.awt.Rectangle;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PTS34A
 */
public class MapTest {
    
    //Delcaration of test objects
    private Map map;
    private Car car;
    private Player player;
    
    public MapTest() {
    }
    
    @Before
    public void setUp() {
        player = new Player("Testuser", "password", Privilege.NORMAL, CarType.CASUAL);
        car = new Car(0, 0, 0, player.getCarType(), player);
        map = new Map(new Rectangle(0, 0, 10, 10));
    }

    /**
     * Test of addCar method, of class Map.
     */
    @Test
    public void testAddCar() {
        map.addCar(car);
        assertNotNull(map.getCarFromPlayer(player));
    }
    
}
