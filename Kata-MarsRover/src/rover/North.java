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
	Point goForward(int startX, int startY, Grid planet) {
		int endX = startX;
		int endY = startY;
		
		if (onTopEdgeOfGrid(startY, planet)) {
			endY = wrapToBottomEdgeOfGrid(startY);
		}
		else {
			endY = moveUpOnGrid(startY);
		}
		return new Point(endX, endY);
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
