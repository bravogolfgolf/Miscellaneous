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
		case N: this.direction = new North(); break;
		case S: this.direction = new South(); break;
		case E: this.direction = new East(); break;
		case W: this.direction = new West(); break;
		}
	}

	public String getDirection() {
		return direction.getDirection().toString();
	}

	public void landOnPlanet(Grid planet) {	
		this.planet = planet;
	}

	public Grid getPlanetGrid() {
		return planet;
	}

	public void move(String instruction) {
		Point preservedPosition = position;

		switch (Instruction.valueOf(instruction)) {
		case R: turnRight(); break;
		case L: turnLeft(); break;
		case F: goForward(); checkForObstacle(preservedPosition); break;
		case B: goBackward(); checkForObstacle(preservedPosition); break;
		}
	}

	private void turnRight(){
		this.direction = this.direction.turnRight();
	}

	private void turnLeft() {
		this.direction = this.direction.turnLeft();
	}

	private void goForward() {
		setPosition(direction.goForward(position, planet));
	}

	private void goBackward() {
		setPosition(direction.goBackward(position, planet));
	}

	private void checkForObstacle(Point preservedPosition) {
		try {if(planet.hasObstacleAt(position))
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