package nl.soccar.library;

/**
 * Class that represents the Statistics model.
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
     * Constructor used for instantiation of a SessionController object.
     * 
     * @param goals Total number of goals scored by a player.
     * @param assists Total number of assist goals scored by a player.
     * @param gamesWon Total number of games won a player.
     * @param gamesLost Total number of games lost by a player.
     * @param gamesPlayed Total number of games played by a player.
     */
    public Statistics(int goals, int assists, int gamesWon, int gamesLost, int gamesPlayed) {
        this.goals = goals;
        this.assists = assists;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.gamesPlayed = gamesPlayed;
    }
    
    /**
     * Calculated method that gets games ratio.
     * The games ratio is calculated by substracting the lost games from the won games, 
     * devided by the total number of played games and multiplied by 100.
     * 
     * @return Calculated games ratio.
     */
    public double getGamesRatio() {
        return ((double) gamesWon - (double) gamesLost) / (double) gamesPlayed * 100.0D;
    }

    /**
     * Method that gets the total number of goals scored by a player.
     * 
     * @return The total number of goals.
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Method that gets the total number of assist goals scored by a player.
     * 
     * @return The total number of assist goals.
     */
    public int getAssists() {
        return assists;
    }

    /**
     * Method that gets the total numbers of games that are won by a player.
     * 
     * @return The total number of games that are won.
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Method that gets the total number of games that are lost by a player.
     * 
     * @return The total number of games that are lost.
     */
    public int getGamesLost() {
        return gamesLost;
    }

    /**
     * Method that gets the total number games that are played by a player.
     * 
     * @return The total number of games that are played.
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    
}
