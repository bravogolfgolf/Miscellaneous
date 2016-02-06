import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest {

    private Game game;

    @Before
    public void setup(){
        game = new Game();
    }

    @Test
    public void testGameBoardSize() {
        assertEquals(40, game.getBoardSize());
    }

    @Test
    public void testCreateToken(){
        Token token = new Token("Cat");
        assertEquals("Cat", token.getTokenDescription());
    }

    @Test
    public void testAddTokenToGame(){
        Token token = new Token("Cat");
        game.addToken(token);
        assertTrue(token.equals(game.getToken()));
    }
}