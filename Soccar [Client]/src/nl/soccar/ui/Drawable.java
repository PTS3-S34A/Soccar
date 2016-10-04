package nl.soccar.ui;

import javafx.scene.canvas.GraphicsContext;
import nl.soccar.ui.physics.WorldObject;

/**
 *
 * @author PTS34A
 */
public interface Drawable<M, P extends WorldObject> {
    
    void update();
    
    void draw(GraphicsContext context);
    
    M getModel();
    
    P getPhysicsModel();
    
}
