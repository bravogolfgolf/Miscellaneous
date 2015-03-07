package rover;

abstract class Direction {
	abstract Compass getDirection();
	abstract Direction turnRight();
	abstract Direction turnLeft();
	abstract Point goForward(Point position, Grid planet);
	abstract Point goForward(int x, int y, Grid planet);
	abstract Point goBackward(int x, int y, Grid planet);
}
