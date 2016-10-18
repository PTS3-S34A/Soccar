package nl.soccar.library.test;

import java.time.LocalDateTime;
import nl.soccar.library.Event;
import nl.soccar.library.Game;
import nl.soccar.library.Player;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.EventType;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.library.enumeration.Privilege;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Game class.
 *
 * @author PTS34A
 */
public class GameTest {

    // Declaration of test objects.
    private Player player;
    private Event event;
    private Game game;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        player = new Player("username", Privilege.NORMAL, CarType.CASUAL);
        event = new Event(EventType.GOAL, LocalDateTime.of(2016, 1, 1, 0, 0), player);
        game = new Game();
    }

    /**
     * Tests the start method.
     */
    @Test
    public void startTest() {
        // TODO
        // game.start();
        // assertEquals(GameStatus.STARTED, game.getStatus());
    }

    /**
     * Tests the stop method.
     */
    @Test
    public void stopTest() {
        // TODO
        // game.stop();
        // assertEquals(GameStatus.STOPPED, game.getStatus());
    }

    /**
     * Tests the addEvent and getEvents methods.
     */
    @Test
    public void addEventAndGetEventsTest() {
        game.addEvent(event);
        assertEquals(event, game.getEvents().get(0));
    }

    /**
     * Tests the getStarttime method.
     */
    @Test
    public void getStartTimeTest() {
        // TODO
    }

    /**
     * Tests the getStatus method.
     */
    @Test
    public void getStatusTest() {
        assertEquals(GameStatus.STOPPED, game.getStatus());
    }

    /**
     * Tests the getDuration and setDuration methods.
     */
    @Test
    public void getDurationAndSetDurationTest() {
        game.setDuration(Duration.MINUTES_3);
        assertEquals(Duration.MINUTES_3, game.getDuration());
    }

    /**
     * Tests the getBallType and setBallType methods.
     */
    @Test
    public void getBalltypeAndSetBalltypeTest() {
        game.setBalltype(BallType.BOWLING);
        assertEquals(BallType.BOWLING, game.getBalltype());
    }

}
