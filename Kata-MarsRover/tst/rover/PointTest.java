package rover;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	public Point createPoint(int x, int y, int z) {
		Point point = new Point(x, y, z);
		return point;
	}

	@Test
	public void testgetXCoordinate() {
		Point point = createPoint(0, 0, 0);	
		assertEquals(0,point.getX());
	}

	@Test
	public void testgetYCoordinate() {
		Point point = createPoint(0, 0, 0);	
		assertEquals(0,point.getY());
	}

	@Test
	public void testgetZCoordinate() {
		Point point = createPoint(0, 0, 0);	
		assertEquals(0,point.getZ());
	}

	@Test
	public void testgetDifferentXCoordinate() {
		Point point = createPoint(1, 0, 0);	
		assertEquals(1,point.getX());
	}

	@Test
	public void testgetDifferentYCoordinate() {
		Point point = createPoint(0, 2, 0);	
		assertEquals(2,point.getY());
	}

	@Test
	public void testgetDifferentZCoordinate() {
		Point point = createPoint(0, 2, 5);	
		assertEquals(5,point.getZ());
	}
}
