package nl.soccar.library;

import java.util.List;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.library.enumeration.TeamColour;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PTS34A
 */
public class TeamTest {
    
    // Delcaration of test objects
    private Team team;
    private Player player;
    
    @Before
    public void setUp() {
        player = new Player("Testuser", "password", Privilege.NORMAL, CarType.CASUAL);
        team = new Team(TeamColour.BLUE);
    }
    

    /**
     * Test of join method, of class Team.
     */
    @Test
    public void testJoin() {
        team.join(player);
        assertNotNull(team.getPlayers());
    }

    /**
     * Test of leave method, of class Team.
     */
    @Test
    public void testLeave() {
        team.join(player);
        team.leave(player);
        assertNull(team.getPlayers());
    }
    
}