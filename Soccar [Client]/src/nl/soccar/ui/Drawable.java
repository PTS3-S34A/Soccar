package nl.soccar.ui;

import javafx.scene.canvas.GraphicsContext;

/**
 * A Drawable is an Object that can be drawn on the screen. It keeps up with a
 * model. The model represents an object which is connected to this Drawable,
 * such as a Car.
 *
 * @author PTS34A
 * @param <M> The model connected to this Drawable.
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
     * Gets the model assosciated with this Drawable.
     *
     * @return This model, may be null if none specified.
     */
    M getModel();

    /**
     * Gets the GameCanvas on which this drawable is placed.
     *
     * @return The GameCanvas, not null, on which this drawable is placed.
     */
    GameCanvas getCanvas();

}
