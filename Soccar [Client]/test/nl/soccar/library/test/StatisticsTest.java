package nl.soccar.library.test;

import nl.soccar.library.Statistics;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Statistics class.
 *
 * @author PTS34A
 */
public class StatisticsTest {

    // Declaration of test object.
    private Statistics statistics;

    /**
     * Instantiation of test object.
     */
    @Before
    public void setUp() {
        statistics = new Statistics("username",10, 5, 2, 4, 6);
    }

    /**
     * Tests the getGamesRatio method.
     */
    @Test
    public void getGamesRatioTest() {
        assertEquals(Double.toString(Math.round(((2.0D - 4.0D) / 6.0D) * 100.0D)), statistics.getGamesRatio());
    }

    /**
     * Tests the getGoals method.
     */
    @Test
    public void getGoalsTest() {
        assertEquals(10, statistics.getGoals());
    }

    /**
     * Tests the getAssists method.
     */
    @Test
    public void getAssistsTest() {
        assertEquals(5, statistics.getAssists());
    }

    /**
     * Tests the getGamesWon method.
     */
    @Test
    public void getGamesWonTest() {
        assertEquals(2, statistics.getGamesWon());
    }

    /**
     * Tests the getGamesLost method.
     */
    @Test
    public void getGamesLostTest() {
        assertEquals(4, statistics.getGamesLost());
    }
    
    /**
     * Tests the getGamesPlayed method.
     */
    @Test
    public void getGamesPlayed() {
        assertEquals(6, statistics.getGamesPlayed());
    }
    
}
