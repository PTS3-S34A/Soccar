package nl.soccar.library;

import nl.soccar.library.enumeration.BallType;

public class Ball extends Entity {

    private final BallType type;

    public Ball(double x, double y, double degree, BallType type) {
        super(x, y, degree);
        this.type = type;
    }
    
    @Override
    public void move(double x, double y, double degree) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BallType getType() {
        return type;
    }
    
}
