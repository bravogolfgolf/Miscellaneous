package rover;

public class West extends Direction {

	@Override
	Compass getCompass() {
		return Compass.W;
	}

	String getCompassSting(){
		return "W";}
	
	@Override
	Direction turnRight() {
		return new North();
	}

	@Override
	Direction turnLeft() {
		return new South();
	}

	@Override
	Point goForward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if (onLeftEdgeOfGrid(x)) x = wrapToRightEdgeOfGrid(x, planet);
		else x = moveLeftOnGrid(x);
		return new Point(x, y);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if(onRightEdgeOfGrid(x, planet)) x = wrapToLeftEdgeOfGrid(x);
		else x = moveRightOnGrid(x);
		return new Point(x, y);
	}
}