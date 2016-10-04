package nl.soccar.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PTS34A
 */
public abstract class GameCanvas {

    private final List<Drawable> drawables;

    /**
     * Initiates a new GameCanvas object.
     * 
     */
    public GameCanvas() {
        drawables = new ArrayList<>();
    }

    public abstract void start();
    
    public abstract void stop();

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
     * Method that gets the list of drawable items of this GameCanvas.
     * 
     * @return unmodifiable List of drawables.
     */
    public final List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }

}
