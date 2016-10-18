package nl.soccar.util.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import nl.soccar.util.PhysicsUtilities;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.util PhysicsUtilities class.
 *
 * @author PTS34A
 */
public class PhysicsUtilitiesTest {

    /**
     * Tests the calculateCarHeight method.
     */
    @Test
    public void calculateCarHeightTest() {
        assertEquals(Math.round(24.0F), Math.round(PhysicsUtilities.calculateCarHeight(10.0F)));
    }

    /**
     * Tests the calculateWheelWidth method.
     */
    @Test
    public void calculateWheelWidthTest() {
        assertEquals(Math.round(2.0F), Math.round(PhysicsUtilities.calculateWheelWidth(10.0F)));
    }

    /**
     * Tests the calculateWheelHeight method.
     */
    @Test
    public void calculateWheelHeightTest() {
        assertEquals(Math.round(20.0F), Math.round(PhysicsUtilities.calculateWheelHeight(10.0F)));
    }

    /**
     * Marks the private constructor of the PhysicsUtilities class as tested in JaCoCo.
     *
     * @throws NoSuchMethodException Does not apply.
     * @throws IllegalAccessException Does not apply.
     * @throws InvocationTargetException Does not apply.
     * @throws InstantiationException Does not apply.
     */
    @Test
    public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<PhysicsUtilities> constructor = PhysicsUtilities.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
