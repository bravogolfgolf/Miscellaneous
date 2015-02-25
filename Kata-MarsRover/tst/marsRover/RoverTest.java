package marsRover;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoverTest {
	private Point postion;
	private Rover rover;
	private int x;
	private int y;
	private String direction;

	private Rover createRover(int x, int y, String direction) {
		return new Rover(x, y, direction);
	}

	private Point createPoint(int x, int y) {
		return new Point(x, y);
	}

	@Test
	public void testInitialPostion() {
		x = 21;
		y = 20;
		direction = "N";
		postion = createPoint(x, y);
		rover = createRover(x, y, direction);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}


	@Test
	public void testDifferentInitialPostion() {
		x = 45;
		y = 20;
		direction = "W";
		postion = createPoint(x, y);
		rover = createRover(x, y, direction);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}
	
	@Test
	public void testInitialDirection() {
		x = 45;
		y = 20;
		direction = "N";
		rover = createRover(x, y, direction);
		assertEquals("N",rover.getDirection());
	}
	
	@Test
	public void testDifferentDirection() {
		x = 45;
		y = 20;
		direction = "W";
		rover = createRover(x, y, direction);
		assertEquals("W",rover.getDirection());
	}
	
	@Test
	public void testFacingNorthThenTurnRight() {
		x = 10;
		y = 10;
		direction = "N";
		rover = createRover(x, y, direction);
		rover.move("R");
		assertEquals("E",rover.getDirection());
	}
	
	@Test
	public void testFacingEastThenTurnRight() {
		x = 10;
		y = 10;
		direction = "E";
		rover = createRover(x, y, direction);
		rover.move("R");
		assertEquals("S",rover.getDirection());
	}
	
	@Test
	public void testFacingSouthThenTurnRight() {
		x = 10;
		y = 10;
		direction = "S";
		rover = createRover(x, y, direction);
		rover.move("R");
		assertEquals("W",rover.getDirection());
	}
}