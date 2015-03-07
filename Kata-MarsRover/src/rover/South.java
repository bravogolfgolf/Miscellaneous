package rover;

public class South extends Direction {

	@Override
	Compass getDirection() {
		return Compass.S;
	}

	@Override
	Direction turnRight() {
		return new West();
	}

	@Override
	Direction turnLeft() {
		return new East();
	}
}
