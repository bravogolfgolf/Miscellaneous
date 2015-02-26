package marsRover;

public class Rover {
	private String direction;
	private int x;
	private int y;

	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Point getPostion() {
		return new Point(x, y);
	}

	public String getDirection() {
		return direction;
	}

	public void move(String instruction) {
		switch (Instruction.valueOf(instruction)) {
		case R:
			turnRightFrom(direction);
			break;
		case L:
			turnLeftFrom(direction);
			break;
		case F:
			forwardInThis(direction);
			break;
		}
	}

	private void forwardInThis(String direction2) {
		switch (Compass.valueOf(direction)){
		case N: y += 1; break;
		case E: x -= 1; break;
		case S: y -= 1; break;
		case W: x += 1; break;
		}
	}

	private void turnRightFrom(String direction2){
		switch (Compass.valueOf(direction)){
		case N: direction = "E"; break;
		case E: direction = "S"; break;
		case S: direction = "W"; break;
		case W: direction = "N"; break;
		}
	}

	private void turnLeftFrom(String direction2) {
		switch (Compass.valueOf(direction)){
		case N: direction = "W"; break;
		case W: direction = "S"; break;		
		case S: direction = "E"; break;
		case E: direction = "N"; break;
		}
	}
}