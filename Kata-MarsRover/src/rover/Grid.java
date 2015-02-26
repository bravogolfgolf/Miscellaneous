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
		if (obstacles.isEmpty()) {return false;}
		else if (obstacles.get(0).getX() == x || obstacles.get(0).getY() == y) {return true;}
		else {return false;}
	}

	public void addObstacleAt(int x, int y) {
		Point obstacle = new Point(x, y);
		obstacles.add(obstacle);
	}
}
