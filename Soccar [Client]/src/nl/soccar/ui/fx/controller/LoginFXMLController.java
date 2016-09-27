package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.ui.Main;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtfieldName;
    @FXML
    private ToggleButton btnSelectCasualCar;
    @FXML
    private ToggleButton btnSelectPickup;
    @FXML
    private ToggleButton btnSelectSportsCar;
    
    private final ToggleGroup TOGGLE_GROUP = new ToggleGroup();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.setOnAction(e -> {
            login();
        });
        
        btnSelectPickup.setToggleGroup(TOGGLE_GROUP);
        btnSelectCasualCar.setToggleGroup(TOGGLE_GROUP);
        btnSelectSportsCar.setToggleGroup(TOGGLE_GROUP);
        
        btnSelectCasualCar.setSelected(true);
    }

    public void login() {
        CarType selectedCar = CarType.CASUAL;
        if (btnSelectCasualCar.isSelected()) {
            selectedCar = CarType.CASUAL;
        } else if (btnSelectPickup.isSelected()) {
            selectedCar = CarType.PICKUP;
        } else if (btnSelectSportsCar.isSelected()) {
            selectedCar = CarType.SPORTSCAR;
        }
        
        if (!txtfieldName.getText().isEmpty()) {
            Main.getInstance().login(txtfieldName.getText(), selectedCar);
        } else {
            txtfieldName.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
        }
    }
}
