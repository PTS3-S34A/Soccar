package nl.soccar.ui;

import javafx.scene.canvas.GraphicsContext;

/**
 * A Drawable is an Object that can be drawn on the screen. It keeps up with a model.
 * The model represents an Object which is connected to this Drawable, such as a Car.
 * 
 * @author PTS34A 
 * @param <M> The model connected to this Drawable.
 */
public interface Drawable<M> {
    
    /**
     * Method that updates the position of this Drawable object.
     */
    void update();
    
    /**
     * Method that draws this Drawable object on the graphics context.
     * 
     * @param context The drawable graphics context.
     */
    void draw(GraphicsContext context);
    
    /**
     * Method that returns this model.
     * 
     * @return This model.
     */
    M getModel();
    
    /**
     * Method that returns the game canvas on which this drawable is placed.
     * 
     * @return The game canvas.
     */
    GameCanvas getCanvas();
    
}
