package nl.soccar.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PTS34A
 */
public abstract class GameCanvas {

    private final List<Drawable> drawables;

    public GameCanvas() {
        drawables = new ArrayList<>();
    }

    public abstract void start();
    
    public abstract void stop();

    public final void addDrawable(Drawable drawable) {
        drawables.add(drawable);
    }

    public final void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }

    public final List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }

}
