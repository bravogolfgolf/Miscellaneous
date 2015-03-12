package rover;

abstract class Direction {

	static Direction create(String direction) {	
		
		Direction d = (Direction) new North();
		
		if(direction == "N") d = new North();
		if(direction == "S") d = new South();
		if(direction == "E") d = new East();
		if(direction == "W") d = new West();
		return d;
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

	boolean hasObstacleAt(Point position, Grid planet) {
		boolean result = false;
		try {
			if(planet.hasObstacleAt(position)){
				result = true;
				throw new UnsupportedOperationException();
			}
		}
		catch (UnsupportedOperationException e) {
			throw new UnsupportedOperationException("Obstacle Encoutered");
		}
		return result;
	}
}
