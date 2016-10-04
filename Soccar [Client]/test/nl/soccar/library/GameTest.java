package nl.soccar.library;

import java.time.LocalDateTime;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.EventType;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PTS34A
 */
public class GameTest {
    
    // Declaration of test objects
    private Game game;
    private Event event;
    private Player player;
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Before
    public void setUp() {
        game = new Game();
        player = new Player("Testuser", "password", Privilege.NORMAL, CarType.CASUAL);
        event = new Event(EventType.GOAL, LocalDateTime.now(), player);
    }
    
    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        game.start();
        assertEquals(GameStatus.STARTED, game.getStatus());
    }

    /**
     * Test of stop method, of class Game.
     */
    @Test
    public void testStop() {
        game.stop();
        assertEquals(GameStatus.STOPPED, game.getStatus());
    }

    /**
     * Test of addEvent method, of class Game.
     */
    @Test
    public void testAddEvent() {
        game.addEvent(event);
        assertNotNull(game.getEvents());
    }

}
