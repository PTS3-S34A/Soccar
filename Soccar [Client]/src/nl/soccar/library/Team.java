package nl.soccar.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nl.soccar.library.enumeration.TeamColour;

/**
 * Class that represents the Team model.
 * 
 * @author PTS34A
 */
public class Team {

    private TeamColour colour;
    private List<Player> players;

    /**
     * Constructor used for instantiation of a Team object.
     * 
     * @param colour Colour of the team that is beging instantiated.
     */
    public Team(TeamColour colour) {
        this.colour = colour;
        players = new ArrayList<>();
    }

    /**
     * Method that adds a player to this team.
     * 
     * @param player Player that needs to be added to this team.
     */
    public void join(Player player) {
        players.add(player);
    }

    /**
     * Method that removes a player from this team.
     * 
     * @param player Player that needs to be removed to this team.
     */
    public void leave(Player player) {
        players.remove(player);
    }

    /**
     * Method that gets the colour of this team.
     * 
     * @return Colour of this team.
     */
    public TeamColour getTeamColour() {
        return colour;
    }

    /**
     * Method that gets the list of players of this team.
     * 
     * @return List of players of this team.
     */
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
    
}
