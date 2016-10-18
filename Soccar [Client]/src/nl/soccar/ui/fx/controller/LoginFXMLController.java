package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.ui.DisplayConstants;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleGroupCars = new ToggleGroup();

        btnSelectCasualCar.setToggleGroup(toggleGroupCars);
        btnSelectCasualCar.setSelected(true);
        btnSelectSportsCar.setToggleGroup(toggleGroupCars);
        btnSelectPickup.setToggleGroup(toggleGroupCars);

        toggleGroupCars.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            btnSelectCasualCar.setStyle("-fx-border-color: white;");
            btnSelectSportsCar.setStyle("-fx-border-color: white;");
            btnSelectPickup.setStyle("-fx-border-color: white;");
        });
        
        txtFieldName.setOnAction(e -> login());
        btnLogin.setOnAction(e -> login());
    }

    /**
     * Handler for login-button; Uses current selected car, username and
     * optional password.
     */
    private void login() {
        CarType selectedCar = null;
        if (btnSelectCasualCar.isSelected()) {
            selectedCar = CarType.CASUAL;
        } else if (btnSelectPickup.isSelected()) {
            selectedCar = CarType.PICKUP;
        } else if (btnSelectSportsCar.isSelected()) {
            selectedCar = CarType.SPORTSCAR;
        } else {
            btnSelectCasualCar.setStyle("-fx-border-color: red;");
            btnSelectSportsCar.setStyle("-fx-border-color: red;");
            btnSelectPickup.setStyle("-fx-border-color: red;");
            return;
        }

        if (!txtFieldName.getText().isEmpty()) {
            Main.getInstance().login(txtFieldName.getText(), selectedCar);
        } else {
            txtFieldName.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
        }
    }
}
