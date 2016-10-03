package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import nl.soccar.library.Player;
import nl.soccar.library.Session;
import nl.soccar.library.Soccar;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class SessionViewFXMLController implements Initializable {

    @FXML
    private Label lblRoomName;
    @FXML
    private Label lblRoomStatus;
    @FXML
    private ListView lvPlayersRed;
    @FXML
    private ListView lvPlayersBlue;
    @FXML 
    private Button btnLeaveRoom;
    @FXML
    private Button btnLogOut;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblOccupancy;
    @FXML
    private Button btnStartGame;
    @FXML
    private ImageView imgMap;
    
    private Session currentSession; 
    
    private Player currentPlayer;
    
    private Soccar soccarInstance;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogOut.setOnAction(e -> {
            Main.getInstance().logOut();
        });
        
        btnLeaveRoom.setOnAction(e -> {
            leaveRoom();
        });
        
        lblUsername.setText(Soccar.getInstance().getCurrentPlayer().getUsername()); 
        
        currentSession = Soccar.getInstance().getSessionController().getCurrentSession();
        soccarInstance = Soccar.getInstance();
        currentPlayer = Soccar.getInstance().getCurrentPlayer();
        
        setRoomInfo();
    }    
    
    public void setRoomInfo() {
        lblRoomName.setText("Room: " + currentSession.getRoom().getName());
        
        lvPlayersBlue.setItems(FXCollections.observableArrayList(currentSession.getRoom().getTeamBlue().getPlayers()));
        lvPlayersRed.setItems(FXCollections.observableArrayList(currentSession.getRoom().getTeamRed().getPlayers()));
        
        lblOccupancy.setText("Occupancy: " + currentSession.getRoom().getAllPlayers().size() + "/" + currentSession.getRoom().getCapacity());
        
        if(currentSession.getRoom().getAllPlayers().size() == currentSession.getRoom().getCapacity()) {
            btnStartGame.setDisable(false);
        } else {
            btnStartGame.setDisable(true);
        }
    }
    
    public void leaveRoom() {
        Soccar.getInstance().getSessionController().leave(currentSession, currentPlayer);
        Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU);
    }
}
