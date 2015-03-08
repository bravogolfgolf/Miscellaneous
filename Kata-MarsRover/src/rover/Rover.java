package rover;

public class Rover {
	private Point position;
	private Direction direction;
	private Grid planet;

	public Rover(int x, int y, String direction) {
		setPosition(x, y);
		setDirection(direction);
	}

	private void setPosition(int x, int y) {
		setPosition(new Point(x , y));
	}

	private void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}
	
	private void setDirection(String direction) {
		switch (Compass.valueOf(direction)) {
		case N: setDirection(new North()); break;
		case S: setDirection(new South()); break;
		case E: setDirection(new East()); break;
		case W: setDirection(new West()); break;
		}
	}

	private void setDirection(Direction direction){
		this.direction = direction;
	}
	
	private Direction getDirection() {
		return direction;
	}
	
	public String getHeading() {
		return getDirection().getCompass().toString();
	}

	public void landOnPlanet(Grid planet) {	
		this.planet = planet;
	}

	public Grid getPlanetGrid() {
		return planet;
	}

	public void move(String instruction) {
		Point preservedPosition = getPosition();

		switch (Instruction.valueOf(instruction)) {
		case R: turnRight(); break;
		case L: turnLeft(); break;
		case F: goForward(); checkForObstacle(preservedPosition); break;
		case B: goBackward(); checkForObstacle(preservedPosition); break;
		}
	}

	private void turnRight(){
		setDirection(getDirection().turnRight());
	}

	private void turnLeft() {
		setDirection(getDirection().turnLeft());
	}

	private void goForward() {
		setPosition(getDirection().goForward(getPosition(), getPlanetGrid()));
	}

	private void goBackward() {
		setPosition(getDirection().goBackward(getPosition(), getPlanetGrid()));
	}

	private void checkForObstacle(Point preservedPosition) {
		try {if(getPlanetGrid().hasObstacleAt(getPosition()))
			throw new UnsupportedOperationException();
		}
		catch (UnsupportedOperationException e) {
			doNotMove(preservedPosition);
			throw new UnsupportedOperationException("Obstacle Encoutered");
		}
	}

	private void doNotMove(Point preservedPosition) {
		setPosition(preservedPosition);
	}
}