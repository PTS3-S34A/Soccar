package nl.soccar.library;

import nl.soccar.library.enumeration.Privilege;
import nl.soccar.library.enumeration.CarType;

/**
 * Class that represents the Player model.
 * 
 * @author PTS34A
 */
public class Player {
    
    private final String username;
    private final String password;
    private final Privilege privilege;
    private final CarType carType;
    private Statistics statistics;

    /**
     * Constructor used for instantiation of a Player object.
     * 
     * @param username Username of the player.
     * @param password Password of the player.
     * @param privilege Privilege of the player that is used to maintain system rights.
     * @param carType Car type of the player.
     */
    public Player(String username, String password, Privilege privilege, CarType carType) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.carType = carType;
    }

    /**
     * Method that gets the username of the player.
     * 
     * @return Username of the player.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method that gets the privilege of the player.
     * 
     * @return Privilege of the player that is used to maintain system rights.
     */
    public Privilege getPrivilege() {
        return privilege;
    }

    /**
     * Method thats gets the cartype of the player.
     * 
     * @return Car type of the player.
     */
    public CarType getCarType() {
        return carType;
    }

    /**
     * Method that gets the game statistics of the player.
     * 
     * @return Game statistics of the player.
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Method that sets the game statistics of the player.
     * 
     * @param statistics Game statistics of the player.
     */
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
    
}
