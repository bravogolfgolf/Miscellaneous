package marsRover;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoverTest {
	private Rover rover;
	private int x = 0;
	private int y = 0;
	private String direction = "N";

	protected void setUp(){
		createRover(x, y, direction);
	}

	private void createRover(int x, int y, String direction) {
		rover = new Rover(x, y, direction);
	}

	@Test
	public void testInitialPostion() {
		createRover(x, y, direction);
		assertEquals(0, rover.getPostion().getX());
		assertEquals(0, rover.getPostion().getY());
	}

	@Test
	public void testDifferentInitialPostion() {
		x = 45;
		y = 20;
		direction = "W";
		createRover(x, y, direction);
		assertEquals(x, rover.getPostion().getX());
		assertEquals(y, rover.getPostion().getY());
	}

	@Test
	public void testInitialDirection() {
		createRover(x, y, direction);
		assertEquals("N",rover.getDirection());
	}

	@Test
	public void testDifferentDirection() {
		direction = "W";
		createRover(x, y, direction);
		assertEquals("W",rover.getDirection());
	}

	@Test
	public void testFacingNorthThenTurnRight() {
		createRover(x, y, direction);
		rover.move("R");
		assertEquals("E",rover.getDirection());
	}

	@Test
	public void testFacingEastThenTurnRight() {
		direction = "E";
		createRover(x, y, direction);
		rover.move("R");
		assertEquals("S",rover.getDirection());
	}

	@Test
	public void testFacingSouthThenTurnRight() {
		direction = "S";
		createRover(x, y, direction);
		rover.move("R");
		assertEquals("W",rover.getDirection());
	}

	@Test
	public void testFacingWestThenTurnRight() {
		direction = "W";
		createRover(x, y, direction);
		rover.move("R");
		assertEquals("N",rover.getDirection());
	}

	@Test
	public void testFacingNorthThenTurnLeft() {
		createRover(x, y, direction);
		rover.move("L");
		assertEquals("W",rover.getDirection());
	}

	@Test
	public void testFacingWestThenTurnLeft() {
		direction = "W";
		createRover(x, y, direction);
		rover.move("L");
		assertEquals("S",rover.getDirection());
	}

	@Test
	public void testFacingSouthThenTurnLeft() {
		direction = "S";
		createRover(x, y, direction);
		rover.move("L");
		assertEquals("E",rover.getDirection());
	}

	@Test
	public void testFacingEastThenTurnLeft() {
		direction = "E";
		createRover(x, y, direction);
		rover.move("L");
		assertEquals("N",rover.getDirection());
	}

	@Test
	public void testMoveForwardNorth() {
		createRover(x, y, direction);
		rover.move("F");
		assertEquals(0,rover.getPostion().getX());
		assertEquals(1,rover.getPostion().getY());
	}
	
	@Test
	public void testMoveForwardWest() {
		direction = "W";
		createRover(x, y, direction);
		rover.move("F");
		assertEquals(1,rover.getPostion().getX());
		assertEquals(0,rover.getPostion().getY());
	}
	
	@Test
	public void testMoveForwardSouth() {
		y = 1;
		direction = "S";
		createRover(x, y, direction);
		rover.move("F");
		assertEquals(0,rover.getPostion().getX());
		assertEquals(0,rover.getPostion().getY());
	}
	
	@Test
	public void testMoveForwardEast() {
		x = 1;
		direction = "E";
		createRover(x, y, direction);
		rover.move("F");
		assertEquals(0,rover.getPostion().getX());
		assertEquals(0,rover.getPostion().getY());
	}

	@Test
	public void testMoveBackNorth() {
		y = 1;
		createRover(x, y, direction);
		rover.move("B");
		assertEquals(0,rover.getPostion().getX());
		assertEquals(0,rover.getPostion().getY());
	}
	
	@Test
	public void testMoveBackEast() {
		x = 1;
		direction = "E";
		createRover(x, y, direction);
		rover.move("B");
		assertEquals(0,rover.getPostion().getX());
		assertEquals(0,rover.getPostion().getY());
	}
	
	@Test
	public void testMoveBackSouth() {
		direction = "S";
		createRover(x, y, direction);
		rover.move("B");
		assertEquals(1,rover.getPostion().getX());
		assertEquals(0,rover.getPostion().getY());
	}
}