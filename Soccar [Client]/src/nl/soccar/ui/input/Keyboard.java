package nl.soccar.ui.input;

import javafx.scene.input.KeyCode;
import nl.soccar.physics.enumeration.HandbrakeAction;
import nl.soccar.physics.enumeration.SteerAction;
import nl.soccar.physics.enumeration.ThrottleAction;

import java.util.ArrayList;
import java.util.List;

/**
 * The Keyboard class keeps track of all pressed (and in turn released) keys.
 *
 * @author PTS34A
 */
public final class Keyboard {

    // Stores the keys that are being pressed at any time.
    private static final List<KeyCode> PRESSED_KEYS;

    // Stores the key binds.
    private static final List<KeyCode> ACCELERATE;
    private static final List<KeyCode> REVERSE;
    private static final List<KeyCode> STEER_LEFT;
    private static final List<KeyCode> STEER_RIGHT;
    private static final List<KeyCode> HANDBRAKE;

    static {
        PRESSED_KEYS = new ArrayList<>();

        // Accelerate binds
        ACCELERATE = new ArrayList<>();
        ACCELERATE.add(KeyCode.W);
        ACCELERATE.add(KeyCode.UP);

        // Reverse binds
        REVERSE = new ArrayList<>();
        REVERSE.add(KeyCode.S);
        REVERSE.add(KeyCode.DOWN);

        // Steer left binds
        STEER_LEFT = new ArrayList<>();
        STEER_LEFT.add(KeyCode.A);
        STEER_LEFT.add(KeyCode.LEFT);

        // Steer right binds
        STEER_RIGHT = new ArrayList<>();
        STEER_RIGHT.add(KeyCode.D);
        STEER_RIGHT.add(KeyCode.RIGHT);

        // Handbrake binds
        HANDBRAKE = new ArrayList<>();
        HANDBRAKE.add(KeyCode.SPACE);
    }

    /**
     * Constructor
     */
    private Keyboard() {
    }

    /**
     * Method that checks if the given key is already present in pressedKeys
     * list.
     *
     * @param code The keycode that needs to be checked.
     * @return boolean True if already pressed, false if not in pressedKeys
     * list.
     */
    public static boolean isPressed(KeyCode code) {
        return PRESSED_KEYS.contains(code);
    }

    /**
     * Method that adds the given KeyCode to the pressedKeys list.
     *
     * @param code The keycode that needs to be added to the pressedKeys list.
     */
    public static void setKeyPressed(KeyCode code) {
        if (!PRESSED_KEYS.contains(code)) {
            PRESSED_KEYS.add(0, code); // Prepend to the list, so the last key pressed gets first priority
        }
    }

    /**
     * Method that removes the given KeyCode from the pressedKeys list.
     *
     * @param code The keycode that needs to be removed of the pressedKeys list.
     */
    public static void setKeyReleased(KeyCode code) {
        PRESSED_KEYS.remove(code);
    }


    /**
     * Returns the correct ThrottleAction based on the current pressed keys
     *
     * @return ThrottleAction
     */
    public static ThrottleAction getThrottleAction() {

        // The last pressed key
        for (KeyCode pressedKey : PRESSED_KEYS) {

            if (ACCELERATE.contains(pressedKey)) {
                return ThrottleAction.ACCELERATE;
            }

            if (REVERSE.contains(pressedKey)) {
                return ThrottleAction.REVERSE;
            }

        }

        return ThrottleAction.IDLE;
    }

    /**
     * Returns the correct SteerAction based on the current pressed keys
     *
     * @return SteerAction
     */
    public static SteerAction getSteerAction() {

        for (KeyCode pressedKey : PRESSED_KEYS) {

            if (STEER_LEFT.contains(pressedKey)) {
                return SteerAction.STEER_LEFT;
            }

            if (STEER_RIGHT.contains(pressedKey)) {
                return SteerAction.STEER_RIGHT;
            }

        }

        return SteerAction.NONE;
    }

    /**
     * Returns the correct HandbrakeAction based on the current pressed keys
     *
     * @return SteerAction
     */
    public static HandbrakeAction getHandbrakeAction() {

        for (KeyCode pressedKey : PRESSED_KEYS) {

            if (HANDBRAKE.contains(pressedKey)) {
                return HandbrakeAction.ACTIVE;
            }

        }

        return HandbrakeAction.INACTIVE;
    }
}
