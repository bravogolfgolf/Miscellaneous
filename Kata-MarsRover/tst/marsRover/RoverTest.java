package marsRover;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class RoverTest {
	Point postion;
	Rover rover;

	private Rover createRover(int x, int y, String direction) {
		return new Rover(x, y, direction);
	}

	private Point createPoint(int x, int y) {
		return new Point(x, y);
	}

	@Test
	public void testInitialPostion() {
		int x = 21;
		int y = 20;
		String direction = "N";
		postion = createPoint(x, y);
		rover = createRover(x, y, direction);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}

	@Test
	public void testDifferentInitialPostion() {
		int x = 45;
		int y = 20;
		String direction = "W";
		postion = createPoint(x, y);
		rover = createRover(x, y, direction);
		assertEquals(postion.getX(),rover.getPostion().getX());
		assertEquals(postion.getY(),rover.getPostion().getY());
	}
	
	@Test
	public void testInitialDirection() {
		int x = 45;
		int y = 20;
		String direction = "N";
		rover = createRover(x, y, direction);
		assertEquals("N",rover.getDirection());
	}
	
	@Test
	public void testDifferentDirection() {
		int x = 45;
		int y = 20;
		String direction = "W";
		rover = createRover(x, y, direction);
		assertEquals("W",rover.getDirection());
	}
	
	@Test
	public void testFacingNorthThenTurnRight() {
		int x = 10;
		int y = 10;
		String direction = "N";
		rover = createRover(x, y, direction);
		rover.move("R");
		assertEquals("E",rover.getDirection());
	}
	
	@Test
	public void testFacingEastThenTurnRight() {
		int x = 10;
		int y = 10;
		String direction = "E";
		rover = createRover(x, y, direction);
		rover.move("R");
		assertEquals("S",rover.getDirection());
	}
}