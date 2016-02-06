import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Test
    public void testGameBoardSize() {
        board = new Board();
        assertEquals(Board.SIZE_ON_BOARD, board.getBoardSize());
    }


}