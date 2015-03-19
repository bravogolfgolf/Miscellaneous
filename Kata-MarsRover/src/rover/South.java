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
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();

		
		if (onBottomEdgeOfGrid(y)) y = wrapToTopEdgeOfGrid(y, planet);
		else y = moveDownOnGrid(y);
		
		if(planet.hasObstacleAt(new Point(x,y,z))) return goBackward(new Point(x,y,z), planet);
		
		return new Point(x,y,z);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();

		
		if(onTopEdgeOfGrid(y, planet)) y = wrapToBottomEdgeOfGrid(y);
		else y = moveUpOnGrid(y);
		
		if(planet.hasObstacleAt(new Point(x,y,z))) return goBackward(new Point(x,y,z), planet);
		
		return new Point(x,y,z);	}
}