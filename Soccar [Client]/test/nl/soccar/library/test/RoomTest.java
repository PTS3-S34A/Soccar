package nl.soccar.library.test;

import nl.soccar.library.Player;
import nl.soccar.library.Room;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.library.enumeration.TeamColour;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Room class.
 *
 * @author PTS34A
 */
public class RoomTest {

    // Declaration of test objects.
    private Room room;
    private Player player;

    @Before
    public void setUp() {
        room = new Room("name", "password");
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        room.getTeamBlue().join(player);
    }

    /**
     * Tests the check method.
     */
    @Test
    public void checkTest() {
        assertTrue(room.check("password"));
        assertFalse(room.check("wrong password"));
    }

    /**
     * Tests get getHost method.
     */
    @Test
    public void getHostTest() {
        assertEquals(player, room.getHost());
        room.getTeamBlue().leave(player);
        assertNull(room.getHost());
    }

    /**
     * Tests the getTeamRed method.
     */
    @Test
    public void getTeamRedTest() {
        assertEquals(TeamColour.RED, room.getTeamRed().getTeamColour());
    }

    /**
     * Tests the getTeamBlue method.
     */
    @Test
    public void getTeamBlueTest() {
        assertEquals(TeamColour.BLUE, room.getTeamBlue().getTeamColour());
    }

    /**
     * Tests the getAllPlayers method.
     */
    @Test
    public void getAllPlayersTest() {
        assertEquals(1, room.getAllPlayers().size());
    }
    
    /**
     * Tests the getName method.
     */
    @Test
    public void getNameTest() {
        assertEquals("name", room.getName());
    }
    
    /**
     * Tests the getCapacity and setCapacity methods.
     */
    @Test
    public void getCapacityAndSetCapacityTest() {
        room.setCapacity(4);
        assertEquals(4, room.getCapacity());
    }

}
