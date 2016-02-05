import org.junit.Test;

import static org.junit.Assert.*;


public class BoardTest {

    @Test
    public void testBoard() {
        Board board = new Board();
        assertEquals(40, board.size());
    }
}