package nl.soccar.library;

import nl.soccar.library.enumeration.BallType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PTS34A
 */

public class BallTest {
    // Declaration of test objects
    private Ball ball;
    private double x;
    private double y;
    private double degree;
    
    @Before
    public void setUp() {
        ball = new Ball(0, 0, 0, BallType.FOOTBALL);
        
        x = 1D;
        y =1D;
        degree = 1D;
    }

    /**
     * Test of move method, of class Ball.
     */
    @Test
    public void moveTest() {
        ball.move(x, y, degree);
        assertSame(Math.round(x), Math.round(ball.getX()));
        assertSame(Math.round(y), Math.round(ball.getY()));
        assertSame(Math.round(degree), Math.round(ball.getDegree()));
    }

}
