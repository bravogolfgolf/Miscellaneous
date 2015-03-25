package rover;

public class South extends Direction {

	@Override
	String getCompassPoint(){
		return "S";
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
		x = position.x;
		y = position.y;
		z = position.z;

		if (onBottomEdgeOfGrid(y)) y = wrapToTopEdgeOfGrid(y, planet);
		else y = moveDownOnGrid(y);

		planet.checkForObstacle(new Point(x,y,z));

		return new Point(x,y,z);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		x = position.x;
		y = position.y;
		z = position.z;

		if(onTopEdgeOfGrid(y, planet)) y = wrapToBottomEdgeOfGrid(y);
		else y = moveUpOnGrid(y);

		planet.checkForObstacle(new Point(x,y,z));

		return new Point(x,y,z);
	}
}