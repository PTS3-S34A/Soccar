/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import nl.soccar.library.Session;
import nl.soccar.library.SessionController;
import nl.soccar.library.Soccar;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;

/**
 * FXML Controller class
 *
 * @author Luuk
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
    private TextField textFieldPassword; 
    @FXML
    private Slider sliderCapacity;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogOut.setOnAction(e -> {
            Main.getInstance().logOut();
        });
        btnCancel.setOnAction(e -> {
            Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU);
        });
        btnCreateRoom.setOnAction(e -> {
           if (!textFieldRoomName.getText().isEmpty()) {
               createRoom();
           } else {
               textFieldRoomName.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
           }
        });
        
        lblUsername.setText(Soccar.getInstance().getCurrentPlayer().getUsername()); 
    }    
    
    public void createRoom() {
        String password = null;
         
        if (!textFieldPassword.getText().isEmpty()) {
            password = textFieldPassword.getText();
        }
        
        Session newSession = Soccar.getInstance().getSessionController().create(textFieldRoomName.getText(), password, Soccar.getInstance().getCurrentPlayer());
        newSession.getRoom().setCapacity((int)sliderCapacity.getValue());
    }
}
