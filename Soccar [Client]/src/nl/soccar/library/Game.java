package nl.soccar.library;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javafx.scene.shape.Rectangle;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.ui.DisplayConstants;

/**
 * A Game is an object which contains information about a match, like the
 * duration, the GameStatus and the BallType. It also containts a collection of
 * Events that are triggered in the match.
 *
 * @author PTS34A
 */
public class Game {

    private final Map map;

    private Optional<LocalTime> startTime;
    private GameStatus status;
    private Duration duration;

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
        // TODO implementation
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Ends this Game.
     */
    public void stop() {
        // TODO implementation
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Gets the Map of this Game.
     *
     * @return The Map of this Game, not null.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Gets the time at which this Game started. If there's no current match on
     * going, the Optional will be empty.
     *
     * @return An optional that contains the start time of the current match, not null.
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
     * Gets the Duration of this Game.
     *
     * @return The Duration of this Game, not null.
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the Duration of this Game.
     *
     * @param duration The new Duration of this Game.
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * Gets all Events that occurred in this Game.
     *
     * @return A collection of Events that occurred in this Game, not null.
     */
    public List<Event> getEvents() {
        return Collections.unmodifiableList(events);
    }

    /**
     * Adds an Event to this Game.
     *
     * @param event The Event that was triggered during this Game.
     */
    public void addEvent(Event event) {
        events.add(event);
    }

}
