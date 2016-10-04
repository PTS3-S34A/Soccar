package nl.soccar.ui.fx;

import nl.soccar.ui.Drawable;

/**
 *
 * @author PTS34A
 */
public abstract class DrawableFx<M> implements Drawable {

    private GameCanvasFx canvas;
    private M model;

<<<<<<< HEAD
    public DrawableFx(GameCanvasFx canvas, M model) {
=======
    /**
     * Initiates a new DrawableFx object.
     * 
     * @param canvas The drawable context of this DrawableFx.
     * @param model  The used model of this DrawableFx.
     */
    public DrawableFx(GameCanvasFx canvas, T model) {
>>>>>>> refs/remotes/origin/master
        this.canvas = canvas;
        this.model = model;
    }

    /**
     * Method that returns the canvas of this DrawableFx.
     * 
     * @return The canvas of this DrawableFx.
     */
    protected GameCanvasFx getCanvas() {
        return canvas;
    }

    /**
     * Method that returns the used model in this DrawableFx.
     * 
     * @return The model.
     */
    @Override
    public final M getModel() {
        return model;
    }
}
