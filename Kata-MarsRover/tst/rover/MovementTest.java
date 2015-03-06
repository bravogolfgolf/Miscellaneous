package rover;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MovementTest {

	@Test
	public void testTurnRight() {
		assertEquals(Compass.E,Movement.turnRight(Compass.N));
		assertEquals(Compass.W,Movement.turnRight(Compass.S));
		assertEquals(Compass.S,Movement.turnRight(Compass.E));
		assertEquals(Compass.N,Movement.turnRight(Compass.W));
	}

	@Test
	public void testTurnLeft() {
		assertEquals(Compass.W,Movement.turnLeft(Compass.N));
		assertEquals(Compass.E,Movement.turnLeft(Compass.S));
		assertEquals(Compass.N,Movement.turnLeft(Compass.E));
		assertEquals(Compass.S,Movement.turnLeft(Compass.W));
	}

	@Test
	public void testGoForward() {
		assertEquals(Compass.W,Movement.turnLeft(Compass.N));
		assertEquals(Compass.E,Movement.turnLeft(Compass.S));
		assertEquals(Compass.N,Movement.turnLeft(Compass.E));
		assertEquals(Compass.S,Movement.turnLeft(Compass.W));
	}
}
