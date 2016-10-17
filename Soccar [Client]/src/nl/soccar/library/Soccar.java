package nl.soccar.library;

/**
 * Soccar is a Singleton class that serves as container for the
 * SessionsController and the current Player. It also grants access to all
 * underlying classes.
 *
 * @author PTS34A
 */
public class Soccar {

    private static Soccar instance;

    private Player currentPlayer;

    private SessionController sessionController;

    private Soccar() {
        /**
         * Constructor is intentionally set private, so that this Singleton
         * class can never be initialized.
         */
    }

    /**
     * Gets the current Player.
     *
     * @return The current Player, not null.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets the SessionController.
     *
     * @return The SessionController, not null.
     */
    public SessionController getSessionController() {
        return sessionController;
    }

    /**
     * Sets the instance of the Singleton Soccar class. The SessionController is
     * created and the Player is set based on the Player that is passed as an
     * argument.
     *
     * @param player The Player that is currently using the game.
     */
    public static void setInstance(Player player) {
        instance = new Soccar();
        instance.sessionController = new SessionController();
        instance.currentPlayer = player;
    }

    /**
     * Gets the instance of the Singleton Soccar class.
     *
     * @return The Singleton instance of the Soccar class.
     */
    public static Soccar getInstance() {
        return instance;
    }

}
