package rover;

public class East extends Direction {

	@Override
	Compass getCompass() {
		return Compass.E;
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
		return new Point(x, y);
	}
	
	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();
		
		if(onLeftEdgeOfGrid(x)) x = wrapToRightEdgeOfGrid(x,planet);
		else x = moveLeftOnGrid(x);
		return new Point(x, y);
	}
}