package nl.soccar.library.test;

import java.util.Optional;
import nl.soccar.exception.DuplicateValueException;
import nl.soccar.exception.InvalidCredentialException;
import nl.soccar.exception.RoomException;
import nl.soccar.exception.UIException;
import nl.soccar.library.Player;
import nl.soccar.library.Session;
import nl.soccar.library.SessionController;
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
    private Player player5;
    private Player player6;
    private Player player7;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        sessionController = new SessionController();
        session = new Session("name", "password");
        player1 = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        player2 = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        player3 = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        player4 = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        player5 = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        player6 = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        player7 = new Player("username", Privilege.NORMAL, CarType.CASUAL);
    }

    /**
     * Tests the create and getAllSessions methods.
     */
    @Test
    public void createAndGetAllSessionsTest() throws UIException {
        sessionController.create("name", "password", player1);
        assertNotNull(sessionController.getAllSessions());
    }

    /**
     * Tests the DuplicateValueException that can be thrown from the create method.
     */
    @Test(expected = DuplicateValueException.class)
    public void createDuplicateValueExceptionTest() throws UIException {
        sessionController.create("name", "password", player1);
        sessionController.create("name", "password", player2);
    }

    /**
     * Tests the join method.
     */
    @Test
    public void joinTest() throws UIException {
        Session createdSession = sessionController.create("name", "password", player1);
        assertNotNull(sessionController.join(createdSession, "password", player2));
        assertNotNull(sessionController.join(createdSession, "password", player3));
        assertNotNull(sessionController.join(createdSession, "password", player4));
    }

    /**
     * Tests the RoomException that can be thrown from the join method.
     */
    @Test(expected = RoomException.class)
    public void joinRoomExceptionTest() throws UIException {
        Session createdSession = sessionController.create("name", "password", player1);
        assertNotNull(sessionController.join(createdSession, "password", player2));
        assertNotNull(sessionController.join(createdSession, "password", player3));
        assertNotNull(sessionController.join(createdSession, "password", player4));
        assertNotNull(sessionController.join(createdSession, "password", player5));
        assertNotNull(sessionController.join(createdSession, "password", player6));
        sessionController.join(createdSession, "password", player7);
    }

    /**
     * Tests the InvalidCredentialException the can be thrown from the join method.
     */
    @Test(expected = InvalidCredentialException.class)
    public void joinInvalidCredentialExceptionTest() throws UIException {
        Session createdSession = sessionController.create("name", "password", player1);
        sessionController.join(createdSession, "wrong password", player2);
    }

    /**
     * Tests the getAllSessions method.
     */
    public void getAllSessionsTest() throws UIException {
        sessionController.create("name", "password", player1);
        assertNotNull(sessionController.getAllSessions());
    }

    /**
     * Tests get getCurrentSession and setCurrentSession methods.
     */
    @Test
    public void getCurrentSessionAndSetCurrentSessionTest() {
        sessionController.setCurrentSession(session);
        assertEquals(Optional.of(session), sessionController.getCurrentSession());
    }

}
