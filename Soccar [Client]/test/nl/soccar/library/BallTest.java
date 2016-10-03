/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private final double x = 1D;
    private final double y = 1D;
    private final double degree = 1D;
    
    public BallTest() {
    }
    
    @Before
    public void setUp() {
        ball = new Ball(0, 0, 0, BallType.FOOTBALL);
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
