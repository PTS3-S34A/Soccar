package nl.soccar.util.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import nl.soccar.util.ImageUtilities;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.util.ImageUtilities class.
 * 
 * @author PTS34A
 */
public class ImageUtilitiesTest {
    
    /**
     * Marks the private constructor of the ImageUtilities class as tested in JaCoCo.
     *
     * @throws NoSuchMethodException Does not apply.
     * @throws IllegalAccessException Does not apply.
     * @throws InvocationTargetException Does not apply.
     * @throws InstantiationException Does not apply.
     */
    @Test
    public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ImageUtilities> constructor = ImageUtilities.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
