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

/**
 *
 * @author PTS34A
 */
public class GameCanvasFx extends GameCanvas {

    private GraphicsContext context;
    private Timeline gameTimer;

    public GameCanvasFx(GraphicsContext context) {
        this.context = context;

        gameTimer = new Timeline();
        gameTimer.setCycleCount(Timeline.INDEFINITE);
        gameTimer.getKeyFrames().add(new KeyFrame(Duration.seconds(1F / 60F), e -> {
            //TODO add jBox2D world update

            update();
            render();
        }));

        Canvas canvas = context.getCanvas();
        canvas.setOnKeyPressed(e -> {
            Keyboard.getInstance().setKeyPressed(e.getCode());
        });

        canvas.setOnKeyReleased(e -> {
            Keyboard.getInstance().setKeyReleased(e.getCode());
        });
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
