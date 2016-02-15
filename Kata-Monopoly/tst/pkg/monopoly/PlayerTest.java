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
        Token token = new Token(MenuItems.Cat.getDescription());
        player1 = new Player(token);
        player2 = new Player(token);
        dice = new Dice();
    }

    @Test
    public void testCreatePlayer() {
        final int EXPECTED_INITIAL_LOCATION = 0;
        assertEquals(EXPECTED_INITIAL_LOCATION, player1.getTokenLocation());
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
        dice.rollTwoDie();
        player1.takeATurn(dice);
        int endingLocation = dice.getTwoDieRollValue() + startingLocation;
        assertEquals(endingLocation, player1.getTokenLocation());
    }

    @Test
    public void testTokenMovesAndWraps() {
        int startingLocation = Board.LAST_LOCATION_ON_BOARD;
        dice.rollTwoDie();
        player1.setTokenLocation(startingLocation);
        player1.takeATurn(dice);
        assertEquals(dice.getTwoDieRollValue() - 1, player1.getTokenLocation());
        assertTrue(String.format("Location: %d; Number: %d; Result: %d", startingLocation, dice.getTwoDieRollValue(), player1.getTokenLocation()),
                player1.getTokenLocation() < Board.LAST_LOCATION_ON_BOARD);
    }

}
