package nl.soccar.ui.physics.models.test;

import nl.soccar.library.Obstacle;
import nl.soccar.library.enumeration.ObstacleType;
import nl.soccar.ui.physics.GamePhysics;
import nl.soccar.ui.physics.models.ObstaclePhysics;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test that tests the nl.soccar.library.Obstacle class.
 *
 * @author PTS34A
 */
public class ObstaclePhysicsTest {

    // Declaration of test objects.
    private GamePhysics gamePhysics;
    private Obstacle obstacle;
    private ObstaclePhysics obstaclePhysics;

    /**
     * Instantiation of test object.
     */
    @Before
    public void setUp() {
        gamePhysics = new GamePhysics();
        obstacle = new Obstacle(0.0F, 0.0F, 0.0F, 10.0F, 20.0F, ObstacleType.WALL);
        obstaclePhysics = new ObstaclePhysics(obstacle, gamePhysics.getWorld());
        obstaclePhysics.step();
    }

    /**
     * Tests void method for possible crashes.
     */
    @Test
    public void voidMethodsTest() {
        obstaclePhysics.step();
    }

    /**
     * Tests the getX method.
     */
    @Test
    public void getXTest() {
        assertEquals(Math.round(0.0F), Math.round(obstaclePhysics.getX()));
    }

    /**
     * Tests the getY method.
     */
    @Test
    public void getYTest() {
        assertEquals(Math.round(0.0F), Math.round(obstaclePhysics.getY()));
    }

    /**
     * Tests the getDegrees method.
     */
    @Test
    public void getDegreesTest() {
        assertEquals(Math.round(0.0F), Math.round(obstaclePhysics.getDegree()));
    }
    
}
