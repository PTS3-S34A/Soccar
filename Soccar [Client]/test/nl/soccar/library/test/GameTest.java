package nl.soccar.library.test;

import java.time.LocalTime;
import java.util.Optional;
import nl.soccar.library.Event;
import nl.soccar.library.Game;
import nl.soccar.library.Player;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.EventType;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.ui.DisplayConstants;
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
        event = new Event(EventType.GOAL_RED, LocalTime.of(13, 55, 03), player);
        game = new Game();
    }

    /**
     * Tests the start method.
     */
    @Test
    public void startTest() {
        game.start();
        assertEquals(GameStatus.RUNNING, game.getStatus());
    }

    /**
     * Tests the stop method.
     */
    @Test
    public void stopTest() {
        game.stop();
        assertEquals(GameStatus.STOPPED, game.getStatus());
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
        assertEquals(Optional.empty(), game.getStartTime());
    }

    /**
     * Tests the getStatus and setStatus methods.
     */
    @Test
    public void getStatusAndSetStatusTest() {
        assertEquals(GameStatus.STOPPED, game.getStatus());
        game.setStatus(GameStatus.SCORED);
        assertEquals(GameStatus.SCORED, game.getStatus());
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
     * Tests the getMap method.
     */
    @Test
    public void getMapTest() {
        assertEquals(0, Math.round(game.getMap().getSize().getX()));
        assertEquals(0, Math.round(game.getMap().getSize().getY()));
        assertEquals(Math.round(DisplayConstants.MAP_WIDTH), Math.round(game.getMap().getSize().getWidth()));
        assertEquals(Math.round(DisplayConstants.MAP_HEIGHT), Math.round(game.getMap().getSize().getHeight()));
    }
    
    /**
     * Tests the getLastBallTouched andSetLastBallTouched methods.
     */
    @Test
    public void getLastBallTouchedAndSetLastBallTouchedTest() {
        game.setLastBallTouched(player);
        assertEquals(player, game.getLastBallTouched());
    }
    
}
