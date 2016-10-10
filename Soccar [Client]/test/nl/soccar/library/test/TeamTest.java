package nl.soccar.library.test;

import nl.soccar.library.Player;
import nl.soccar.library.Team;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.library.enumeration.TeamColour;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Team class.
 *
 * @author PTS34A
 */
public class TeamTest {

    // Declaration of test objects.
    private Team team;
    private Player player;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        team = new Team(TeamColour.BLUE);
    }

    /**
     * Tests the join, leave and getPlayers methods.
     */
    @Test
    public void joinAndLeaveAndGetPlayersTest() {
        team.join(player);
        assertEquals(1, team.getPlayers().size());
        team.leave(player);
        assertEquals(0, team.getPlayers().size());
    }
    
    /**
     * Tests get getTeamColour method.
     */
    @Test
    public void getTeamColourTest() {
        assertEquals(TeamColour.BLUE, team.getTeamColour());
    }
    
}
