package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PropertyRentTest {

    private Property mediterraneanAve;
    private Property balticAve;

    @Before
    public void setUp() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        Player player = new Player("Cat");
        mediterraneanAve = (Property) board.get(1);
        balticAve = (Property) board.get(3);
        mediterraneanAve.setOwner(player);
        balticAve.setOwner(player);
    }

    @Test
    public void testPropertyGroup() throws IOException {
        assertEquals("Brown", mediterraneanAve.getGroup());
        assertEquals("Brown", balticAve.getGroup());
    }

    @Test
    public void testGetAllPropertiesOfSameGroup() throws IOException {
        assertEquals(2,mediterraneanAve.getAllPropertiesInGroup().size());
    }

    @Test
    public void testPropertiesOfSameGroupHaveSameOwners() throws IOException {
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertTrue(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }
}