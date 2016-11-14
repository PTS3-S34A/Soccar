package nl.soccar.ui.fx;

/**
 * This class keeps track of all constants regarding JavaFX. For example the locations of 
 * FXML files.
 * 
 * @author PTS34A
 */
public final class FXMLConstants {
    
    // Locations of FXML files.
    public static final String LOCATION_MAIN_MENU = "resources/fxml/MainMenuFXML.fxml";
    public static final String LOCATION_LOGIN = "resources/fxml/LoginFXML.fxml";
    public static final String LOCATION_CREATE_ROOM = "resources/fxml/CreateRoomFXML.fxml";
    public static final String LOCATION_SESSION_VIEW = "resources/fxml/SessionViewFXML.fxml";
    public static final String LOCATION_GAME_VIEW = "resources/fxml/GameViewFXML.fxml";
    public static final String LOCATION_GAME_RESULTS = "resources/fxml/GameResultsFXML.fxml";
    public static final String LOCATION_REGISTER = "resources/fxml/RegisterFXML.fxml";
    
    // GUI warnings & description
    public static final String WARNING_USERNAME_EXCISTS = "PLAYERNAME EXCISTS";
    public static final String DESCRIPTION_USERNAME_EXCISTS = "LOGIN OR CHOOSE A DIFFERENT PLAYERNAME";
    public static final String WARNING_NEW_USERNAME = "REGISTER";
    public static final String DESCRIPTION_NEW_USERNAME = "WOULD YOU LIKE TO REGISTER YOUR ACCOUNT?";
            
    private FXMLConstants() {
    }
    
}
