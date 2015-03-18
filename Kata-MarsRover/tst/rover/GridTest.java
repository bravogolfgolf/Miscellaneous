package rover;


import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GridTest extends TestCase{
	private Grid grid;
	private int height = 10;
	int width = 11;

	protected void setUp(){
		createGrid(height, width);
	}

	private void createGrid(int height, int width) {
		grid = new Grid(height,width);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testGridHeightAndWidth() {
		assertEquals(10,grid.getHeight());
		assertEquals(11,grid.getWidth());
	}

	@Test
	public void testDifferentHeightAndWidth() {
		int height = 12;
		int width = 13;
		createGrid(height, width);
		assertEquals(12,grid.getHeight());
		assertEquals(13,grid.getWidth());
	}

	@Test
	public void testHasObstacleAt() {
		assertEquals(false, grid.hasObstacleAt(new Point(1, 1)));
	}
}
