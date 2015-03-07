package rover;

public class East extends Direction {

	@Override
	Compass getDirection() {
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
	Point goForward(int startX, int startY, Grid planet) {
		int endX = startX;
		int endY = startY;

		if (onRightEdgeOfGrid(startX, planet)) {
			endX = wrapToLeftEdgeOfGrid(startX);
		} 
		else {
			endX = moveRightOnGrid(startX);
		}
		return new Point(endX, endY);
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
