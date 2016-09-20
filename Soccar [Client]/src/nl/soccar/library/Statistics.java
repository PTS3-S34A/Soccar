package nl.soccar.library;

public class Statistics {
    
    private final int goals;
    private final int assists;
    private final int gamesWon;
    private final int gamesLost;
    private final int gamesPlayed;

    public Statistics(int goals, int assists, int gamesWon, int gamesLost, int gamesPlayed) {
        this.goals = goals;
        this.assists = assists;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.gamesPlayed = gamesPlayed;
    }
    
    public double getGamesRatio() {
        return (gamesWon - gamesLost) / gamesPlayed * 100.0;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
    
}
