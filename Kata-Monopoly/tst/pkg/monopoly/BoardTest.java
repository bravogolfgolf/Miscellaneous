package pkg.monopoly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void testGameBoardSize() {
        assertEquals(Board.SIZE_ON_BOARD, board.getBoardSize());
    }

    @Test
    public void testSpaceIdAndOrder() {
        for (int i = 0; i < Board.SIZE_ON_BOARD; i++) {
            assertEquals(i, board.getSpace(i).getID());
        }
    }

    @Test
    public void testSpaceDescription() {
        assertEquals("Go", board.getSpace(0).getDescription());
        assertEquals("Mediterranean Avenue", board.getSpace(1).getDescription());
        assertEquals("Community Chest", board.getSpace(2).getDescription());
        assertEquals("Baltic Avenue", board.getSpace(3).getDescription());
        assertEquals("Income Tax", board.getSpace(4).getDescription());
        assertEquals("Reading Railroad", board.getSpace(5).getDescription());
        assertEquals("Oriental Avenue", board.getSpace(6).getDescription());
        assertEquals("Chance", board.getSpace(7).getDescription());
        assertEquals("Vermont Avenue", board.getSpace(8).getDescription());
        assertEquals("Connecticut Avenue", board.getSpace(9).getDescription());
        assertEquals("Jail", board.getSpace(10).getDescription());
        assertEquals("St. Charles Place", board.getSpace(11).getDescription());
        assertEquals("Electric Company", board.getSpace(12).getDescription());
        assertEquals("States Avenue", board.getSpace(13).getDescription());
        assertEquals("Virginia Avenue", board.getSpace(14).getDescription());
        assertEquals("Pennsylvania Railroad", board.getSpace(15).getDescription());
        assertEquals("St. James Place", board.getSpace(16).getDescription());
        assertEquals("Community Chest", board.getSpace(17).getDescription());
        assertEquals("Tennessee Avenue", board.getSpace(18).getDescription());
        assertEquals("New York Avenue", board.getSpace(19).getDescription());
        assertEquals("Free Parking", board.getSpace(20).getDescription());
        assertEquals("Kentucky Avenue", board.getSpace(21).getDescription());
        assertEquals("Chance", board.getSpace(22).getDescription());
        assertEquals("Indiana Avenue", board.getSpace(23).getDescription());
        assertEquals("Illinois Avenue", board.getSpace(24).getDescription());
        assertEquals("B & O Railroad", board.getSpace(25).getDescription());
        assertEquals("Atlantic Avenue", board.getSpace(26).getDescription());
        assertEquals("Ventnor Avenue", board.getSpace(27).getDescription());
        assertEquals("Water Works", board.getSpace(28).getDescription());
        assertEquals("Marvin Gardens", board.getSpace(29).getDescription());
        assertEquals("Go to Jail", board.getSpace(30).getDescription());
        assertEquals("Pacific Avenue", board.getSpace(31).getDescription());
        assertEquals("North Carolina Avenue", board.getSpace(32).getDescription());
        assertEquals("Community Chest", board.getSpace(33).getDescription());
        assertEquals("Pennsylvania Avenue", board.getSpace(34).getDescription());
        assertEquals("Short Line", board.getSpace(35).getDescription());
        assertEquals("Chance", board.getSpace(36).getDescription());
        assertEquals("Park Place", board.getSpace(37).getDescription());
        assertEquals("Luxury Tax", board.getSpace(38).getDescription());
        assertEquals("Boardwalk", board.getSpace(39).getDescription());
    }
}