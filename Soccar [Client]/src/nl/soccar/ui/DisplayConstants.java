package nl.soccar.ui;

/**
 * This class will keep up with all constants regarding the UI. 
 * 
 * @author PTS34A
 */
public final class DisplayConstants {

    /**
     * Screen constants in pixels
     */
    public static final float SCREEN_WIDTH = 1200;
    public static final float SCREEN_HEIGHT = 800;

    /**
     * Car constants in JBox2D units
     */
    public static final float CAR_WIDTH = 5.0F;
    
    /**
     * Map constants in JBox2D units
     */
    public static final float MAP_WIDTH = 160.0F;
    public static final float MAP_HEIGHT = 90.0F;
    public static final float LINE_WIDTH = 0.2F;
    public static final float CENTRE_CIRCLE_SIZE = 13.75F;
    public static final float CENTRE_SPOT_SIZE = 1.5F;
    public static final float FIELD_MARGIN = 5.0F;
    public static final float BOX_WIDTH = 12.5F;
    public static final float BOX_HEIGHT = 32.5F;
    public static final float GOAL_WIDTH = 3.5F;
    public static final float GOAL_HEIGHT = BOX_HEIGHT / 1.5F;
    
    /**
     * Map image constants
     */
    public static final String LOCATION_TEXTURE_MOON = "resources/images/moon_texture.jpg";
    public static final String LOCATION_TEXTURE_DESERT = "resources/images/desert_texture.jpg";
    public static final String LOCATION_TEXTURE_GRASS = "resources/images/grass_texture.jpg";
    public static final String LOCATION_TEXTURE_CAR_RED = "resources/images/car_red.png";

    private DisplayConstants() {
    }
}
