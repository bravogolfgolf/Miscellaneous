package rover;

public class West extends Direction {

	@Override
	Compass getDirection() {
		return Compass.W;
	}

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

	private boolean onLeftEdgeOfGrid(int x) {
		return x == 0;
	}

	private int wrapToRightEdgeOfGrid(int x, Grid planet) {
		return x = planet.getWidth();
	}

	private int moveLeftOnGrid(int x) {
		return x -= 1;
	}
	
	@Override
	Point goBackward(Point position, Grid planet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Point goBackward(int x, int y, Grid planet) {
		if(onRightEdgeOfGrid(x, planet)) x = wrapToLeftEdgeOfGrid(x);
		else x = moveRightOnGrid(x);
		return new Point(x, y);
	}

	private boolean onRightEdgeOfGrid(int x, Grid planet) {
		return x == planet.getWidth();
	}

	private int wrapToLeftEdgeOfGrid(int x) {
		return x = 0;
	}

	private int moveRightOnGrid(int x) {
		return x += 1;
	}
}