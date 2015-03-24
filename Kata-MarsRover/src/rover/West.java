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
		int z = position.getZ();
		
		if (onLeftEdgeOfGrid(x)) x = wrapToRightEdgeOfGrid(x, planet);
		else x = moveLeftOnGrid(x);
		
		if(planet.checkForObstacle(new Point(x,y,z))) return goBackward(new Point(x,y,z), planet);
		
		return new Point(x,y,z);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		
		if(onRightEdgeOfGrid(x, planet)) x = wrapToLeftEdgeOfGrid(x);
		else x = moveRightOnGrid(x);

		if(planet.checkForObstacle(new Point(x,y,z))) return goBackward(new Point(x,y,z), planet);
		
		return new Point(x,y,z);
	}
}