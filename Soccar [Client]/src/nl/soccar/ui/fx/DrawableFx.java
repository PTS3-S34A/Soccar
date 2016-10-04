package nl.soccar.ui.fx;

import nl.soccar.ui.Drawable;
import nl.soccar.ui.physics.WorldObject;

/**
 *
 * @author PTS34A
 */
public abstract class DrawableFx<M, P extends WorldObject> implements Drawable {

    private GameCanvasFx canvas;
    private M model;
    private P physicsModel;

    public DrawableFx(GameCanvasFx canvas, M model, P physicsModel) {
        this.canvas = canvas;
        this.model = model;
        this.physicsModel = physicsModel;
    }

    protected GameCanvasFx getCanvas() {
        return canvas;
    }

    @Override
    public final M getModel() {
        return model;
    }
    
    @Override
    public final P getPhysicsModel() {
        return physicsModel;
    }

}
