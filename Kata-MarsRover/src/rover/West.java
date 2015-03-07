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
	Point goForward(int startX, int startY, Grid planet) {
		int endX = startX;
		int endY = startY;

		if (onLeftEdgeOfGrid(startX)) {
			endX = wrapToRightEdgeOfGrid(startX, planet);
		} 
		else {
			endX = moveLeftOnGrid(startX);
		}
		return new Point(endX, endY);
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
}
