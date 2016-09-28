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

/**
 *
 * @author PTS34A
 */
public class Main extends Application {

    private static Main mainClass;
    
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        mainClass = this;
        this.primaryStage = primaryStage;
        
        setScene(FXMLConstants.LOCATION_LOGIN);
    }

    public static Main getInstance() {
      return mainClass;
    }
     
    public static void main(String[] args) {
        launch(args);
    }
    
    public void login(String loginName, CarType selectedCar) {
        //TODO Login handling (password, privilege)
        Soccar.setInstance(new Player(loginName, "", Privilege.NORMAL, selectedCar));
        setScene(FXMLConstants.LOCATION_MAIN_MENU);
    }
    
    public void logOut() {
        Soccar.setInstance(null);
        setScene(FXMLConstants.LOCATION_LOGIN);
    }
    
    public void setScene(String sceneName) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(sceneName));
            Scene scene = new Scene(root, DisplayConstants.WIDTH, DisplayConstants.HEIGHT);

            primaryStage.setTitle(Soccar.APPLICATION_NAME);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
