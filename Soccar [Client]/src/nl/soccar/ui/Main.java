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

    @Override
    public void start(Stage primaryStage) {
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

    public static void main(String[] args) {
        launch(args);
    }

}
