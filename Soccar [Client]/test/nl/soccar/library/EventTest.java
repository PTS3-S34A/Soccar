package nl.soccar.library;

import java.time.LocalDateTime;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.EventType;
import nl.soccar.library.enumeration.Privilege;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test that tests the nl.soccar.library.Event class.
 *
 * @author PTS34A
 */
public class EventTest {

    // Declaration of test objects.
    private Player player;
    private Event event;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        player = new Player("username", "password", Privilege.NORMAL, CarType.CASUAL);
        event = new Event(EventType.GOAL, LocalDateTime.of(2016, 1, 1, 0, 0), player);
    }
    
    /**
     * Tests the getType method.
     */
    @Test
    public void getTypeTest() {
        assertEquals(EventType.GOAL, event.getType());
    }
    
    /**
     * Tests the getTime method.
     */
    @Test
    public void getTimeTest() {
        assertEquals(LocalDateTime.of(2016, 1, 1, 0, 0), event.getTime());
    }
    
    /**
     * Tests the getPlayer method.
     */
    @Test
    public void getPlayerTest() {
        assertEquals(player, event.getPlayer());
    }
    
}
