package rover;

import static org.junit.Assert.*;

import org.junit.Test;

import rover.Point;

public class PointTest {

	@Test
	public void testgetXCoordinate() {
		Point point = new Point(0,0);	
		assertEquals(0,point.getX());
	}

	@Test
	public void testgetYCoordinate() {
		Point point = new Point(0,0);	
		assertEquals(0,point.getY());
	}
	
	@Test
	public void testgetDifferentXCoordinate() {
		Point point = new Point(1,0);	
		assertEquals(1,point.getX());
	}
	
	@Test
	public void testgetDifferentYCoordinate() {
		Point point = new Point(0,2);	
		assertEquals(2,point.getY());
	}
	
}
