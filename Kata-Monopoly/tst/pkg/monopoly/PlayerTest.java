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

    private static final int PRICE_OF_BOARDWALK = 400;
    private static final int PASS_GO = 200;
    private static final int PRICE_OF_CONNECTICUT_AVENUE = 120;
    private Game game;
    private List<Space> board;
    private Player player1;
    private Player player2;
    private DiceMock diceMock;
    private SpaceMockLandOnPassByCounter start;
    private SpaceMockLandOnPassByCounter space1;
    private SpaceMockLandOnPassByCounter space2;

    @Before
    public void setup() throws IOException {
        game = new Game("US");
        board = game.getBoard();
        player1 = new Player("Cat");
        player2 = new Player("Dog");
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
        final int EXPECTED_INITIAL_CASH_BALANCE = 1500;
        player1.setNextPlayer(player2);
        assertEquals("Cat", player1.getDescription());
        assertEquals(EXPECTED_INITIAL_CASH_BALANCE, player1.getCashBalance());
        assertTrue(player1.getNextPlayer().equals(player2));
    }

    @Test
    public void testMovesAndDoesNoWrap() throws GoToJail.GoToJailException {
        player1.setSpace(start);
        player1.takeATurn(diceMock);
        Space endingLocation = space2;
        assertTrue(endingLocation.equals(player1.getSpace()));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testMovesAndWraps() throws GoToJail.GoToJailException {
        player1.setSpace(space1);
        player1.takeATurn(diceMock);
        Space endingLocation = start;
        assertTrue(endingLocation.equals(player1.getSpace()));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testIncreaseCashBalance() {
        int expectedBalance = player1.getCashBalance() + 100;
        int expectedNetWorth = player1.getNetWorth() + 100;
        player1.transaction(100, "Cash");
        assertEquals(expectedBalance, player1.getCashBalance());
        assertEquals(expectedNetWorth, player1.getNetWorth());
    }

    @Test
    public void testTransactions() {
        assertEquals(1500, player1.getCashBalance());
        assertEquals(1500, player1.getNetWorth());

        player1.transaction(-1400, "Cash");
        assertEquals(100, player1.getCashBalance());
        assertEquals(100, player1.getNetWorth());

        player1.transaction(-100, "Purchase");
        assertEquals(0, player1.getCashBalance());
        assertEquals(50, player1.getNetWorth());

        player1.transaction(50, "Mortgage");
        assertEquals(50, player1.getCashBalance());
        assertEquals(50, player1.getNetWorth());

        player1.transaction(60, "Cash");
        assertEquals(110, player1.getCashBalance());
        assertEquals(110, player1.getNetWorth());

        player1.transaction(-110, "Un-mortgage");
        assertEquals(0, player1.getCashBalance());
        assertEquals(100, player1.getNetWorth());
    }

    @Test
    public void testPlayerRollsDoublesThenNot() throws GoToJail.GoToJailException {
        Dice diceMock = new DiceMockRollsDouble3sThenPlain4();
        playerInitialization();
        Property property1 = (Property) board.get(6);
        Jail property2 = (Jail) board.get(10);

        assertFalse(player1.getSpace().getDescription().equals(property2.getDescription()));
        assertTrue(property1.getOwner().isBank());

        player1.takeATurn(diceMock);

        assertTrue(player1.getSpace().getDescription().equals(property2.getDescription()));
        assertTrue(property1.getOwner().equals(player1));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testPlayerRollsDoublesTwiceThenNot() throws GoToJail.GoToJailException {
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
        assertEquals(0, player1.getNumberOfRolls());
    }

    private void playerInitialization() {
        player1.setSpace(board.get(0));
        player1.resetRollCounter();
    }

    @Test
    public void testPlayerRollsDoublesThreeTimesGoesToJail() {
        int beginningBalance = player1.getCashBalance();
        int beginningNetWorth = player1.getNetWorth();
        Dice diceMock = new DiceMockRollsDoubleThreeTimesInARow();
        player1.setSpace(board.get(35));
        player1.resetRollCounter();

        RealEstate boardwalk = (RealEstate) board.get(39);
        assertTrue(boardwalk.getOwner().isBank());
        int endingBalance = beginningBalance - PRICE_OF_BOARDWALK;
        int endingNetWorth = beginningNetWorth - PRICE_OF_BOARDWALK + (PRICE_OF_BOARDWALK / 2);

        endingBalance = endingBalance + PASS_GO;
        endingNetWorth = endingNetWorth + PASS_GO;

        Property connecticut = (Property) board.get(9);
        assertTrue(connecticut.getOwner().isBank());
        endingBalance = endingBalance - PRICE_OF_CONNECTICUT_AVENUE;
        endingNetWorth = endingNetWorth - PRICE_OF_CONNECTICUT_AVENUE + (PRICE_OF_CONNECTICUT_AVENUE / 2);

        Jail jail = (Jail) board.get(10);
        assertTrue(jail.getDescription().equals("Just Visiting/Jail"));

        game.addPlayer(player1);
        game.play(diceMock);
        assertTrue(boardwalk.getOwner().equals(player1));
        assertTrue(connecticut.getOwner().equals(player1));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(endingNetWorth, player1.getNetWorth());
        assertTrue(player1.getSpace().equals(jail));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testPlayerRollsDoublesAndLandsOnGoesToJail() {
        int beginningBalance = player1.getCashBalance();
        Dice diceMock = new DiceMockRollsDoubleThreeTimesInARow();
        player1.setSpace(board.get(26));
        player1.resetRollCounter();

        Jail jail = (Jail) board.get(10);
        assertTrue(jail.getDescription().equals("Just Visiting/Jail"));

        game.addPlayer(player1);
        game.play(diceMock);
        assertEquals(beginningBalance, player1.getCashBalance());
        assertTrue(player1.getSpace().equals(jail));
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testPlayerIsInJail() {
        assertFalse(player1.isInJail());
        player1.setInJail(true);
        assertTrue(player1.isInJail());
    }

    @Test
    public void testPostBail() {
        Jail jail = (Jail) board.get(10);
        player1.setSpace(jail);
        player1.setInJail(true);
        assertEquals(1500, player1.getCashBalance());
        assertTrue(player1.isInJail());
        player1.postBail();
        assertEquals(1450, player1.getCashBalance());
        assertFalse(player1.isInJail());
        assertEquals(0, player1.getNumberOfRolls());
    }

    @Test
    public void testAddGetOutOfJailCard() {
        Card getOutOfJail = Card.create("Get out of Jail Free – This card may be kept until needed or sold", "GetOutOfJail");
        player1.addCard(getOutOfJail);
        assertTrue(getOutOfJail.equals(player1.getCard()));
    }

    @Test
    public void testAddGetOutOfJailCards() {
        Card getOutOfJail1 = Card.create("Get out of Jail Free – This card may be kept until needed or sold", "GetOutOfJail");
        Card getOutOfJail2 = Card.create("Get out of Jail Free – This card may be kept until needed or sold", "GetOutOfJail");
        player1.addCard(getOutOfJail1);
        player1.addCard(getOutOfJail2);
        assertTrue(getOutOfJail1.equals(player1.getCard()));
        assertTrue(getOutOfJail2.equals(player1.getCard()));
    }

    @Test
    public void testPlayerHashcode() {
        Player player2 = new Player("Cat");
        assertEquals(player1.hashCode(), player2.hashCode());
    }
}
