package nl.soccar.library;

import javafx.scene.shape.Rectangle;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.ui.DisplayConstants;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import nl.soccar.library.enumeration.EventType;

/**
 * A Game is an object which contains information about a match, like the
 * duration, the GameStatus and the BallType. It also containts a collection of
 * Events that are triggered in the match.
 *
 * @author PTS34A
 */
public class Game {

    private final Map map;
    private Player lastBallTouched;

    private Optional<LocalTime> startTime;
    private GameStatus status;
    private int duration; // Duration in seconds

    private final List<Event> events;

    /**
     * Constructor used to instantiate a new Game object. While initializing
     * this Game, a new Ball is created and the Map is set with the default
     * constant values. The startTime is set to empty, the GameStatus is set to
     * stopped and the events list is initiated.
     */
    public Game() {
        Ball ball = new Ball(DisplayConstants.MAP_WIDTH / 2, DisplayConstants.MAP_HEIGHT / 2, 0.0F, DisplayConstants.BALL_RADIUS, BallType.FOOTBALL);
        map = new Map(new Rectangle(0, 0, DisplayConstants.MAP_WIDTH, DisplayConstants.MAP_HEIGHT), ball);

        startTime = Optional.empty();
        status = GameStatus.STOPPED;
        events = new ArrayList<>();
    }

    /**
     * Starts this Game.
     */
    public void start() {
        status = GameStatus.RUNNING;
        startTime = Optional.of(LocalTime.now());
    }

    /**
     * Ends this Game.
     */
    public void stop() {
        status = GameStatus.STOPPED;
    }

    /**
     * Gets the time at which this Game started. If there's no current match on
     * going, the Optional will be empty.
     *
     * @return An optional that contains the start time of the current match,
     * not null.
     */
    public Optional<LocalTime> getStartTime() {
        return startTime;
    }

    /**
     * Gets the GameStatus of this Game.
     *
     * @return The GameStatus of this Game, not null.
     */
    public GameStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of this Game.
     *
     * @param status The status to be set.
     */
    public void setStatus(GameStatus status) {
        this.status = status;
    }

    /**
     * Gets the time remaining for the current game.
     *
     * @return
     */
    public long getTimeLeft() {
        long diff = ChronoUnit.SECONDS.between(startTime.get(), LocalTime.now());
        return duration - diff;
    }

    /**
     * Gets the Duration of this Game.
     *
     * @return The Duration of this Game, not null.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the Duration of this Game.
     *
     * @param duration The new Duration of this Game.
     */
    public void setDuration(Duration duration) {
        switch (duration) {
            case MINUTES_3:
                this.duration = 180;
                break;
            case MINUTES_5:
                this.duration = 300;
                break;
            case MINUTES_10:
                this.duration = 600;
                break;
            default:
                //exception
                break;
        }
    }

    /**
     * Gets all Events that occurred in this Game.
     *
     * @return A collection of Events that occurred in this Game, not null.
     */
    public List<Event> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public int getScore(EventType type) {
        int score = 0;

        for (Event e : events) {
            if (e.getType().equals(type)) {
                score++;
            }
        }
        return score;
    }

    /**
     * Adds an Event to this Game.
     *
     * @param event The Event that was triggered during this Game.
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    public Map getMap() {
        return map;
    }

    /**
     * Gets the last player who touched the ball.
     *
     * @return
     */
    public Player getLastBallTouched() {
        return lastBallTouched;
    }

    /**
     * Sets the last player who touched the ball.
     *
     * @param lastBallTouched
     */
    public void setLastBallTouched(Player lastBallTouched) {
        this.lastBallTouched = lastBallTouched;
    }
}
