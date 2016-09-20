package nl.soccar.library;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import nl.soccar.library.enumeration.MapType;

public class Map {
    
    private Rectangle size;
    private Rectangle goalBlue;
    private Rectangle goalRed;
    private MapType type;
    
    private List<Car> cars;
    private Ball ball;

    public Map(Rectangle size, Rectangle goalBlue, Rectangle goalRed) {
        this.size = size;
        this.goalBlue = goalBlue;
        this.goalRed = goalRed;
        type = MapType.GRASSLAND;
        
        cars = new ArrayList<>();
    }
    
    public void addCar(Car car) {
        cars.add(car);
    }
    
    public Car getCarFromPlayer(Player player) {
        return cars.stream().filter(c -> c.getPlayer().equals(player)).findFirst().get();
    }

    public Rectangle getSize() {
        return size;
    }

    public Rectangle getGoalBlue() {
        return goalBlue;
    }

    public Rectangle getGoalRed() {
        return goalRed;
    }

    public MapType getMapType() {
        return type;
    }

    public void setMapType(MapType type) {
        this.type = type;
    }
    
}
