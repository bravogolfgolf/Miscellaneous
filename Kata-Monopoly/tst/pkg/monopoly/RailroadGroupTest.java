package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RailroadGroupTest {

    private static final int PRICE_OF_RAILROAD = 200;
    private static final int RENT_OF_RAILROAD = 25;
    private Railroad reading;
    private Railroad pennsylvania;
    private Railroad bAndO;
    private Railroad shortLine;
    private final Player player1 = new Player("Cat");
    private final Player player2 = new Player("Dog");

    @Before
    public void setUp() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        reading = (Railroad) board.get(5);
        pennsylvania = (Railroad) board.get(15);
        bAndO = (Railroad) board.get(25);
        shortLine = (Railroad) board.get(35);
    }

    @Test
    public void testCreation() {
        Space property = Space.create("Railroad", "Short Line", "Railroad", -1, -1);
        assertEquals("Short Line", property.getDescription());
        assertEquals("Railroad", property.getGroup());
    }

    @Test
    public void testOwnership() {
        assertTrue(reading.getOwner().isBank());
        reading.setOwner(player1);
        assertEquals(player1, reading.getOwner());
        assertTrue(pennsylvania.getOwner().isBank());
        assertTrue(bAndO.getOwner().isBank());
        assertTrue(shortLine.getOwner().isBank());
    }

    @Test
    public void testPrice() {
        assertEquals(PRICE_OF_RAILROAD, reading.getPrice());
        assertEquals(PRICE_OF_RAILROAD, pennsylvania.getPrice());
        assertEquals(PRICE_OF_RAILROAD, bAndO.getPrice());
        assertEquals(PRICE_OF_RAILROAD, shortLine.getPrice());
    }

    @Test
    public void testRent() {
        assertEquals(RENT_OF_RAILROAD, reading.getRent());
        assertEquals(RENT_OF_RAILROAD, pennsylvania.getRent());
        assertEquals(RENT_OF_RAILROAD, bAndO.getRent());
        assertEquals(RENT_OF_RAILROAD, shortLine.getRent());
    }

    @Test
    public void testPropertyGroup() throws IOException {
        assertEquals("Railroad", reading.getGroup());
        assertEquals("Railroad", pennsylvania.getGroup());
        assertEquals("Railroad", bAndO.getGroup());
        assertEquals("Railroad", shortLine.getGroup());
    }

    @Test
    public void testGetAllPropertiesOfSameGroup() throws IOException {
        assertEquals(4, reading.getAllPropertiesInGroup().size());
    }

    @Test
    public void testCountHowManyPropertiesOfThisGroupAreOwnedByTheSameOwner() throws IOException {
        reading.setOwner(player1);
        pennsylvania.setOwner(player2);
        bAndO.setOwner(player2);
        shortLine.setOwner(player2);
        List<Space> properties = reading.getAllPropertiesInGroup();
        assertEquals(1, reading.getCountOfPropertiesInGroupWithSameOwner(properties));

        reading.setOwner(player1);
        pennsylvania.setOwner(player1);
        bAndO.setOwner(player2);
        shortLine.setOwner(player2);
        properties = reading.getAllPropertiesInGroup();
        assertEquals(2, reading.getCountOfPropertiesInGroupWithSameOwner(properties));

        reading.setOwner(player1);
        pennsylvania.setOwner(player1);
        bAndO.setOwner(player1);
        shortLine.setOwner(player2);
        properties = reading.getAllPropertiesInGroup();
        assertEquals(3, reading.getCountOfPropertiesInGroupWithSameOwner(properties));

        reading.setOwner(player1);
        pennsylvania.setOwner(player1);
        bAndO.setOwner(player1);
        shortLine.setOwner(player1);
        properties = reading.getAllPropertiesInGroup();
        assertEquals(4, reading.getCountOfPropertiesInGroupWithSameOwner(properties));
    }
}
