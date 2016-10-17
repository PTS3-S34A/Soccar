package nl.soccar.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import nl.soccar.exception.DuplicateValueException;
import nl.soccar.exception.ExceptionConstants;
import nl.soccar.exception.InvalidCredentialException;
import nl.soccar.exception.RoomException;
import nl.soccar.exception.UIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A SessionController keeps track of all Sessions and provides methods for
 * creating and joining/leaving Sessions.
 *
 * @author PTS34A
 */
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);
    private static final Random RANDOM = new Random();

    private Optional<Session> currentSession;
    private final List<Session> sessions;

    /**
     * Constructor used to initiate a new SessionController object. It
     * initializes all sessions, by default there are no sessions until
     * retrieved from the network.
     */
    public SessionController() {
        currentSession = Optional.empty();
        sessions = new ArrayList<>();
    }

    /**
     * Creates a new Session with the given parameters.
     *
     * @param name Name, not null & not empty, of the room that is nested inside
     * this session.
     * @param password Password, not null, of the Room that is nested inside
     * this session.
     * @param player Player, not null, that creates the session.
     * @return The Session, not null, that was created.
     * @throws nl.soccar.exception.DuplicateValueException When the given
     * roomname has already been used (ignoring capital characters).
     */
    public Session create(String name, String password, Player player) throws DuplicateValueException {
        if (sessions.stream().map(s -> s.getRoom().getName()).anyMatch(name::equalsIgnoreCase)) {
            throw new DuplicateValueException(ExceptionConstants.DUPLICATE_ROOM_TITLE, ExceptionConstants.DUPLICATE_ROOM_MESSAGE);
        }

        Session session = new Session(name, password);
        sessions.add(session);

        try {
            join(session, password, player);
        } catch (UIException e) {
            // Should never happen: password is always equal, room is never full.
            LOGGER.error("An error occurred while joining a session", e);
        }
        return session;
    }

    /**
     * Adds a Player to a Session given that there is space in the specified
     * Session, and that the given password is equal to the password of the Room
     * nested in the Session.
     *
     * @param session The Session, not null, that the Player wants to join.
     * @param password The password, not null, of the Room that is nested inside
     * this session.
     * @param player The Player, not null, that needs to be added to this
     * session.
     * @return The Session, not null, that was joined.
     * @throws nl.soccar.exception.InvalidCredentialException When the given
     * password is not correct.
     * @throws nl.soccar.exception.RoomException When there is no capacity left
     * in the room for the Player to join.
     */
    public Session join(Session session, String password, Player player) throws UIException {
        Room room = session.getRoom();
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

        return session;
    }

    /**
     * Removes the given Player from the given Session.
     *
     * @param session The Session, not null, from where the Player needs to be
     * removed.
     * @param player The Player, not null, that needs to be removed from this
     * Session.
     */
    public void leave(Session session, Player player) {
        Room room = session.getRoom();

        room.getTeamBlue().leave(player);
        room.getTeamRed().leave(player);

        Soccar.getInstance().getSessionController().setCurrentSession(null);
    }

    /**
     * Gets all Session that this SessionController currently keeps track of.
     *
     * @return A List, not null, of all Sessions.
     */
    public List<Session> getAllSessions() {
        return Collections.unmodifiableList(sessions);
    }

    /**
     * Gets the Session that is currently joined by the Player that launched the
     * application.
     *
     * @return The Session, may be null to indicate that there's no current
     * Session., that is currently joined.
     */
    public Optional<Session> getCurrentSession() {
        return currentSession;
    }

    /**
     * Sets the current Session that is joined by the player that launched the
     * application.
     *
     * @param session The current session, may be null to indicate there's no
     * joined Session, the current player is in.
     */
    public void setCurrentSession(Session session) {
        currentSession = Optional.of(session);
    }

}
