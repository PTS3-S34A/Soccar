package nl.soccar.library;

/**
 * Class that represents the Session model.
 * 
 * @author PTS34A
 */
public class Session {

    private final Game game;
    private final Room room;
    
    /**
     * Constructor used for instantiation of a Session object.
     * 
     * @param name Name of the room that is nested inside this session.
     * @param password Password of the room that is nested inside this session.
     */
    public Session(String name, String password) {
        game = new Game();
        room = new Room(name, password);
    }

    /**
     * Method that gets the game.
     * 
     * @return Game that is nested in this session.
     */
    public Game getGame() {
        return game;
    }
    
    /**
     * Method that gets the room.
     * 
     * @return Room that is nested in this session.
     */
    public Room getRoom() {
        return room;
    }
    
}
