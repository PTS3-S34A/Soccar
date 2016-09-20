package nl.soccar.library;

import java.time.LocalDateTime;
import nl.soccar.library.enumeration.EventType;

public class Event {
    
    private EventType type;
    private LocalDateTime time;
    private Player player;

    public Event(EventType type, LocalDateTime time, Player player) {
        this.type = type;
        this.time = time;
        this.player = player;
    }

    public EventType getType() {
        return type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Player getPlayer() {
        return player;
    }
    
}
