import org.junit.Before;
import org.junit.Ignore;
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
    public void testCreatePlayer(){
        Player player = new Player("Cat");
        assertEquals("Cat", player.getPlayerName());
    }

//    @Test
//    public void testMovePlayer(){
//        game.addPlayer("Cat");
//        player.roll();
//        assertEquals(7,player.getCurrentPosition());
//    }
}