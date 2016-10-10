package nl.soccar.util.test;

import java.awt.Rectangle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import nl.soccar.library.Ball;
import nl.soccar.library.Map;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.util.MapUtilities;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.util MapUtilities class.
 *
 * @author PTS34A
 */
public class MapUtilitiesTest {

    // Declaration of test object.
    private Map map;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        map = new Map(new Rectangle(0, 0, 10, 10), new Ball(0.0F, 0.0F, 0.0F, 0.0F, BallType.HOCKEY));
    }

    /**
     * Tests the getLeftGoal method.
     */
    @Test
    public void getLeftGoalTest() {
        assertEquals(MapUtilities.getLeftGoal(), map.getGoalBlue());
    }

    /**
     * Tests the getRightGoal method.
     */
    @Test
    public void getRightGoalTest() {
        assertEquals(MapUtilities.getRightGoal(), map.getGoalRed());
    }

    /**
     * Marks the private constructor of the MapUtilities class as tested in JaCoCo.
     * @throws NoSuchMethodException Does not apply.
     * @throws IllegalAccessException Does not apply.
     * @throws InvocationTargetException Does not apply.
     * @throws InstantiationException Does not apply.
     */
    @Test
    public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<MapUtilities> constructor = MapUtilities.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
