package nl.soccar.ui.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.soccar.library.Session;
import nl.soccar.library.SessionController;
import nl.soccar.library.Soccar;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;

/**
 * FXML Controller class
 *
 * @author PTS34A
 */
public class MainMenuFXMLController implements Initializable {

    private static final String NO_PASSWORD = "";
    @FXML
    private Button btnCreateRoom;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnJoinRoom;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblCar;
    @FXML
    private TableView tblSessionList;
    @FXML
    private TableColumn tbclName;
    @FXML
    private TableColumn tbclOccupation;
    @FXML
    private TableColumn tbclOwner;
    @FXML
    private TableColumn tbclPassword;

    private SessionController sessionController;

    /**
     * Initialization of this controller class on current scene; Events get
     * handled.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionController = Soccar.getInstance().getSessionController();
        
        lblUsername.setText(Soccar.getInstance().getCurrentPlayer().getUsername());
        lblCar.setText(Soccar.getInstance().getCurrentPlayer().getCarType().toString());

        tbclName.setCellValueFactory(new PropertyValueFactory<SessionTableItem, String>("roomName"));
        tbclOccupation.setCellValueFactory(new PropertyValueFactory<SessionTableItem, String>("occupancy"));
        tbclOwner.setCellValueFactory(new PropertyValueFactory<SessionTableItem, String>("hostName"));
        tbclPassword.setCellValueFactory(new PropertyValueFactory<SessionTableItem, String>("passwordAvailable"));
        
        btnCreateRoom.setOnAction(e -> {
            Main.getInstance().setScene(FXMLConstants.LOCATION_CREATE_ROOM);
        });
        btnLogOut.setOnAction(e -> {
            Main.getInstance().logOut();
        });
        
        btnJoinRoom.setOnAction(e -> {
            Main.getInstance().logOut();
        });

        tblSessionList.setRowFactory(tv -> {
            TableRow<SessionTableItem> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    joinRoom(row);
                }
            });
            return row;
        });
        updateTable();
    }

    public void updateTable() {
        tblSessionList.getItems().clear();

        ObservableList<SessionTableItem> sessionItems = FXCollections.observableArrayList();
        for (Session s : Soccar.getInstance().getSessionController().getAllSessions()) {
            sessionItems.add(new SessionTableItem(s));
        }
        tblSessionList.getItems().addAll(sessionItems);
    }

    public void joinRoom(TableRow row) {
        SessionTableItem rowData = (SessionTableItem) row.getItem();
        
        Session selectedSession = rowData.getSession();
        
        if (selectedSession.getRoom().passwordAvailable()) {
            TextInputDialog dialog = new TextInputDialog("Password");
            dialog.setTitle("Password locked room");
            dialog.setHeaderText("This room is locked!");
            dialog.setContentText("Please enter your password:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(password -> sessionController.setCurrentSession(sessionController.join(selectedSession, password, Soccar.getInstance().getCurrentPlayer())));
        } else {
            sessionController.setCurrentSession(sessionController.join(selectedSession, NO_PASSWORD, Soccar.getInstance().getCurrentPlayer()));
        }

        Main.getInstance().setScene(FXMLConstants.LOCATION_SESSION_VIEW);
    }

}
