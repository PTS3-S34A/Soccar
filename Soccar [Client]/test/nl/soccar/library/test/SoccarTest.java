package nl.soccar.library.test;

import nl.soccar.library.Player;
import nl.soccar.library.Soccar;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Soccar class.
 *
 * @author PTS34A
 */
public class SoccarTest {

    // Declaration of test object.
    private Player player;

    /**
     * Instantiation of test objects.
     * 
     * This method implicitly tests the setInstance method of the Soccar singleton class.
     */
    @Before
    public void setUp() {
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        Soccar.setInstance(player);
    }

    /**
     * Tests the getCurrentPlayer method.
     * 
     * This method implicitly tests the getInstance method of the Soccar singleton class.
     */
    @Test
    public void getCurrentPlayerTest() {
        assertEquals(player, Soccar.getInstance().getCurrentPlayer());
    }
    
    /**
     * Tests the getSessionController method.
     * 
     * This method implicitly tests the getInstance method of the Soccar singleton class.
     */
    @Test
    public void getSessionControllerTest() {
        assertNotNull(Soccar.getInstance().getSessionController());
    }
    
}
