package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PropertyRentTest {

    private Property mediterraneanAve;
    private Property balticAve;

    @Before
    public void setUp() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        mediterraneanAve = (Property) board.get(1);
        balticAve = (Property) board.get(3);
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
}