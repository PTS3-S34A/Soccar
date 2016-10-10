package nl.soccar.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class that represents the SessionController model.
 *
 * @author PTS34A
 */
public class SessionController {

    private static Random rnd;

    private Session currentSession;

    private List<Session> allSessions;

    /**
     * Constructor used for instantiation of a SessionController object.
     *
     */
    public SessionController() {
        allSessions = new ArrayList<>();
        rnd = new Random();
    }

    /**
     * Method that creates a session.
     *
     * @param name Name of the room that is nested inside this session.
     * @param password Password of the room that is nested inside this session.
     * @param player Player that creates the session.
     * @return Session that was created.
     */
    public Session create(String name, String password, Player player) {
        Session session = new Session(name, password);
        allSessions.add(session);

        join(session, password, player);
        return session;
    }

    /**
     * Method that adds a player to a session.
     *
     * @param s Session that the player wants to join.
     * @param password Password of the room that is nested inside this session.
     * @param player Player that needs to be added to this session.
     * @return Session that was joined.
     */
    public Session join(Session s, String password, Player player) {
        Room room = s.getRoom();
        if (room.getAllPlayers().size() >= room.getCapacity()) {
            // TODO implementatie foutmelding
            return null;
        }
        if (!room.check(password)) {
            // TODO implementatie foutmelding
            return null;
        }

        Team teamBlue = room.getTeamBlue();
        Team teamRed = room.getTeamRed();

        List<Player> teamRedPlayers = teamRed.getPlayers();
        List<Player> teamBluePlayers = teamBlue.getPlayers();

        int bluePlayers = teamBluePlayers.size();
        int redPlayers = teamRedPlayers.size();

        if (bluePlayers < redPlayers || (bluePlayers == redPlayers && (rnd.nextInt(2) + 1 == 1))) {
            teamBlue.join(player);
        } else {
            teamRed.join(player);
        }

        return s;
    }

    /**
     * Method that removes a player from a session.
     *
     * @param session Session from where the player needs to be removed.
     * @param player Player that needs to be removed from this session.
     */
    public void leave(Session session, Player player) {
        Room room = session.getRoom();

        room.getTeamBlue().leave(player);
        room.getTeamRed().leave(player);

        Soccar.getInstance().getSessionController().setCurrentSession(null);
    }

    /**
     * Method that gets a list of all sessions.
     *
     * @return List of all sessions.
     */
    public List<Session> getAllSessions() {
        return Collections.unmodifiableList(allSessions);
    }

    /**
     * Method that gets a observable list of all rooms.
     *
     * @return Observablelist of all rooms.
     */
    public ObservableList<Room> getAllRooms() {
        ObservableList<Room> roomList = FXCollections.observableArrayList();
        allSessions.forEach(s -> roomList.add(s.getRoom()));
        return roomList;
    }

    /**
     * Method that gets the current session
     *
     * @return the current session the player is in.
     */
    public Session getCurrentSession() {
        return currentSession;
    }

    /**
     * Method that sets the current Session.
     *
     * @param currentSession Current session the current player is in.
     */
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

}
