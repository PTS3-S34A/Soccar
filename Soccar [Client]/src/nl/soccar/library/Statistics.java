package nl.soccar.library;

/**
 * Keeps track of all Statistics regarding a Player.
 *
 * @author PTS34A
 */
public class Statistics {

    private final int goals;
    private final int assists;
    private final int gamesWon;
    private final int gamesLost;
    private final int gamesPlayed;

    /**
     * Constructor used for instantiation of a new Statistics object.
     *
     * @param goals Total number of goals, higher/equal than/to 0. scored by a
     * Player.
     * @param assists Total number of assist goals, higher/equal than/to 0,
     * scored by a Player.
     * @param gamesWon Total number of games, higher/equal than/to 0, won a
     * player.
     * @param gamesLost Total number of games, higher/equal than/to 0, lost by a
     * player.
     * @param gamesPlayed Total number of games, higher/equal than/to 0, played
     * by a player.
     */
    public Statistics(int goals, int assists, int gamesWon, int gamesLost, int gamesPlayed) {
        this.goals = goals;
        this.assists = assists;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * Calculates the ratio of won/lost games compared to the total amount of
     * games played. The games ratio is calculated by substracting the lost
     * games from the won games, devided by the total number of played games and
     * multiplied by 100.
     *
     * @return Calculated games ratio, higher/equal than/to 0.
     */
    public double getGamesRatio() {
        return ((double) gamesWon - (double) gamesLost) / (double) gamesPlayed * 100.0D;
    }

    /**
     * Gets the amount of scored goals.
     *
     * @return The total number of goals, higher/equal than/to 0.
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Gets the total amount of assist goals scored by a Player.
     *
     * @return The total number of assist goals, higher/equal than/to 0.
     */
    public int getAssists() {
        return assists;
    }

    /**
     * Gets the total amount of won games by a Player.
     *
     * @return The total number of games that are won, higher/equal than/to 0.
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Gets the total amount of lost games by a Player.
     *
     * @return The total number of games that are lost, higher/equal than/to 0.
     */
    public int getGamesLost() {
        return gamesLost;
    }

    /**
     * Gets the total amount of played games by a Player.
     *
     * @return The total number of games that are played, higher/equal than/to 0.
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

}
