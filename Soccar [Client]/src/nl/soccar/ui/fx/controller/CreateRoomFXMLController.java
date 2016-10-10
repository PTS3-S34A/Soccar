package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import nl.soccar.library.Session;
import nl.soccar.library.Soccar;
import nl.soccar.library.enumeration.MapType;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class CreateRoomFXMLController implements Initializable {

    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnCreateRoom;
    @FXML
    private Label lblUsername;
    @FXML
    private TextField textFieldRoomName;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private Slider sliderCapacity;
    @FXML
    private ComboBox cbMap;

    /**
     * Initialization of this controller class on current scene; Events get
     * handled.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogOut.setOnAction(e -> Main.getInstance().logOut());
        btnCancel.setOnAction(e -> Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU));
        btnCreateRoom.setOnAction(e -> {
            if (!textFieldRoomName.getText().isEmpty()) {
                createRoom();
            } else {
                textFieldRoomName.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
            }
        });

        lblUsername.setText(Soccar.getInstance().getCurrentPlayer().getUsername());

        ObservableList<MapType> list = cbMap.getItems();
        list.addAll(MapType.values());

        cbMap.setValue(MapType.GRASSLAND);
    }

    /**
     * Event-handler for CreatRoom button; Uses password, roomname, capacity and
     * map-type.
     */
    public void createRoom() {
        String password = "";

        if (!textFieldPassword.getText().isEmpty()) {
            password = textFieldPassword.getText();
        }

        Session newSession;
        try {
            newSession = Soccar.getInstance().getSessionController().create(textFieldRoomName.getText(), password, Soccar.getInstance().getCurrentPlayer());
            newSession.getRoom().setCapacity((int) sliderCapacity.getValue());
            Soccar.getInstance().getSessionController().setCurrentSession(newSession);
            Main.getInstance().setScene(FXMLConstants.LOCATION_SESSION_VIEW);
            
        } catch (DuplicateValueException e) {
            e.printStackTrace(System.err);
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle(e.getTitle());
            alert.setHeaderText(e.getTitle());
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }  
    }
    
}
