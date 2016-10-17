package nl.soccar.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nl.soccar.ui.physics.GamePhysics;

/**
 * A canvas keeps track of Drawables. It updates them and provides a way to draw
 * them. It also keeps track of all Physics, the Drawables (in turn) provide
 * stepping methodes for the World (Physics).
 *
 * @author PTS34A
 */
public abstract class GameCanvas {

    private final GamePhysics physics;
    private final List<Drawable> drawables;

    /**
     * Initiates a new GameCanvas object. While initializing, the collections of
     * Drawables en Physics are also initialized.
     */
    public GameCanvas() {
        drawables = new ArrayList<>();
        physics = new GamePhysics();
    }

    /**
     * Starts the game loop and starts drawing all Drawables at a fixed rate.
     */
    public abstract void start();

    /**
     * Stops the game loop and stops drawing all Drawables.
     */
    public abstract void stop();

    /**
     * Adds a Drawable to the list of Drawables.
     *
     * @param drawable Drawable item that needs to be added to the collection of
     * Drawables.
     */
    public final void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    /**
     * Removes a Drawable out of the list of Drawables.
     *
     * @param drawable Drawable item that needs to be removed from the
     * collection of Drawables.
     */
    public final void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }

    /**
     * Gets the GamePhysics.
     *
     * @return The GamePhysics, not null.
     */
    public final GamePhysics getPhysics() {
        return physics;
    }

    /**
     * Gets all Drawables of this GameCanvas.
     *
     * @return An unmodifiable List of Drawables, not null.
     */
    public final List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }

}
