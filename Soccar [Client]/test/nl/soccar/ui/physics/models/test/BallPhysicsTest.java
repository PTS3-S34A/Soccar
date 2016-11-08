package nl.soccar.ui.physics.models.test;

import nl.soccar.library.Ball;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.physics.GamePhysics;
import nl.soccar.physics.models.BallPhysics;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Ball class.
 *
 * @author PTS34A
 */
public class BallPhysicsTest {

    // Declaration of test objects.
    private GamePhysics gamePhysics;
    private Ball ball;
    private BallPhysics ballPhysics;

    /**
     * Instantiation of test object.
     */
    @Before
    public void setUp() {
        gamePhysics = new GamePhysics();
        ball = new Ball(0.0F, 0.0F, 0.0F, 10.0F, BallType.FOOTBALL);
        ballPhysics = new BallPhysics(ball, gamePhysics.getWorld());
    }
    
    /**
     * Tests the reset method.
     */
    @Test
    public void resetTest() {
        ballPhysics.reset();
        assertEquals(Math.round(0.0F), Math.round(ballPhysics.getX()));
        assertEquals(Math.round(0.0F), Math.round(ballPhysics.getY()));
    }

    /**
     * Tests the getX method.
     */
    @Test
    public void getXTest() {
        assertEquals(Math.round(0.0F), Math.round(ballPhysics.getX()));
    }

    /**
     * Tests the getY method.
     */
    @Test
    public void getYTest() {
        assertEquals(Math.round(0.0F), Math.round(ballPhysics.getY()));
    }

    /**
     * Tests the getDegrees method.
     */
    @Test
    public void getDegreesTest() {
        assertEquals(Math.round(0.0F), Math.round(ballPhysics.getDegree()));
    }

}
