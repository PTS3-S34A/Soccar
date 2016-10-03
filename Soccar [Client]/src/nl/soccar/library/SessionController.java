package nl.soccar.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Method that removes a player from a session.
     * 
     * @param session Session from where the player needs to be removed.
     * @param player Player that needs to be removed from this session.
     */
    public void leave(Session session, Player player) {
        // TODO implementatie
        throw new UnsupportedOperationException("Not supported yet.");
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
        for(Session s : allSessions) {
            roomList.add(s.getRoom());
        }
        return roomList;
        //return Collections.unmodifiableList(allSessions);
    }

}
