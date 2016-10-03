package nl.soccar.ui.input;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;

/**
 *
 * @author PTS34A
 */
public final class Keyboard {

    private static final Keyboard instance = new Keyboard();

    /**
     * Method that gets this Keyboard object.
     * 
     * @return This keyboard object.
     */
    public static Keyboard getInstance() {
        return instance;
    }

    private List<KeyCode> pressedKeys;

    private Keyboard() {
        pressedKeys = new ArrayList<>();
    }

    /**
     * Method that checks if the given key is pressed.
     * 
     * @param code The keycode that needs to be checked.
     * @return 
     */
    public boolean isPressed(KeyCode code) {
        return pressedKeys.contains(code);
    }

    /**
     * Method that adds the given KeyCode to the pressedKeys list.
     * 
     * @param code The keycode that needs to be added to the pressedKeys list.
     */
    public void setKeyPressed(KeyCode code) {
        if (!pressedKeys.contains(code)) {
            pressedKeys.add(code);
        }
    }

    /**
     * Method that removes the given KeyCode of the pressedKeys list.
     * 
     * @param code The keycode that needs to be removed of the pressedKeys list.
     */
    public void setKeyReleased(KeyCode code) {
        pressedKeys.remove(code);
    }

}
