package nl.soccar.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
 * Entry point of the Soccar application. The Main class keeps track of the user
 * interface and provides a way to switch scenes.
 *
 * @author PTS34A
 */
public class Main extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static Main instance;

    private Stage primaryStage;

    /**
     * Constructor used for initiation of a Main object. This only happens once,
     * so the static instance gets filled out here.
     */
    public Main() {
        super();

        synchronized (Main.class) {
            if (instance != null) {
                throw new UnsupportedOperationException("Main is a singleton, cannot be called from its constructor.");
            }

            instance = this;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        setScene(FXMLConstants.LOCATION_LOGIN);
    }

    /**
     * Gets the instance of the Singleton Main class.
     *
     * @return The Singleton instance of the Main class.
     */
    public static Main getInstance() {
        return instance;
    }

    /**
     * Starts the application and configures the error logger.
     *
     * @param args The command line arguments to passed into the application.
     */
    public static void main(String[] args) {
        BasicConfigurator.configure();

        launch(args);
    }

    /**
     * Handles a login request. On success, it adjusts the current Player and
     * changes the scene to the main menu. On fail, it throws an exception and
     * displays an error message to the user.
     *
     * @param username The username of the Player.
     * @param selectedCar The selected car of the Player.
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
     * Changes the scene by giving a name. The actual file is resolved by
     * combining a predefined String and the given name. The stage title and
     * icon are also set.
     *
     * @param sceneName The name of the scene.
     */
    public void setScene(String sceneName) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            Scene scene = new Scene(root, DisplayConstants.SCREEN_WIDTH, DisplayConstants.SCREEN_HEIGHT);

            primaryStage.setTitle(DisplayConstants.APPLICATION_NAME);
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image(DisplayConstants.LOCATION_STAGE_ICON));

            primaryStage.show();
        } catch (IOException e) {
            LOGGER.error("An error occurred while changing a scene.", e);
        }
    }

    /**
     * Sets the application window to full screen mode.
     *
     * @param fullScreen True if the application window needs to be set to full
     * screen mode.
     */
    public void setFullScreen(boolean fullScreen) {
        primaryStage.setMaximized(fullScreen);
        primaryStage.setFullScreen(fullScreen);
        primaryStage.setResizable(!fullScreen);
    }

    /**
     * Gets the width of the primary stage.
     *
     * @return The width of the primary stage.
     */
    public float getStageWidth() {
        return (float) primaryStage.getWidth();
    }

}
