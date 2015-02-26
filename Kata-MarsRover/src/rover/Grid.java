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
	
	public void addObstacleAt(int x, int y) {
		Point obstacle = new Point(x, y);
		obstacles.add(obstacle);
	}

	public boolean hasObstacleAt(int x, int y) {
		Point input = new Point(x, y);
		Point currentObstacle;
		if (isNotEmpty(obstacles)) {
			for (int i = 0; i < obstacles.size(); i++) {
				 currentObstacle = obstacles.get(i);
				if (theTwoAreEqual(input, currentObstacle)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isNotEmpty(List<Point> obstacles) {
		return !obstacles.isEmpty();
	}

	private boolean theTwoAreEqual(Point input, Point obstacle) {
		return obstacle.getX() == input.getX() && obstacle.getY() == input.getY();
	}
}
