package nl.soccar.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author PTS34A
 */
public class GamePanel {
    
    private GraphicsContext context;
    
    private List<Drawable> drawables;
    
    public GamePanel(GraphicsContext context) {
        this.context = context;
        
        drawables = new ArrayList<>();
    }
    
    private void clear() {
        Canvas canvas = context.getCanvas();
        
        context.clearRect(0D, 0D, canvas.getWidth(), canvas.getHeight());
    }
    
    public void render() {
        clear();
        drawables.stream().forEach(d -> d.draw(context));
    }
    
    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }
    
}
