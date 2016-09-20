package nl.soccar.library;

public class Session {

    private Game game;
    
    public Session(String name, String password) {
        game = new Game();
    }

    public Game getGame() {
        return game;
    }
    
}
