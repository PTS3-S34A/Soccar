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
import nl.soccar.library.Soccar;
import nl.soccar.ui.Main;

/**
 * FXML Controller class
 *
 * @author Luuk
 */
public class CreateRoomFXMLController implements Initializable {
    
    @FXML
    private Button btnLogOut;
    @FXML
    private Label lblUsername;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogOut.setOnAction(e -> {
            Main.getInstance().logOut();
        });
        
        lblUsername.setText(Soccar.getInstance().getCurrentPlayer().getUsername()); 
    }    
    
}
