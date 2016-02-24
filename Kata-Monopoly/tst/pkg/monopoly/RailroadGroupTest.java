package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RailroadGroupTest {

    private Property reading;
    private Property pennsylvania;
    private Property bAndO;
    private Property shortLine;
    private final Player player1 = new Player("Cat");
    private final Player player2 = new Player("Dog");

    @Before
    public void setUp() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        reading = (Property) board.get(5);
        pennsylvania = (Property) board.get(15);
        bAndO = (Property) board.get(25);
        shortLine = (Property) board.get(35);
    }

    @Test
    public void testPropertyGroup() throws IOException {
        assertEquals("Railroad", reading.getGroup());
        assertEquals("Railroad", pennsylvania.getGroup());
        assertEquals("Railroad", bAndO.getGroup());
        assertEquals("Railroad", shortLine.getGroup());
    }


}
