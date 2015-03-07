package rover;

public class Rover {
	private Grid planet;
	private Direction direction;
	private int x;
	private int y;

	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		setDirection(direction);
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

	public Point getPosition() {
		return new Point(x, y);
	}

	public void move(String instruction) {
		int preservedX = x;
		int preservedY = y;

		switch (Instruction.valueOf(instruction)) {
		case R: turnRight(); break;
		case L: turnLeft(); break;
		case F: goForward(); checkForObstacle(preservedX, preservedY); break;
		case B: goBackward(); checkForObstacle(preservedX, preservedY); break;
		}
	}

	private void turnRight(){
		this.direction = this.direction.turnRight();
	}

	private void turnLeft() {
		this.direction = this.direction.turnLeft();
	}

	private void goForward() {
		Point p = direction.goForward(x, y, planet);
		x = p.getX();
		y = p.getY();	
	}

	private void goBackward() {
		Point p;
		switch (direction.getDirection()) {
		case N: p = direction.goBackward(x, y, planet); x = p.getX(); y = p.getY(); break;
		case S: p = direction.goBackward(x, y, planet); x = p.getX(); y = p.getY(); break;
		case E: p = direction.goBackward(x, y, planet); x = p.getX(); y = p.getY(); break;
		case W: p = direction.goBackward(x, y, planet); x = p.getX(); y = p.getY(); break;
		}
	}

	private void checkForObstacle(int preservedX, int preservedY) {
		try {if(planet.hasObstacleAt(x, y))
			throw new UnsupportedOperationException();
		}
		catch (UnsupportedOperationException e) {
			doNotMove(preservedX, preservedY);
			throw new UnsupportedOperationException("Obstacle Encoutered");
		}
	}

	private void doNotMove(int preservedX, int preservedY) {
		x = preservedX;
		y = preservedY;
	}
}