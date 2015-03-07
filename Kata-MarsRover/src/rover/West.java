package rover;

public class West extends Direction {

	@Override
	Compass getDirection() {
		return Compass.W;
	}

	@Override
	Direction turnRight() {
		return new North();
	}

	@Override
	Direction turnLeft() {
		return new South();
	}
}
