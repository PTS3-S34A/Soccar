package nl.soccar.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nl.soccar.library.enumeration.TeamColour;

public class Team {

    private TeamColour colour;
    private List<Player> players;

    public Team(TeamColour colour) {
        this.colour = colour;
        players = new ArrayList<>();
    }

    public void join(Player player) {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void leave(Player player) {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TeamColour getTeamColour() {
        return colour;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
    
}
