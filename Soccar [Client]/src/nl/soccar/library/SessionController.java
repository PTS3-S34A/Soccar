package nl.soccar.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nl.soccar.exception.DuplicateValueException;
import nl.soccar.exception.ExceptionConstants;
import nl.soccar.exception.InvalidCredentialException;
import nl.soccar.exception.RoomException;
import nl.soccar.exception.UIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that represents the SessionController model.
 *
 * @author PTS34A
 */
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);
    private static final Random RANDOM = new Random();

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
     * @throws nl.soccar.exception.DuplicateValueException When Roomname has already been used.
     */
    public Session create(String name, String password, Player player) throws DuplicateValueException {
        for (Session s : allSessions) {
            if (s.getRoom().getName().equals(name)) {
                throw new DuplicateValueException(ExceptionConstants.DUPLICATE_ROOM_TITLE, ExceptionConstants.DUPLICATE_ROOM_MESSAGE);
            }
        }

        Session session = new Session(name, password);
        allSessions.add(session);

        try {
            join(session, password, player);
        } catch (UIException e) {
            // Should never happen: password is always equal, room is never full.
            LOGGER.error("An error occurred while joining a session", e);
        }
        return session;
    }

    /**
     * Method that adds a player to a session.
     *
     * @param s Session that the player wants to join.
     * @param password Password of the room that is nested inside this session.
     * @param player Player that needs to be added to this session.
     * @return Session that was joined.
     * @throws nl.soccar.exception.InvalidCredentialException When Password is not correct.
     * @throws nl.soccar.exception.RoomException When Room capacity is smaller then current playercount.
     */
    public Session join(Session s, String password, Player player) throws UIException {
        Room room = s.getRoom();
        if (room.getOccupancy() >= room.getCapacity()) {
            throw new RoomException(ExceptionConstants.ROOM_FULL_TITLE, ExceptionConstants.ROOM_FULL_MESSAGE);
        }
        if (!room.check(password)) {
            throw new InvalidCredentialException(ExceptionConstants.WRONG_PASSWORD_TITLE, ExceptionConstants.WRONG_PASSWORD_MESSAGE);
        }

        Team teamBlue = room.getTeamBlue();
        Team teamRed = room.getTeamRed();

        List<Player> teamRedPlayers = teamRed.getPlayers();
        List<Player> teamBluePlayers = teamBlue.getPlayers();

        int bluePlayers = teamBluePlayers.size();
        int redPlayers = teamRedPlayers.size();

        if (bluePlayers < redPlayers || (bluePlayers == redPlayers && (RANDOM.nextInt(2) + 1 == 1))) {
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
        allSessions.stream().map(s -> s.getRoom()).forEach(roomList::add);
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
