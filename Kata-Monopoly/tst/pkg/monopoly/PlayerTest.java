package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    public static final int MORTGAGE_AMOUNT = 100;
    public static final int UNMORTGAGE_AMOUNT = 110;
    private Game game;
    private List<Space> board;
    private Player player;
    private DiceMock diceMock;
    private SpaceMockLandOnPassByCounter start;
    private SpaceMockLandOnPassByCounter space1;
    private SpaceMockLandOnPassByCounter space2;
    private Property property;

    @Before
    public void setup() throws IOException {
        game = new Game("Spaces_US.txt");
        board = game.getBoard();
        player = new Player();
        diceMock = new DiceMock();
        start = new SpaceMockLandOnPassByCounter("Start");
        space1 = new SpaceMockLandOnPassByCounter("Space1");
        space2 = new SpaceMockLandOnPassByCounter("Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
        property = new Property("Short Line");
        property.setOwner(player);
        property.setPrice(200);
        property.setRent(25);
        property.setIsMortgaged(false);
    }

    @After
    public void tearDown() {
        game = null;
        board = null;
        player = null;
        diceMock = null;
        start = null;
        space1 = null;
        space2 = null;
        property = null;
    }

    @Test
    public void testCreatePlayer() {
        final Space EXPECTED_INITIAL_LOCATION = new Go("Go");
        final int EXPECTED_INITIAL_CASH_BALANCE = 1500;
        assertEquals(EXPECTED_INITIAL_LOCATION, player.getSpace());
        assertEquals(EXPECTED_INITIAL_CASH_BALANCE, player.getCashBalance());
    }

    @Test
    public void testMovesAndDoesNoWrap() {
        player.setSpace(start);
        player.takeATurn(diceMock);
        Space endingLocation = space2;
        assertTrue(endingLocation.equals(player.getSpace()));
    }

    @Test
    public void testMovesAndWraps() {
        player.setSpace(space1);
        player.takeATurn(diceMock);
        Space endingLocation = start;
        assertTrue(endingLocation.equals(player.getSpace()));
    }

    @Test
    public void testIncreaseCashBalance() {
        int expectedBalance = player.getCashBalance() + 100;
        player.changeCashBalanceBy(100);
        assertEquals(expectedBalance, player.getCashBalance());
    }

    @Test
    public void testPlayerMortgagesProperty() {
        int expectedBalance = player.getCashBalance() + MORTGAGE_AMOUNT;
        player.mortgageProperty(property);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(true, property.isMortgaged());

    }

    @Test
    public void testPlayerUnMortgagesProperty() {
        property.setIsMortgaged(true);
        int expectedBalance = player.getCashBalance() - UNMORTGAGE_AMOUNT;
        player.unmortgageProperty(property);
        assertEquals(expectedBalance, player.getCashBalance());
        assertEquals(false, property.isMortgaged());

    }

    @Test
    public void testPlayerRollsDoublesThenNot() {
        Dice diceMock = new DiceMockRollsDouble3sThenPlain4();
        playerInitialization();

        Property property1 = (Property) board.get(6);
        Jail property2 = (Jail) board.get(10);
        assertFalse(player.getSpace().getDescription().equals(property2.getDescription()));
        assertTrue(property1.getOwner() == null);

        player.takeATurn(diceMock);

        assertTrue(property1.getOwner().equals(player));
        assertTrue(player.getSpace().getDescription().equals(property2.getDescription()));
    }

    @Test
    public void testPlayerRollsDoublesTwiceThenNot() {
        Dice diceMock = new DiceMockRollsDoubleTwiceThenNot();
        playerInitialization();

        Property vermontAve = (Property) board.get(8);
        assertTrue(vermontAve.getOwner() == null);
        Property tennesseeAve = (Property) board.get(18);
        assertTrue(tennesseeAve.getOwner() == null);
        Property atlanticAve = (Property) board.get(26);
        assertTrue(atlanticAve.getOwner() == null);

        player.takeATurn(diceMock);

        assertTrue(vermontAve.getOwner().equals(player));
        assertTrue(tennesseeAve.getOwner().equals(player));
        assertTrue(atlanticAve.getOwner().equals(player));
    }

    private int playerInitialization() {
        player.setSpace(board.get(0));
        player.resetDoublesRolledInATurnCounter();
        return player.getCashBalance();
    }

    @Test
    public void testPlayerRollsDoublesThreeTimesGoesToJail() {
        Dice diceMock = new DiceMockRollsDoubleThreeTimesInARow();
        int beginningBalance = playerInitialization();

        IncomeTax incomeTax = (IncomeTax) board.get(4);
        assertTrue(incomeTax.getDescription().equals("Income Tax"));
        int endingBalance = beginningBalance - (beginningBalance / 10);

        Property virginiaAve = (Property) board.get(14);
        assertTrue(virginiaAve.getOwner() == null);

        Jail jail = (Jail) board.get(10);
        assertTrue(jail.getDescription().equals("Just Visiting/Jail"));

        player.takeATurn(diceMock);

        assertTrue(virginiaAve.getOwner().equals(player));
        assertEquals(endingBalance,player.getCashBalance());
        assertTrue(player.getSpace().equals(jail));

    }
}
