package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player1;

    @Before
    public void setup() {
        player1 = new Player();
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
        DiceMock diceMock = new DiceMock();
        Board board = new Board();
        player1.setSpace(new Go("Go"));
        player1.takeATurn(diceMock);
        Space endingLocation = board.getSpace(2);
        assertEquals(endingLocation, player1.getSpace());
    }

    @Test
    public void testMovesAndWraps() {
        DiceMock diceMock = new DiceMock();
        Board board = new Board();
        player1.setSpace(board.getSpace(39));
        player1.takeATurn(diceMock);
        Space endingLocation = board.getSpace(1);
        assertEquals(endingLocation, player1.getSpace());
    }

    @Test
    public void testIncreaseCashBalance(){
        int expectedBalance = player1.getCashBalance() + 100;
        player1.increaseCashBalanceBy(100);
        assertEquals(expectedBalance,player1.getCashBalance());
    }
}
