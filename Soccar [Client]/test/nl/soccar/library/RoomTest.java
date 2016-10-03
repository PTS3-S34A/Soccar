package nl.soccar.library;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PTS34A
 */
public class RoomTest {
    
    // Declaration of test objects
    private Room room;
    private final String pass = "12345";
    
    
    public RoomTest() {
    }
    
    @Before
    public void setUp() {
        room = new Room("De vliegende hollander", pass);
    }

    /**
     * Test of check method, of class Room.
     */
    @Test
    public void testCheckTrue() {
        assertTrue(room.check(pass));
    }
    
    /**
     * Test of check method, of class Room.
     */
    @Test
    public void testCheckFalse() {
        assertFalse(room.check(""));
    }

}
