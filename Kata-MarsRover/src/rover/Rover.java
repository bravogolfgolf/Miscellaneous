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
		switch (direction.getDirection()) {
		case N: if (onTopEdgeOfGrid()) {wrapToBottomEdgeOfGrid();} else {moveUpOnGrid();} break;
		case S: if (onBottomEdgeOfGrid()) {wrapToTopEdgeOfGrid();} else {moveDownOnGrid();} break;
		case E: if (onRightEdgeOfGrid()) {wrapToLeftEdgeOfGrid();} else {moveRightOnGrid();} break;
		case W: if (onLeftEdgeOfGrid()) {wrapToRightEdgeOfGrid();} else {moveLeftOnGrid();} break;
		}
	}

	private void goBackward() {
		switch (direction.getDirection()) {
		case N: if(onBottomEdgeOfGrid()) {wrapToTopEdgeOfGrid();} else {moveDownOnGrid();} break;
		case S: if(onTopEdgeOfGrid()) {wrapToBottomEdgeOfGrid();} else {moveUpOnGrid();} break;
		case E: if(onLeftEdgeOfGrid()) {wrapToRightEdgeOfGrid();} else {moveLeftOnGrid();} break;
		case W: if(onRightEdgeOfGrid()) {wrapToLeftEdgeOfGrid();} else {moveRightOnGrid();} break;
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

	private boolean onTopEdgeOfGrid() {
		return y == planet.getHeight();
	}

	private boolean onBottomEdgeOfGrid() {
		return y == 0;
	}

	private boolean onRightEdgeOfGrid() {
		return x == planet.getWidth();
	}

	private boolean onLeftEdgeOfGrid() {
		return x == 0;
	}

	private void wrapToTopEdgeOfGrid() {
		y = planet.getHeight();
	}

	private void wrapToBottomEdgeOfGrid() {
		y = 0;
	}

	private void wrapToRightEdgeOfGrid() {
		x = planet.getWidth();
	}

	private int wrapToLeftEdgeOfGrid() {
		return x = 0;
	}

	private void moveUpOnGrid() {
		y += 1;
	}

	private void moveDownOnGrid() {
		y -= 1;
	}

	private void moveRightOnGrid() {
		x += 1;
	}

	private void moveLeftOnGrid() {
		x -= 1;
	}
}