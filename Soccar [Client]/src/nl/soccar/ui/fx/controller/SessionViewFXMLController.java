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
import nl.soccar.library.Room;
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

    private Session currentSession;

    private Player currentPlayer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Soccar soccar = Soccar.getInstance();
        currentSession = soccar.getSessionController().getCurrentSession();
        currentPlayer = soccar.getCurrentPlayer();

        btnLogOut.setOnAction(e -> Main.getInstance().logOut());
        btnLeaveRoom.setOnAction(e -> leaveRoom());

        lblUsername.setText(currentPlayer.getUsername());

        setRoomInfo();
    }

    public void setRoomInfo() {
        Room room = currentSession.getRoom();
        int roomSize = room.getAllPlayers().size();

        lblRoomName.setText("Room: " + room.getName());
        lblOccupancy.setText("Occupancy: " + (roomSize + "/" + room.getCapacity()));

        lvPlayersBlue.setItems(FXCollections.observableArrayList(room.getTeamBlue().getPlayers()));
        lvPlayersRed.setItems(FXCollections.observableArrayList(room.getTeamRed().getPlayers()));

        btnStartGame.setDisable(roomSize != room.getCapacity());
    }

    public void leaveRoom() {
        Soccar.getInstance().getSessionController().leave(currentSession, currentPlayer);
        Main.getInstance().setScene(FXMLConstants.LOCATION_MAIN_MENU);
    }
}
