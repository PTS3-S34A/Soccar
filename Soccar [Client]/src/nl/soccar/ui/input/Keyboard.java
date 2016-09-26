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

    public static Keyboard getInstance() {
        return instance;
    }

    private List<KeyCode> pressedKeys;

    private Keyboard() {
        pressedKeys = new ArrayList<>();
    }

    public boolean isPressed(KeyCode code) {
        return pressedKeys.contains(code);
    }

    public void setKeyPressed(KeyCode code) {
        if (!pressedKeys.contains(code)) {
            pressedKeys.add(code);
        }
    }

    public void setKeyReleased(KeyCode code) {
        pressedKeys.remove(code);
    }

}
