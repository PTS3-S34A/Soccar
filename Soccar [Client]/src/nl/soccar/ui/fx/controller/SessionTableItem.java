package nl.soccar.ui.fx.controller;

import javafx.beans.property.SimpleStringProperty;
import nl.soccar.library.Session;

/**
 *
 * @author PTS34A
 */
public class SessionTableItem {

    private final SimpleStringProperty roomName;
    private final SimpleStringProperty occupancy;
    private final SimpleStringProperty hostName;
    private final Session session;

    public SessionTableItem(Session s) {
        this.roomName = new SimpleStringProperty(s.getRoom().getName());
        this.occupancy = new SimpleStringProperty(s.getRoom().getAllPlayers().size() + " / " + s.getRoom().getCapacity());
        if (s.getRoom().getHost() != null) {
            this.hostName = new SimpleStringProperty(s.getRoom().getHost().toString());
        } else {
            this.hostName = new SimpleStringProperty("No host available");
        }

        this.session = s;
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

}
