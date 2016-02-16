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
            assertEquals(i, board.getSpaceId(i));
        }
    }

    @Test
    public void testSpaceDescription() {
        assertEquals("Go", board.getSpaceDescripton(0));
        assertEquals("Mediterranean Avenue", board.getSpaceDescripton(1));
        assertEquals("Community Chest", board.getSpaceDescripton(2));
        assertEquals("Baltic Avenue", board.getSpaceDescripton(3));
        assertEquals("Income Tax", board.getSpaceDescripton(4));
        assertEquals("Reading Railroad", board.getSpaceDescripton(5));
        assertEquals("Oriental Avenue", board.getSpaceDescripton(6));
        assertEquals("Chance", board.getSpaceDescripton(7));
        assertEquals("Vermont Avenue", board.getSpaceDescripton(8));
        assertEquals("Connecticut Avenue", board.getSpaceDescripton(9));
        assertEquals("Jail", board.getSpaceDescripton(10));
        assertEquals("St. Charles Place", board.getSpaceDescripton(11));
        assertEquals("Electric Company", board.getSpaceDescripton(12));
        assertEquals("States Avenue", board.getSpaceDescripton(13));
        assertEquals("Virginia Avenue", board.getSpaceDescripton(14));
        assertEquals("Pennsylvania Railroad", board.getSpaceDescripton(15));
        assertEquals("St. James Place", board.getSpaceDescripton(16));
        assertEquals("Community Chest", board.getSpaceDescripton(17));
        assertEquals("Tennessee Avenue", board.getSpaceDescripton(18));
        assertEquals("New York Avenue", board.getSpaceDescripton(19));
        assertEquals("Free Parking", board.getSpaceDescripton(20));
        assertEquals("Kentucky Avenue", board.getSpaceDescripton(21));
        assertEquals("Chance", board.getSpaceDescripton(22));
        assertEquals("Indiana Avenue", board.getSpaceDescripton(23));
        assertEquals("Illinois Avenue", board.getSpaceDescripton(24));
        assertEquals("B & O Railroad", board.getSpaceDescripton(25));
        assertEquals("Atlantic Avenue", board.getSpaceDescripton(26));
        assertEquals("Ventnor Avenue", board.getSpaceDescripton(27));
        assertEquals("Water Works", board.getSpaceDescripton(28));
        assertEquals("Marvin Gardens", board.getSpaceDescripton(29));
        assertEquals("Go to Jail", board.getSpaceDescripton(30));
        assertEquals("Pacific Avenue", board.getSpaceDescripton(31));
        assertEquals("North Carolina Avenue", board.getSpaceDescripton(32));
        assertEquals("Community Chest", board.getSpaceDescripton(33));
        assertEquals("Pennsylvania Avenue", board.getSpaceDescripton(34));
        assertEquals("Short Line", board.getSpaceDescripton(35));
        assertEquals("Chance", board.getSpaceDescripton(36));
        assertEquals("Park Place", board.getSpaceDescripton(37));
        assertEquals("Luxury Tax", board.getSpaceDescripton(38));
        assertEquals("Boardwalk", board.getSpaceDescripton(39));

    }
}