package nl.soccar.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nl.soccar.library.enumeration.TeamColour;

/**
 * A Team is an object containts up to three Players. A Team is identified by
 * its colour.
 *
 * @author PTS34A
 */
public class Team {

    private final TeamColour colour;
    private List<Player> players;

    /**
     * Constructor used for instantiation of a Team object. While initializing,
     * the collection of player is also initialized.
     *
     * @param colour The colour of the Team.
     */
    public Team(TeamColour colour) {
        this.colour = colour;
        players = new ArrayList<>();
    }

    /**
     * Adds a Player to this Team.
     *
     * @param player The Player that needs to be added to this Team.
     */
    public void join(Player player) {
        players.add(player);
    }

    /**
     * Removes a Player from this Team.
     *
     * @param player The Player that needs to be removed to this Team.
     */
    public void leave(Player player) {
        players.remove(player);
    }

    /**
     * Gets the colour of this Team.
     *
     * @return The colour of this Team, not null.
     */
    public TeamColour getTeamColour() {
        return colour;
    }

    /**
     * Gets all players of this Team.
     *
     * @return An unmodifiable List of Players of this Team, not null.
     */
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

}
