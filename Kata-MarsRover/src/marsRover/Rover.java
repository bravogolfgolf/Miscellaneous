package marsRover;

public class Rover {
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
			turnRightFrom();
			break;
		case L:
			turnLeftFrom();
			break;
		case F:
			forwardInThis();
			break;
		}
	}

	private void forwardInThis() {
		switch (direction) {
		case N: y += 1; break;
		case E: x -= 1; break;
		case S: y -= 1; break;
		case W: x += 1; break;
		}
	}

	private void turnRightFrom(){
		switch (direction){
		case N: direction = Compass.E; break;
		case E: direction = Compass.S; break;
		case S: direction = Compass.W; break;
		case W: direction = Compass.N; break;
		}
	}

	private void turnLeftFrom() {
		switch (direction){
		case N: direction = Compass.W; break;
		case W: direction = Compass.S; break;		
		case S: direction = Compass.E; break;
		case E: direction = Compass.N; break;
		}
	}
}