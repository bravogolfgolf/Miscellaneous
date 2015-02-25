package marsRover;

public class Rover {
	private Point postion;
	private String direction;

	public Rover(int x, int y, String direction) {
		Point point = new Point(x,y);
		this.postion = point;
		this.direction = direction;
	}

	public Point getPostion() {
		return postion;
	}

	public String getDirection() {
		return direction;
	}

	public void move(String instruction) {
		switch (Instruction.valueOf(instruction)) {
		case R:
			turnRightFrom(direction);
			break;
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
}
