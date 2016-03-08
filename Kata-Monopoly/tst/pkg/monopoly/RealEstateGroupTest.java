package pkg.monopoly;

import org.junit.Before;
import org.junit.Ignore;
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
    public static final int MEDITERRANEAN_1_HOUSE_RENT = 10;
    private static final int MEDITERRANEAN_2_HOUSE_RENT = 30;
    private static final int MEDITERRANEAN_3_HOUSE_RENT = 90;
    private static final int MEDITERRANEAN_4_HOUSE_RENT = 160;
    private static final int MEDITERRANEAN_HOTEl_RENT = 250;
    private RealEstate mediterraneanAve;
    private RealEstate balticAve;
    private final Player player1 = new Player("Cat");
    private final Player player2 = new Player("Dog");
    private final int player1BeginningBalance = player1.getCashBalance();
    private final int player2BeginningBalance = player2.getCashBalance();

    @Before
    public void setUp() throws IOException {
        Game game = new Game("US");
        List<Space> board = game.getBoard();
        mediterraneanAve = (RealEstate) board.get(1);
        balticAve = (RealEstate) board.get(3);
    }

    @Test
    public void testCreation() {
        Space property = Space.create("RealEstate", "Park Place", "Blue", -1, -1, 1, 2, 3, 4, 5);
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
    public void testImprovements() {
        mediterraneanAve.addImprovements();
        assertEquals(1, mediterraneanAve.getImprovements());
        mediterraneanAve.removeImprovements();
        assertEquals(0, mediterraneanAve.getImprovements());
    }

    @Test
    public void testLandOnUnownedPropertyWithEnoughMoney() {
        assertTrue(mediterraneanAve.getOwner().isBank());
        int endingBalance = player1BeginningBalance - PRICE_OF_MEDITERRANEAN;
        int exceptedNetWorth = player1.getNetWorth() - PRICE_OF_MEDITERRANEAN + (PRICE_OF_MEDITERRANEAN / 2);
        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(player1, mediterraneanAve.getOwner());
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(exceptedNetWorth, player1.getNetWorth());

    }

    @Ignore
    public void testLandOnUnownedPropertyWithOutEnoughMoney() {
        player1.transaction(-1500,"Cash");
        assertEquals(0,player1.getCashBalance());
        assertEquals(0,player1.getNetWorth());
        assertTrue(mediterraneanAve.getOwner().isBank());
        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertTrue(mediterraneanAve.getOwner().isBank());
        assertEquals(0, player1.getCashBalance());
        assertEquals(0, player1.getNetWorth());
    }

    @Test
    public void testLandOnOwnedAndUnMortgagedPropertyNoHousesOrHotel() {
        ownedUnMortgagedProperty(player2, mediterraneanAve);
        int player1EndingBalance = player1BeginningBalance - RENT_OF_MEDITERRANEAN;
        int player2EndingBalance = player2BeginningBalance + RENT_OF_MEDITERRANEAN;
        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(player2, mediterraneanAve.getOwner());
        assertTrue(balticAve.getOwner().isBank());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);

        balticAve.setOwner(player2);
        player1EndingBalance = player1EndingBalance - (RENT_OF_BALTIC * 2);
        player2EndingBalance = player2EndingBalance + (RENT_OF_BALTIC * 2);
        balticAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);

        balticAve.landOn(player2, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);
    }

    @Test
    public void testLandOnOwnedAndUnMortgagedPropertyWithHousesOrHotel() {
        ownedUnMortgagedProperty(player2, mediterraneanAve);
        ownedUnMortgagedProperty(player2, balticAve);

        mediterraneanAve.addImprovements();
        int player1EndingBalance = player1BeginningBalance - MEDITERRANEAN_1_HOUSE_RENT;
        int player2EndingBalance = player2BeginningBalance + MEDITERRANEAN_1_HOUSE_RENT;

        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);

        mediterraneanAve.addImprovements();
        player1EndingBalance -= MEDITERRANEAN_2_HOUSE_RENT;
        player2EndingBalance += MEDITERRANEAN_2_HOUSE_RENT;

        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);

        mediterraneanAve.addImprovements();
        player1EndingBalance -= MEDITERRANEAN_3_HOUSE_RENT;
        player2EndingBalance += MEDITERRANEAN_3_HOUSE_RENT;

        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);

        mediterraneanAve.addImprovements();
        player1EndingBalance -= MEDITERRANEAN_4_HOUSE_RENT;
        player2EndingBalance += MEDITERRANEAN_4_HOUSE_RENT;

        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);

        mediterraneanAve.addImprovements();
        player1EndingBalance -= MEDITERRANEAN_HOTEl_RENT;
        player2EndingBalance += MEDITERRANEAN_HOTEl_RENT;

        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        checkPlayersCashBalances(player1EndingBalance, player2EndingBalance);
    }

    private void checkPlayersCashBalances(int player1EndingBalance, int player2EndingBalance) {
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
    }

    private void ownedUnMortgagedProperty(Player player, Property property) {
        property.setOwner(player);
        assertEquals(player, property.getOwner());
        assertEquals(false, property.isMortgaged());
    }

    @Test
    public void testLandOnOwnedAndMortgagedProperty() {
        ownedMortgagedProperty();
        mediterraneanAve.landOn(player1, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(player2, mediterraneanAve.getOwner());
        checkPlayersCashBalances(player1BeginningBalance, player2BeginningBalance);
    }

    private void ownedMortgagedProperty() {
        mediterraneanAve.setOwner(player2);
        mediterraneanAve.setIsMortgaged(true);
        assertEquals(player2, mediterraneanAve.getOwner());
        assertEquals(true, mediterraneanAve.isMortgaged());
    }

    @Test
    public void testPlayerDoesNotPayHimselfRent() {
        PlayerMockDoesNotPaySelfRent playerMock = new PlayerMockDoesNotPaySelfRent();
        ownedUnMortgagedProperty(playerMock, mediterraneanAve);
        mediterraneanAve.landOn(playerMock, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
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