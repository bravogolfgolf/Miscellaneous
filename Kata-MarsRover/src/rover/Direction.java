package rover;

import rover.Grid.ObstacleEncoutered;

abstract class Direction {

	static Direction create(String direction) {			
		if(direction == "N") return new North();
		if(direction == "S") return new South();
		if(direction == "E") return new East();
		if(direction == "W") return new West();
		throw new IllegalArgumentException("Incorrect direction value");
	}

	abstract String getCompassPoint();
	abstract Direction turnRight();
	abstract Direction turnLeft();
	abstract Point goForward(Point position, Grid planet);
	abstract Point goBackward(Point position, Grid planet);

	boolean onTopEdgeOfGrid(int y, Grid planet) {return y == planet.getHeight();}
	boolean onBottomEdgeOfGrid(int y) {return y == 0;}
	boolean onLeftEdgeOfGrid(int x) {return x == 0;}
	boolean onRightEdgeOfGrid(int x, Grid planet) {return x == planet.getWidth();}

	int wrapToTopEdgeOfGrid(int y, Grid planet) {return y = planet.getHeight();}
	int wrapToBottomEdgeOfGrid(int y) {return y = 0;}
	int wrapToLeftEdgeOfGrid(int x) {return x = 0;}	
	int wrapToRightEdgeOfGrid(int x, Grid planet) {return x = planet.getWidth();	}

	int moveUpOnGrid(int y) {return y += 1;}
	int moveDownOnGrid(int y) {return y -= 1;}
	int moveLeftOnGrid(int x) {return x -= 1;}
	int moveRightOnGrid(int x) {return x += 1;}

	Point doNotMoveIfObstacleInWay(Point position, Grid planet) {
		try {
			if(planet.hasObstacleAt(position));
			return position;
		} catch (ObstacleEncoutered e) {
			return goBackward(position, planet);
		}
	}
}
