package nl.soccar.library.test;

import nl.soccar.library.Ball;
import nl.soccar.library.enumeration.BallType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Ball class.
 *
 * @author PTS34A
 */
public class BallTest {

    // Declaration of test object.
    private Ball ball;

    /**
     * Instantiation of test object.
     */
    @Before
    public void setUp() {
        ball = new Ball(0.0F, 0.0F, 0.0F, 10.0F, BallType.FOOTBALL);
    }

    /**
     * Tests the move method.
     */
    @Test
    public void moveTest() {
        float newX = 1.0F;
        float newY = 1.0F;
        float newDegree = 1.0F;

        ball.move(newX, newY, newDegree);

        assertEquals(Math.round(newX), Math.round(ball.getX()));
        assertEquals(Math.round(newY), Math.round(ball.getY()));
        assertEquals(Math.round(newDegree), Math.round(ball.getDegree()));
    }

    /**
     * Tests the getRadius method.
     */
    @Test
    public void getRadiusTest() {
        assertEquals(Math.round(10.0F), Math.round(ball.getRadius()));
    }

    /**
     * Tests the getBallType and setBallType methods.
     */
    @Test
    public void getBallTypeandSetBallTypeTest() {
        ball.setBallType(BallType.HOCKEY);
        assertEquals(BallType.HOCKEY, ball.getBallType());
    }

}
