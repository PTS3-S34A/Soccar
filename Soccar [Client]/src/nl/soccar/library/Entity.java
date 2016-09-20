package nl.soccar.library;

public abstract class Entity {
    
    protected double x;
    protected double y;
    protected double degree;
    protected double velocity;

    public Entity(double x, double y, double degree) {
        this.x = x;
        this.y = y;
        this.degree = degree;
        velocity = 0;
    }
    
    public abstract void move(double x, double y, double degree);

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final double getDegree() {
        return degree;
    }

    public final double getVelocity() {
        return velocity;
    }

}
