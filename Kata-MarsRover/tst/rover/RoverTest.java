package rover;

import junit.framework.TestCase;

import org.junit.*;

public class RoverTest extends TestCase {
	private Rover rover;
	private Grid mars;
	private String direction = "N";
	private int x = 0;
	private int y = 0;
	private int height = 9;
	private int width = 9;

	protected void setUp(){
		createRoverOnGrid(x, y, direction);
	}

	private void createRoverOnGrid(int x, int y, String direction) {
		rover = new Rover(x, y, direction);
		mars = new Grid(height, width);
		rover.placeOnGrid(mars);
	}

	@Test
	public void testPlaceRoverOnGrid() {
		assertEquals(9,rover.getGridDimesions().getHeight());
		assertEquals(9,rover.getGridDimesions().getWidth());
	}

	@Test
	public void testGridDifferentDimensions() {
		height = 11;
		width = 12;
		mars = new Grid(height, width);
		createRoverOnGrid(x, y, direction);
		assertEquals(11,rover.getGridDimesions().getHeight());
		assertEquals(12,rover.getGridDimesions().getWidth());
	}

	@Test
	public void testInitialPostion() {
		assertEquals(0, rover.getPosition().getX());
		assertEquals(0, rover.getPosition().getY());
	}

	@Test
	public void testDifferentInitialPostion() {
		x = 45;
		y = 20;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		assertEquals(x, rover.getPosition().getX());
		assertEquals(y, rover.getPosition().getY());
	}

	@Test
	public void testInitialDirection() {
		assertEquals("N",rover.getDirection());
	}

	@Test
	public void testDifferentDirection() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		assertEquals("W",rover.getDirection());
	}


	@Test
	public void testFacingNorthThenTurnRight() {
		turnRight();
		assertEquals("E",rover.getDirection());
	}

	private void turnRight() {
		rover.move("R");
	}

	@Test
	public void testFacingEastThenTurnRight() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("S",rover.getDirection());
	}

	@Test
	public void testFacingSouthThenTurnRight() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("W",rover.getDirection());
	}

	@Test
	public void testFacingWestThenTurnRight() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("N",rover.getDirection());
	}

	@Test
	public void testFacingNorthThenTurnLeft() {
		turnLeft();
		assertEquals("W",rover.getDirection());
	}

	private void turnLeft() {
		rover.move("L");
	}

	@Test
	public void testFacingWestThenTurnLeft() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("S",rover.getDirection());
	}

	@Test
	public void testFacingSouthThenTurnLeft() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("E",rover.getDirection());
	}

	@Test
	public void testFacingEastThenTurnLeft() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("N",rover.getDirection());
	}

	@Test
	public void testMoveForwardNorth() {
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(1,rover.getPosition().getY());
	}

	private void goForward() {
		rover.move("F");
	}

	@Test
	public void testMoveForwardWest() {
		x = 1;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardSouth() {
		y = 1;
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardEast() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(1,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackNorth() {
		y = 1;
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackEast() {
		x = 1;
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	private void goBackward() {
		rover.move("B");
	}

	@Test
	public void testMoveBackSouth() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(1,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackWest() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(1,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardNorthWrap() {
		y = 9;
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardEastWrap() {
		x = 9;
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardSouthWrap() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(9,rover.getPosition().getY());
	}

	@Test
	public void testMoveForwardWestWrap() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(9,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}

	@Test
	public void testMoveBackNorthWrap() {
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(9,rover.getPosition().getY());
	}
	
	@Test
	public void testMoveBackEastWrap() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(9,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}
	
	@Test
	public void testMoveBackSouthWrap() {
		y = 9;
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}
	
	@Test
	public void testMoveBackWestWrap() {
		x = 9;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}
	
	@Test
	public void testFoundObstacle() throws Exception {
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 1);
		goForward();
		assertEquals(0,rover.getPosition().getX());
		assertEquals(0,rover.getPosition().getY());
	}
}