package rover;

public class East extends Direction {

	@Override
	Compass getDirection() {
		return Compass.E;
	}

	@Override
	Direction turnRight() {
		return new South();
	}

	@Override
	Direction turnLeft() {
		return new North();
	}
}
