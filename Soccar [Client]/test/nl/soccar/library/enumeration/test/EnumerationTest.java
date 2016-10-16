package nl.soccar.library.enumeration.test;

import nl.soccar.library.enumeration.BallType;
import nl.soccar.library.enumeration.CarType;
import nl.soccar.library.enumeration.Duration;
import nl.soccar.library.enumeration.EventType;
import nl.soccar.library.enumeration.GameStatus;
import nl.soccar.library.enumeration.MapType;
import nl.soccar.library.enumeration.ObstacleType;
import nl.soccar.library.enumeration.Privilege;
import nl.soccar.library.enumeration.TeamColour;
import org.junit.Test;

/**
 * JUnit test that tests all nl.soccar.library.enumeration enumerations.
 * 
 * @author PTS34A
 */
public class EnumerationTest {
    
    /**
     * Tests all enumerations
     */
    @Test
    public void testAllEnumerations() {
        BallType.valueOf(BallType.BOWLING.toString());
        CarType.valueOf(CarType.CASUAL.toString());
        Duration.valueOf(Duration.MINUTES_10.toString());
        EventType.valueOf(EventType.ASSIST.toString());
        GameStatus.valueOf(GameStatus.STARTED.toString());
        MapType.valueOf(MapType.DESERT.toString());
        ObstacleType.valueOf(ObstacleType.WALL.toString());
        Privilege.valueOf(Privilege.ADMINISTRATOR.toString());
        TeamColour.valueOf(TeamColour.BLUE.toString());
    }

}
