package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Player player;
    private DiceMock diceMock;
    private Space start;
    private Space space1;
    private Space space2;

    @Before
    public void setup() {
        player = new Player();
        diceMock = new DiceMock();
        start = new Space("Start");
        space1 = new Space("Space1");
        space2 = new Space("Space2");
        start.setNextSpace(space1);
        space1.setNextSpace(space2);
        space2.setNextSpace(start);
    }

    @After
    public void tearDown() {
        player = null;
        diceMock = null;
        start = null;
        space1 = null;
        space2 = null;
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
    public void testIncreaseCashBalance(){
        int expectedBalance = player.getCashBalance() + 100;
        player.increaseCashBalanceBy(100);
        assertEquals(expectedBalance, player.getCashBalance());
    }
}
