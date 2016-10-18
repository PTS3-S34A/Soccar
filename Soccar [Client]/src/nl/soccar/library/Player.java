package nl.soccar.library;

import nl.soccar.library.enumeration.Privilege;
import nl.soccar.library.enumeration.CarType;

/**
 * A Player is an object which contains information about the user that is
 * playing the game.
 *
 * @author PTS34A
 */
public class Player {

    private final String username;
    private final Privilege privilege;
    private final CarType carType;
    private Statistics statistics;

    /**
     * Constructor used for instantiation of a Player object.
     *
     * @param username The username of this player that will visible for all
     * other players of the game.
     * @param privilege The Privilege of this player that is used to maintain
     * system rights.
     * @param carType The CarType of this player that determines the aesthetics
     * of the car.
     */
    public Player(String username, Privilege privilege, CarType carType) {
        this.username = username;
        this.privilege = privilege;
        this.carType = carType;
    }

    /**
     * Gets the username of this player.
     *
     * @return The username of this player, not null.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the privilege of this player.
     *
     * @return The Privilege of this player that is used to maintain system
     * rights, not null.
     */
    public Privilege getPrivilege() {
        return privilege;
    }

    /**
     * Gets the CarType of this Player.
     *
     * @return Car type of this player, not null.
     */
    public CarType getCarType() {
        return carType;
    }

    /**
     * Gets the Game Statistics of this Player.
     *
     * @return Game Statistics of this Player, not null.
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Sets the Game Statistics of this player.
     *
     * @param statistics The new Game Statistics of this Player.
     */
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return username;
    }
}
