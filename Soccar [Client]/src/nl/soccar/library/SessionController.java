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

    private Session currentSession;

    private List<Session> allSessions;

    /**
     * Constructor used for instantiation of a SessionController object.
     *
     */
    public SessionController() {
        allSessions = new ArrayList<>();
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

        join(name, password, player);
        return session;
    }

    /**
     * Method that adds a player to a session.
     *
     * @param name Name of the room that is nested inside this session.
     * @param password Password of the room that is nested inside this session.
     * @param player Player that needs to be added to this session.
     * @return Session that was joined.
     */
    public Session join(String name, String password, Player player) {
        for (Session s : allSessions) {
            if (s.getRoom().getName().equals(name) && s.getRoom().check(password)) {
                if (s.getRoom().getTeamRed().getPlayers().size() > s.getRoom().getTeamBlue().getPlayers().size()) {
                    s.getRoom().getTeamBlue().join(player);
                } else if (s.getRoom().getTeamRed().getPlayers().size() < s.getRoom().getTeamBlue().getPlayers().size()) {
                    s.getRoom().getTeamRed().join(player);
                } else {
                    Random rnd = new Random();
                    int random = rnd.nextInt(2) + 1;

                    if (random == 1) {
                        s.getRoom().getTeamBlue().join(player);
                    } else {
                        s.getRoom().getTeamRed().join(player);
                    }
                }
                return s;
            }
        }
        return null;
    }

    /**
     * Method that removes a player from a session.
     *
     * @param session Session from where the player needs to be removed.
     * @param player Player that needs to be removed from this session.
     */
    public void leave(Session session, Player player) {
        session.getRoom().getTeamBlue().leave(player);
        session.getRoom().getTeamRed().leave(player);
    }

    /**
     * Method that gets a list of all sessions.
     *
     * @return List of all sessions.
     */
    public List<Session> getAllSessions() {
        return Collections.unmodifiableList(allSessions);
    }

    public ObservableList<Room> getAllRooms() {
        ObservableList<Room> roomList = FXCollections.observableArrayList();
        for (Session s : allSessions) {
            roomList.add(s.getRoom());
        }
        return roomList;
        //return Collections.unmodifiableList(allSessions);
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
