package nl.soccar.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.soccar.library.Soccar;

/**
 *
 * @author PTS34A
 */
public class Main extends Application {

    private static Main mainClass = null;
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        mainClass = this;
        this.primaryStage = primaryStage;
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            
            // TODO implementatie
            Scene scene = new Scene(root, 1200, 800);

            primaryStage.setTitle(Soccar.APPLICATION_NAME);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public static Main getInstance() {
      return mainClass;
    }
     
    public static void main(String[] args) {
        launch(args);
    }
    
    public void login(String loginName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuFXML.fxml"));
            
            // TODO implementatie
            Scene scene = new Scene(root, 1200, 800);

            primaryStage.setTitle(Soccar.APPLICATION_NAME);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void setScene(String sceneName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(sceneName));
            
            // TODO implementatie
            Scene scene = new Scene(root, 1200, 800);

            primaryStage.setTitle(Soccar.APPLICATION_NAME);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
