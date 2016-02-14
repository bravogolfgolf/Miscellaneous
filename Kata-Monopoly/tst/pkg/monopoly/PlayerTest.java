package pkg.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Player player1;
    private Player player2;

    @Before
    public void setup() {
        Token token = new Token(MenuItems.Cat.getDescription());
        player1 = new Player(token);
        player2 = new Player(token);

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
        int startingProperty = player1.getTokenLocation();
        int number = player1.roll();
        int endingProperty = number + startingProperty;
        assertEquals(endingProperty, player1.getTokenLocation());
    }

    @Test
    public void testTokenMovesAndWraps() {
        int startingProperty = Board.LAST_LOCATION_ON_BOARD;
        player1.setTokenLocation(startingProperty);
        int number = player1.roll();
        assertTrue(String.format("Location: %d; Number: %d; Result: %d", startingProperty, number, player1.getTokenLocation()),
                player1.getTokenLocation() < Board.LAST_LOCATION_ON_BOARD);
    }

}
