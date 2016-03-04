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
    private int player1BeginningBalance = player1.getCashBalance();
    private int player2BeginningBalance = player2.getCashBalance();

    @Before
    public void setUp() throws IOException {
        Game game = new Game("US");
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
    public void testMortgaged() {
        assertEquals(false, reading.isMortgaged());
        reading.setIsMortgaged(true);
        assertEquals(true, reading.isMortgaged());
    }

    @Test
    public void testLandOnUnownedProperty() {
        assertTrue(reading.getOwner().isBank());
        int endingBalance = player1BeginningBalance - PRICE_OF_RAILROAD;
        reading.landOn(player1, "Roll");
        assertEquals(player1, reading.getOwner());
        assertEquals(endingBalance, player1.getCashBalance());
    }

    @Test
    public void testLandOnOwnedAndUnmortgagedProperty() {
        ownedUnMortgagedProperty(player2);
        int player1EndingBalance = player1BeginningBalance - RENT_OF_RAILROAD;
        int player2EndingBalance = player2BeginningBalance + RENT_OF_RAILROAD;
        reading.landOn(player1, "Roll");
        assertEquals(player2, reading.getOwner());
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
    }

    private void ownedUnMortgagedProperty(Player player) {
        reading.setOwner(player);
        assertEquals(player, reading.getOwner());
        assertEquals(false, reading.isMortgaged());
    }

    @Test
    public void testLandOnOwnedAndMortgagedProperty() {
        ownedMortgagedProperty();
        reading.landOn(player1, "Roll");
        assertEquals(player2, reading.getOwner());
        assertEquals(player1BeginningBalance, player1.getCashBalance());
        assertEquals(player2BeginningBalance, player2.getCashBalance());
    }

    private void ownedMortgagedProperty() {
        reading.setOwner(player2);
        reading.setIsMortgaged(true);
        assertEquals(player2, reading.getOwner());
        assertEquals(true, reading.isMortgaged());
    }

    @Test
    public void testPlayerDoesNotPayHimselfRent() {
        PlayerMockDoesNotPaySelfRent playerMock = new PlayerMockDoesNotPaySelfRent();
        ownedUnMortgagedProperty(playerMock);
        reading.landOn(playerMock, "Roll");
        assertEquals(0, playerMock.changeCashBalanceBy);
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
