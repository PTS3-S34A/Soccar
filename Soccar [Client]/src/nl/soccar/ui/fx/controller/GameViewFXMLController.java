package nl.soccar.ui.fx.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import nl.soccar.library.Ball;
import nl.soccar.library.Car;
import nl.soccar.library.Map;
import nl.soccar.library.Player;
import nl.soccar.library.Session;
import nl.soccar.library.Soccar;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.fx.GameCanvasFx;
import nl.soccar.ui.fx.models.BallUiFx;
import nl.soccar.ui.fx.models.CarUiFx;
import nl.soccar.ui.fx.models.MapUiFx;
import nl.soccar.ui.physics.models.BallPhysics;
import nl.soccar.ui.physics.models.CarPhysics;
import nl.soccar.util.PhysicsUtilities;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class GameViewFXMLController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        float width = (float) dimension.getWidth();
        float height = (float) dimension.getHeight();

        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
        canvas.setWidth(width);
        canvas.setHeight(height);
        canvas.setFocusTraversable(true);

        GameCanvasFx gameCanvas = new GameCanvasFx(canvas.getGraphicsContext2D());
        gameCanvas.start();

        Session session = Soccar.getInstance().getSessionController().getCurrentSession();
        initializeMap(session, gameCanvas);
        initializeBall(session, gameCanvas);
        initializeCar(gameCanvas);
    }

    private void initializeMap(Session session, GameCanvasFx gameCanvas) {
        Map map = session.getGame().getMap();
        MapUiFx mapUiFx = new MapUiFx(gameCanvas, map);

        gameCanvas.addDrawable(mapUiFx);
        mapUiFx.addWalls();
    }

    private void initializeBall(Session session, GameCanvasFx gameCanvas) {
        Ball ball = session.getGame().getMap().getBall();
        BallPhysics ballPhysics = new BallPhysics(ball, gameCanvas.getPhysics().getWorld());
        BallUiFx ballUiFx = new BallUiFx(gameCanvas, ball, ballPhysics);

        gameCanvas.addDrawable(ballUiFx);
    }

    private void initializeCar(GameCanvasFx gameCanvas) {
        Player player = Soccar.getInstance().getCurrentPlayer();

        Car car = new Car(60.0F, 60.0F, 0.0F, DisplayConstants.CAR_WIDTH, PhysicsUtilities.calculateCarHeight(DisplayConstants.CAR_WIDTH), player.getCarType(), player);
        CarPhysics carPhysics = new CarPhysics(car, gameCanvas.getPhysics().getWorld());
        CarUiFx carUiFx = new CarUiFx(gameCanvas, car, carPhysics);

        gameCanvas.addDrawable(carUiFx);
    }

}
