package rover;

public class North extends Direction {

	@Override
	Compass getDirection() {
		return Compass.N;
	}

	@Override
	Direction turnRight() {
		return new East();
	}

	@Override
	Direction turnLeft() {
		return new West();
	}

	@Override
	Point goForward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if (onTopEdgeOfGrid(y, planet)) y = wrapToBottomEdgeOfGrid(y);
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
	
	@Override
	Point goBackward(Point position, Grid planet) {
		return goBackward(position.getX(), position.getY(), planet);
	}

	@Override
	Point goBackward(int inX, int inY, Grid planet) {
		Point position = new Point(inX,inY);
		int x = position.getX();
		int y = position.getY();

		if(onBottomEdgeOfGrid(y)) y = wrapToTopEdgeOfGrid(y, planet);
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
}