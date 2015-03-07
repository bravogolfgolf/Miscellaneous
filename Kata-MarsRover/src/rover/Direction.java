package rover;

abstract class Direction {
	abstract Compass getDirection();
	abstract Direction turnRight();
	abstract Direction turnLeft();
}
