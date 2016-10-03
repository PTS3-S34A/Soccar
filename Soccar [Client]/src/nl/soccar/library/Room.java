package nl.soccar.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents the Room model.
 *
 * @author PTS34A
 */
public class Room {

    private static final int DEFAULT_CAPACITY = 6;

    private String name;
    private String password;
    private int capacity;

    private Team teamRed;
    private Team teamBlue;

    /**
     * Constructor used for instantiation of a Room object.
     *
     * @param name
     * @param password
     */
    public Room(String name, String password) {
        this.name = name;
        this.password = password;
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Method that checks if the password of the room is equal to the password
     * that is passed in as argument.
     *
     * @param password Password that needs to be checked for equality.
     * @return
     */
    public boolean check(String password) {
        return password.equals(this.password);
    }

    /**
     * Method that gets the player that is the host of this room.
     *
     * @return Player that is the host of the room.
     */
    public Player getHost() {
        Player hostPlayer = getAllPlayers().get(0);
        if (hostPlayer == null) {
            //TODO No host available.
            return null;
        } else {
            return getAllPlayers().get(0);
        }
    }

    /**
     * Method that gets team red.
     *
     * @return Team red.
     */
    public Team getTeamRed() {
        return teamRed;
    }

    /**
     * Method that gets team blue.
     *
     * @return Team blue.
     */
    public Team getTeamBlue() {
        return teamBlue;
    }

    /**
     * Method that gets a list of all players from both teams.
     *
     * @return A list of players from both teams.
     */
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.addAll(teamRed.getPlayers());
        players.addAll(teamBlue.getPlayers());

        return players;
    }

    /**
     * Method that gets the name of this room.
     *
     * @return Name of this room.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that gets the capicity of this room.
     *
     * @return Capicity of this room.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Method that sets the capicity of this room.
     *
     * @param capacity Capicity that needs to be set for this room.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
