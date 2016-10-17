package nl.soccar.library;

import nl.soccar.library.enumeration.CarType;

/**
 * A Car is an Entity, placed on a Map, that moves around based on a Player's
 * input.
 *
 * @author PTS34A
 */
public class Car extends Entity {

    private final float width;
    private final float height;

    private int booster;
    private CarType type;
    private final Player player;

    /**
     * Constructor used to instantiate a new Car object. Booster will be set to
     * 0 by default.
     *
     * @param x The X-position of this Car, relative to the Map this Car is
     * placed on.
     * @param y The Y-position of this Car, relative to the Map this Car is
     * placed on.
     * @param degree The angle, in degrees, in which this Car is going in,
     * relative to the Map this Car is placed on.
     * @param width The width of this Car, in JBox2D units.
     * @param height The height of this Car, in JBox2D units.
     * @param type The CarType of this Car. The type determines how this Car
     * will be drawn on the screen.
     * @param player The Player that is driving this Car. The player should not
     * be null.
     */
    public Car(float x, float y, float degree, float width, float height, CarType type, Player player) {
        super(x, y, degree);
        this.width = width;
        this.height = height;
        this.type = type;
        this.player = player;

        booster = 0;
    }

    /**
     * Gets the width of this Car in JBox2D units.
     *
     * @return The width of this Car.
     */
    public float getWidth() {
        return width;
    }

    /**
     * Gets the height of this Car in JBox2D units.
     *
     * @return The height of this Car.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Gets the remaining booster of this Car.
     *
     * @return The remaining booster of this Car, between 0 and 100 inclusive.
     */
    public int getBooster() {
        return booster;
    }

    /**
     * Gets the CarType of this Car.
     *
     * @return The CarType of this Car.
     */
    public CarType getCarType() {
        return type;
    }

    /**
     * Gets the Player that is driving this Car.
     *
     * @return The Player that is driving this Car, not null.
     */
    public Player getPlayer() {
        return player;
    }

}
