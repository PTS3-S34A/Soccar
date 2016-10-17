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
     * Method thats gets the CarType of this Player.
     *
     * @return Car type of this player, not null.
     */
    public CarType getCarType() {
        return carType;
    }

    /**
     * Method that gets the game statistics of this player.
     *
     * @return Game statistics of this player, not null.
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Method that sets the game Statistics of this player.
     *
     * @param statistics The new game Statistics of this player.
     */
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return username;
    }
}
