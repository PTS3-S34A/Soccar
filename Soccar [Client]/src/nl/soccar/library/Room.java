package nl.soccar.library;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private int capacity;
    private String password;

    private Team teamRed;
    private Team teamBlue;

    public Room(String name, int capacity, String password) {
        this.name = name;
        this.capacity = capacity;
        this.password = password;
    }

    public boolean check(String password) {
        return password.equals(this.password);
    }

    public Player getHost() {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Team getTeamRed() {
        return teamRed;
    }

    public Team getTeamBlue() {
        return teamBlue;
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.addAll(teamRed.getPlayers());
        players.addAll(teamBlue.getPlayers());
        
        return players;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
