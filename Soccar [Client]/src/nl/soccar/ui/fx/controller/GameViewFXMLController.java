package nl.soccar.ui.fx.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import nl.soccar.library.Ball;
import nl.soccar.library.Car;
import nl.soccar.library.Map;
import nl.soccar.library.Player;
import nl.soccar.library.Soccar;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.MapType;
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
    AnchorPane anchorPane;

    @FXML
    Canvas canvas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        float width = (float) screenSize.getWidth();
        float height = (float) screenSize.getHeight();
        // TODO: use the width and height of the users screen.

        anchorPane.setPrefWidth(DisplayConstants.SCREEN_WIDTH);
        anchorPane.setPrefHeight(DisplayConstants.SCREEN_HEIGHT);
        canvas.setWidth(DisplayConstants.SCREEN_WIDTH);
        canvas.setHeight(DisplayConstants.SCREEN_HEIGHT);
        canvas.setFocusTraversable(true);

        /**
         * Instantiate and start the GameCanvasFX object.
         */
        GameCanvasFx game = new GameCanvasFx(canvas.getGraphicsContext2D());
        game.start();

        /**
         * Get the users settings from the 
         */
        Soccar soccar = Soccar.getInstance();
        Player player = soccar.getCurrentPlayer();
        CarType carType = player.getCarType();
        BallType ballType = soccar.getSessionController().getCurrentSession().getGame().getBalltype();

        /**
         * Create the domain models.
         */
        Ball ball = new Ball(DisplayConstants.MAP_WIDTH / 2, DisplayConstants.MAP_HEIGHT / 2, 0, 5, ballType);
        Map map = new Map(new Rectangle(0, 0, DisplayConstants.MAP_WIDTH, DisplayConstants.MAP_HEIGHT), ball);
        Car car = new Car(60, 60, 0, DisplayConstants.CAR_WIDTH, PhysicsUtilities.calculateCarHeight(DisplayConstants.CAR_WIDTH), carType, player);

        map.setMapType(MapType.GRASSLAND); // TODO: set the map type that the user selected in the session view.

        /**
         * Create the Physics models.
         */
        BallPhysics ballPhysics = new BallPhysics(ball, game.getPhysics().getWorld());
        CarPhysics carPhysics = new CarPhysics(car, game.getPhysics().getWorld());

        /**
         * Crate the UiFx models.
         */
        MapUiFx mapUiFx = new MapUiFx(game, map);
        BallUiFx ballUiFx = new BallUiFx(game, ball, ballPhysics);
        CarUiFx carUiFx = new CarUiFx(game, car, carPhysics);

        /**
         * Add drawables to the game in the correct drawing order.
         */
        game.addDrawable(mapUiFx);
        mapUiFx.addWalls();
        game.addDrawable(ballUiFx);
        game.addDrawable(carUiFx);
    }

}
