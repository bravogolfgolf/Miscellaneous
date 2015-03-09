package rover;

public class East extends Direction {

	@Override
	String getCompassPoint(){
		return "E";
	}

	@Override
	Direction turnRight() {
		return new South();
	}

	@Override
	Direction turnLeft() {
		return new North();
	}

	@Override
	Point goForward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if (onRightEdgeOfGrid(x, planet)) x = wrapToLeftEdgeOfGrid(x);
		else x = moveRightOnGrid(x);
		if(hasObstacleAt(new Point(x,y), planet)) return goBackward(new Point(x,y), planet);
		return new Point(x, y);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if(onLeftEdgeOfGrid(x)) x = wrapToRightEdgeOfGrid(x,planet);
		else x = moveLeftOnGrid(x);
		if(hasObstacleAt(new Point(x,y), planet)) return goForward(new Point(x,y), planet);
		return new Point(x, y);
	}
}