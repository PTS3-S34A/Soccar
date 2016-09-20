package nl.soccar.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.GameStatus;

public class Game {

    private LocalDateTime startTime;
    private Duration duration;
    private BallType balltype;
    private GameStatus status;

    private List<Event> events;

    public Game() {
        status = GameStatus.STOPPED;
        events = new ArrayList<>();
    }

    public void start() {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stop() {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addEvent(Event event) {
        events.add(event);
    }
    
    public List<Event> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public BallType getBalltype() {
        return balltype;
    }

    public void setBalltype(BallType balltype) {
        this.balltype = balltype;
    }

}
