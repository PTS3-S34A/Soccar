package nl.soccar.ui.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.soccar.library.Session;
import nl.soccar.library.Soccar;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class MainMenuFXMLController implements Initializable {

    @FXML
    private Button btnCreateRoom;
    @FXML
    private Button btnLogOut;
    @FXML
    private Label lblUsername;
    @FXML
    private TableView tblSessionList;
    @FXML
    private TableColumn tbclName;
    @FXML
    private TableColumn tbclOccupation;
    @FXML
    private TableColumn tbclOwner;
    
    private ObservableList<Session> tblSessionItems;
    
    /**
     * Initialization of this controller class on current scene; Events get handled.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCreateRoom.setOnAction(e -> {
            Main.getInstance().setScene(FXMLConstants.LOCATION_CREATE_ROOM);
        });    
        btnLogOut.setOnAction(e -> {
            Main.getInstance().logOut();
        });
        
        lblUsername.setText(Soccar.getInstance().getCurrentPlayer().getUsername());  
        
        updateTable();     
    }
    
    public void updateTable() {
        tblSessionList.getItems().addAll(Soccar.getInstance().getSessionController().getAllSessions());
    }
    
}
