package nl.soccar.ui;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author PTS34A
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
