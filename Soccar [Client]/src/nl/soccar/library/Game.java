package nl.soccar.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.GameStatus;

/**
 * A Game contains all kind of information about a Match.
 * 
 * @author PTS34A
 */
public class Game {

    private Optional<LocalDateTime> startTime;
    private Duration duration;
    private BallType balltype;
    private GameStatus status;

    private List<Event> events;
    
    /**
     * Initiates a new Game Object.
     */
    public Game() {
        startTime = Optional.empty();
        status = GameStatus.STOPPED;
        events = new ArrayList<>();
    }

    /**
     * Starts this Game.
     */
    public void start() {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Ends this Game.
     */
    public void stop() {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Adds an Event to this Game.
     * 
     * @param event The Event that occurred in this Game.
     */
    public void addEvent(Event event) {
        events.add(event);
    }
    
    /**
     * Gets all Events that occurred in this Game.
     * 
     * @return A List of Events that occurred in this Game.
     */
    public List<Event> getEvents() {
        return Collections.unmodifiableList(events);
    }

    /**
     * Gets the time at which this Game started, if there's no current match on going, the Optional will be empty.
     * 
     * @return An Optional that contains the start time of the current match.
     */
    public Optional<LocalDateTime> getStartTime() {
        return startTime;
    }

    /**
     * Gets the status of this Game.
     * 
     * @return The status of this Game.
     */
    public GameStatus getStatus() {
        return status;
    }

    /**
     * Gets the Duration of this Game.
     * 
     * @return The Duration of this Game.
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
     * Gets the BallType that should be used for this Game.
     * 
     * @return The BallType that should be used for this Game.
     */
    public BallType getBalltype() {
        return balltype;
    }

    /**
     * Sets the new BallType that should be used for this Game.
     * 
     * @param balltype The new BallType that should be used for this Game.
     */
    public void setBalltype(BallType balltype) {
        this.balltype = balltype;
    }

}
