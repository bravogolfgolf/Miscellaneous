package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    public static final int MORTGAGE_AMOUNT = 100;
    public static final int UNMORTGAGE_AMOUNT = 110;
    private Player player;
    private DiceMock diceMock;
    private SpaceMockLandOnPassByCounter start;
    private SpaceMockLandOnPassByCounter space1;
    private SpaceMockLandOnPassByCounter space2;
    private Property property;

    @Before
    public void setup() {
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
    public void testPlayerRollsDoublesThenNot(){
        DiceMockRollsDouble3sThenPlain4 diceMock = new DiceMockRollsDouble3sThenPlain4();
        SpaceMockMoveCounter spaceMockMoveCounter = new SpaceMockMoveCounter();
        player.setSpace(spaceMockMoveCounter);
        player.takeATurn(diceMock);
        assertEquals(2,spaceMockMoveCounter.moveCounter);
    }

    @Test
    public void testPlayerRollsDoublesTwiceThenNot(){
        Dice diceMock = new DiceMockRollsDoubleTwiceThenNot();
        SpaceMockMoveCounter spaceMockMoveCounter = new SpaceMockMoveCounter();
        player.setSpace(spaceMockMoveCounter);
        player.takeATurn(diceMock);
        assertEquals(3,spaceMockMoveCounter.moveCounter);
    }

    @Test
    public void testPlayerRollsDoublesThreeTimesGoesToJail(){
        Dice diceMock = new DiceMockRollsDoubleThreeTimesInARow();
        SpaceMockMoveCounter spaceMockMoveCounter = new SpaceMockMoveCounter();
        player.setSpace(spaceMockMoveCounter);
        player.takeATurn(diceMock);
        assertEquals(3,spaceMockMoveCounter.moveCounter);
    }
}
