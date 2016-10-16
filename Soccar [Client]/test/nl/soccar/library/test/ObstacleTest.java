package nl.soccar.library.test;

import nl.soccar.library.Obstacle;
import nl.soccar.library.enumeration.ObstacleType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Obstacle class.
 *
 * @author PTS34A
 */
public class ObstacleTest {

    // Declaration of test object.
    private Obstacle obstacle;

    /**
     * Instantiation of test object.
     */
    @Before
    public void setUp() {
        obstacle = new Obstacle(0.0F, 0.0F, 0.0F, 10.0F, 20.0F, ObstacleType.WALL);
    }

    /**
     * Tests the getWidth method.
     */
    @Test
    public void getWidthTest() {
        assertEquals(Math.round(10.0F), Math.round(obstacle.getWidth()));
    }

    /**
     * Tests the getHeight method.
     */
    @Test
    public void getHeightTest() {
        assertEquals(Math.round(20.0F), Math.round(obstacle.getHeight()));
    }

    /**
     * Tests the getHeight method.
     */
    @Test
    public void getTypeTest() {
        assertEquals(ObstacleType.WALL, obstacle.getType());
    }

}
