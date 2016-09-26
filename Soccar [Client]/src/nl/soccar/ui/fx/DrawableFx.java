package nl.soccar.ui.fx;

import nl.soccar.ui.Drawable;

/**
 *
 * @author PTS34A
 */
public abstract class DrawableFx<T> implements Drawable {
    
    private GameCanvasFx canvas;
    private T type;
    
    public DrawableFx(GameCanvasFx canvas, T type) {
        this.canvas = canvas;
        this.type = type;
    }
    
    protected GameCanvasFx getCanvas() {
        return canvas;
    }
    
    protected T getType() {
        return type;
    }
    
}
