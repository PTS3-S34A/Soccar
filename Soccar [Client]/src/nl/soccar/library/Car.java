package nl.soccar.library;

import nl.soccar.library.enumeration.CarType;

/**
 * A Car, on a Map, is an Entity that moves around.
 * 
 * @author PTS34A
 */
public class Car extends Entity {

    private int booster;
    private CarType type;    
    private Player player;

    /**
     * Initiates a new Car Object.
     * 
     * @param x The x-position of this Car.
     * @param y The y-position of this Car.
     * @param degree The degree which this Car is going in.
     * @param type The type of this Car.
     * @param player The Player that is driving this Car.
     */
    public Car(double x, double y, double degree, CarType type, Player player) {
        super(x, y, degree);
        this.type = type;        
        this.player = player;
    }
        
    @Override
    public void move(double x, double y, double degree) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Gets the remaining booster of this Car.
     * 
     * @return The remaining booster of this Car.
     */
    public int getBooster() {
        return booster;
    }

    /**
     * Gets the type of this Car.
     * 
     * @return The type of this Car.
     */
    public CarType getType() {
        return type;
    }

    /**
     * Gets the Player that is driving this Car.
     * 
     * @return The Player that is driving this Car.
     */
    public Player getPlayer() {
        return player;
    }
    
}
