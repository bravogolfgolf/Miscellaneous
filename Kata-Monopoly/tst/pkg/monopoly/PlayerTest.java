package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Player player1;
    private Player player2;
    private Dice dice;

    @Before
    public void setup() {
        Token token = new Token("Cat");
        player1 = new Player(token);
        player2 = new Player(token);
        dice = new Dice();
    }

    @Test
    public void testCreatePlayer() {
        final int EXPECTED_INITIAL_LOCATION = 0;
        final int EXPECTED_INITIAL_CASH_BALANCE = 1500;
        assertEquals(EXPECTED_INITIAL_LOCATION, player1.getTokenLocation());
        assertEquals(EXPECTED_INITIAL_CASH_BALANCE, player1.getCashBalance());
        assertEquals("Cat", player1.getTokenDescription());
    }

    @Test
    public void testPlayerEqualityAndHashcode() {
        assertTrue(player1.equals(player2));
        assertTrue(player1.hashCode() == player2.hashCode());
    }

    @Test
    public void testTokenMovesNoWrap() {
        int startingLocation = player1.getTokenLocation();
        player1.takeATurn(dice);
        int endingLocation = dice.getTwoDieRollValue() + startingLocation;
        assertEquals(endingLocation, player1.getTokenLocation());
    }

    @Test
    public void testTokenMovesAndWraps() {
        playerPassesGo();
        assertEquals(dice.getTwoDieRollValue() - 1, player1.getTokenLocation());
        assertTrue(String.format("Location: %d; Number: %d; Result: %d", Board.LAST_LOCATION_ON_BOARD, dice.getTwoDieRollValue(), player1.getTokenLocation()),
                player1.getTokenLocation() < Board.LAST_LOCATION_ON_BOARD);
    }

    private void playerPassesGo() {
        player1.setTokenLocation(Board.LAST_LOCATION_ON_BOARD);
        player1.takeATurn(dice);

    }

    @Test
    public void testIncreaseCashBalance(){
        int expectedBalance = player1.getCashBalance() + 100;
        player1.increaseCashBalanceBy(100);
        assertEquals(expectedBalance,player1.getCashBalance());
    }

    @Test
    public void testSetSalaryFlag() {
        assertTrue(!player1.getSalaryFlag());
        player1.setSalaryFlag(true);
        assertTrue(player1.getSalaryFlag());
    }

    @Test
    public void testPlayerWhoPassesGoHasSalaryFlagSetToTrue(){
        playerPassesGo();
        assertTrue(player1.getSalaryFlag());
    }


}
