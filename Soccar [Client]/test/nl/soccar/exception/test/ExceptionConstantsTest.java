package nl.soccar.exception.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import nl.soccar.exception.ExceptionConstants;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.exception.ExceptionConstants class.
 * 
 * @author PTS34A
 */
public class ExceptionConstantsTest {
    
    /**
     * Marks the private constructor of the ExceptionConstants class as tested in JaCoCo.
     *
     * @throws NoSuchMethodException Does not apply.
     * @throws IllegalAccessException Does not apply.
     * @throws InvocationTargetException Does not apply.
     * @throws InstantiationException Does not apply.
     */
    @Test
    public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ExceptionConstants> constructor = ExceptionConstants.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
    
}
