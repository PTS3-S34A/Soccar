package nl.soccar.ui.physics.models;

import javafx.scene.shape.Rectangle;
import nl.soccar.library.*;
import nl.soccar.library.enumeration.EventType;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.physics.WorldObject;
import nl.soccar.util.MapUtilities;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * BallPhysics is a physics-model that keeps track of the physics of the Ball.
 *
 * @author PTS34A
 */
public class BallPhysics implements WorldObject {

    private static final float DENSITY = 0.01F;
    private static final float FRICTION = 1.0F;
    private static final float RESTITUTION = 0.8F;

    private static final float LINEAR_DAMPING = 1.0F;
    private static final float ANGULAR_DAMPING = 1.0F;

    private final Vec2 originalPos;

    private final Body body;
    private final float radius;
    private Ball ball;

    /**
     * Initiates a new BallPhysics Object using the given parameter.
     *
     * @param ball  The ball model to keep track of.
     * @param world The world in which this model is placed.
     */
    public BallPhysics(Ball ball, World world) {
        this.ball = ball;
        originalPos = new Vec2(ball.getX(), ball.getY());
        radius = ball.getRadius();

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(originalPos);
        bd.linearDamping = LINEAR_DAMPING;
        bd.angularDamping = ANGULAR_DAMPING;

        CircleShape cs = new CircleShape();
        cs.m_radius = radius;

        FixtureDef fd = new FixtureDef();
        fd.density = DENSITY;
        fd.friction = FRICTION;
        fd.restitution = RESTITUTION;
        fd.shape = cs;
        fd.userData = ball;

        body = world.createBody(bd);
        body.createFixture(fd);
    }

    @Override
    public void step() {
        ball.move(getX(), getY(), getDegree());
        checkGoalScored();
    }

    @Override
    public void reset() {
        body.setLinearVelocity(new Vec2(0.0F, 0.0F));
        body.setAngularVelocity(0.0F);
        body.setTransform(originalPos, 0.0F);
    }

    /**
     * Checks if the ball passes by the goal line.
     * When it does, it adds an event to the Game object and sets the GameStatus to SCORED.
     */
    private void checkGoalScored() {
        Game game = Soccar.getInstance().getSessionController().getCurrentSession().get().getGame();
        Player player = Soccar.getInstance().getCurrentPlayer();

        float ballX = ball.getX();
        Rectangle leftGoal = MapUtilities.getLeftGoal();
        Rectangle rightGoal = MapUtilities.getRightGoal();

        if (ballX > rightGoal.getX() + DisplayConstants.BALL_RADIUS) {
            game.addEvent(new Event(EventType.GOAL_RED, LocalTime.now(), player));
            game.setStatus(GameStatus.SCORED);
        } else if (ballX < leftGoal.getX() + leftGoal.getWidth() - DisplayConstants.BALL_RADIUS) {
            game.addEvent(new Event(EventType.GOAL_BLUE, LocalTime.now(), player));
            game.setStatus(GameStatus.SCORED);
        }
    }

    @Override
    public float getX() {
        return body.getPosition().x;
    }

    @Override
    public float getY() {
        return body.getPosition().y;
    }

    @Override
    public float getDegree() {
        return (float) Math.toDegrees(body.getAngle());
    }

}
