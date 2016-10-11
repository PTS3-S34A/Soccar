package nl.soccar.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.soccar.library.Player;
import nl.soccar.library.Soccar;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.ui.fx.FXMLConstants;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point of the Soccar application. The Main class keeps track of the UI and provides a way to switch certain scenes.
 * 
 * @author PTS34A
 */
public class Main extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    private static Main mainClass;
    
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        mainClass = this;
        this.primaryStage = primaryStage;
        
        setScene(FXMLConstants.LOCATION_LOGIN);
    }

    /**
     * Gets an instance of this class (singleton).
     * 
     * @return A singleton instance of this class.
     */
    public static Main getInstance() {
      return mainClass;
    }
     
    /**
     * Starts the application.
     * 
     * @param args The command line arguments to pass into the application.
     */
    public static void main(String[] args) {
        BasicConfigurator.configure();
        
        launch(args);
    }
    
    /**
     * Handles a login request. On success: adjusts the current player and changes the scene to the main menu.
     * On fail: throws an exception and displays an error message to the end user.
     * 
     * @param username The username of the player.
     * @param selectedCar The selected car of the player.
     */
    public void login(String username, CarType selectedCar) {
        //TODO Login handling (password, privilege)
        Soccar.setInstance(new Player(username, Privilege.NORMAL, selectedCar));
        setScene(FXMLConstants.LOCATION_MAIN_MENU);
    }
    
    /**
     * Logs out the current user and changes the scene to the login menu.
     */
    public void logOut() {
        Soccar.setInstance(null);
        setScene(FXMLConstants.LOCATION_LOGIN);
    }
    
    /**
     * Changes the scene by giving a name. The actual file is resolved by combining a predefined String and the given name.
     * 
     * @param sceneName The name of the scene.
     */
    public void setScene(String sceneName) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            Scene scene = new Scene(root, DisplayConstants.SCREEN_WIDTH, DisplayConstants.SCREEN_HEIGHT);

            primaryStage.setTitle(Soccar.APPLICATION_NAME);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            LOGGER.error("An error occurred while changing a scene.", e);
        }
    }
}
