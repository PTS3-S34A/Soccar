package nl.soccar.library;

import nl.soccar.library.enumeration.CarType;

public class Car extends Entity {

    private int booster;
    private CarType type;    
    private Player player;

    public Car(double x, double y, double degree, CarType type, Player player) {
        super(x, y, degree);
        this.type = type;        
        this.player = player;
    }
        
    @Override
    public void move(double x, double y, double degree) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getBooster() {
        return booster;
    }

    public CarType getType() {
        return type;
    }

    public Player getPlayer() {
        return player;
    }
    
}
