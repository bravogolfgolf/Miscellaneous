package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilityGroupTest {

    private static final int PRICE_OF_ELECTRIC = 150;
    private static final int PRICE_OF_WATER = 150;
    public static final int MOCK_ROLL_VALUE = 5;
    public static final int RENT_OWED_IF_ONE_UTILITY_OWNED = MOCK_ROLL_VALUE * 4;
    public static final int RENT_OWED_IF_BOTH_UTILITIES_OWNED = MOCK_ROLL_VALUE * 10;
    private Utility electric;
    private Utility water;
    private final Player player1 = new Player("Cat");
    private final Player player2 = new Player("Dog");
    private final int player1BeginningBalance = player1.getCashBalance();
    private final int player2BeginningBalance = player2.getCashBalance();


    @Before
    public void setUp() throws IOException {
        Game game = new Game("US");
        List<Space> board = game.getBoard();
        electric = (Utility) board.get(12);
        water = (Utility) board.get(28);
    }

    @Test
    public void testCreation() {
        Space property = Space.create("Utility", "Water Works", "Utility", -1);
        assertEquals("Water Works", property.getDescription());
        assertEquals("Utility", property.getGroup());
    }

    @Test
    public void testOwnership() {
        assertTrue(electric.getOwner().isBank());
        electric.setOwner(player1);
        assertEquals(player1, electric.getOwner());
        assertTrue(water.getOwner().isBank());
    }

    @Test
    public void testPrice() {
        assertEquals(PRICE_OF_ELECTRIC, electric.getPrice());
        assertEquals(PRICE_OF_WATER, water.getPrice());
    }

    @Test
    public void testMortgaged() {
        assertEquals(false, electric.isMortgaged());
        electric.setIsMortgaged(true);
        assertEquals(true, electric.isMortgaged());
    }

    @Test
    public void testLandOnUnownedProperty() {
        assertTrue(electric.getOwner().isBank());
        int endingBalance = player1BeginningBalance - PRICE_OF_ELECTRIC;
        int exceptedNetWorth = player1.getNetWorth() - PRICE_OF_ELECTRIC + (PRICE_OF_ELECTRIC / 2);
        electric.landOn(player1, "Roll", new SourceOfMoveMultiplier());
        assertEquals(player1, electric.getOwner());
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(exceptedNetWorth,player1.getNetWorth());
    }

    @Test
    public void testLandOnOwnedAndUnMortgagedUtility() {
        ownedUnMortgagedProperty(player2);
        int player1EndingBalance = player1BeginningBalance - RENT_OWED_IF_ONE_UTILITY_OWNED;
        int player2EndingBalance = player2BeginningBalance + RENT_OWED_IF_ONE_UTILITY_OWNED;
        electric.numberRolled = MOCK_ROLL_VALUE;
        electric.landOn(player1, "Roll", new SourceOfMoveMultiplier());
        assertEquals(player2, electric.getOwner());
        assertTrue(water.getOwner().isBank());
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());

        water.numberRolled = MOCK_ROLL_VALUE;
        water.setOwner(player2);
        water.landOn(player1, "Roll", new SourceOfMoveMultiplier());
        player1EndingBalance = player1EndingBalance - RENT_OWED_IF_BOTH_UTILITIES_OWNED;
        player2EndingBalance = player2EndingBalance + RENT_OWED_IF_BOTH_UTILITIES_OWNED;
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());

        water.landOn(player2, "Roll", new SourceOfMoveMultiplier());
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
    }

    private void ownedUnMortgagedProperty(Player player) {
        electric.setOwner(player);
        assertEquals(player, electric.getOwner());
        assertEquals(false, electric.isMortgaged());
    }

    @Test
    public void testLandOnOwnedAndMortgagedProperty() {
        ownedMortgagedProperty();
        electric.landOn(player1, "Roll", new SourceOfMoveMultiplier());
        assertEquals(player2, electric.getOwner());
        assertEquals(player1BeginningBalance, player1.getCashBalance());
        assertEquals(player2BeginningBalance, player2.getCashBalance());
    }

    private void ownedMortgagedProperty() {
        electric.setOwner(player2);
        electric.setIsMortgaged(true);
        assertEquals(player2, electric.getOwner());
        assertEquals(true, electric.isMortgaged());
    }

    @Test
    public void testPlayerDoesNotPayHimselfRent() {
        PlayerMockDoesNotPaySelfRent playerMock = new PlayerMockDoesNotPaySelfRent();
        ownedUnMortgagedProperty(playerMock);
        electric.landOn(playerMock, "Roll", new SourceOfMoveMultiplier());
        assertEquals(0, playerMock.changeCashBalanceBy);
    }

    @Test
    public void testPropertyGroup() throws IOException {
        assertEquals("Utility", electric.getGroup());
        assertEquals("Utility", water.getGroup());
    }

    @Test
    public void testGetAllPropertiesOfSameGroup() throws IOException {
        assertEquals(2, electric.getAllPropertiesInGroup().size());
    }

    @Test
    public void testPropertiesOfSameGroupHaveSameOwners() throws IOException {
        electric.setOwner(player1);
        water.setOwner(player1);
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertTrue(electric.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupHaveDifferentOwners() throws IOException {
        electric.setOwner(player1);
        water.setOwner(player2);
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertFalse(electric.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testAtLeastOnePropertiesOfSameGroupIsOwnedByBank() throws IOException {
        electric.setOwner(player1);
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertFalse(electric.allPropertiesHaveSameOwner(properties));
    }

    @Test
    public void testPropertiesOfSameGroupAreAllOwnedByBank() throws IOException {
        List<Space> properties = electric.getAllPropertiesInGroup();
        assertTrue(electric.allPropertiesHaveSameOwner(properties));
    }
}
