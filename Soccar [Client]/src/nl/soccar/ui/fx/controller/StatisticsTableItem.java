package nl.soccar.ui.fx.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import nl.soccar.library.Statistics;

/**
 * A table-item represents one single row inside a (JavaFX) TableView.
 *
 * @author PTS34A
 */
public class StatisticsTableItem {

    private final SimpleStringProperty username;
    private final SimpleIntegerProperty goals;
    private final SimpleIntegerProperty assists;
    private final SimpleStringProperty ratio;
    private final SimpleIntegerProperty gamesWon;
    private final SimpleIntegerProperty gamesEven;
    private final SimpleIntegerProperty gamesLost;

    private final Statistics s;

    /**
     * Initiates a new StatisticsTableItem using the given session.
     *
     * @param s The statistics of which values will be retreived from.
     */
    public StatisticsTableItem(Statistics s) {
        this.s = s;

        username = new SimpleStringProperty(s.getUsername());
        goals = new SimpleIntegerProperty(s.getGoals());
        assists = new SimpleIntegerProperty(s.getAssists());
        ratio = new SimpleStringProperty(String.format("%.1f", s.getGamesRatio()));
        gamesWon = new SimpleIntegerProperty(s.getGamesWon());
        gamesEven = new SimpleIntegerProperty(s.getGamesPlayed() - s.getGamesWon() - s.getGamesLost());
        gamesLost = new SimpleIntegerProperty(s.getGamesLost());
    }

    public String getUsername() {
        return username.get();
    }

    public Integer getGoals() {
        return goals.get();
    }

    public Integer getAssists() {
        return assists.get();
    }

    public String getRatio() {
        return ratio.get();
    }

    public Integer getGamesWon() {
        return gamesWon.get();
    }

    public Integer getGamesEven() {
        return gamesEven.get();
    }

    public Integer getGamesLost() {
        return gamesLost.get();
    }

}
