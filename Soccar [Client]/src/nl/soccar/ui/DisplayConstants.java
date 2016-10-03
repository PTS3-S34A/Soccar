package nl.soccar.ui;

/**
 *
 * @author PTS34A
 */
public final class DisplayConstants {
    
    /**
     * Screen properties
     */
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    
    /**
     * Map properties
     */
    public static final int LINE_WIDTH = 2;
    public static final double CENTRE_CIRCLE_SIZE = 137.5;
    public static final int CENTRE_SPOT_SIZE = 15;
    public static final int FIELD_MARGIN = 50;
    public static final int BOX_WIDTH = 125;
    public static final int BOX_HEIGHT = 325;
    public static final int GOAL_WIDTH = 35;
    public static final double GOAL_HEIGHT = BOX_HEIGHT / 1.5;
    /**
     * Map images properties
     */
    public static final String LOCATION_TEXTURE_MOON = "resources/images/moon_texture.jpg";
    public static final String LOCATION_TEXTURE_DESERT = "resources/images/desert_texture.jpg";
    public static final String LOCATION_TEXTURE_GRASS = "resources/images/grass_texture.jpg";
    
    private DisplayConstants() {
    }
}
