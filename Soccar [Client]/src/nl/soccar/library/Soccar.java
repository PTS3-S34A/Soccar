package nl.soccar.library;

public class Soccar {
    
    private Soccar instance;
    private Player currentPlayer;
    
    private Soccar() { }
    
    public void setInstance(Player player) {
        currentPlayer = player;
    }
    
    public Soccar getInstance() {
        return instance;
    }
    
}
