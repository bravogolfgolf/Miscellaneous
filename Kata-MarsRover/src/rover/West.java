package rover;

public class West extends Direction {

	@Override
	String getCompassPoint(){
		return "W";
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
		x = position.x;
		y = position.y;
		z = position.z;

		if (onLeftEdgeOfGrid(x)) x = wrapToRightEdgeOfGrid(x, planet);
		else x = moveLeftOnGrid(x);

		planet.checkForObstacle(new Point(x,y,z));

		return new Point(x,y,z);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		x = position.x;
		y = position.y;
		z = position.z;

		if(onRightEdgeOfGrid(x, planet)) x = wrapToLeftEdgeOfGrid(x);
		else x = moveRightOnGrid(x);

		planet.checkForObstacle(new Point(x,y,z));

		return new Point(x,y,z);
	}
}