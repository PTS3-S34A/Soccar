package nl.soccar.ui;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author PTS34A
 */
public interface Drawable<M> {
    
    void update();
    
    void draw(GraphicsContext context);
    
    M getModel();
    
}
