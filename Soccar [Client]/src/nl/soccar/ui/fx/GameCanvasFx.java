package nl.soccar.ui.fx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import nl.soccar.library.Game;
import nl.soccar.library.Notification;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.Drawable;
import nl.soccar.ui.GameCanvas;
import nl.soccar.ui.fx.models.NotificationUiFx;
import nl.soccar.ui.input.Keyboard;
import nl.soccar.physics.PhysicsContants;
import nl.soccar.physics.WorldObject;

import java.util.List;

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
    public GameCanvasFx(Game game, GraphicsContext context) {
        super(game);

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
        getGame().setStatus(GameStatus.RUNNING);
        gameTimer.playFromStart();
    }

    @Override
    public void stop() {
        gameTimer.stop();
    }

    /**
     * Updates each WorldObject by calling their step method.
     */
    private void update() {

        List<WorldObject> worldObjects = super.getWorldObjects();
        GameStatus status = getGame().getStatus();

        if (status == GameStatus.RUNNING) {
            worldObjects.forEach(WorldObject::step);
        }

        if (status == GameStatus.SCORED) {
            worldObjects.forEach(WorldObject::reset);
            getGame().setStatus(GameStatus.RUNNING);

            // TODO: Refactor...
            String text = getGame().getLastBallTouched().getUsername() + " SCORED!";
            Notification n = new Notification(
                    DisplayConstants.MAP_WIDTH / 2,
                    DisplayConstants.MAP_HEIGHT / 2, 0,
                    text, Font.font("Arial", FontWeight.BOLD, 80), Color.WHITE, Color.BLACK);

            NotificationUiFx nFx = new NotificationUiFx(this, n);
            addDrawable(nFx);
        }
    }

    /**
     * Clears the canvas and renders a frame by drawing all Drawable items.
     */
    private void render() {
        clear();

        List<Drawable> drawables = super.getDrawables();
        drawables.forEach(d -> d.draw(context));
    }

    /**
     * Clears the canvas completely.
     */
    private void clear() {
        Canvas canvas = context.getCanvas();
        context.clearRect(0D, 0D, canvas.getWidth(), canvas.getHeight());
    }

}
