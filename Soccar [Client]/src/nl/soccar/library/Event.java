package nl.soccar.library;

import java.time.LocalDateTime;
import nl.soccar.library.enumeration.EventType;

/**
 * An Event is something that occurs in a Game. This includes, but is not limited to: scoring a goal, making an assist.
 * 
 * @author PTS34A
 */
public class Event {
    
    private EventType type;
    private LocalDateTime time;
    private Player player;

    /**
     * Initiates a new Event Object.
     * 
     * @param type The type of this Event.
     * @param time The time at which this Event occurred.
     * @param player The Player that executed this Event.
     */
    public Event(EventType type, LocalDateTime time, Player player) {
        this.type = type;
        this.time = time;
        this.player = player;
    }

    /**
     * Gets the type of this Event.
     * 
     * @return The type of this Event.
     */
    public EventType getType() {
        return type;
    }

    /**
     * Gets the time at which this Event occurred.
     * 
     * @return The time at which this Event occurred.
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Gets the Player that executed this Event.
     * 
     * @return The Player that executed this Event.
     */
    public Player getPlayer() {
        return player;
    }
    
}
