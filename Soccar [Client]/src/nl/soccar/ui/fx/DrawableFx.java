package nl.soccar.ui.fx;

import nl.soccar.ui.Drawable;

/**
 *
 * @author PTS34A
 */
public abstract class DrawableFx<T> implements Drawable {

    private GameCanvasFx canvas;
    private T model;

    public DrawableFx(GameCanvasFx canvas, T model) {
        this.canvas = canvas;
        this.model = model;
    }

    protected GameCanvasFx getCanvas() {
        return canvas;
    }

    @Override
    public final T getModel() {
        return model;
    }

}
