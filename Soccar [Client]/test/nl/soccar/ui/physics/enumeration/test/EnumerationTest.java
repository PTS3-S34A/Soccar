package nl.soccar.ui.physics.enumeration.test;

import nl.soccar.ui.physics.enumeration.SteerAction;
import nl.soccar.ui.physics.enumeration.ThrottleAction;
import org.junit.Test;

/**
 * JUnit test that tests all nl.soccar.ui.physics.enumeration enumerations.
 * 
 * @author PTS34A
 */
public class EnumerationTest {
    
    /**
     * Tests all enumerations
     */
    @Test
    public void testAllEnumerations() {
        SteerAction.valueOf(SteerAction.NONE.toString());
        ThrottleAction.valueOf(ThrottleAction.ACCELERATE.toString());
    }

}
