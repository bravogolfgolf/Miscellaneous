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
	Point goForward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if (onBottomEdgeOfGrid(y)) y = wrapToTopEdgeOfGrid(y, planet);
		else y = moveDownOnGrid(y);
		return new Point(x, y);
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

	@Override
	Point goBackward(int inX, int inY, Grid planet) {
		return null;
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();
		
		if(onTopEdgeOfGrid(y, planet)) y = wrapToBottomEdgeOfGrid(y);
		else y = moveUpOnGrid(y);
		return new Point(x, y);
	}

	private boolean onTopEdgeOfGrid(int y, Grid planet) {
		return y == planet.getHeight();
	}

	private int wrapToBottomEdgeOfGrid(int y) {
		return y = 0;
	}

	private int moveUpOnGrid(int y) {
		return y += 1;
	}
}