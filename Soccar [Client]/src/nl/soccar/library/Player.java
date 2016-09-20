package nl.soccar.library;

import nl.soccar.library.enumeration.Privilege;
import nl.soccar.library.enumeration.CarType;

public class Player {
    
    private final String username;
    private final String password;
    private final Privilege privilege;
    private final CarType carType;
    private Statistics statistics;

    public Player(String username, String password, Privilege privilege, CarType carType) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
        this.carType = carType;
    }

    public String getUsername() {
        return username;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public CarType getCarType() {
        return carType;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
    
}
