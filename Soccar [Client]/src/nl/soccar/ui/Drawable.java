package nl.soccar.ui;

import javafx.scene.canvas.GraphicsContext;

/**
 * A Drawable is an Object that can be drawn on the screen. It keeps up with a
 * model. The model represents an object which is connected to this Drawable,
 * such as a Car.
 *
 * @author PTS34A
 * @param <M> The model connected to this Drawable.
 * @author PTS34A
 */
public interface Drawable<M> {

    /**
     * Draws this Drawable object on the graphics context that is passed as an
     * argument.
     *
     * @param context The drawable graphics context.
     */
    void draw(GraphicsContext context);

    /**
     * Returns this model.
     *
     * @return This model.
     */
    M getModel();

    /**
     * Returns the game canvas on which this drawable is placed.
     *
     * @return The game canvas.
     */
    GameCanvas getCanvas();

}
