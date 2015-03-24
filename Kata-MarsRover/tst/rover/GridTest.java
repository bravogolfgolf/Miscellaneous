package rover;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GridTest {
	private Grid grid;
	private int height = 10;
	int width = 11;

	private void createGrid(int height, int width) {
		grid = new Grid(height,width);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	@Test
	public void testGridHeightAndWidth() {
		createGrid(height, width);
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
	public void testDoesNotHasObstacleAt() {
		createGrid(height, width);
		assertEquals(false, grid.checkForObstacle(new Point(1,1,0)));
	}
	
	@Test
	public void testHasObstacleAtAndThrowsException() {
		thrown.expect(Grid.ObstacleEncoutered.class);
		createGrid(height, width);
		grid.addObstacleAt(1, 1, 0);
		assertEquals(false, grid.checkForObstacle(new Point(1,1,0)));		
	}
}
