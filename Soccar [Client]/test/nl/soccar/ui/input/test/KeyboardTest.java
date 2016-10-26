package nl.soccar.ui.input.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
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

    /**
     * Marks the private constructor of the Keyboard class as tested in JaCoCo.
     *
     * @throws NoSuchMethodException Does not apply.
     * @throws IllegalAccessException Does not apply.
     * @throws InvocationTargetException Does not apply.
     * @throws InstantiationException Does not apply.
     */
    @Test
    public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Keyboard> constructor = Keyboard.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    // The getThrottleAction, getSteerAction and getHandbrakeAction methods are tested in the CarPhysicsTest class because they rely on the stepping of the physics objects.
}
