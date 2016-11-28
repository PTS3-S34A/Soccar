package nl.soccar.rmi;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Properties;
import nl.soccar.library.Statistics;
import nl.soccar.rmi.interfaces.IClientAuthenticated;
import nl.soccar.rmi.interfaces.IClientUnauthenticated;
import nl.soccar.util.PasswordUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO Documentation
 *
 * @author PTS34A
 */
public class RmiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RmiController.class);

    private static RmiController instance;
    private IClientUnauthenticated clientUnauthenticated;
    private IClientAuthenticated clientAuthenticated;

    private RmiController() throws RemoteException {
        Properties props = new Properties();

        try (FileInputStream input = new FileInputStream("mainserver.prop")) {
            props.load(input);
        } catch (IOException e) {
            LOGGER.error("An error occurred while loading the mainserver properties file.", e);
        }

        try {
            Registry r = LocateRegistry.getRegistry(props.getProperty("mainserver"), RmiConstants.PORT_NUMBER_CLIENT);
            clientUnauthenticated = (IClientUnauthenticated) r.lookup(RmiConstants.BINDING_NAME_CLIENT);
        } catch (RemoteException | NotBoundException e) {
            LOGGER.error("An error occurred while connecting to the Main server through RMI.", e);
            System.out.println(e);
        }
    }

    public static RmiController getInstance() {
        return instance;
    }

    public static void setInstance() throws RemoteException {
        instance = new RmiController();
    }

    public boolean add(String username, String password) {
        try {
            return clientUnauthenticated.add(username, PasswordUtilities.generateHash(password));
        } catch (RemoteException e) {
            LOGGER.warn("An error occurred while adding a new user on the Main server through RMI.", e);
            return false;
        }
    }

    public boolean checkIfExists(String username) {
        try {
            return clientUnauthenticated.checkIfExists(username);
        } catch (RemoteException e) {
            LOGGER.warn("An error occurred while checking if a user exists on the Main server through RMI.", e);
            return false;
        }
    }

    public boolean checkPassword(String username, String password) {
        try {
            clientAuthenticated = clientUnauthenticated.checkPassword(username, PasswordUtilities.generateHash(password));
        } catch (RemoteException e) {
            LOGGER.warn("An error occurred while checking the users password on the Main server through RMI.", e);
        }
        return clientAuthenticated != null;
    }

    public List<Statistics> getAllStatistics() {
        try {
            return clientUnauthenticated.getAllStatistics();
        } catch (RemoteException e) {
            LOGGER.warn("An error occurred while retrieving all statistic from the Main server through RMI.", e);
            return null;
        }
    }

}
