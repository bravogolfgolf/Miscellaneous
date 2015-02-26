package rover;

import java.util.*;

public class Grid {
	private int height;
	private int width;
	private List<Point> obstacles = new ArrayList<Point>();

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
		if (!obstacles.isEmpty()) {
			for (int i = 0; i < obstacles.size(); i++) {
				if (obstacles.get(i).getX() == x && obstacles.get(i).getY() == y) {
					return true;
				}
			}
		}
		return false;
	}

	public void addObstacleAt(int x, int y) {
		Point obstacle = new Point(x, y);
		obstacles.add(obstacle);
	}
}
