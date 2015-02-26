package marsRover;

public class Rover {
	Grid planet;
	private Compass direction;
	private int x;
	private int y;

	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = Compass.valueOf(direction);
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
		case N: y += 1; break;
		case E: x -= 1; break;
		case S: y -= 1; break;
		case W: x += 1; break;
		}
	}

	private void goBackward() {
		switch (direction) {
		case N: y -= 1; break;
		case E: x -= 1; break;
		case S: y += 1; break;
		case W: x += 1; break;
		}
	}

	public void placeOnGrid(Grid mars) {	
		planet = mars;
	}

	public Object getGridDimesions() {
		return planet.getHeight();
	}
}