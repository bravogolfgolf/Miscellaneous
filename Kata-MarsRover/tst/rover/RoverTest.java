package rover;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class RoverTest {
	private Model rover;
	private Grid mars;
	private String direction = "N";
	private int x = 0;
	private int y = 0;
	private int z = 0;
	private int height = 9;
	private int width = 9;

	private void createRoverOnGrid(int x, int y, String direction) {
		rover = new Rover(x, y, z, direction);
		mars = new Grid(height, width);
		rover.landOnPlanet(mars);
	}
	
	private void goForward() {
		rover.move("F");
	}
	
	private void goBackward() {
		rover.move("B");
	}

	private void turnRight() {
		rover.move("R");
	}
	
	private void turnLeft() {
		rover.move("L");
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInitialPostion() {
		createRoverOnGrid(x, y, direction);
		assertEquals(0, rover.getPosition().x);
		assertEquals(0, rover.getPosition().y);
	}

	@Test
	public void testDifferentInitialPostion() {
		x = 45;
		y = 20;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		assertEquals(x, rover.getPosition().x);
		assertEquals(y, rover.getPosition().y);
	}

	@Test
	public void testInitialDirection() {
		createRoverOnGrid(x, y, direction);
		assertEquals("N",rover.getHeading());
	}

	@Test
	public void testDifferentDirection() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		assertEquals("W",rover.getHeading());
	}

	@Test
	public void testFacingNorthThenTurnRight() {
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("E",rover.getHeading());
	}

	@Test
	public void testFacingEastThenTurnRight() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("S",rover.getHeading());
	}

	@Test
	public void testFacingSouthThenTurnRight() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("W",rover.getHeading());
	}

	@Test
	public void testFacingWestThenTurnRight() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		turnRight();
		assertEquals("N",rover.getHeading());
	}

	@Test
	public void testFacingNorthThenTurnLeft() {
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("W",rover.getHeading());
	}

	@Test
	public void testFacingWestThenTurnLeft() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("S",rover.getHeading());
	}

	@Test
	public void testFacingSouthThenTurnLeft() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("E",rover.getHeading());
	}

	@Test
	public void testFacingEastThenTurnLeft() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		turnLeft();
		assertEquals("N",rover.getHeading());
	}

	@Test
	public void testMoveForwardNorth() {
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(1,rover.getPosition().y);
	}

	@Test
	public void testMoveForwardWest() {
		x = 1;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveForwardSouth() {
		y = 1;
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveForwardEast() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(1,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveBackNorth() {
		y = 1;
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveBackEast() {
		x = 1;
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveBackSouth() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(1,rover.getPosition().y);
	}

	@Test
	public void testMoveBackWest() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(1,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveForwardNorthWrap() {
		y = 9;
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveForwardEastWrap() {
		x = 9;
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveForwardSouthWrap() {
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(9,rover.getPosition().y);
	}

	@Test
	public void testMoveForwardWestWrap() {
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goForward();
		assertEquals(9,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveBackNorthWrap() {
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(9,rover.getPosition().y);
	}

	@Test
	public void testMoveBackEastWrap() {
		direction = "E";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(9,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveBackSouthWrap() {
		y = 9;
		direction = "S";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testMoveBackWestWrap() {
		x = 9;
		direction = "W";
		createRoverOnGrid(x, y, direction);
		goBackward();
		assertEquals(0,rover.getPosition().x);
		assertEquals(0,rover.getPosition().y);
	}

	@Test
	public void testFoundObstacleForward() {
		thrown.expect(Grid.ObstacleEncoutered.class);
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 1, 0);
		goForward();
	}

	@Test
	public void throwsExceptionEncouterObstacleBackward() {
		thrown.expect(Grid.ObstacleEncoutered.class);
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 9, 0);
		goBackward();
	}

	@Test
	public void throwsExceptionEncouterObstacleBackwardSouth() {
		thrown.expect(Grid.ObstacleEncoutered.class);
		direction = "S";
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 1, 0);
		goBackward();
	}

	@Test
	public void throwsExceptionEncouterObstacleForwardSouth() {
		thrown.expect(Grid.ObstacleEncoutered.class);
		direction = "S";
		createRoverOnGrid(x, y, direction);
		mars.addObstacleAt(0, 9, 0);
		goForward();
	}

	@Test
	public void throwsExceptionForIncorrectDirection() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Incorrect direction value");
		direction = "X";
		createRoverOnGrid(x, y, direction);
	}
}