package nl.soccar.ui.input.test;

import javafx.scene.input.KeyCode;
import nl.soccar.ui.input.Keyboard;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.ui.input Keyboard class.
 *
 * @author PTS34A
 */
public class KeyboardTest {

    /**
     * Tests the isPressed and setKeyPressed methods.
     */
    @Test
    public void isPressedAndSetKeyPressedTest() {
        assertFalse(Keyboard.isPressed(KeyCode.A));
        Keyboard.setKeyPressed(KeyCode.A);
        Keyboard.setKeyPressed(KeyCode.A); // Tests an alternative path in the setKeyPressed method.
        assertTrue(Keyboard.isPressed(KeyCode.A));
    }

    /**
     * Tests the setKeyReleased method.
     */
    @Test
    public void setKeyReleaseTest() {
        Keyboard.setKeyPressed(KeyCode.A);
        assertTrue(Keyboard.isPressed(KeyCode.A));
        Keyboard.setKeyReleased(KeyCode.A);
        assertFalse(Keyboard.isPressed(KeyCode.A));
    }

    // The getThrottleAction, getSteerAction and getHandbrakeAction methods are tested in the CarPhysicsTest class because they rely on the stepping of the physics objects.
    
}
