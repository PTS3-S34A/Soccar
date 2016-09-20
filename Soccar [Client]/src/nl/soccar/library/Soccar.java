package nl.soccar.library;

/**
 * Class that represents the Soccar model.
 * 
 * @author PTS34A
 */
public class Soccar {
    
    private Soccar instance;
    private Player currentPlayer;
    
    // Constructor that is intentionally set private (Singleton)
    private Soccar() { }
    
    /**
     * Method that sets the instance of the Singleton Soccar class.
     * 
     * @param player Player that is currently using the game.
     */
    public void setInstance(Player player) {
        currentPlayer = player;
    }
    
    /**
     * Method that gets the instance of the Singleton Soccar class.
     * 
     * @return Instance of the Soccar class.
     */
    public Soccar getInstance() {
        return instance;
    }
    
}
