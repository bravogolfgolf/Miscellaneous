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

    public static final int PRICE_OF_VIRGINIA_AVENUE = 160;
    private Game game;
    private List<Space> board;
    private Player player1;
    private DiceMock diceMock;
    private SpaceMockLandOnPassByCounter start;
    private SpaceMockLandOnPassByCounter space1;
    private SpaceMockLandOnPassByCounter space2;

    @Before
    public void setup() throws IOException {
        game = new Game("Spaces_US.txt");
        board = game.getBoard();
        player1 = new Player("Cat");
        diceMock = new DiceMock();
        mockSpaceSetUp();
    }

    private void mockSpaceSetUp() {
        start = new SpaceMockLandOnPassByCounter("Start");
        space1 = new SpaceMockLandOnPassByCounter("Space1");
        space2 = new SpaceMockLandOnPassByCounter("Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
    }

    @After
    public void tearDown() {
        game = null;
        board = null;
        player1 = null;
        diceMock = null;
        start = null;
        space1 = null;
        space2 = null;
    }

    @Test
    public void testCreatePlayer() {
        final Space EXPECTED_INITIAL_LOCATION = new Go("Go");
        final int EXPECTED_INITIAL_CASH_BALANCE = 1500;
        assertEquals(EXPECTED_INITIAL_LOCATION, player1.getSpace());
        assertEquals(EXPECTED_INITIAL_CASH_BALANCE, player1.getCashBalance());
    }

    @Test
    public void testMovesAndDoesNoWrap() {
        player1.setSpace(start);
        player1.takeATurn(diceMock);
        Space endingLocation = space2;
        assertTrue(endingLocation.equals(player1.getSpace()));
    }

    @Test
    public void testMovesAndWraps() {
        player1.setSpace(space1);
        player1.takeATurn(diceMock);
        Space endingLocation = start;
        assertTrue(endingLocation.equals(player1.getSpace()));
    }

    @Test
    public void testIncreaseCashBalance() {
        int expectedBalance = player1.getCashBalance() + 100;
        player1.changeCashBalanceBy(100);
        assertEquals(expectedBalance, player1.getCashBalance());
    }

    @Test
    public void testPlayerRollsDoublesThenNot() {
        Dice diceMock = new DiceMockRollsDouble3sThenPlain4();
        playerInitialization();
        Property property1 = (Property) board.get(6);
        Jail property2 = (Jail) board.get(10);

        assertFalse(player1.getSpace().getDescription().equals(property2.getDescription()));
        assertTrue(property1.getOwner().isBank());

        player1.takeATurn(diceMock);

        assertTrue(player1.getSpace().getDescription().equals(property2.getDescription()));
        assertTrue(property1.getOwner().equals(player1));
    }

    @Test
    public void testPlayerRollsDoublesTwiceThenNot() {
        Dice diceMock = new DiceMockRollsDoubleTwiceThenNot();
        playerInitialization();

        Property vermontAve = (Property) board.get(8);
        assertTrue(vermontAve.getOwner().isBank());
        Property tennesseeAve = (Property) board.get(18);
        assertTrue(tennesseeAve.getOwner().isBank());
        Property atlanticAve = (Property) board.get(26);
        assertTrue(atlanticAve.getOwner().isBank());

        player1.takeATurn(diceMock);

        assertTrue(vermontAve.getOwner().equals(player1));
        assertTrue(tennesseeAve.getOwner().equals(player1));
        assertTrue(atlanticAve.getOwner().equals(player1));
    }

    private int playerInitialization() {
        player1.setSpace(board.get(0));
        player1.resetDoublesRolledInATurnCounter();
        return player1.getCashBalance();
    }

    @Test
    public void testPlayerRollsDoublesThreeTimesGoesToJail() {
        Dice diceMock = new DiceMockRollsDoubleThreeTimesInARow();
        int beginningBalance = playerInitialization();

        IncomeTax incomeTax = (IncomeTax) board.get(4);
        assertTrue(incomeTax.getDescription().equals("Income Tax"));
        int endingBalance = beginningBalance - (beginningBalance / 10);

        Property virginiaAve = (Property) board.get(14);
        assertTrue(virginiaAve.getOwner().isBank());
        endingBalance = endingBalance - PRICE_OF_VIRGINIA_AVENUE;

        Jail jail = (Jail) board.get(10);
        assertTrue(jail.getDescription().equals("Just Visiting/Jail"));

        player1.takeATurn(diceMock);

        assertTrue(virginiaAve.getOwner().equals(player1));
        assertEquals(endingBalance, player1.getCashBalance());
        assertTrue(player1.getSpace().equals(jail));
    }

    @Test
    public void testPlayerHashcode() {
        Player player2 = new Player("Cat");
        assertEquals(player1.hashCode(), player2.hashCode());
    }
}
