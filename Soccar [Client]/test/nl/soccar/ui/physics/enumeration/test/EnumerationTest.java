package nl.soccar.ui.physics.enumeration.test;

import nl.soccar.physics.enumeration.HandbrakeAction;
import nl.soccar.physics.enumeration.SteerAction;
import nl.soccar.physics.enumeration.ThrottleAction;
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
        HandbrakeAction.valueOf(HandbrakeAction.ACTIVE.toString());
        SteerAction.valueOf(SteerAction.NONE.toString());
        ThrottleAction.valueOf(ThrottleAction.ACCELERATE.toString());
    }

}
