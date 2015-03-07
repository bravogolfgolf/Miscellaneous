package rover;

public class North extends Direction {

	@Override
	Compass getDirection() {
		return Compass.N;
	}

	@Override
	Direction turnRight() {
		return new East();
	}

	@Override
	Direction turnLeft() {
		return new West();
	}
}
