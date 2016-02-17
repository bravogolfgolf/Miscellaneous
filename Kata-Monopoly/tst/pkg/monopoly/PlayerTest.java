package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private DiceMock diceMock;
    private Board board;

    @Before
    public void setup() {
        player = new Player();
        diceMock = new DiceMock();
        board = new Board();
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
        player.setSpace(board.getSpace(0));
        player.takeATurn(diceMock);
        Space endingLocation = board.getSpace(2);
        assertEquals(endingLocation, player.getSpace());
    }

    @Test
    public void testMovesAndWraps() {
        player.setSpace(board.getSpace(39));
        player.takeATurn(diceMock);
        Space endingLocation = board.getSpace(1);
        assertEquals(endingLocation, player.getSpace());
    }

    @Test
    public void testIncreaseCashBalance(){
        int expectedBalance = player.getCashBalance() + 100;
        player.increaseCashBalanceBy(100);
        assertEquals(expectedBalance, player.getCashBalance());
    }
}
