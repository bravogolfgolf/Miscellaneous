package rover;

public class Grid {
	private int height;
	private int width;

	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean hasObstacleAt(int x, int y) {
		return true;
	}
}
