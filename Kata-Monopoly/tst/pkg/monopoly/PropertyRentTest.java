package pkg.monopoly;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PropertyRentTest {

    @Test
    public void testPropertyGroup() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        Property mediterraneanAve = (Property) board.get(1);
        assertEquals("", mediterraneanAve.getGroup());
        mediterraneanAve.setGroup("Brown");
        assertEquals("Brown", mediterraneanAve.getGroup());
    }

    @Test
    public void testGetAllPropertiesOfSameGroup() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        Property mediterraneanAve = (Property) board.get(1);
        Property balticAve = (Property) board.get(3);
        mediterraneanAve.setOwner(new Player());
        balticAve.setOwner(new Player());
        mediterraneanAve.setGroup("Brown");
        balticAve.setGroup("Brown");
        assertEquals(2,mediterraneanAve.getAllPropertiesInGroup().size());
    }
}