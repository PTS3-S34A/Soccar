package nl.soccar.ui.physics.models;

import nl.soccar.library.*;
import nl.soccar.library.enumeration.EventType;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.ui.physics.WorldObject;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

import java.time.LocalDateTime;

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
    public void checkGoalScored() {

        Game game = Soccar.getInstance().getSessionController().getCurrentSession().getGame();
        Player player = Soccar.getInstance().getCurrentPlayer();

        float ballX = ball.getX();

        if (ballX > 156.0F) {
            game.addEvent(new Event(EventType.GOAL_RED, LocalDateTime.now(), player));
            game.setStatus(GameStatus.SCORED);
            System.out.println("GOAL RED");
        } else if (ballX < 4.0F) {
            game.addEvent(new Event(EventType.GOAL_BLUE, LocalDateTime.now(), player));
            game.setStatus(GameStatus.SCORED);
            System.out.println("GOAL BLUE");
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
