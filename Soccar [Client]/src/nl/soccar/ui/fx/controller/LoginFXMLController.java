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
    private TextField txtFieldName;
    @FXML
    private ToggleButton btnSelectCasualCar;
    @FXML
    private ToggleButton btnSelectPickup;
    @FXML
    private ToggleButton btnSelectSportsCar;
    
    private ToggleGroup toggleGroupCars;
    
    /**
     * Initialization of this controller class on current scene; Events get handled.
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        toggleGroupCars  = new ToggleGroup();
        
        btnSelectPickup.setToggleGroup(toggleGroupCars);
        btnSelectCasualCar.setToggleGroup(toggleGroupCars);
        btnSelectSportsCar.setToggleGroup(toggleGroupCars);
        
        btnSelectCasualCar.setSelected(true);
        btnLogin.setOnAction(e -> {
            login();
        });
        
        
    }

    /**
     * Handler for login-button; Uses current selected car, username and optional password.
     */
    public void login() {
        CarType selectedCar = CarType.CASUAL;
        if (btnSelectCasualCar.isSelected()) {
            selectedCar = CarType.CASUAL;
        } else if (btnSelectPickup.isSelected()) {
            selectedCar = CarType.PICKUP;
        } else if (btnSelectSportsCar.isSelected()) {
            selectedCar = CarType.SPORTSCAR;
        }
        
        if (!txtFieldName.getText().isEmpty()) {
            Main.getInstance().login(txtFieldName.getText(), selectedCar);
        } else {
            txtFieldName.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
        }
    }
}
