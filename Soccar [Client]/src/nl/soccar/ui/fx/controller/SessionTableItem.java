package nl.soccar.ui.fx.controller;

import javafx.beans.property.SimpleStringProperty;
import nl.soccar.library.Player;
import nl.soccar.library.Room;
import nl.soccar.library.Session;

/**
 *
 * @author PTS34A
 */
public class SessionTableItem {

    private final SimpleStringProperty roomName;
    private final SimpleStringProperty occupancy;
    private final SimpleStringProperty hostName;
    private final SimpleStringProperty passwordAvailable;
    
    private final Session session;

    public SessionTableItem(Session s) {
        this.session = s;
        
        Room room = s.getRoom();
        roomName = new SimpleStringProperty(room.getName());
        occupancy = new SimpleStringProperty(room.getAllPlayers().size() + " / " + room.getCapacity());
        
        Player host = room.getHost();
        hostName = new SimpleStringProperty(host != null ? host.getUsername() : "No host available.");
        
        passwordAvailable = new SimpleStringProperty(room.passwordAvailable() ? "Yes" : "No");
    }

    public String getRoomName() {
        return roomName.get();
    }

    public Session getSession() {
        return session;
    }

    public String getOccupancy() {
        return occupancy.get();
    }

    public String getHostName() {
        return hostName.get();
    }

    public String getPasswordAvailable() {
        return passwordAvailable.get();
    }
}
