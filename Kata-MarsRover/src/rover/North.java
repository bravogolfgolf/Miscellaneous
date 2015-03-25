package rover;

public class North extends Direction {

	@Override
	String getCompassPoint(){
		return "N";
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
		int z = position.getZ();

		if (onTopEdgeOfGrid(y, planet)) y = wrapToBottomEdgeOfGrid(y);
		else y = moveUpOnGrid(y);

		planet.checkForObstacle(new Point(x,y,z));

		return new Point(x,y,z);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();

		if(onBottomEdgeOfGrid(y)) y = wrapToTopEdgeOfGrid(y, planet);
		else y = moveDownOnGrid(y);

		planet.checkForObstacle(new Point(x,y,z));

		return new Point(x,y,z);
	}
}