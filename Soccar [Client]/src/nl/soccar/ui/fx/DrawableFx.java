package nl.soccar.ui.fx;

import nl.soccar.ui.Drawable;

/**
 *
 * @author PTS34A
 */
public abstract class DrawableFx<M> implements Drawable {

    private GameCanvasFx canvas;
    private M model;

    public DrawableFx(GameCanvasFx canvas, M model) {
        this.canvas = canvas;
        this.model = model;
    }

    protected GameCanvasFx getCanvas() {
        return canvas;
    }

    @Override
    public final M getModel() {
        return model;
    }
}
