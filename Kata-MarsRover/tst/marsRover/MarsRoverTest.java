package marsRover;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarsRoverTest {

	@Test
	public void testXCoordinate() {
		Point point = new Point();	
		assertEquals(0,point.getX());
	}

	@Test
	public void testYCoordinate() {
		Point point = new Point();	
		assertEquals(0,point.getY());
	}
}
