package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import nl.soccar.exception.DuplicateValueException;
import nl.soccar.library.Game;
import nl.soccar.library.Map;
import nl.soccar.library.Player;
import nl.soccar.library.Session;
import nl.soccar.library.SessionController;
import nl.soccar.library.Soccar;
import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.MapType;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class CreateRoomFXMLController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateRoomFXMLController.class);

    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnCreateRoom;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblCar;
    @FXML
    private TextField textFieldRoomName;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private Slider sliderCapacity;
    @FXML
    private ComboBox cbMap;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogOut.setOnAction(e -> Main.getInstance().logOut());
        btnCancel.setOnAction(e -> Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU));
        btnCreateRoom.setOnAction(e -> {
            if (!textFieldRoomName.getText().isEmpty()) {
                createRoom();
            } else {
                textFieldRoomName.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
            }
        });

        Player player = Soccar.getInstance().getCurrentPlayer();
        lblUsername.setText(player.getUsername());
        lblCar.setText(player.getCarType().toString());
        textFieldRoomName.setOnAction(e -> createRoom());

        ObservableList<MapType> list = cbMap.getItems();
        list.addAll(MapType.values());

        cbMap.setValue(MapType.GRASSLAND);
    }

    /**
     * Event-handler for CreatRoom button; Uses password, roomname, capacity and
     * map-type.
     */
    private void createRoom() {
        String password = "";

        if (!textFieldPassword.getText().isEmpty()) {
            password = textFieldPassword.getText();
        }

        Session session;
        try {
            Soccar soccar = Soccar.getInstance();
            SessionController controller = soccar.getSessionController();

            session = controller.create(textFieldRoomName.getText(), password, soccar.getCurrentPlayer());
            session.getRoom().setCapacity((int) sliderCapacity.getValue());

            Game game = session.getGame();
            game.setDuration(Duration.MINUTES_3); // TODO implement manual selection duration.

            Map map = game.getMap();
            map.setMapType((MapType) cbMap.getValue());
            map.getBall().setBallType(BallType.FOOTBALL); // TODO implement manual selection ball.

            controller.setCurrentSession(session);
            Main.getInstance().setScene(FXMLConstants.LOCATION_SESSION_VIEW);
        } catch (DuplicateValueException e) {
            LOGGER.error("An error occurred while creating a room.", e);

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle(e.getTitle());
            alert.setHeaderText(e.getTitle());
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

}
