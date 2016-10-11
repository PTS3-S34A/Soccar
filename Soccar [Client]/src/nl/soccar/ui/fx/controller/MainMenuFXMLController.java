package nl.soccar.ui.fx.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.soccar.exception.InvalidCredentialException;
import nl.soccar.exception.RoomException;
import nl.soccar.library.Session;
import nl.soccar.library.SessionController;
import nl.soccar.library.Soccar;
import nl.soccar.ui.Main;
import nl.soccar.ui.fx.FXMLConstants;
import org.apache.log4j.Logger;

public class MainMenuFXMLController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(MainMenuFXMLController.class);
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
    private TableView<SessionTableItem> tblSessionList;
    @FXML
    private TableColumn tbclName;
    @FXML
    private TableColumn tbclOccupation;
    @FXML
    private TableColumn tbclOwner;
    @FXML
    private TableColumn tbclPassword;

    private SessionController sessionController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionController = Soccar.getInstance().getSessionController();

        lblUsername.setText(Soccar.getInstance().getCurrentPlayer().getUsername());
        lblCar.setText(Soccar.getInstance().getCurrentPlayer().getCarType().toString());

        btnLogOut.setOnAction(e -> Main.getInstance().logOut());
        btnCreateRoom.setOnAction(e -> Main.getInstance().setScene(FXMLConstants.LOCATION_CREATE_ROOM));
        btnJoinRoom.setOnAction(e -> joinRoom(tblSessionList.getSelectionModel().getSelectedItem()));

        tbclName.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        tbclOccupation.setCellValueFactory(new PropertyValueFactory<>("occupancy"));
        tbclOwner.setCellValueFactory(new PropertyValueFactory<>("hostName"));
        tbclPassword.setCellValueFactory(new PropertyValueFactory<>("passwordAvailable"));
        tblSessionList.setRowFactory(tv -> {
            TableRow<SessionTableItem> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    joinRoom((SessionTableItem) row.getItem());
                }
            });
            return row;
        });

        updateTable();
    }

    private void updateTable() {
        ObservableList<SessionTableItem> sessionItems = FXCollections.observableArrayList();
        Soccar.getInstance().getSessionController().getAllSessions().stream().map(SessionTableItem::new).forEach(sessionItems::add);
        
        tblSessionList.getItems().clear();
        tblSessionList.getItems().addAll(sessionItems);
    }

    public void joinRoom(SessionTableItem selectedRow) {
        String password = NO_PASSWORD;

        Session selectedSession = selectedRow.getSession();
        if (selectedSession.getRoom().passwordAvailable()) {
            TextInputDialog dialog = new TextInputDialog("Password");
            dialog.setTitle("Password locked room");
            dialog.setHeaderText("This room is locked!");
            dialog.setContentText("Please enter your password:");

            Optional<String> result = dialog.showAndWait();
            password = result.get();
        }

        try {
            sessionController.setCurrentSession(sessionController.join(selectedSession, password, Soccar.getInstance().getCurrentPlayer()));
            Main.getInstance().setScene(FXMLConstants.LOCATION_SESSION_VIEW);
        } catch (InvalidCredentialException | RoomException e) {
            LOGGER.error("An error occurred while joining a room.", e);

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(e.getTitle());
            alert.setHeaderText(e.getTitle());
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

}
