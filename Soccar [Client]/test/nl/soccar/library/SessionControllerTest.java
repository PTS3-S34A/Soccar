package nl.soccar.library;

import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.SessionController class.
 *
 * @author PTS34A
 */
public class SessionControllerTest {

    // Declaration of test objects.
    private SessionController sessionController;
    private Session session;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        sessionController = new SessionController();
        session = new Session("name", "password");
        player1 = new Player("username", "password", Privilege.NORMAL, CarType.CASUAL);
        player2 = new Player("password", "password", Privilege.NORMAL, CarType.CASUAL);
        player3 = new Player("password", "password", Privilege.NORMAL, CarType.CASUAL);
        player4 = new Player("password", "password", Privilege.NORMAL, CarType.CASUAL);
    }

    /**
     * Tests the create and getAllSessions methods.
     */
    @Test
    public void createAndGetAllSessionsTest() {
        sessionController.create("name", "password", player1);
        assertNotNull(sessionController.getAllSessions());
    }

    /**
     * Tests the join method.
     */
    @Test
    public void joinTest() {
        sessionController.create("name", "password", player1);
        assertNotNull(sessionController.join("name", "password", player2));
        assertNotNull(sessionController.join("name", "password", player3));
        assertNotNull(sessionController.join("name", "password", player4));
        assertNull(sessionController.join("name", "wrong password", player1));
        assertNull(sessionController.join("wrong name", "password", player1));
    }

    /**
     * Tests the leave method.
     */
    @Test
    public void leaveTest() {
        sessionController.create("name", "password", player1);
        sessionController.leave(session, player1);
    }

    /**
     * Tests the getAllRooms method.
     */
    @Test
    public void getAllRoomsTest() {
        sessionController.create("name", "password", player1);
        assertNotNull(sessionController.getAllRooms());
    }

    /**
     * Tests get getCurrentSession and setCurrentSession methods.
     */
    @Test
    public void getCurrentSessionAndSetCurrentSessionTest() {
        sessionController.setCurrentSession(session);
        assertEquals(session, sessionController.getCurrentSession());
    }

}
