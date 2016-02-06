import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void testGameBoardSize() {
        assertEquals(40, game.getBoardSize());
    }

    @Test
    public void testCreateToken() {
        Token token = new Token("Cat");
        assertEquals(0, token.getLocation());
        assertEquals("Cat", token.getTokenDescription());
    }

    @Test
    public void testAddTokenToGame() {
        Token token = new Token("Cat");
        game.addToken(token);
        assertTrue(token.equals(game.getToken()));
    }

    @Test
    public void testTokenMovesNoWrap() {
        Token token = new Token("Cat");
        game.addToken(token);
        int startingProperty = token.getLocation();
        int number = game.roll();
        int endingProperty = number + startingProperty;
        assertEquals(endingProperty,token.getLocation());
    }

}