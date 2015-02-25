package marsRover;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoverTest {
	private Point postion;
	private Rover rover;
	private int x = 0;
	private int y = 0;
	private String direction = "N";

	protected void setUp(){
		createRover(x, y, direction);
		createPoint(x, y);
	}

	private void createRover(int x, int y, String direction) {
		rover = new Rover(x, y, direction);
	}

	private void createPoint(int x, int y) {
		postion = new Point(x, y);
	}

	@Test
	public void testInitialPostion() {
		createPoint(x, y);
		createRover(x, y, direction);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}


	@Test
	public void testDifferentInitialPostion() {
		x = 45;
		y = 20;
		direction = "W";
		createPoint(x, y);
		createRover(x, y, direction);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
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
}