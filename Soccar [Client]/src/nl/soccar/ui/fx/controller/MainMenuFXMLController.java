package nl.soccar.ui.fx.controller;

import java.io.IOException;
import java.net.URL;
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

    /**
     * Initialization of this controller class on current scene; Events get
     * handled.
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

        tbclName.setCellValueFactory(new PropertyValueFactory<SessionTableItem, String>("roomName"));
        tbclOccupation.setCellValueFactory(new PropertyValueFactory<SessionTableItem, String>("occupancy"));
        tbclOwner.setCellValueFactory(new PropertyValueFactory<SessionTableItem, String>("hostName"));

        tblSessionList.setRowFactory(tv -> {
            TableRow<SessionTableItem> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    SessionTableItem rowData = row.getItem();
                    
                    Soccar.getInstance().getSessionController().join(rowData.getSession().getRoom().getName(), "", Soccar.getInstance().getCurrentPlayer());
                    Main.getInstance().setScene(FXMLConstants.LOCATION_SESSION_VIEW);
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

}
