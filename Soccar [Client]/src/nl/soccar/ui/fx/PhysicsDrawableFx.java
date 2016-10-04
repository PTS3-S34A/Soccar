package nl.soccar.ui.fx;

import nl.soccar.ui.physics.WorldObject;

/**
 *
 * @author PTS34A
 */
public abstract class PhysicsDrawableFx<M, P extends WorldObject> extends DrawableFx<M> {

    private P physicsModel;

    public PhysicsDrawableFx(GameCanvasFx canvas, M model, P physicsModel) {
        super(canvas, model);
        this.physicsModel = physicsModel;
    }
    
    public final P getPhysicsModel() {
        return physicsModel;
    }

}
