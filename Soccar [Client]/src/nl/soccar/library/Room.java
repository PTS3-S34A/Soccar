package nl.soccar.library;

import java.util.ArrayList;
import java.util.List;
import nl.soccar.library.enumeration.TeamColour;

/**
 * A Room is a place where Players come together before they start a Game. A
 * Room contains two Teams and defines how many players can actually join.
 * Lastly it may contain a password that Players must specify before joining.
 *
 * @author PTS34A
 */
public class Room {

    private static final int DEFAULT_CAPACITY = 6;

    private final String name;
    private final String password;
    private int capacity;

    private final Team teamRed;
    private final Team teamBlue;

    /**
     * Constructor used for instantiation of a Room object.
     *
     * @param name Name, not null, for the initiatabe room.
     * @param password The password, empty if none given, for this Room.
     */
    public Room(String name, String password) {
        this.name = name;
        this.password = password;
        capacity = DEFAULT_CAPACITY;

        teamBlue = new Team(TeamColour.BLUE);
        teamRed = new Team(TeamColour.RED);
    }

    /**
     * Checks if the password of the Room is equal to the password that is
     * passed in as argument.
     *
     * @param password The password, not null, that will be checked for
     * equality.
     * @return boolean True if, and only if, the given password is equal to the
     * password specified in this Room.
     */
    public boolean check(String password) {
        return this.password.equals(password);
    }

    /**
     * Gets the host of this Room. The host is the first player that entered
     * this Room.
     *
     * @return Player The Player, not null, who is host, and thus entered this
     * Room first.
     */
    public Player getHost() {
        Player player = null;
        List<Player> allPlayers = getAllPlayers();

        if (!allPlayers.isEmpty()) {
            player = allPlayers.get(0);
        }

        return player;
    }

    /**
     * Gets the red Team.
     *
     * @return Team The red Team, not null.
     */
    public Team getTeamRed() {
        return teamRed;
    }

    /**
     * Gets the blue Team.
     *
     * @return Team The blue Team, not null.
     */
    public Team getTeamBlue() {
        return teamBlue;
    }

    /**
     * Gets all players from both Teams.
     *
     * @return A List, not null, of all players, built by adding all Players
     * from the red and blue Team to one List.
     */
    public List<Player> getAllPlayers() {
        // TODO fix actual order of players in the List.

        List<Player> players = new ArrayList<>();
        players.addAll(teamRed.getPlayers());
        players.addAll(teamBlue.getPlayers());

        return players;
    }

    /**
     * Gets the name of this Room.
     *
     * @return The name of this Room, not null.
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates the amount of players that are currently in this room.
     *
     * @return The amount, between 0 and 6 inclusive, of Players currently in
     * this Room.
     */
    public int getOccupancy() {
        return teamRed.getPlayers().size() + teamBlue.getPlayers().size();
    }

    /**
     * Gets the maximum capacity of this Room.
     *
     * @return The capacity, 2, 4 or 6, of this Room.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the maximum capacity of this Room. The maximum capacity should
     * always be even, higher/equal than/to 0 and lower/equal than/to 6.
     *
     * @param capacity Capicity, capacity >= 0 && capacity <= 6 && capacity % 2
     * == 0, that needs to be set for this room.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Checks whether a password is available by checking if the password isn't
     * empty.
     *
     * @return True if, and only if, the password is not empty.
     */
    public boolean passwordAvailable() {
        return !password.isEmpty();
    }
}
