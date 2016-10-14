package nl.soccar.ui.fx;

import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;
import nl.soccar.ui.Drawable;
import nl.soccar.ui.GameCanvas;
import nl.soccar.ui.input.Keyboard;
import nl.soccar.ui.physics.PhysicsContants;

/**
 * This class is an extension to the GameCanvas class, it provides a way to run the game loop using JavaFX classes.
 * 
 * @author PTS34A
 */
public class GameCanvasFx extends GameCanvas {

    private GraphicsContext context;
    private Timeline gameTimer;

    /**
     * Initiates a new GameCanvasFx object using the given parameters.
     * 
     * @param context The context which can be used by Drawables to actually draw on a Canvas.
     */
    public GameCanvasFx(GraphicsContext context) {
        this.context = context;

        gameTimer = new Timeline();
        gameTimer.setCycleCount(Timeline.INDEFINITE);
        gameTimer.getKeyFrames().add(new KeyFrame(Duration.seconds(1.0F / PhysicsContants.FPS), e -> {
            super.getPhysics().step();
            update();
            render();
        }));

        Canvas canvas = context.getCanvas();
        canvas.setOnKeyPressed(e -> Keyboard.setKeyPressed(e.getCode()));
        canvas.setOnKeyReleased(e -> Keyboard.setKeyReleased(e.getCode()));
    }

    @Override
    public void start() {
        gameTimer.playFromStart();
    }

    @Override
    public void stop() {
        gameTimer.stop();
    }

    private void update() {
        List<Drawable> drawables = super.getDrawables();
        drawables.stream().forEach(d -> d.update());
    }

    private void render() {
        clear();

        List<Drawable> drawables = super.getDrawables();
        drawables.stream().forEach(d -> d.draw(context));
    }

    private void clear() {
        Canvas canvas = context.getCanvas();
        context.clearRect(0D, 0D, canvas.getWidth(), canvas.getHeight());
    }

}
