package nl.soccar.ui;

import nl.soccar.library.Game;
import nl.soccar.ui.physics.GamePhysics;
import nl.soccar.ui.physics.WorldObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A canvas keeps track of Drawables. It updates them and provides a way to draw them.
 * It also keeps track of all Physics, the drawables (in turn) provide stepping methodes for the World (Physics).
 *
 * @author PTS34A
 */
public abstract class GameCanvas {

    private final Game game;
    private final GamePhysics physics;
    private final List<WorldObject> worldObjects;
    private final List<Drawable> drawables;

    /**
     * Initiates a new GameCanvas object.
     */
    public GameCanvas(Game game) {
        this.game = game;

        worldObjects = new ArrayList<>();
        drawables = new ArrayList<>();
        physics = new GamePhysics();
    }

    /**
     * Starts the game loop and starts drawing all drawables at a fixed rate.
     */
    public abstract void start();

    /**
     * Stops the game loop and stops drawing all drawables.
     */
    public abstract void stop();

    /**
     * Method that adds a world object to the list of world objects.
     *
     * @param worldObject WorldObject item that needs to be added to the list of world objects.
     */
    public final void addWorldObject(WorldObject worldObject) {
        worldObjects.add(worldObject);
    }

    /**
     * Method that removes world object out of the list of world objects.
     *
     * @param worldObject WorldObject item that needs to be removed from the worldObjects list.
     */
    public final void removeWorldObject(WorldObject worldObject) {
        worldObjects.remove(worldObject);
    }

    /**
     * Method that adds a drawable to the list of drawables.
     *
     * @param drawable Drawable item that needs to be added to the list of drawables.
     */
    public final void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    /**
     * Method that removes drawable out of the list of drawables.
     *
     * @param drawable Drawable item that needs to be removed from the drawable list.
     */
    public final void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }

    /**
     * Method that gets the physics.
     *
     * @return The physics.
     */
    public final GamePhysics getPhysics() {
        return physics;
    }

    /**
     * Method that gets the list of drawable items of this GameCanvas.
     *
     * @return unmodifiable List of drawables.
     */
    public final List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }


    /**
     * Method that gets the list of world object items of this GameCanvas.
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
