package nl.soccar.library;

import java.time.LocalTime;
import nl.soccar.library.enumeration.EventType;

/**
 * An Event is added to a Game whenever actions, specified in EventType, are
 * performed. It describes the type of Event, when it occurred and who triggered
 * it.
 *
 * @author PTS34A
 */
public class Event {

    private final EventType type;
    private final LocalTime time;
    private final Player player;

    /**
     * Constructor used to initiate a new Event object.
     *
     * @param type The EventType of this Event.
     * @param time The time at which this Event occurred, not null.
     * @param player The Player that triggered this Event, not null.
     */
    public Event(EventType type, LocalTime time, Player player) {
        this.type = type;
        this.time = time;
        this.player = player;
    }

    /**
     * Gets the EventType of this Event.
     *
     * @return The EventType of this Event.
     */
    public EventType getType() {
        return type;
    }

    /**
     * Gets the time at which this Event occurred.
     *
     * @return The time at which this Event occurred, not null.
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Gets the Player that triggered this Event.
     *
     * @return The Player that triggered this Event, not null.
     */
    public Player getPlayer() {
        return player;
    }

}
