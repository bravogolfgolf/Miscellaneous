import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {

    public static final int LAST_LOCATION_ON_BOARD = 39;
    private Game game;
    private Token tokenCat;
    private Token tokenThimble;

    @Before
    public void setup() {
        game = new Game();
        tokenCat = new Token("Cat");
        tokenThimble = new Token("Thimble");
        game.addToken(tokenCat);
    }

    @Test
    public void testGameBoardSize() {
        assertEquals(40, game.getBoardSize());
    }

    @Test
    public void testCreateToken() {
        assertEquals(0, tokenCat.getLocation());
        assertEquals("Cat", tokenCat.getTokenDescription());
    }

    @Test
    public void testAddTokenToGame() {
        assertTrue(tokenCat.equals(game.getToken()));
    }

    @Test
    public void testAddSecondTokenToGame() {
        game.addToken(tokenThimble);
        assertEquals(2,game.getNumberOfTokens());
    }

    @Test
    public void testTokenMovesNoWrap() {
        int startingProperty = tokenCat.getLocation();
        int number = game.roll();
        int endingProperty = number + startingProperty;
        assertEquals(endingProperty, tokenCat.getLocation());
    }

    @Test
    public void testTokenMovesAndWraps() {
        int startingProperty = LAST_LOCATION_ON_BOARD;
        tokenCat.setLocation(startingProperty);
        int number = game.roll();
        assertTrue(String.format("Location: %d; Number: %d; Result: %d", startingProperty, number, tokenCat.getLocation()),
                tokenCat.getLocation() < LAST_LOCATION_ON_BOARD);
    }

}