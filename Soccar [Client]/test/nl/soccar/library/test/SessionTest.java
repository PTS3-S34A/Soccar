package nl.soccar.library.test;

import nl.soccar.library.Session;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Session class.
 *
 * @author PTS34A
 */
public class SessionTest {

    // Declaration of test object.
    private Session session;

    /**
     * Instantiation of test object.
     */
    @Before
    public void setUp() {
        session = new Session("name", "password");
    }

    /**
     * Tests the getGame method.
     */
    @Test
    public void getGameTest() {
        assertNotNull(session.getGame());
    }

    /**
     * Tests the getRoom method.
     */
    @Test
    public void getRoomTest() {
        assertNotNull(session.getRoom());
    }
    
}
