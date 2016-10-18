package nl.soccar.ui;

import nl.soccar.library.Game;
import nl.soccar.ui.physics.GamePhysics;
import nl.soccar.ui.physics.WorldObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A canvas keeps track of Drawables. It updates them and provides a way to draw
 * them. It also keeps track of all Physics, the Drawables (in turn) provide
 * stepping methodes for the World (Physics).
 *
 * @author PTS34A
 */
public abstract class GameCanvas {

    private final Game game;
    private final GamePhysics physics;
    private final List<WorldObject> worldObjects;
    private final List<Drawable> drawables;

    /**
     * Initiates a new GameCanvas object. While initializing, the collections of
     * Drawables en Physics are also initialized.
     *
     * @param game The Game, not null, that will be used to interact with.
     */
    public GameCanvas(Game game) {
        this.game = game;

        worldObjects = new ArrayList<>();
        drawables = new ArrayList<>();
        physics = new GamePhysics();
    }

    /**
     * Starts the game loop and starts drawing all Drawables and updating all
     * physics objects. at a fixed rate.
     */
    public abstract void start();

    /**
     * Stops the game loop and stops drawing all Drawables and updating all
     * physics objects.
     */
    public abstract void stop();

    /**
     * Adds a world object to the list of world objects.
     *
     * @param worldObject WorldObject item, not null, that needs to be added to
     * the list of world objects.
     */
    public final void addWorldObject(WorldObject worldObject) {
        worldObjects.add(worldObject);
    }

    /**
     * Removes world object out of the list of world objects.
     *
     * @param worldObject WorldObject item, not null, that needs to be removed
     * from the worldObjects list.
     */
    public final void removeWorldObject(WorldObject worldObject) {
        worldObjects.remove(worldObject);
    }

    /**
     * Adds a drawable to the list of drawables.
     *
     * @param drawable Drawable item, not null, that needs to be added to the
     * list of drawables.
     */
    public final void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    /**
     * Removes a drawable out of the list of drawables.
     *
     * @param drawable Drawable item, not null, that needs to be removed from
     * the drawable list.
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
     * @return An unmodifiable List, not null, of Drawables, not null.
     */
    public final List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }

    /**
     * Gets the list of world object items of this GameCanvas.
     *
     * @return unmodifiable List of world objects.
     */
    public final List<WorldObject> getWorldObjects() {
        return Collections.unmodifiableList(worldObjects);
    }

    /**
     * Returns the Game object from the library.
     *
     * @return Game The main game object
     */
    public final Game getGame() {
        return game;
    }

}
