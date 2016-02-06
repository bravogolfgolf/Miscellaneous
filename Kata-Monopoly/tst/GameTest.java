import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {

    public static final int LAST_LOCATION_ON_BOARD = 39;
    private Game game;
    private Token token;

    @Before
    public void setup() {
        game = new Game();
        token = new Token("Cat");
        game.addToken(token);
    }

    @Test
    public void testGameBoardSize() {
        assertEquals(40, game.getBoardSize());
    }

    @Test
    public void testCreateToken() {
        assertEquals(0, token.getLocation());
        assertEquals("Cat", token.getTokenDescription());
    }

    @Test
    public void testAddTokenToGame() {
        assertTrue(token.equals(game.getToken()));
    }

    @Test
    public void testTokenMovesNoWrap() {
        int startingProperty = token.getLocation();
        int number = game.roll();
        int endingProperty = number + startingProperty;
        assertEquals(endingProperty, token.getLocation());
    }

    @Test
    public void testTokenMovesAndWraps() {
        token.setLocation(LAST_LOCATION_ON_BOARD);
        int startingProperty = token.getLocation();
        int number = game.roll();
        int endingProperty = number + startingProperty;
        assertEquals(endingProperty, token.getLocation());
        assertTrue(token.getLocation() < LAST_LOCATION_ON_BOARD);
    }

}