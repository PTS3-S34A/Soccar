package nl.soccar.util.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import javafx.scene.shape.Rectangle;
import nl.soccar.library.Ball;
import nl.soccar.library.Map;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.util.MapUtilities;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.util.MapUtilities class.
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
        Rectangle expectedLeftGoal = MapUtilities.getLeftGoal();
        Rectangle actualLeftGoal = map.getGoalBlue();

        assertEquals(Math.round(expectedLeftGoal.getX()), Math.round(actualLeftGoal.getX()));
        assertEquals(Math.round(expectedLeftGoal.getY()), Math.round(actualLeftGoal.getY()));
        assertEquals(Math.round(expectedLeftGoal.getWidth()), Math.round(actualLeftGoal.getWidth()));
        assertEquals(Math.round(expectedLeftGoal.getHeight()), Math.round(actualLeftGoal.getHeight()));
    }

    /**
     * Tests the getRightGoal method.
     */
    @Test
    public void getRightGoalTest() {
        Rectangle expectedRightGoal = MapUtilities.getRightGoal();
        Rectangle actualRightGoal = map.getGoalRed();

        assertEquals(Math.round(expectedRightGoal.getX()), Math.round(actualRightGoal.getX()));
        assertEquals(Math.round(expectedRightGoal.getY()), Math.round(actualRightGoal.getY()));
        assertEquals(Math.round(expectedRightGoal.getWidth()), Math.round(actualRightGoal.getWidth()));
        assertEquals(Math.round(expectedRightGoal.getHeight()), Math.round(actualRightGoal.getHeight()));
    }

    /**
     * Tests the getCentreX method.
     */
    @Test
    public void getCentreXTest() {
        Rectangle rectangle = new Rectangle(0, 0, 10, 12);
        assertEquals(5, Math.round(MapUtilities.getCentreX(rectangle)));
    }

    /**
     * Tests the getCentreY method.
     */
    @Test
    public void getCentreYTest() {
        Rectangle rectangle = new Rectangle(0, 0, 10, 12);
        assertEquals(6, Math.round(MapUtilities.getCentreY(rectangle)));
    }

    /**
     * Marks the private constructor of the MapUtilities class as tested in JaCoCo.
     *
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
