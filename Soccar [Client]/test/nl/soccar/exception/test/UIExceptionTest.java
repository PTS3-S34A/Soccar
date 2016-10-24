package nl.soccar.exception.test;

import nl.soccar.exception.UIException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test that tests the nl.soccar.exception.UIException class.
 * 
 * @author PTS34A
 */
public class UIExceptionTest {
    
    // Declaration of test object.
    private UIException exception;

    /**
     * Instantiation of test object.
     */
    @Before
    public void setUp() {
        exception = new UIException("title", "message");
    }
    
    /**
     * Tests the getTitle method.
     */
    @Test
    public void getTitleTest() {
        assertEquals("title", exception.getTitle());
    }
    
}
