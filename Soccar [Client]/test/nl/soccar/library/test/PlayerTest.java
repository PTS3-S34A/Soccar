package nl.soccar.library.test;

import nl.soccar.library.Player;
import nl.soccar.library.Statistics;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Player class.
 *
 * @author PTS34A
 */
public class PlayerTest {
    
    // Declaration of test objects.
    private Player player;
    private Statistics statistics;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        statistics = new Statistics(0, 0, 0, 0, 0);
    }
    
    /**
     * Tests the getUsername method.
     */
    @Test
    public void getUsernameTest() {
        assertEquals("username", player.getUsername());
    }
    
    /**
     * Tests the getPrivilege method.
     */
    @Test
    public void getPrivilegeTest() {
        assertEquals(Privilege.NORMAL, player.getPrivilege());
    }
    
    /**
     * Tests the getCarType method.
     */
    @Test
    public void getCarTypeTest() {
        assertEquals(CarType.CASUAL, player.getCarType());
    }
    
    /**
     * Tests the getStatistics and setStatistics methods.
     */
    @Test
    public void getStatisticsAndSetStatisticsTest() {
        player.setStatistics(statistics);
        assertEquals(statistics, player.getStatistics());
    }
    
    /**
     * Tests the toString method
     */
    @Test
    public void toStringTest() {
        assertEquals("username", player.toString());
    }
    
}
