package nl.soccar.library.test;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import nl.soccar.library.Notification;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test that tests the nl.soccar.library.Notification class.
 *
 * @author PTS34A
 */
public class NotificationTest {

    // Declaration of test objects.
    private Font font;
    private Notification notification;

    /**
     * Instantiation of test objects.
     */
    @Before
    public void setUp() {
        font = new Font("Font", 1);
        notification = new Notification(0, 0, 0, "content", font, Color.BLACK, Color.BLUE);
    }

    /**
     * Tests the getContent method.
     */
    @Test
    public void getContentTest() {
        assertEquals("content", notification.getContent());
    }

    /**
     * Tests the getFont method.
     */
    @Test
    public void getFontTest() {
        assertEquals(font, notification.getFont());
    }

    /**
     * Tests the getStroke method.
     */
    @Test
    public void getStrokeTest() {
        assertEquals(Color.BLUE, notification.getStroke());
    }

    /**
     * Tests the getStroke method.
     */
    @Test
    public void getFillTest() {
        assertEquals(Color.BLACK, notification.getFill());
    }

}
