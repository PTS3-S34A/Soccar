package nl.soccar.library;

/**
 * A Session is a container object that contains a Game and a Room.
 *
 * @author PTS34A
 */
public class Session {

    private final Game game;
    private final Room room;

    /**
     * Constructor used for instantiation of a Session object. While
     * initializing, the Game and Room objects are created.
     *
     * @param name Name of the Room that is nested inside this Session.
     * @param password Password of the Room that is nested inside this Session.
     */
    public Session(String name, String password) {
        game = new Game();
        room = new Room(name, password);
    }

    /**
     * Method that gets the Game.
     *
     * @return The Game that is nested in this Session, not null.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Method that gets the Room.
     *
     * @return The Room that is nested in this Session, not null.
     */
    public Room getRoom() {
        return room;
    }

}
