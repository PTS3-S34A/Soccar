package nl.soccar.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private Button btnSelectSportscar;
    @FXML
    private Button btnSelectPickup;
    @FXML
    private Button btnSelectCasual;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtfieldName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.setOnAction(e -> {
            login();
        });
    }

    public void login() {
        if (!txtfieldName.getText().isEmpty()) {
            Main.getInstance().login(txtfieldName.getText());
        } else {
            txtfieldName.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
        }
    }
}
