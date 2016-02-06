import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

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
        assertEquals(Game.SIZE_ON_BOARD, game.getBoardSize());
    }

    @Test
    public void testAddTokenToGame() {
        final int NUMBER_OF_EXPECTED_TOKENS = 1;
        assertEquals(NUMBER_OF_EXPECTED_TOKENS, game.getNumberOfTokens());
    }

    @Test
    public void testAddSecondTokenToGame() {
        final int NUMBER_OF_EXPECTED_TOKENS = 2;
        game.addToken(tokenThimble);
        assertEquals(NUMBER_OF_EXPECTED_TOKENS, game.getNumberOfTokens());
    }
}