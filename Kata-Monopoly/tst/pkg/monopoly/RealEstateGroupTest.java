package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RealEstateGroupTest {

    private static final int PRICE_OF_MEDITERRANEAN = 60;
    private static final int PRICE_OF_BALTIC = 60;
    private static final int RENT_OF_MEDITERRANEAN = 2;
    private static final int RENT_OF_BALTIC = 4;
    private RealEstate mediterraneanAve;
    private RealEstate balticAve;
    private final Player player1 = new Player("Cat");
    private final Player player2 = new Player("Dog");
    private int player1BeginningBalance = player1.getCashBalance();
    private int player2BeginningBalance = player2.getCashBalance();

    @Before
    public void setUp() throws IOException {
        Game game = new Game("Spaces_US.txt");
        List<Space> board = game.getBoard();
        mediterraneanAve = (RealEstate) board.get(1);
        balticAve = (RealEstate) board.get(3);
    }

    @Test
    public void testCreation() {
        Space property = Space.create("RealEstate", "Park Place", "Blue", -1, -1);
        assertEquals("Park Place", property.getDescription());
        assertEquals("Blue", property.getGroup());
    }

    @Test
    public void testOwnership() {
        assertTrue(mediterraneanAve.getOwner().isBank());
        mediterraneanAve.setOwner(player1);
        assertEquals(player1, mediterraneanAve.getOwner());
        assertTrue(balticAve.getOwner().isBank());
    }

    @Test
    public void testPrice() {
        assertEquals(PRICE_OF_MEDITERRANEAN, mediterraneanAve.getPrice());
        assertEquals(PRICE_OF_BALTIC, balticAve.getPrice());
    }

    @Test
    public void testRent() {
        assertEquals(RENT_OF_MEDITERRANEAN, mediterraneanAve.getRent());
        assertEquals(RENT_OF_BALTIC, balticAve.getRent());
    }

    @Test
    public void testMortgaged() {
        assertEquals(false, mediterraneanAve.isMortgaged());
        mediterraneanAve.setIsMortgaged(true);
        assertEquals(true, mediterraneanAve.isMortgaged());
    }

    @Test
    public void testLandOnUnownedProperty() {
        assertTrue(mediterraneanAve.getOwner().isBank());
        int endingBalance = player1BeginningBalance - PRICE_OF_MEDITERRANEAN;
        mediterraneanAve.landOn(player1);
        assertEquals(player1, mediterraneanAve.getOwner());
        assertEquals(endingBalance, player1.getCashBalance());
    }

    @Test
    public void testLandOnOwnedAndUnmortgagedPropertyNoHousesOrHotel() {
        ownedUnMortgagedProperty(player2);
        int player1EndingBalance = player1BeginningBalance - RENT_OF_MEDITERRANEAN;
        int player2EndingBalance = player2BeginningBalance + RENT_OF_MEDITERRANEAN;
        mediterraneanAve.landOn(player1);
        assertEquals(player2, mediterraneanAve.getOwner());
        assertTrue(balticAve.getOwner().isBank());
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());

        balticAve.setOwner(player2);
        player1EndingBalance = player1EndingBalance - (RENT_OF_BALTIC * 2);
        player2EndingBalance = player2EndingBalance + (RENT_OF_BALTIC * 2);
        balticAve.landOn(player1);
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());

        balticAve.landOn(player2);
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
    }

    private void ownedUnMortgagedProperty(Player player) {
        mediterraneanAve.setOwner(player);
        assertEquals(player, mediterraneanAve.getOwner());
        assertEquals(false, mediterraneanAve.isMortgaged());
    }

    @Test
    public void testLandOnOwnedAndMortgagedProperty() {
        ownedMortgagedProperty();
        mediterraneanAve.landOn(player1);
        assertEquals(player2, mediterraneanAve.getOwner());
        assertEquals(player1BeginningBalance, player1.getCashBalance());
        assertEquals(player2BeginningBalance, player2.getCashBalance());
    }

    private void ownedMortgagedProperty() {
        mediterraneanAve.setOwner(player2);
        mediterraneanAve.setIsMortgaged(true);
        assertEquals(player2, mediterraneanAve.getOwner());
        assertEquals(true, mediterraneanAve.isMortgaged());
    }

    @Test
    public void testPlayerDoesNotPayHimselfRent() {
        PlayerMockCashBalanceCounter playerMock = new PlayerMockCashBalanceCounter();
        ownedUnMortgagedProperty(playerMock);
        mediterraneanAve.landOn(playerMock);
        assertEquals(0, playerMock.changeCashBalanceBy);
    }

    @Test
    public void testPropertyGroup() throws IOException {
        assertEquals("Brown", mediterraneanAve.getGroup());
        assertEquals("Brown", balticAve.getGroup());
    }

    @Test
    public void testGetAllPropertiesOfSameGroup() throws IOException {
        assertEquals(2, mediterraneanAve.getAllPropertiesInGroup().size());
    }

    @Test
    public void testPropertiesOfSameGroupHaveSameOwners() throws IOException {
        mediterraneanAve.setOwner(player1);
        balticAve.setOwner(player1);
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertTrue(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupHaveDifferentOwners() throws IOException {
        mediterraneanAve.setOwner(player1);
        balticAve.setOwner(player2);
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertFalse(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testAtLeastOnePropertiesOfSameGroupIsOwnedByBank() throws IOException {
        mediterraneanAve.setOwner(player1);
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertFalse(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupAreAllOwnedByBank() throws IOException {
        List<Space> properties = mediterraneanAve.getAllPropertiesInGroup();
        assertTrue(mediterraneanAve.allPropertiesHaveSameOwner(properties));
    }
}