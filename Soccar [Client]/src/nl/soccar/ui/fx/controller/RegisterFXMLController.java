package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import nl.soccar.library.Soccar;
import nl.soccar.rmi.RmiController;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class RegisterFXMLController implements Initializable {

    @FXML
    private Button btnLoginRegister;
    @FXML
    private Button btnCancel;
    @FXML
    private PasswordField txtFieldPassword;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblUsernameDescription;

    private RmiController rmiController;
    private String username;
    private boolean userExists;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rmiController = RmiController.getInstance();
        txtFieldPassword.setOnAction(e -> loginOrRegister());
        btnLoginRegister.setOnAction(e -> loginOrRegister());
        btnCancel.setOnAction(e -> Main.getInstance().setScene(FXMLConstants.LOCATION_LOGIN));
        
        setState();
    }

    private void checkUsername() {
        userExists = false;
    }

    /**
     * Handler for loginOrRegister-button; Uses current selected car, username
     * and optional password.
     */
    private void setState() {
        username = Soccar.getInstance().getCurrentPlayer().getUsername();
        userExists = rmiController.checkIfExists(username);
        if (userExists) {
            lblUsername.setText(username);
            lblUsernameDescription.setText(FXMLConstants.WARNING_USERNAME_EXISTS);
            btnLoginRegister.setText(FXMLConstants.BUTTON_USERNAME_EXISTS);
        } else {
            lblUsername.setText(username);
            lblUsernameDescription.setText(FXMLConstants.WARNING_NEW_USERNAME);
            btnLoginRegister.setText(FXMLConstants.BUTTON_NEW_USERNAME);
        }
    }

    private void loginOrRegister() {
        String password = txtFieldPassword.getText();

        if (!checkInput(password)) {
            return;
        }

        if (userExists && rmiController.checkPassword(username, password)) {
            System.out.println("hoi");
            Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU);
        } else {
            clearInput();
        }

        if (!userExists && rmiController.add(username, password)) {
            Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU);
        } else {
            clearInput();
        }
    }

    private boolean checkInput(String password) {
        if (!password.isEmpty()) {
            return true;
        }
        txtFieldPassword.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
        return false;
    }

    private void clearInput() {
        txtFieldPassword.clear();
        txtFieldPassword.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
    }

}
