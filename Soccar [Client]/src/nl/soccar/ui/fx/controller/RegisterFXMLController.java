package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import nl.soccar.library.Player;
import nl.soccar.library.Soccar;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.ui.DisplayConstants;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class RegisterFXMLController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldPassword;
    @FXML
    private Label lblWarning;
    @FXML
    private Label lblDescription;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtFieldPassword.setOnAction(e -> login());
        btnLogin.setOnAction(e -> login());
   
        setState();
    }

    /**
     * Handler for login-button; Uses current selected car, username and
     * optional password.
     */
    private void setState() {
        String username = Soccar.getInstance().getCurrentPlayer().getUsername();
        String tempUsername = Soccar.getInstance().getCurrentPlayer().getTempUsername();
        
        if (username.isEmpty() && !tempUsername.isEmpty()) {
            lblWarning.setText(FXMLConstants.WARNING_NEW_USERNAME);
            lblDescription.setText(FXMLConstants.DESCRIPTION_NEW_USERNAME);
            
            txtFieldName.setText(tempUsername);
            
            txtFieldPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            changeButtonState(newValue);
        });
        } else {
            lblWarning.setText(FXMLConstants.WARNING_USERNAME_EXCISTS);
            lblDescription.setText(FXMLConstants.DESCRIPTION_USERNAME_EXCISTS);
            
            txtFieldName.setText(username);
            txtFieldPassword.setPromptText("PASSWORD");
            btnLogin.setText("LOGIN");
        }
    }
    
    private void login() {
        Player player = Soccar.getInstance().getCurrentPlayer();
        player.setUsername(player.getTempUsername());
        Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU);
    }
    
    private void changeButtonState(String newValue) {
        if(newValue.equals("")) {
            btnLogin.setText("GUEST");
        } else {
            btnLogin.setText("REGISTER");
        }
    }
}
