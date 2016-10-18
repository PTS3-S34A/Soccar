package nl.soccar.ui.fx;

import nl.soccar.physics.WorldObject;

/**
 * This class is an extension on top of the regular Fx Drawable. On top of the regular implementation
 * It also provides a model for a physics-object. For example a Car needs to be tracked by the World.
 * 
 * @author PTS34A
 * @param <M> The model that is connected to this Drawable.
 * @param <P> The physics-model that is connected to this Drawable.
 */
public abstract class PhysicsDrawableFx<M, P extends WorldObject> extends DrawableFx<M> {

    private P physicsModel;

    /**
     * Initiates a new PhysicsDrawableFx
     * 
     * @param canvas The canvas on which this Drawable is placed.
     * @param model The model of this Drawable.
     * @param physicsModel The physics-model of this Drawable.
     */
    public PhysicsDrawableFx(GameCanvasFx canvas, M model, P physicsModel) {
        super(canvas, model);
        this.physicsModel = physicsModel;
    }
    
    /**
     * Gets the physics-model which this Drawable tracks.
     * 
     * @return The physics-model of this Drawable.
     */
    public final P getPhysicsModel() {
        return physicsModel;
    }

}
