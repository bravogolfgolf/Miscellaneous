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
	
	public void addObstacleAt(int x, int y, int z) {
		Point obstacle = new Point(x,y,z);
		obstacles.add(obstacle);
	}

	public void checkForObstacle(Point position){
		Point currentObstacle;
		if (isNotEmpty(obstacles)) {
			for (int i = 0; i < obstacles.size(); i++) {
				 currentObstacle = obstacles.get(i);
				if (position.equals(currentObstacle)) {
					throw new ObstacleEncoutered("Obstacle Encoutered");
				}
			}
		}
	}
	
	private boolean isNotEmpty(List<Point> obstacles) {
		return !obstacles.isEmpty();
	}

	@SuppressWarnings("serial")
	static final class ObstacleEncoutered extends RuntimeException {

		public ObstacleEncoutered(String string) {
			super(string);
		}
	}
}

