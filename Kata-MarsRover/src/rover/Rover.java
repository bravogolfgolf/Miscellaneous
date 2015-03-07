package rover;

public class Rover {
	private Point position;
	private Direction direction;
	private Grid planet;
	private int x;
	private int y;

	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		setPosition(x, y);
		setDirection(direction);
	}

	public void setPosition(int x, int y) {
		setPosition(new Point(x , y));
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}
	public void setDirection(String direction) {
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

	public void placeOnGrid(Grid planet) {	
		this.planet = planet;
	}

	public Grid getGridDimesions() {
		return planet;
	}

	public void move(String instruction) {
		Point preservedPosition = new Point(x, y);

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
		setPosition(direction.goForward(x, y, planet));	
	}

	private void goBackward() {
		setPosition(direction.goBackward(x, y, planet));
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