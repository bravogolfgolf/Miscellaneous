package marsRover;

public class Rover {
	private Grid planet;
	private Compass direction;
	private int x;
	private int y;

	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = Compass.valueOf(direction);
	}

	public void placeOnGrid(Grid mars) {	
		planet = mars;
	}

	public Grid getGridDimesions() {
		return planet;
	}

	public Point getPostion() {
		return new Point(x, y);
	}

	public String getDirection() {
		return direction.toString();
	}

	public void move(String instruction) {
		switch (Instruction.valueOf(instruction)) {
		case R:
			turnRight();
			break;
		case L:
			turnLeft();
			break;
		case F:
			goforward();
			break;
		case B:
			goBackward();
			break;
		}
	}

	private void turnRight(){
		switch (direction){
		case N: direction = Compass.E; break;
		case E: direction = Compass.S; break;
		case S: direction = Compass.W; break;
		case W: direction = Compass.N; break;
		}
	}

	private void turnLeft() {
		switch (direction){
		case N: direction = Compass.W; break;
		case W: direction = Compass.S; break;		
		case S: direction = Compass.E; break;
		case E: direction = Compass.N; break;
		}
	}

	private void goforward() {
		switch (direction) {
		case N: if (onTopEdgeOfGrid()) {wrapToBottomEdgeOfGrid();} else {moveUpGrid();} break;
		case E: if (onRightEdgeOfGrid()) {wrapToLeftEdgeOfGrid();} else {moveRightOnGrid();} break;
		case S: if (onBottomEdgeOfGrid()) {wrapToTopEdgeOfGrid();} else {moveDownOnGrid();} break;
		case W: x -= 1; break;
		}
	}

	private void moveDownOnGrid() {
		y -= 1;
	}

	private void wrapToTopEdgeOfGrid() {
		y = 9;
	}

	private boolean onBottomEdgeOfGrid() {
		return y == 0;
	}

	private int moveRightOnGrid() {
		return x += 1;
	}

	private int wrapToLeftEdgeOfGrid() {
		return x = 0;
	}

	protected boolean onRightEdgeOfGrid() {
		return x == planet.getWidth();
	}

	protected void wrapToBottomEdgeOfGrid() {
		y = 0;
	}

	protected boolean onTopEdgeOfGrid() {
		return y == planet.getHeight();
	}

	protected void moveUpGrid() {
		y += 1;
	}

	private void goBackward() {
		switch (direction) {
		case N: moveDownOnGrid(); break;
		case E: x -= 1; break;
		case S: moveUpGrid(); break;
		case W: moveRightOnGrid(); break;
		}
	}
}