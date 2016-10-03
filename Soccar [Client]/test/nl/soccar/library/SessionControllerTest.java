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
public class SessionControllerTest {
    
    // Declaration of test objects.
    private SessionController controller;
    private Session session;
    private Player player;
    private Player player2;
    
    public SessionControllerTest() {
    }
    
    @Before
    public void setUp() {
        controller = new SessionController();
        session = new Session("Testroom", "1234");
        player = new Player("Testuser", "password", Privilege.NORMAL, CarType.CASUAL);
        player2 = new Player("Testuser2", "password", Privilege.NORMAL, CarType.CASUAL);
    }

    /**
     * Test of create method, of class SessionController.
     */
    @Test
    public void testCreate() {
        controller.create("test123", "123", player);
        assertNotNull(controller.getAllSessions());
    }

    /**
     * Test of join method, of class SessionController.
     */
    @Test
    public void testJoin() {
        controller.create("test123", "123", player);
        Session s2 = controller.join("test123", "123", player2);
        assertNotNull(s2);
    }

    /**
     * Test of leave method, of class SessionController.
     */
    @Test
    public void testLeave() {
        controller.create("test123", "123", player);
        controller.leave(session, player);
        
    }

    /**
     * Test of getAllSessions method, of class SessionController.
     */
    @Test
    public void testGetAllSessions() {
        controller.create("test123", "123", player);
        assertNotNull(controller.getAllSessions());
    }
    
}
