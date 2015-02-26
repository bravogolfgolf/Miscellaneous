package rover;

import static org.junit.Assert.*;
import org.junit.Test;

public class GridTest {

	@Test
	public void testGridHeight() {
		Grid grid = new Grid(10,11);	
		assertEquals(10,grid.getHeight());
	}
	
	@Test
	public void testGridWidth() {
		Grid grid = new Grid(10,11);	
		assertEquals(11,grid.getWidth());
	}

	@Test
	public void testDifferentHeight() {
		Grid grid = new Grid(14,11);	
		assertEquals(14,grid.getHeight());
	}
	
	@Test
	public void testDifferentWidth() {
		Grid grid = new Grid(14,20);	
		assertEquals(20,grid.getWidth());
	}


}
