import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest {

    @Test
    public void testGame() {
        Game board = new Game();
        assertEquals(40, board.getSize());
    }
}