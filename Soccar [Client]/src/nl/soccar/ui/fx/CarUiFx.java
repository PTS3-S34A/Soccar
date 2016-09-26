package nl.soccar.ui.fx;

import javafx.scene.canvas.GraphicsContext;
import nl.soccar.library.Car;
import nl.soccar.ui.Drawable;

/**
 *
 * @author PTS34A
 */
public class CarUiFx extends DrawableFx<Car> {

    public CarUiFx(GameCanvasFx canvas, Car car) {
        super(canvas, car);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(GraphicsContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
