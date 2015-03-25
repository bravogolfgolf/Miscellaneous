package rover;

public class East extends Direction {

	@Override
	String getCompassPoint(){
		return "E";
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
	Point goForward(Point position, Grid planet) {

		if (onRightEdgeOfGrid(position.x, planet)) position.x = wrapToLeftEdgeOfGrid(position.x);
		else position.x = moveRightOnGrid(position.x);

		planet.checkForObstacle(position);
		
		return position;
	}

	@Override
	Point goBackward(Point position, Grid planet) {

		if(onLeftEdgeOfGrid(position.x)) position.x = wrapToRightEdgeOfGrid(position.x,planet);
		else position.x = moveLeftOnGrid(position.x);

		planet.checkForObstacle(position);
		
		return position;
	}
}