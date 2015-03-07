package rover;

abstract class Direction {
	abstract Compass getDirection();
	abstract Direction turnRight();
	abstract Direction turnLeft();
	abstract Point goForward(int startX, int startY, Grid planet);
}
