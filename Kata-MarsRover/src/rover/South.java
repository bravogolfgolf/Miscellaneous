package rover;

public class South extends Direction {

	@Override
	Compass getDirection() {
		return Compass.S;
	}

	@Override
	Direction turnRight() {
		return new West();
	}

	@Override
	Direction turnLeft() {
		return new East();
	}

	@Override
	Point goForward(int startX, int startY, Grid planet) {
		int endX = startX;
		int endY = startY;

		if (onBottomEdgeOfGrid(startY)) {
			endY = wrapToTopEdgeOfGrid(startY, planet);
		}
		else {
			endY = moveDownOnGrid(startY);
		}
		return new Point(endX, endY);
	}

	private boolean onBottomEdgeOfGrid(int y) {
		return y == 0;
	}

	private int wrapToTopEdgeOfGrid(int y, Grid planet) {
		return y = planet.getHeight();
	}

	private int moveDownOnGrid(int y) {
		return y -= 1;
	}
}
