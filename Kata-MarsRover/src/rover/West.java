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
		int x = position.getX();
		int y = position.getY();

		if (onLeftEdgeOfGrid(x)) x = wrapToRightEdgeOfGrid(x, planet);
		else x = moveLeftOnGrid(x);
		
		if(hasObstacleAt(new Point(x,y), planet)) return goBackward(new Point(x,y), planet);
		
		return new Point(x, y);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();

		if(onRightEdgeOfGrid(x, planet)) x = wrapToLeftEdgeOfGrid(x);
		else x = moveRightOnGrid(x);
		if(hasObstacleAt(new Point(x,y), planet)) return goForward(new Point(x,y), planet);
		return new Point(x, y);
	}
}