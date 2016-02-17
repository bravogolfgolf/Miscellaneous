package pkg.monopoly;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    public static final int BOARDWALK = 39;
    public static final int GO = 0;
    private Board board = new Board();

    @Test
    public void testGameBoardSize() {
        assertEquals(Board.SIZE_ON_BOARD, board.getBoardSize());
    }

    @Test
    public void testSpaceIdAndOrder() {
        Go go = new Go("Go");
        assertTrue(go.getClass() == board.getSpace(0).getClass());

        Space space = new Space("Space");
        for (int i = 1; i < Board.SIZE_ON_BOARD; i++) {
            assertTrue(space.getClass() == board.getSpace(i).getClass());
        }
    }

    @Test
    public void testCreateLocationNavigationListStartingAtNotGo(){
        List<Space> navigationList;
        Player player = new Player();
        player.setLocation(board.getSpace(BOARDWALK));
        navigationList = board.getNavigationList(player);
        assertEquals(40,navigationList.size());
        assertTrue(board.getSpace(0).equals(navigationList.get(1)));
    }

    @Test
    public void testCreateLocationNavigationListStartingAtGo(){
        List<Space> navigationList;
        Player player = new Player();
        player.setLocation(board.getSpace(GO));
        navigationList = board.getNavigationList(player);
        assertEquals(40,navigationList.size());
        assertTrue(board.getSpace(0).equals(navigationList.get(0)));
    }
}