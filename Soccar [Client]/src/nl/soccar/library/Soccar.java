package nl.soccar.library;

/**
 * Class that represents the Soccar model.
 *
 * @author PTS34A
 */
public class Soccar {

    /**
     * Constant string that will be used to print out the application name.
     */
    public static final String APPLICATION_NAME = "Soccar";
    
    private static Soccar instance;
    
    private Player currentPlayer;

    // Constructor that is intentionally set private (Singleton)
    private Soccar() {
    }
    
    /**
     * 
     * @return 
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Method that sets the instance of the Singleton Soccar class.
     *
     * @param player Player that is currently using the game.
     */
    public static void setInstance(Player player) {
        instance = new Soccar();
        instance.currentPlayer = player;
    }

    /**
     * Method that gets the instance of the Singleton Soccar class.
     *
     * @return Instance of the Soccar class.
     */
    public static Soccar getInstance() {
        return instance;
    }
       
}
